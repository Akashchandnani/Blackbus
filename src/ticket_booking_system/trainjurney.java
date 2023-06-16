package ticket_booking_system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class trainjurney extends JFrame { 
	
    public static JTextField From = new JTextField();
    public static String from ;
    public static String dest ;
    public static String date ;
    
	trainjurney() {
		
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
				if (from.isEmpty() | dest.isEmpty() | date.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter correct details");
				} else {

					new displayt(from, dest , date).setVisible(true);
					dispose();
					 
				}
			}
		});
		JButton btn5 = new JButton("Cancel");
		btn5.setBounds(400, 380, 80, 40);
		add(btn5);
		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

//				new choose().setVisible(true);;
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
		new trainjurney();
                
               
                  
		
	}

}