package ticket_booking_system;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class ticket1  extends JFrame {
	journey obj1 = new journey();
	ticket1(String from, String dest , String date){
		
		JLabel Bus_ticket = new JLabel("BUS TICKET");
		Bus_ticket.setFont(new Font("Helvetica", Font.BOLD, 30));
		Bus_ticket.setBounds(270, 10, 250, 40);
		add(Bus_ticket);
		
		JLabel Date = new JLabel("Date :");
		Date.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
		Date.setBounds(20, 90, 100, 40); 
		add(Date);
		
		JLabel datevalue = new JLabel(date);
		datevalue.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
		datevalue.setBounds(100, 90, 150, 40); 
		add(datevalue);
		
		JLabel source = new JLabel("From :");
		source.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
		source.setBounds(20,190, 100, 40);
		add(source);
		 
		JLabel sourcevalue = new JLabel();
	    sourcevalue.setText(from); 
		sourcevalue.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
		sourcevalue.setBounds(130,190, 100, 40);
		add(sourcevalue);
		
		JLabel Destination = new JLabel("To :");
		Destination.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
		Destination.setBounds(420, 190, 100, 40);
		add(Destination);
		
		JLabel destivalue = new JLabel();
	    destivalue.setText(dest); 
		destivalue.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
		destivalue.setBounds(480,190, 200, 40);
		add(destivalue);
		JLabel busname = new JLabel("Bus name :");
		busname.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
		busname.setBounds(20, 310, 150, 40);
		add(busname);
		
		JLabel Fare = new JLabel("Fare :");
		Fare.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
		Fare.setBounds(420, 310, 100, 40);
		add(Fare);

		JLabel bus = new JLabel();
		bus.setText("  "+display.buslist.get(0));
		bus.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 24));
		bus.setBounds(160, 293, 250, 80);
		add(bus);
		
		JLabel Fare_charge = new JLabel();
		Fare_charge.setText("  "+display.farelist.get(0)); 
		Fare_charge.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
		Fare_charge.setBounds(500, 291, 150, 80);
		add(Fare_charge);
		
//		 JButton print = new JButton("print");
//	        print.setBounds(400, 400, 90, 30);
//	        add(print);
//	        print.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent ae) {
//					if(ae.getSource()==print) {
//						
//					}
//					  try {
//				ticket1.print(0);
//					  }
//					catch(Exception e) {
//						e.printStackTrace();
//					
//					
//				}
					
//				}
//			});
		
		ImageIcon ch = new ImageIcon(
				"C:/Users/91761/eclipse-workspace/ticket_booking_system/src/ticket_booking_system/download.jpg");
		Image img = ch.getImage();
		Image temp_image = img.getScaledInstance(800, 500, Image.SCALE_SMOOTH);
		ch = new ImageIcon(temp_image);
		JLabel ak = new JLabel("", ch, JLabel.CENTER);
		ak.setBounds(0, 0, 800, 500);
		add(ak);
       

		setSize(800, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	protected static void print(int i) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		 
	}

}