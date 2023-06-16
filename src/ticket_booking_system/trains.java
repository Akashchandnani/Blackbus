package ticket_booking_system;

import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class trains {
    
        // creating ArrayList
    	public static String train1(){
    		
        ArrayList<String> my_list1 = new ArrayList<String>();
  
        // adding elements
        my_list1.add("Intercity Express");
        my_list1.add("Aashram Express11");
        my_list1.add("Duronto Express");
  
        // using collections.shuffle to shuffle elements of
        // ArrayList
       
        int index = (int)(Math.random()*my_list1.size());
        String name1 = my_list1.get(index);
  
        // using for each loop to print values at random
        System.out.println(name1);
        return name1;
        
    	}
    	public static String train2(){
    	 ArrayList<String> my_list2 = new ArrayList<String>();
    	  
         // adding elements
         my_list2.add("Rajdhani Express");
         my_list2.add("Shatabdi Express");
         my_list2.add("Hindustan Express");
   
         // using collections.shuffle to shuffle elements of
         // ArrayList
        
         int index = (int)(Math.random()*my_list2.size());
         String name2 = my_list2.get(index);
   
         // using for each loop to print values at random
         System.out.println(name2);
         return name2;
         
        
         
     	}
    	
    	public static String train3(){
       	 ArrayList<String> my_list3 = new ArrayList<String>();
       	  
            // adding elements
            my_list3.add("Nationl Express");
            my_list3.add("Univarsal Express");
            my_list3.add("Humsafar Express");
      
            // using collections.shuffle to shuffle elements of
            // ArrayList
           
            int index = (int)(Math.random()*my_list3.size());
            String name3 = my_list3.get(index);
      
            // using for each loop to print values at random
            System.out.println(name3);
            return name3;
            
           
            
        	}


    	public static String Charge() {
    		int max = 1000;
    		int min = 100;
    		Random random = new Random();
    		int i =min +  random.nextInt(max-min);
    		String charge = Integer.toString(i);
    		System.out.println(charge);
			return charge;
    		
    	}
    	public static void main(String[] args){
    	     train1();
    	     train2();
    	     train3();
    		Charge();
        
    }
}