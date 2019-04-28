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

	private JButton calculateButton;
	private JButton resetButton;
	private JTextField avgField;
	private JTextField desiredField;
	private JTextField finalField;
	private String storeAvg;
	private String storeDesired;
	private String storeFinal;

	//constructor 
	public Display(){

		//Setting up Display
		super("Final Grade Calculator");
		setPreferredSize(new Dimension(680,150));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout layout = new GridLayout(4,2); 
		setLayout(layout);

		//Creating the components i.e label, text field and buttons 
		JLabel textAvg = new JLabel("What is your current average (%): ");
		avgField = new JTextField();
		JLabel textDesired = new JLabel("What is your desired grade (%): ");
		desiredField = new JTextField();
		JLabel textFinal = new JLabel("How much is your final worth (%): ");
		finalField = new JTextField();
		calculateButton = new JButton("Calculate");
		resetButton = new JButton("Reset");

		//Adding the components
		add(textAvg);
		add(avgField);
		add(textDesired);
		add(desiredField);
		add(textFinal);
		add(finalField);
		add(resetButton);
		add(calculateButton);

		pack();
		setVisible(true);

		//Creating new object "eventPressed" from eventHandler class
		eventHandler eventPressed = new eventHandler();
		calculateButton.addActionListener(eventPressed);
		resetButton.addActionListener(eventPressed);
	}

	//new class that handles all the action
	private class eventHandler implements ActionListener{

		//method called automatically when an action occurs
		public void actionPerformed(ActionEvent e) {

			//if Calculate button is clicked
			if(e.getSource() == calculateButton) {

				//if all text fields are empty
				if(avgField.getText().isEmpty() && desiredField.getText().isEmpty() && finalField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Fill out all text fields");
				
				//if Current Average text field is empty
				}else if(avgField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter your current grade");
				
				//if Desired Grade text field is empty
				}else if(desiredField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter your desired grade");
				
				//if Weight of final text field is empty
				}else if(finalField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter the weight of the final");
				
				}else {				
					//Calculates minimum grade in final
					try {
						storeAvg = avgField.getText();
						storeDesired = desiredField.getText();
						storeFinal = finalField.getText();
						double currentGrade = Double.parseDouble(storeAvg);
						double desiredGrade = Double.parseDouble(storeDesired);
						double finalWorth = Double.parseDouble(storeFinal);
						double MinimumFinalGrade = (100*(desiredGrade - currentGrade*((100-finalWorth)/(double) 100)))/(double) finalWorth;
						double finalGrade = Math.round(MinimumFinalGrade*100)/100.0;
						JOptionPane.showMessageDialog(null,"You will need at least: " + finalGrade +"%");	
					
					//if user does not enter a number in any of the text fields
					}catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Error: Enter a number between 0 and 100.");
					}
				}
			
			//if Reset button is clicked
			}else if(e.getSource() == resetButton){
				avgField.setText("");
				desiredField.setText("");
				finalField.setText("");
			}
		
		}

	}
}
