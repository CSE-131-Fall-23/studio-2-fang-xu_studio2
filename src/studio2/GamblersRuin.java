package studio2;

import java.util.Scanner;

public class GamblersRuin {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int ruins = 0;
		double expectedRuinRate;
		
		System.out.println("How many simulations would you like to run: ");
		int totalSimulations = in.nextInt();
		System.out.println("Enter your start amount: ");
		int startAmount = in.nextInt();
		System.out.println("Enter your win limit: ");
		int winLimit = in.nextInt();
		System.out.println("Enter your win chance: ");
		double winChance = in.nextDouble();
		
		for(int i = 1; i <= totalSimulations ; i++) {
			int rounds = 0;
			int currentAmount = startAmount;
			while(currentAmount > 0 && currentAmount < winLimit) {
				rounds++;
				if(Math.random()>winChance) {
					currentAmount--;
				}
				else {
					currentAmount++;
				}
				
			}
			if(currentAmount == 0) {
				//System.out.println(rounds + "LOSE");
				ruins++;
			}
			else if(currentAmount == winLimit) {
				//System.out.println(rounds + "WIN");
			}
		}
		System.out.println("LOSSES: " + ruins + " SIMULATIONS: " + totalSimulations);
		double ruinRate = ruins/(double)totalSimulations;
		System.out.println("Ruin Rate from Simulation: " + ruinRate);
		if(winChance == 0.5) {
			expectedRuinRate = 1.0 - startAmount/(double)winLimit;
		}
		else {
			double x = (1.0-winChance)/winChance;
			expectedRuinRate = (Math.pow(x, startAmount) - Math.pow(x, winLimit))/(1.0 - Math.pow(x, winLimit));
			
		}
		System.out.println("Expected Ruin Rate: " + expectedRuinRate);

	}

}