package guijavafx.basics.general;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class BindingDemo {
	public static void main(String[] args) {
		DoubleProperty d1 = new SimpleDoubleProperty(1);
		DoubleProperty d2 = new SimpleDoubleProperty(2);
		System.out.println("d1: " + d1.getValue() + " d2: " + d2.getValue());
//		d1.bind(d2);  // unidirectional binding
		d1.bindBidirectional(d2);
		System.out.println("d1: " + d1.getValue() + " d2: " + d2.getValue());
		d2.setValue(70.2);
		System.out.println("d1: " + d1.getValue() + " d2: " + d2.getValue());
		
		d1.setValue(99.0); // COMPILER ERROR if using unidirectional binding 
		System.out.println("d1: " + d1.getValue() + " d2: " + d2.getValue());
	}
}
