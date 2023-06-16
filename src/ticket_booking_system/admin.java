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
	public class admin extends JFrame{
	 admin(){
			
	    	JButton btn = new JButton("");
	    	btn.setText("ADMIN");
	    	btn.setBackground(Color.BLACK);
	    	btn.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));
	    	btn.setForeground(Color.white);
	    	btn.setBounds(400, 500, 100, 40);
	    	add(btn);
	    	
	    	
			JLabel book = new JLabel("Bookmyseat");
			book.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 80));
			book.setForeground(Color.BLACK);
			book.setBounds(190, 20, 600, 100);
			add(book);
			JButton btn1 = new JButton("USER");
			btn1.setBackground(Color.BLACK);
			btn1.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));
	    	btn1.setBounds(600, 500, 100, 40);  
	    	btn1.setForeground(Color.white);
	    	add(btn1);
            btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					new air2().setVisible(true);
					dispose();
					
				}
			}
				);
			
			btn1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					new air().setVisible(true);
					dispose();
					
				}
			}
				);
			

//		    ImageIcon bus = new ImageIcon("C:/Users/91761/eclipse-workspace/ticket_booking_system/src/ticket_booking_system/wp2577124.jpg");
//	    	Image cd = bus.getImage();
//	    	Image temp_bus = cd.getScaledInstance(300, 250, Image.SCALE_SMOOTH);
//	    	bus = new ImageIcon(temp_bus);
//	    	JLabel middle = new JLabel(bus); 
//	    	middle.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 35));
//			middle.setBounds(600, 320, 300,250);
//			add(middle);
			
			setSize(900, 600);
			setLayout(null);
			ImageIcon back = new ImageIcon("C:/Users/91761/eclipse-workspace/ticket_booking_system/src/ticket_booking_system/image.jpg");
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
			new admin();
		}

	}
	