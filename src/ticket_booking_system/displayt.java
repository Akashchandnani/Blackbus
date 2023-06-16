package ticket_booking_system;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class displayt extends JFrame {
	public static String firsttrain = trains.train1();
	public static String secondtrain = trains.train2();
	public static String fare1 =trains.Charge();
	public static String fare2 =trains.Charge();
	public static String thirdtrain = trains.train3();
	public static String fare3 =trains.Charge();
	displayt(String from , String dest , String date) {
		JLabel bus_name = new JLabel("Train Name");
		bus_name.setFont(new Font("Garamond", Font.CENTER_BASELINE, 15));
		bus_name.setBounds(75, 10, 100, 30);
		add(bus_name);
		
		JLabel fare = new JLabel("Fare");
		fare.setFont(new Font("Garamond", Font.CENTER_BASELINE, 15));
		fare.setBounds(350, 10, 100, 30);
		add(fare);

		JLabel fare_charge1 = new JLabel(fare1);
		fare_charge1.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
		fare_charge1.setBounds(350, 50, 100, 30);
		add(fare_charge1);
		
//                JLabel fare_charge5 = new JLabel(fake);
//		fare_charge5.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
//		fare_charge5.setBounds(350, 50, 100, 30);
//		add(fare_charge5);
		
		JLabel fare_charge2 = new JLabel(fare2);
		fare_charge2.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
		fare_charge2.setBounds(350, 120, 100, 30);
		add(fare_charge2);
		
		JLabel fare_charge3 = new JLabel(fare3);
		fare_charge3.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
		fare_charge3.setBounds(350, 200, 100, 30);
		add(fare_charge3);
		
	
		JLabel text1 = new JLabel(firsttrain);
		text1.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
		text1.setBounds(80, 50, 300, 30);
		add(text1);
		
		JLabel text2 = new JLabel(secondtrain);
		text2.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
		text2.setBounds(80, 120, 300, 30);
		add(text2);
		
		JLabel text3 = new JLabel(thirdtrain);
		text3.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 25));
		text3.setBounds(80, 200, 300, 30);
		add(text3);
		
		JButton Confirm1 = new JButton("Confirm");
		Confirm1.setBounds(450, 50, 90, 30);
		add(Confirm1);
		Confirm1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//                            String from = from;
//                            String dest1 = dest;
				new trainticket1(from, dest , date ).setVisible(true);
//                                System.out.println(fake);
			}
		});
		
		JButton Confirm2 = new JButton("Confirm"); 
		Confirm2.setBounds(450, 120, 90, 30);
		add(Confirm2);
		Confirm2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new trainticket2(from, dest , date).setVisible(true);
			}
		});
		
		JButton Confirm3 = new JButton("Confirm");
		Confirm3.setBounds(450, 200, 90, 30);
		add(Confirm3);
		Confirm3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new trainticket3(from, dest , date).setVisible(true);
			}
		});
		
		ImageIcon ch = new ImageIcon(
				"C:/Users/91761/eclipse-workspace/ticket_booking_system/src/ticket_booking_system/download.jpg");
		Image img = ch.getImage();
		Image temp_image = img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
		ch = new ImageIcon(temp_image);
		JLabel ak = new JLabel("", ch, JLabel.CENTER);
		ak.setBounds(0, 0, 900, 600);
		add(ak);

		setSize(600, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		
//                journey obj = new journey();
//                new Mavenproject1(obj.fake);
//                System.out.println(obj.fake);
	}

}