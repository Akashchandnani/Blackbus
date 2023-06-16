package ticket_booking_system;

import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class Buses {
    
        // creating ArrayList
    	public static String Bus1(){
    		
        ArrayList<String> my_list1 = new ArrayList<String>();
  
        // adding elements
        my_list1.add("VRL Travels");
        my_list1.add("SRS TRavels");
        my_list1.add("Shrinath Travels");
  
        // using collections.shuffle to shuffle elements of
        // ArrayList
       
        int index = (int)(Math.random()*my_list1.size());
        String name1 = my_list1.get(index);
  
        // using for each loop to print values at random
        System.out.println(name1);
        return name1;
    	}
    	public static String Bus2() {
    		ArrayList<String> my_list2 = new ArrayList<String>();
        
        // adding elements
        my_list2.add("KVM Travels");
        my_list2.add("Kallada Travels");
        my_list2.add("Rajasthan Travels");
  
        // using collections.shuffle to shuffle elements of
        // ArrayList
       
        int index = (int)(Math.random()*my_list2.size());
        String name2 = my_list2.get(index);
  
        // using for each loop to print values at random
        System.out.println(name2);
        return name2;
       
        
    	}
    	
    	public static String Bus3() {
    		ArrayList<String> my_list3 = new ArrayList<String>();
        
        // adding elements
        my_list3.add("National Travels");
        my_list3.add("Univarsal Travels");
        my_list3.add("volvo Travels");
  
        // using collections.shuffle to shuffle elements of
        // ArrayList
       
        int index = (int)(Math.random()*my_list3.size());
        String name3 = my_list3.get(index);
  
        // using for each loop to print values at random
        System.out.println(name3);
        return name3;
        
    	}
    	
    	public static String Charge() {
    		int max = 500;
    		int min = 100;
    		Random random = new Random();
    		int i =min +  random.nextInt(max-min);
    		String charge = Integer.toString(i);
    		System.out.println(charge);
			return charge;
    		
    	}
    	public static void main(String[] args){
    		Bus1();
    		Bus2();
    		Bus3();
    		Charge();
        
    }
}