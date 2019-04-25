/*
 * This program will calculate the grade you need to get on your final
 * Author: Ved
 */

import java.util.Scanner;

public class FinalGradeCalculator {
	
	public static void main(String[] args) {
		
		//Creating a new Scanner object
		Scanner user_input = new Scanner(System.in);
		
		try {
			
		//Informing the user of the function of the program
		System.out.println("This program will calculate the grade you need to get on your final");
		
		//User enters Current Grade
		System.out.print("What is your current average (%): ");
		double CurrentGrade = user_input.nextDouble();
		
		//User enters desired grade
		System.out.print("What is your desired grade (%): ");
		int DesiredGrade = Integer.parseInt(user_input.next());
		
		//User enters final worth
		System.out.print("What is the weight of your final (%): ");
		double FinalWorth = user_input.nextDouble();
		
		//Calculate Minimum grade to get on the final
		double MinimumFinalGrade = (100*(DesiredGrade - CurrentGrade*((100-FinalWorth)/(double) 100)))/(double) FinalWorth;
		System.out.println("You will need at least: " +MinimumFinalGrade + " %");
		
		}
		finally {
			user_input.close();
		}
	}	
}
