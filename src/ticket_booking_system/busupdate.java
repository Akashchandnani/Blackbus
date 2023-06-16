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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class busupdate extends JFrame {
	int r1;
	busupdate(){
		JLabel route = new JLabel("ADD NEW BUS");
		route.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 35));
		route.setBounds(100, 20, 600, 50);
		add(route);
		JLabel source = new JLabel("BUS NAME:");
		source.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 25));
		source.setBounds(25, 100, 200, 50);
		add(source);
		
		JTextField user = new JTextField();
		user.setBounds(230,111, 200, 35);
		add(user);

//		JLabel destination = new JLabel("BUS FARE:");
//		destination.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 25));
//		destination.setBounds(25, 200, 200, 50);
//		add(destination);
//		
//		JTextField dest = new JTextField();
//		dest.setBounds(230,211, 200, 35);
//		add(dest);
		
		JButton go = new JButton("CONFIRM");
		go.setFont(new Font("Tahoma", Font.CENTER_BASELINE,15));
		go.setBounds(230, 200, 120, 40);
		add(go);
		
//		JLabel bus = new JLabel("BUS DETAILS");
//		bus.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 35));
//		bus.setBounds(320, 230, 600, 50);
//		add(bus);
//		
//		JLabel busname = new JLabel("BUS NAME:");
//		busname.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 25));
//		busname.setBounds(25, 320, 200, 50);
//		add(busname);
//		
//		JTextField bustext = new JTextField();
//		bustext.setBounds(175,330, 200, 35);
//		add(bustext);
//		
//		JLabel busfare = new JLabel("BUS FARE:");
//		busfare.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 25));
//		busfare.setBounds(410, 320, 200, 50);
//		add(busfare);
//		
//		JTextField faretext = new JTextField();
//		faretext.setBounds(605,331, 200, 35);
//		add(faretext);
//		
//		JButton go1 = new JButton("GO");
//		go1.setFont(new Font("Tahoma", Font.CENTER_BASELINE,15));
//		go1.setBounds(750, 390, 60, 40);
//		add(go1);
		
		JButton back = new JButton("BACK");
		back.setFont(new Font("Tahoma", Font.CENTER_BASELINE,15));
		back.setBounds(100, 200, 80, 40);
		add(back);
		
		go.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String busname = user.getText();
				if(busname.isEmpty()) {
					JOptionPane.showMessageDialog(null , "Bus name can't be blank");
				}
				else {
					try {
			            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/image","root", "");
			            String query1 = "SELECT bus_id FROM bus ORDER BY bus_id DESC LIMIT 1;";
			            Statement stmt = con.createStatement();
			            ResultSet rst = stmt.executeQuery(query1);
			            if( rst.next()) {
			              r1=rst.getInt(1);
			            }
			            int r2 = r1+1;
			            String query = "INSERT INTO bus(bus_id,bus_name) VALUES(?,?)";
			            PreparedStatement st = con.prepareStatement( query);
			            st.setInt(1,r2 );
			            st.setString(2, busname);
			            if(st.executeUpdate()> 0) {
			            	JOptionPane.showMessageDialog(null, "insert successfull");
			            }
					}
			            catch(SQLException ex) {
							ex.printStackTrace();
						
						
					}
				}
				
			}
		});
		
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
		Image temp_img = img.getScaledInstance(900,600,Image.SCALE_SMOOTH);
		image = new ImageIcon(temp_img);
		JLabel background = new JLabel("",image,JLabel.CENTER);
		background.setBounds(0, 0, 500, 400);
		add(background);
		
		setSize(500, 300);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
            
	public static void main(String[] args) {
		new busupdate();

	}

}
