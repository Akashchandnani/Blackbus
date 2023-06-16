package ticket_booking_system;
import java.util.regex.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
public class register1 extends JFrame{
	int flag=0;
	int temp=0;
    register1(){
    	JButton btn = new JButton("register");
    	JButton btn1 = new JButton("Back");
		JLabel book = new JLabel("Register now");
		book.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 35));
		book.setBounds(300, 25, 250, 80);
		add(book);
		JTextField user = new JTextField();
		user.setBounds(330,130, 200, 20);
		JLabel username = new JLabel("Username:");
		username.setFont(new Font("Tahoma", Font.BOLD, 18));
		username.setBounds(200, 100, 150, 80);
		
		add(username);
		add(user);
		
		JTextField first = new JTextField();
		first.setBounds(330,180, 200, 20);
		
		JLabel First = new JLabel("First_name:");
		First.setFont(new Font("Tahoma", Font.BOLD, 18));
		First.setBounds(200, 150, 150, 80);
		
		add(first);
		add(First);
		
		JTextField second = new JTextField();
		second.setBounds(330,230, 200, 20);
		JLabel sec = new JLabel("last_name:");
		sec.setFont(new Font("Tahoma", Font.BOLD, 18));
		sec.setBounds(200, 200, 150, 80);
		
		add(second);
		add(sec);
		
		JFormattedTextField third = new JFormattedTextField();
		third.setBounds(330,280, 200, 20);
		JLabel email = new JLabel("email:");
		email.setFont(new Font("Tahoma", Font.BOLD, 18));
		email.setBounds(200, 250, 150, 80);
		
		add(third);
		add(email);
		
		JTextField forth = new JTextField();
		forth.setBounds(330,330, 200, 20);
		JLabel phn = new JLabel("phone no:");
		phn.setFont(new Font("Tahoma", Font.BOLD, 18));
	    phn.setBounds(200, 300, 150, 80);
		
		add(forth);
		add(phn);
		
		JTextField pasw = new JTextField();
		pasw.setBounds(330, 380, 200, 20);
		
		JLabel password = new JLabel("password:");
		password.setFont(new Font("Tahoma", Font.BOLD, 18));
		password.setBounds(200, 350, 150, 80);
		
		add(password);
		add(pasw); 
		
		btn.setBounds(430, 450, 100, 30);
		 ImageIcon arrow = null;
		 
		add(btn);
		
		btn1.setBounds(230, 450, 100, 30);
		add(btn1);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String user_name = user.getText();
				String passwd = pasw.getText();
				String firstname = first.getText();
				String lastname = second.getText();
                String thirdd = third.getText();
				String fourthh = forth.getText();
				String regex = "^(.+)@(.+)$";
				Pattern pattern = Pattern.compile(regex);
				
					  Matcher matcher = pattern.matcher(thirdd);
					  System.out.println(thirdd +" : "+ matcher.matches());
					  String rege = "(0/91)?[7-9][0-9]{9}";
			          Pattern patter = Pattern.compile(rege);
						
					  Matcher match = patter.matcher(fourthh );
					  System.out.println(fourthh  +" : "+ matcher.matches());
				
				if(user_name.isEmpty()|passwd.isEmpty()|firstname.isEmpty()|lastname.isEmpty()|thirdd.isEmpty()|fourthh.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Fill all the required fileds");
				}
				else {
				try {
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/image","root", "");
		            String query = "INSERT INTO register1(user_name, passwd, type) VALUES(?,?,?)";
		            PreparedStatement st = con.prepareStatement( query);
		            st.setString(1, user_name);
		            st.setString(2,  passwd);
		            st.setString(3, "A");
		            if(matcher.matches()){
						flag =1;
		            }
		            else {
		            	JOptionPane.showMessageDialog(null, "enter valid email");
		            	
		            }
		            if(match.matches()){
						temp =1;
		            }
		            else {
		            	JOptionPane.showMessageDialog(null, "enter valid phone no.");
		            	
		            }
		            
		            if(flag == 1 && temp ==1) {
		            if(st.executeUpdate()>0) {
		            	JOptionPane.showMessageDialog(null, "User successfully added");
		            }
		            }
				}
				catch(SQLException ex) {
					ex.printStackTrace();
				}
				dispose();
				
			}
				
		}
		}
		
				);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new options().setVisible(true);
				dispose();
				
			}
		});
		setSize(800, 550);
		setLayout(null);
		ImageIcon back = new ImageIcon("C:/Users/91761/eclipse-workspace/ticket_booking_system/src/ticket_booking_system/download.jpg");
		Image img = back.getImage();
		Image temp_img = img.getScaledInstance(800,550,Image.SCALE_SMOOTH);
		back = new ImageIcon(temp_img);
		JLabel background = new JLabel("",back,JLabel.CENTER);
		background.setBounds(0, 0, 800, 550);
		add(background);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
	public static void main(String[] args) {
		
		new register1();
	}

}
