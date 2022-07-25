package general.elementary;

import org.junit.Test;
import static org.junit.Assert.*;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DisplayCurrentTimeTest {

    @Test
    public void currentTimeTest() {
        ZonedDateTime currentTime = ZonedDateTime.now(ZoneOffset.UTC);
        String time = String.format("%02d:%02d:%02d", currentTime.getHour(), currentTime.getMinute(), currentTime.getSecond());
        assertEquals(time, DisplayCurrentTime.currentTime());
    }
}
