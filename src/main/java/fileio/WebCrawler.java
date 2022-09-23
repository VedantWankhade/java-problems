package fileio;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WebCrawler {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a url: ");
        String startingUrl = in.next();

        while (!isUrl(startingUrl)) {
            System.out.print("Please enter a valid url (starting with http / https: ");
            startingUrl = in.next();
        }
        in.close();
        System.out.println("Set "+ startingUrl + " as seed url");
        
        crawl(startingUrl);
    }

    private static void crawl(String startingUrl) {
        List<String> pendingUrls = new ArrayList<>();
        List<String> crawledUrls = new ArrayList<>();

        pendingUrls.add(startingUrl);

        while (!pendingUrls.isEmpty() && crawledUrls.size() <= 100) {
            String urlString = pendingUrls.remove(0);
            if (crawledUrls.contains(urlString)) {
                System.out.println(yellow("Already crawled " + urlString));
            } else {
                crawledUrls.add(urlString);
                try(
                    InputStream urlStream = (new URL(urlString)).openStream();
                ) {
                    System.out.println(green("Crawling url " + urlString));
                    List<String> urls = extractUrls(urlStream);
                    urls = urls.stream().filter((url) -> !crawledUrls.contains(url)).toList();
                    // System.out.println("Found following urls from " + urlString + " " + urls);
                    // System.out.println("Adding them to queue");
                    pendingUrls.addAll(urls);
                } catch(MalformedURLException e) {
                    System.out.println(red(e.getMessage()) + ": Invalid url: " + urlString);
                } catch(IOException e) {
                    System.out.println(red(e.getMessage()) + " Error reading from url: " + urlString);
                }
            }
        }
    }


    private static List<String> extractUrls(InputStream urlInputStream) {
        List<String> urls = new ArrayList<>();
        Scanner in = new Scanner(urlInputStream);
        while (in.hasNext()) {
            String _url = in.next();
            // System.out.println("-------------[" + getUrl(_url) + "]----------");
            try {
                String url = getUrl(_url);
                if (!url.equals("")) urls.add(url);
            } catch (MalformedURLException e) {
                System.out.println(red(e.getMessage() + _url));
            }
            
        }
        in.close();
        return urls;
    }

    private static String getUrl(String urlString) throws MalformedURLException {
        if (isUrl(urlString)) {
            // System.out.println(yellow(urlString));
            int startIndex = urlString.indexOf("https");
            int endIndex = urlString.indexOf("\"", startIndex); 
            if (endIndex == -1) {
                throw new MalformedURLException("Malformed html ");
            }
            return urlString.substring(startIndex, endIndex);
        } 
        
        return "";
    }

    private static boolean isUrl(String s) {
        if (s.contains("https:")) return true;
        // if (s.matches("https?:\\/\\/.*\\..*")) return true;
        return false;
    }

    private static String coloredString(String s, String color) {
        return color + s + "\033[0m";
    }

    private static String red(String s) {
        return coloredString(s, "\033[0;31m");
    }
    
    private static String green(String s) {
        return coloredString(s, "\033[0;32m");
    }

    private static String yellow(String s) {
        return coloredString(s, "\033[0;33m");
    }
}