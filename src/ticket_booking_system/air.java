package ticket_booking_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
public class air extends JFrame{
 air(){
		
		JButton btn = new JButton("login");
		JLabel book = new JLabel("Bookmyseat");
		book.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 35));
		book.setBounds(300, 40, 250, 80);
		add(book);
		JTextField user = new JTextField();
		user.setBounds(350,180, 200, 30);
		JLabel username = new JLabel("Username:");
		username.setFont(new Font("Tahoma", Font.BOLD, 22));
		username.setBounds(200, 150, 150, 80);
		
		add(username);
		add(user);
		
		
		JPasswordField pasw = new JPasswordField();
		pasw.setEchoChar('*');
		pasw.setBounds(350, 230, 200, 30);
		JLabel password = new JLabel("password:");
		password.setFont(new Font("Tahoma", Font.BOLD, 22));
		password.setBounds(200, 200, 150, 80);
		
		add(password);
		add(pasw); 
		btn.setBounds(350, 300, 80, 30);
		btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		 ImageIcon arrow = null; 
	     JButton btn1 = new JButton(arrow); 
	     btn1.setText("Register new user");
	     btn1.setFont(new Font("Tahoma", Font.BOLD, 15));
		 btn1.setBounds(350, 340, 180, 30);
		 JButton btn2 = new JButton(); 
	     btn2.setText("Back");
	     btn2.setFont(new Font("Tahoma", Font.BOLD, 15));
		 btn2.setBounds(450, 300, 80, 30);
		 
		add(btn);
		add(btn1);
		add(btn2);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String user_name = user.getText();
				String passwd = pasw.getText();
				ResultSet rs;
				if(user_name.isEmpty()) {
					JOptionPane.showMessageDialog(null, "username can't be blank." );
				}
				else {
				try {
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/image","root", "");
		            String query = "SELECT * FROM register1 WHERE user_name = ? AND passwd =? AND type = ?" ;
		            PreparedStatement st = con.prepareStatement( query);
		            st.setString(1, user_name);
		            st.setString(2,  passwd);
		            st.setString(3,  "u");
		            rs = st.executeQuery();
		            if(rs.next()) {
		            	JOptionPane.showMessageDialog(null, "Welcome  "+user_name );
		            	new journey().setVisible(true);
		            	dispose();
		            }
		            else {
		            	JOptionPane.showMessageDialog(null, "Wrong details" );
		            }

				}
				
				catch(SQLException ex) {
					ex.printStackTrace();
				
				
			}
				}
		}
			}
		);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new register().setVisible(true);
				dispose();
				
			}
		}
			);
        btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new admin().setVisible(true);
				dispose();
				
			}
		}
			);
		setSize(900, 600);
		setLayout(null);
		ImageIcon back = new ImageIcon("C:/Users/91761/eclipse-workspace/Poornima/src/ticket.jpg");
		Image img = back.getImage();
		Image temp_img = img.getScaledInstance(900,600,Image.SCALE_SMOOTH);
		back = new ImageIcon(temp_img);
		JLabel background = new JLabel("",back,JLabel.CENTER);
		background.setBounds(0, 0, 900, 600);
		add(background);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	public static void main(String[] args) {
		new air();
	}

}
