package ticket_booking_system;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class farebus extends JFrame {
	
 farebus(){
	 JLabel route = new JLabel("ADD NEW ROUTE");
		route.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 35));
		route.setBounds(300, 20, 600, 50);
		add(route);
		JLabel source = new JLabel("SOURCE:");
		source.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 25));
		source.setBounds(25, 91, 200, 50);
		add(source);
		
		JTextField user = new JTextField();
		user.setBounds(180,105, 150, 35);
		add(user);
		
		JLabel destination = new JLabel("DESTINATION:");
		destination.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 23));
		destination.setBounds(458, 91, 200, 50);
		add(destination);
		
		JTextField dest = new JTextField();
		dest.setBounds(650,101, 150, 35);
		add(dest);
	 
	    JLabel bus = new JLabel("BUS DETAILS");
		bus.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 35));
		bus.setBounds(320, 220, 300, 50);
		add(bus);
		
		JLabel busname = new JLabel("BUS NAME:");
		busname.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 25));
		busname.setBounds(25, 303, 200, 50);
		add(busname);
		
		JComboBox<String> bustext = new JComboBox();
		bustext.setBounds(185,313, 150, 35);
		add(bustext);
		
		try {
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/image","root", "");
         Statement stmt = con.createStatement();
         ResultSet rst = stmt.executeQuery("SELECT bus_name FROM bus");
         while( rst.next()) {
           String name = rst.getString("bus_name");
           bustext.addItem(name);
         }
		}
         catch(SQLException ex) {
				ex.printStackTrace();	
		}	
		JLabel busfare = new JLabel("BUS FARE:");
		busfare.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 25));
		busfare.setBounds(458, 303, 200, 50);
		add(busfare);
		
		JTextField faretext = new JTextField();
		faretext.setBounds(640,310, 150, 35);
		add(faretext);
		
		JButton go1 = new JButton("CONFIRM");
		go1.setFont(new Font("Tahoma", Font.CENTER_BASELINE,15));
		go1.setBounds(500, 480, 110, 40);
		add(go1);
		
		JButton back = new JButton("BACK");
		back.setFont(new Font("Tahoma", Font.CENTER_BASELINE,15));
		back.setBounds(360, 480, 80, 40);
		add(back);
		
		 go1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int r1=0;
					String from = user.getText();
					String desti = dest.getText();
					String name = (String)bustext.getSelectedItem();
					String fare = faretext.getText();
					if(from.isEmpty() || desti.isEmpty()||name.isEmpty()||fare.isEmpty()) {
						JOptionPane.showMessageDialog(null , "Details can't be blank");
					}
					else {
						try {
				            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/image","root", "");
				            String query1 = "SELECT R_id FROM path WHERE Source = ? AND Destination =?";
				            PreparedStatement stm = con.prepareStatement( query1);
				            stm.setString(1, from);
				            stm.setString(2,  desti);
				            ResultSet rst = stm.executeQuery();
				            if( rst.next()) {
				             r1=rst.getInt(1);
				           }
				            
				            String query2 = "SELECT bus_id FROM bus WHERE bus_name =? ";
				            PreparedStatement str = con.prepareStatement(query2);
				            str.setString(1,name);
				            ResultSet rs = str.executeQuery();
				            int r3 = 0;
				            if(rs.next()) {
				            	r3=rs.getInt(1);
				            }
				            int count=0;
				            String query3 = "SELECT COUNT(R_id) FROM root WHERE R_id = ? ";
				            PreparedStatement strs = con.prepareStatement(query3);
				            strs.setInt(1,r1);
				            ResultSet rss = strs.executeQuery();
				            if(rss.next()) {
				            	count=rss.getInt(1);
				            }
				   
				            if(count<3) {
				            String query4 = "INSERT INTO root(R_id,bus_id , bus_fare) VALUES(?,?,?)";
				            PreparedStatement sts = con.prepareStatement( query4);
				            sts.setInt(1,r1 );
				            sts.setInt(2, r3);
				            sts.setString(3,fare);
				            if(sts.executeUpdate()> 0) {
				            	JOptionPane.showMessageDialog(null, "insert successfull");
//				            	JOptionPane.showMessageDialog(null, "please set bus for "+from+" to "+desti);
//				            	new farebus().setVisible(true);
//				            	dispose();
				            }
				            }
				            else {
				            	JOptionPane.showMessageDialog(null, "you already have 3 bus can't add more");
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
		background.setBounds(0, 0, 900, 600);
		add(background);
		
		setSize(900, 600);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
            
	public static void main(String[] args) {
		new farebus();

	}
}
