package ticket_booking_system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;
public class journey extends JFrame { 
	
    public static JTextField From = new JTextField();
    public static String from ;
    public static String dest ;
    public static String date ;
    int flag =0;
    
	journey() {
		
		JLabel Date = new JLabel("Date->");
		Date.setFont(new Font("Tahoma", Font.BOLD, 22));
		Date.setBounds(280, 260, 150, 30);
		add(Date);
		JTextField Datetext = new JTextField();
		Datetext.setBounds(370, 260, 100, 30);
		// desti.setText();
		Datetext.setEditable(true);
		add(Datetext);

		JLabel book = new JLabel("From ->");
		book.setFont(new Font("Tahoma", Font.BOLD, 22));
		book.setBounds(70, 310, 150, 30);
		add(book);
		JTextField From = new JTextField();
		From.setBounds(180, 310, 200, 30);
		// From.setText();
		From.setEditable(true);
		add(From);
		JLabel one = new JLabel();
		one.setFont(new Font("Tahoma", Font.BOLD, 22));
		one.setBounds(280, 260, 150, 30);
		add(one);
		JLabel to = new JLabel("To ->");
		to.setFont(new Font("Tahoma", Font.BOLD, 22));
		to.setBounds(430, 310, 150, 30);
		add(to);
		JTextField destination = new JTextField();
		destination.setBounds(510, 310, 200, 30);
		// desti.setText();
		destination.isEditable();
		add(destination);

		JButton Search = new JButton("Search");
		Search.setBounds(280, 380, 80, 40);
		add(Search);
		 
		
		
		Search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 from = From.getText();
                                 
			     dest = destination.getText();
			     
			     date = Datetext.getText();
			     String regex = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((?:19|20)[0-9][0-9])";
				 Pattern pattern = Pattern.compile(regex);
			     Matcher matcher = pattern.matcher(date);
				  System.out.println(date +" : "+ matcher.matches());
			     ResultSet rs;
			     if(matcher.matches()) {
			    	 flag=1;
			     }
					if (from.isEmpty() | dest.isEmpty() | date.isEmpty() | flag==0) {
						JOptionPane.showMessageDialog(null, "Please enter correct details");
					}
					else{
			     try {
			            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/image","root", "");
			            String query = "SELECT * FROM path WHERE Source = ? AND Destination =?";
			            PreparedStatement st = con.prepareStatement( query);

			            st.setString(1, from);
			            st.setString(2,  dest);
			            rs = st.executeQuery();
			            if(rs.next()) {
			            	new display(from, dest , date).setVisible(true);
			            	dispose();
			            }
			            else {
			            	JOptionPane.showMessageDialog(null, "enter correct details" );
			            }
			     }

				catch(SQLException ex) {
					ex.printStackTrace();
				
				
			}
					}
			}
		});
		JButton btn5 = new JButton("Cancel");
		btn5.setBounds(400, 380, 80, 40);
		add(btn5);
		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new air().setVisible(true);
				dispose();
			}
		});
		setSize(800, 500);
		setLayout(null);
		ImageIcon ch = new ImageIcon(
				"C:/Users/91761/eclipse-workspace/ticket_booking_system/src/ticket_booking_system/4.-BLOG-FEATURED_JOURNEY_PODCAST-4-1920x1000.png");
		Image img = ch.getImage();
		Image temp_image = img.getScaledInstance(800, 500, Image.SCALE_SMOOTH);
		ch = new ImageIcon(temp_image);
		JLabel ak = new JLabel("", ch, JLabel.CENTER);
		ak.setBounds(0, 0, 800, 500);
		add(ak);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

	}

	public static void main(String[] args) {
		new journey();
                
               
                  
		
	}

}