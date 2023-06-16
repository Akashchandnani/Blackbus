package ticket_booking_system;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class display extends JFrame {
	ResultSet rs1;
	String busname;
	String busfare;
	static ArrayList<String> buslist = new ArrayList<String>();  
	static ArrayList<String> farelist = new ArrayList<String>();  
	display(String from, String dest , String date) {
		
	int r1 = 0;
		try {		
		  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/image","root", "");
		  String query = "SELECT R_id FROM path WHERE Source = ? AND Destination =?";
          PreparedStatement stm = con.prepareStatement( query);
          stm.setString(1, from);
          stm.setString(2,  dest);
         ResultSet rs = stm.executeQuery();
         if( rs.next()) {
           r1=rs.getInt(1);
         }


	        String query1 = "SELECT * From bus ,root, path WHERE bus.bus_id = root.bus_id AND path.R_id=root.R_id AND path.R_id=?";
 
	        PreparedStatement st = con.prepareStatement(query1);
	        st.setInt(1,r1);
	        rs1 = st.executeQuery();
	       
	       while(rs1.next()) {
	    	   busname=rs1.getString("bus_name");
	    	   busfare=rs1.getString("bus_fare");
	    	   buslist.add(busname);
	    	   farelist.add(busfare);
	    	   
			}
	       
	       }
	       catch(SQLException ex) {
				ex.printStackTrace();
			
			
		}
		int l1 = buslist.size();
	    int l2 = farelist.size();
		if(l1 ==3 && l2 ==3) {
		JLabel bus_name = new JLabel("Buses Name");
		bus_name.setFont(new Font("Garamond", Font.CENTER_BASELINE, 15));
		bus_name.setBounds(75, 10, 100, 30);
		add(bus_name);
		
		JLabel fare = new JLabel("Fare");
		fare.setFont(new Font("Garamond", Font.CENTER_BASELINE, 15));
		fare.setBounds(350, 10, 100, 30);
		add(fare);

		JLabel fare_charge1 = new JLabel(farelist.get(0));
		fare_charge1.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
		fare_charge1.setBounds(350, 50, 100, 30);
		add(fare_charge1);
		JLabel fare_charge2 = new JLabel(farelist.get(2));
		fare_charge2.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
		fare_charge2.setBounds(350, 120, 100, 30);
		add(fare_charge2);
		
		JLabel fare_charge3 = new JLabel(farelist.get(1));
		fare_charge3.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
		fare_charge3.setBounds(350, 200, 100, 30);
		add(fare_charge3);
		
	
		JLabel text1 = new JLabel(buslist.get(0));
		text1.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
		text1.setBounds(80, 50, 300, 30);
		add(text1);
		
		JLabel text2 = new JLabel(buslist.get(1));
		text2.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
		text2.setBounds(80, 120, 300, 30);
		add(text2);
		
		JLabel text3 = new JLabel(buslist.get(2));
		text3.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
		text3.setBounds(80, 200, 300, 30);
		add(text3);
		
		JButton Confirm1 = new JButton("Confirm");
		Confirm1.setBounds(450, 50, 90, 30);
		add(Confirm1);
		Confirm1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ticket1(from, dest , date ).setVisible(true);
				dispose();
			}
		});
		
		JButton Confirm2 = new JButton("Confirm"); 
		Confirm2.setBounds(450, 120, 90, 30);
		add(Confirm2);
		Confirm2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ticket2(from, dest , date).setVisible(true);
				dispose();
			}
		});
		
		JButton Confirm3 = new JButton("Confirm");
		Confirm3.setBounds(450, 200, 90, 30);
		add(Confirm3);
		Confirm3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ticket3(from, dest , date).setVisible(true);
				dispose();
			}
		});
		}
		if(l1==2 && l2 ==2) {
			JLabel bus_name = new JLabel("Buses Name");
			bus_name.setFont(new Font("Garamond", Font.CENTER_BASELINE, 15));
			bus_name.setBounds(75, 10, 100, 30);
			add(bus_name);
			
			JLabel fare = new JLabel("Fare");
			fare.setFont(new Font("Garamond", Font.CENTER_BASELINE, 15));
			fare.setBounds(350, 10, 100, 30);
			add(fare);

			JLabel fare_charge1 = new JLabel(farelist.get(0));
			fare_charge1.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
			fare_charge1.setBounds(350, 75, 100, 30);
			add(fare_charge1);
			JLabel fare_charge2 = new JLabel(farelist.get(1));
			fare_charge2.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
			fare_charge2.setBounds(350, 175, 100, 30);
			add(fare_charge2);
			
//			JLabel fare_charge3 = new JLabel(farelist.get(2));
//			fare_charge3.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
//			fare_charge3.setBounds(350, 200, 100, 30);
//			add(fare_charge3);
			
		
			JLabel text1 = new JLabel(buslist.get(0));
			text1.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
			text1.setBounds(80, 75, 300, 30);
			add(text1);
			
			JLabel text2 = new JLabel(buslist.get(1));
			text2.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
			text2.setBounds(80, 175, 300, 30);
			add(text2);
			
//			JLabel text3 = new JLabel(buslist.get(2));
//			text3.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
//			text3.setBounds(80, 200, 300, 30);
//			add(text3);
			
			JButton Confirm1 = new JButton("Confirm");
			Confirm1.setBounds(450, 75, 90, 30);
			add(Confirm1);
			Confirm1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					new ticket1(from, dest , date ).setVisible(true);
					dispose();
				}
			});
			
			JButton Confirm2 = new JButton("Confirm"); 
			Confirm2.setBounds(450, 175, 90, 30);
			add(Confirm2);
			Confirm2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					new ticket2(from, dest , date).setVisible(true);
					dispose();
				}
			});
			
//			JButton Confirm3 = new JButton("Confirm");
//			Confirm3.setBounds(450, 200, 90, 30);
//			add(Confirm3);
//			Confirm3.addActionListener(new ActionListener() {
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					new ticket3(from, dest , date).setVisible(true);
//					dispose();
//				}
//			});
		}
		if(l1==1 && l2 ==1) {
			JLabel bus_name = new JLabel("Buses Name");
			bus_name.setFont(new Font("Garamond", Font.CENTER_BASELINE, 15));
			bus_name.setBounds(75, 10, 100, 30);
			add(bus_name);
			
			JLabel fare = new JLabel("Fare");
			fare.setFont(new Font("Garamond", Font.CENTER_BASELINE, 15));
			fare.setBounds(350, 10, 100, 30);
			add(fare);

			JLabel fare_charge1 = new JLabel(farelist.get(0));
			fare_charge1.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
			fare_charge1.setBounds(350, 125, 100, 30);
			add(fare_charge1);
//			JLabel fare_charge2 = new JLabel(farelist.get(1));
//			fare_charge2.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
//			fare_charge2.setBounds(350, 120, 100, 30);
//			add(fare_charge2);
			
//			JLabel fare_charge3 = new JLabel(farelist.get(2));
//			fare_charge3.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
//			fare_charge3.setBounds(350, 200, 100, 30);
//			add(fare_charge3);
			
		
			JLabel text1 = new JLabel(buslist.get(0));
			text1.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
			text1.setBounds(80, 125, 300, 30);
			add(text1);
			
//			JLabel text2 = new JLabel(buslist.get(1));
//			text2.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
//			text2.setBounds(80, 120, 300, 30);
//			add(text2);
			
//			JLabel text3 = new JLabel(buslist.get(2));
//			text3.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
//			text3.setBounds(80, 200, 300, 30);
//			add(text3);
			
			JButton Confirm1 = new JButton("Confirm");
			Confirm1.setBounds(450, 125, 90, 30);
			add(Confirm1);
			Confirm1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					new ticket1(from, dest , date ).setVisible(true);
					dispose();
				}
			});
			
//			JButton Confirm2 = new JButton("Confirm"); 
//			Confirm2.setBounds(450, 120, 90, 30);
//			add(Confirm2);
//			Confirm2.addActionListener(new ActionListener() {
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					new ticket2(from, dest , date).setVisible(true);
//					dispose();
//				}
//			});
			
//			JButton Confirm3 = new JButton("Confirm");
//			Confirm3.setBounds(450, 200, 90, 30);
//			add(Confirm3);
//			Confirm3.addActionListener(new ActionListener() {
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					new ticket3(from, dest , date).setVisible(true);
//					dispose();
//				}
//			});
		}
		ImageIcon ch = new ImageIcon(
				"C:/Users/91761/eclipse-workspace/ticket_booking_system/src/ticket_booking_system/download.jpg");
		Image img = ch.getImage();
		Image temp_image = img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
		ch = new ImageIcon(temp_image);
		JLabel ak = new JLabel("", ch, JLabel.CENTER);
		ak.setBounds(0, 0, 600, 300);
		add(ak);

		setSize(600, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	public static void main(String[] args) {
		
	}

}