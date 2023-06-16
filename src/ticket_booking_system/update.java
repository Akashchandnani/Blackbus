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
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class update extends JFrame {
//	int flag=0;
	int r1 =0;
	update(){
		JLabel route = new JLabel("ADD NEW ROUTE");
		route.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 30));
		route.setBounds(70, 20, 600, 50);
		add(route);
		JLabel source = new JLabel("SOURCE:");
		source.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 20));
		source.setBounds(25, 80, 200, 50);
		add(source);
		
		JTextField user = new JTextField();
		user.setBounds(25,125, 200, 30);
		add(user);
		
		JLabel destination = new JLabel("DESTINATION:");
		destination.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 20));
		destination.setBounds(25, 160, 200, 50);
		add(destination);
		
		JTextField dest = new JTextField();
		dest.setBounds(25,200, 200, 30);
		add(dest);
		
		JButton go = new JButton("CONFIRM");
		go.setFont(new Font("Tahoma", Font.CENTER_BASELINE,15));
		go.setBounds(150, 270, 120, 40);
		add(go);
		
//		JLabel bus = new JLabel("BUS DETAILS");
//		bus.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 35));
//		bus.setBounds(320, 250, 600, 50);
//		add(bus);
//		
//		JLabel busname = new JLabel("BUS NAME:");
//		busname.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 25));
//		busname.setBounds(25, 340, 200, 50);
//		add(busname);
//		
//		JComboBox<String> bustext = new JComboBox();
//		bustext.setBounds(175,350, 200, 35);
//		add(bustext);
		
//		try {
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/image","root", "");
//            Statement stmt = con.createStatement();
//            ResultSet rst = stmt.executeQuery("SELECT bus_name FROM bus");
//            while( rst.next()) {
//              String name = rst.getString("bus_name");
//              bustext.addItem(name);
//            }
//		}
//            catch(SQLException ex) {
//				ex.printStackTrace();	
//		}
//		
//		JLabel busfare = new JLabel("BUS FARE:");
//		busfare.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 25));
//		busfare.setBounds(410, 340, 200, 50);
//		add(busfare);
//		
//		JTextField faretext = new JTextField();
//		faretext.setBounds(605,348, 200, 35);
//		add(faretext);
//		
//		JButton go1 = new JButton("ADD");
//		go1.setFont(new Font("Tahoma", Font.CENTER_BASELINE,15));
//		go1.setBounds(730, 410, 70, 40);
//		add(go1);
//		
		JButton back = new JButton("BACK");
		back.setFont(new Font("Tahoma", Font.CENTER_BASELINE,15));
		back.setBounds(50, 270, 80, 40);
		add(back);
//		
		go.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String from = user.getText();
				String desti = dest.getText();
//				String name = (String)bustext.getSelectedItem();
//				String fare = faretext.getText();
				if(from.isEmpty() || desti.isEmpty()) {
					JOptionPane.showMessageDialog(null , "Details can't be blank");
				}
				else {
					try {
			            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/image","root", "");
			            String query1 = "SELECT R_id FROM path ORDER BY R_id DESC LIMIT 1";
			            Statement stmt = con.createStatement();
			            ResultSet rst = stmt.executeQuery(query1);
			            if( rst.next()) {
			              r1=rst.getInt(1);
			            }
			           
			            
//			            String query2 = "SELECT bus_id FROM bus WHERE bus_name =? ";
//			            PreparedStatement str = con.prepareStatement(query2);
//			            str.setString(1,name);
//			            ResultSet rs = str.executeQuery();
//			            int r3 = 0;
//			            if(rs.next()) {
//			            	r3=rs.getInt(1);
//			            }
//			            System.out.println();
			            int r2 = r1+1;
			            String query = "INSERT INTO path(R_id,Source , Destination) VALUES(?,?,?)";
			            PreparedStatement st = con.prepareStatement( query);
			            st.setInt(1,r2 );
			            st.setString(2, from);
			            st.setString(3,  desti);
			            
//			            String query3 = "INSERT INTO root(R_id,bus_id , bus_fare) VALUES(?,?,?)";
//			            PreparedStatement sts = con.prepareStatement( query3);
//			            sts.setInt(1,r2 );
//			            sts.setInt(2, r3);
//			            sts.setString(3,fare);
			            if(st.executeUpdate()> 0) {
			            	JOptionPane.showMessageDialog(null, "insert successfull");
			            	JOptionPane.showMessageDialog(null, "please set bus for "+from+" to "+desti);
			            	new farebus().setVisible(true);
			            	dispose();
			            }
			            
					}
			            catch(SQLException ex) {
							ex.printStackTrace();
						
						
					}
				}
			}
		});
//		
//		if(flag==1) {
//		for(int i = 0 ; i<2; i++) {
//        go1.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//			 	 String name = (String)bustext.getSelectedItem();
//				String fare = faretext.getText();
//				
//				if(name.isEmpty() || fare.isEmpty()) {
//					JOptionPane.showMessageDialog(null , "Details can't be blank");
//				}
//				
//			
//			
//			}
//		});
//		}
//		}
        back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new options().setVisible(true);
				dispose();
				
			}
		}
			);
		ImageIcon image = new ImageIcon("C:/Users/91761/eclipse-workspace/ticket_booking_system/src/ticket_booking_system/update.jpg");
		Image img = image.getImage();
		Image temp_img = img.getScaledInstance(400,440,Image.SCALE_SMOOTH);
		image = new ImageIcon(temp_img);
		JLabel background = new JLabel("",image,JLabel.CENTER);
		background.setBounds(0, 0, 400, 380);
		add(background);
		
		setSize(400, 380);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
            
	public static void main(String[] args) {
		new update();

	}

}
