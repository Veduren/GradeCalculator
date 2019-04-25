//This program will calculate the grade you need to get on your final

import java.util.Scanner;

public class FinalGradeCalculator {

	public static void main(String[] args) {

		//Creating a new Scanner object
		Scanner user_input = new Scanner(System.in);

		//Initializing variables
		double CurrentGrade = 0;
		double DesiredGrade = 0;
		double FinalWorth = 0;

		try {

			//Informing the user of the function of the program
			System.out.println("This program will calculate the grade you need to get on your final");
			
			//Loop checks validity of user input: Current average
			while(true) {
				System.out.print("What is your current average (%): ");
				if(user_input.hasNextDouble()) {
					CurrentGrade = user_input.nextDouble();
					if(CurrentGrade > 0 && CurrentGrade < 100) {
						break;
					}
				}
				else {
					user_input.next(); //clearing the previous value in the scanner
				}
				System.out.println("Invalid Entry! Please enter a number [0,100]");
			}	

			//Loop checks validity of user input: Desired average
			while(true) {
				System.out.print("What is your desired grade (%): ");
				if(user_input.hasNextDouble()) {
					DesiredGrade = user_input.nextDouble();
					if(DesiredGrade > 0 && DesiredGrade < 100) {
						break;
					}
				}
				else {
					user_input.next();
				}
				System.out.println("Invalid Entry! Please enter a number [0,100]");
			}
			
			//Loop checks validity of user input: Final Worth
			while(true) {
				System.out.print("What is the weight of your final (%): ");
				if(user_input.hasNextDouble()) {
					FinalWorth = user_input.nextDouble();
					if(FinalWorth > 0 && FinalWorth < 100) {
						break;
					}
				}
				else {
					user_input.next();
				}
				System.out.println("Invalid Entry! Please enter a number [0,100]");
			}

			//Calculate Minimum grade to get on the final
			double MinimumFinalGrade = (100*(DesiredGrade - CurrentGrade*((100-FinalWorth)/(double) 100)))/(double) FinalWorth;
			System.out.println("You will need at least: " +MinimumFinalGrade + " %");

		}
		finally {
			user_input.close();
		}
	}	
}
