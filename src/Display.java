import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Display extends JFrame {

	private JButton addbutton1;
	private JTextField avgField;
	private String store;

	//constructor 
	public Display(){
		
		//Setting up Display
		super("Final Grade Calculator");
		setPreferredSize(new Dimension(680,200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout layout = new GridLayout(5,2); // 5 rows, 2 columns 
		setLayout(layout);

		//Creating the components i.e label, text field and buttons 
		JLabel textAvg = new JLabel("What is your current average (%): ");
		avgField = new JTextField();
		JLabel textDesired = new JLabel("What is your desired grade (%): ");
		JTextField desiredField = new JTextField();
		JLabel textFinal = new JLabel("How much is your final worth (%): ");
		JTextField finalField = new JTextField();
		JLabel textResult = new JLabel("You must obtain the following grade in the final (%): ");
		JTextField resultField = new JTextField();
		addbutton1 = new JButton("Calculate");
		JButton addbutton2 = new JButton("Reset");
		
		//Adding the components
		add(textAvg);
		add(avgField);
		add(textDesired);
		add(desiredField);
		add(textFinal);
		add(finalField);
		add(textResult);
		add(resultField);
		add(addbutton2);
		add(addbutton1);
		
		pack();
		setVisible(true);

		//Creating new object "eventPressed" from eventHandler class
		eventHandler eventPressed = new eventHandler();
		addbutton1.addActionListener(eventPressed);
	}
	
	//new class that handles all the action
	private class eventHandler implements ActionListener{
		
		//method called automatically when an action occurs
		public void actionPerformed(ActionEvent e) {

			if(e.getSource() == addbutton1) {
				store = avgField.getText();
				JOptionPane.showMessageDialog(null, store);
			}
		}
	}
	
}
