package ticket_booking_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class choose extends JFrame{
     choose(){
    	JLabel book = new JLabel("Online booking");
		book.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 35));
		book.setBounds(300, 4, 300, 80);
		add(book);
//		
//    	ImageIcon Flight = new ImageIcon("C:/Users/91761/eclipse-workspace/ticket_booking_system/src/ticket_booking_system/flight.jpg");
//    	Image ab = Flight.getImage();
//    	Image temp_flight = ab.getScaledInstance(210, 180, Image.SCALE_SMOOTH);
//    	Flight = new ImageIcon(temp_flight);
//    	JButton btn1 = new JButton("Flight" , Flight);
//    	btn1.setBounds(150, 80, 180, 180);
//    	add(btn1);
    	
    	ImageIcon bus = new ImageIcon("C:/Users/91761/eclipse-workspace/ticket_booking_system/src/ticket_booking_system/bus.jpg");
    	Image cd = bus.getImage();
    	Image temp_bus = cd.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
    	bus = new ImageIcon(temp_bus);
    	JButton btn2 = new JButton("Bus" , bus);
    	btn2.setBounds(120, 150, 280, 300);
    	add(btn2);
    	btn2.addActionListener(new ActionListener() {
			
	  		@Override
			public void actionPerformed(ActionEvent e) {
			    	
				new journey().setVisible(true);
				dispose();
				}
			}
    	);
    	ImageIcon train = new ImageIcon("C:/Users/91761/eclipse-workspace/ticket_booking_system/src/ticket_booking_system/train.jpg");
    	Image ef = train.getImage();
    	Image temp_train = ef.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
    	train = new ImageIcon(temp_train);
    	JButton btn3 = new JButton("Train", train);
    	btn3.setBounds(450, 150, 280, 300);         
    	add(btn3);
        btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			    	
				new trainjurney().setVisible(true);
				dispose();
				}
			}
    	);
    	

//    	ImageIcon cab = new ImageIcon("C:/Users/91761/eclipse-workspace/ticket_booking_system/src/ticket_booking_system/cab.jpg");
//    	Image gh = cab.getImage();
//    	Image temp_cab = gh.getScaledInstance(210, 180, Image.SCALE_SMOOTH);
//    	cab = new ImageIcon(temp_cab);
//    	JButton btn4 = new JButton("Cab", cab);
//    	btn4.setBounds(450, 320, 180, 180);
//    	add(btn4);
    	
    	JButton btn5 = new JButton("Back");
    	btn5.setBounds(350, 520, 80, 30);
    	add(btn5);
    	btn5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			    	
				new air().setVisible(true);
			}
		});
    	
    	setSize(900,600);
    	setLayout(null);
    	ImageIcon ch = new ImageIcon("C:/Users/91761/eclipse-workspace/ticket_booking_system/src/ticket_booking_system/download.jpg");
    	Image img = ch.getImage();
    	Image temp_image = img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
    	ch = new ImageIcon(temp_image);
    	JLabel ak = new JLabel("", ch, JLabel.CENTER);
    	ak.setBounds(0,0, 900, 600);
    	add(ak);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	}
    	
    
	public static void main(String[] args) {
		new choose();
	}

}
