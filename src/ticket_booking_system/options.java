package ticket_booking_system;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class options extends JFrame{
	options(){
		JLabel route = new JLabel("UPDATES");
		route.setForeground(Color.WHITE);
		route.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 30));
		route.setBounds(150, 20, 300, 50);
		add(route);
		
		JButton add = new JButton("Add new admin");
		add.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 16));
		add.setBackground(Color.white);  
    	add.setForeground(Color.black);
		add.setBounds(50,100, 160, 30);
		add(add);
		JButton update = new JButton("Add new route");
	    update.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 16));
	    update.setBackground(Color.white);  
    	update.setForeground(Color.black);
	    update.setBounds(250,100, 160, 30);
		add(update);
		 
		JButton bus = new JButton("Add new bus");
	    bus.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 16));
	    bus.setBackground(Color.white);  
    	bus.setForeground(Color.black);
	    bus.setBounds(50,180, 160, 30);
		add(bus);
		
		JButton transport = new JButton("SET BUS ");
		transport.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 16));
		transport.setBackground(Color.white);  
    	transport.setForeground(Color.black);
		transport.setBounds(250,180, 160, 30);
		add(transport);
		
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new register1().setVisible(true);
				dispose();
				
			} 
		}
			);
		
        update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new update().setVisible(true);
				dispose();
				
			}
		}
			);
//        
       bus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new busupdate().setVisible(true);
				dispose();
				
			} 
		}
			);
       
       transport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new farebus().setVisible(true);
				dispose();
				
			} 
		}
			);
       
       JButton btn5 = new JButton("Back");
		btn5.setBounds(170, 250, 80, 30);
		add(btn5);
		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new air2().setVisible(true);
				dispose();
			}
		});
		ImageIcon back = new ImageIcon("C:/Users/91761/eclipse-workspace/ticket_booking_system/src/ticket_booking_system/wp2577124.jpg");
		Image img = back.getImage();
		Image temp_img = img.getScaledInstance(500,350,Image.SCALE_SMOOTH);
		back = new ImageIcon(temp_img);
		JLabel background = new JLabel("",back,JLabel.CENTER);
		background.setBounds(0, 0, 500, 350);
		add(background);
	setSize(500, 350);
	setLayout(null);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new options();
	}
}    
