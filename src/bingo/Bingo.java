package bingo;

import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;

public class Bingo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//bingo card
		String[][] bingoCard = {
				{"7", "23", "39", "54", "68"},
				{"5", "26", "35", "60", "75"},
				{"3", "18", "*", "47", "73"},
				{"14", "25", "41", "55", "66"},
				{"10", "28", "44", "59", "71"}
				
		};
		
		ArrayList<Integer> numbers = new ArrayList<Integer>(); 			//stores numbers that are called
		
		//the Bingo game itself
		for(int turns = 1; turns <= 75; turns++)
		{
			//displaying Bingo card
			 for(int i = 0; i < bingoCard.length; i++)
			 {
				 for(int j = 0; j < bingoCard[i].length; j++)
						 System.out.print(bingoCard[i][j] + " ");
				 
				 System.out.println(" ");
			 }

		//Bingo numbers
				
		Random rand = new Random();
		int n = rand.nextInt(75) + 1;
		for(int index = 0; index < numbers.size(); index++) 
		{
			//if that number was already called
			if(n == numbers.get(index))
			{ 
				n = rand.nextInt(75) + 1;
				index = -1;		//starts loop over

			}

		}
		
		//Bingo letters 
		char letter = 0;
		if(n >=1 && n <= 15)
			letter = 'B';
				
		else if(n >= 16 && n <=30)
			letter = 'I';
				
		else if(n >= 31 && n <= 45)
			letter = 'N';
				
		else if(n >= 46 && n <= 60)
			letter = 'G';
				
		else if(n >= 61 && n <=75)
			letter = '0';
		
		System.out.println(letter);
		System.out.println(n);
		
		numbers.add(n);

		 boolean iGotIt = false;
				
		 for(int i = 0; i < bingoCard.length; i++)
		 {
			 for(int j = 0; j < bingoCard[i].length; j++)
			 {

				 if(bingoCard[i][j].equals("*"))
					 continue;

				 //if you have the letter/number combination being called
				 if(n == Integer.parseInt(bingoCard[i][j]))
				 {  
					 System.out.println("You got that one. Press any key to mark it off");
					 Scanner sc = new Scanner(System.in);
					 String markOff = sc.nextLine();
					 bingoCard[i][j] = "*";
					 iGotIt = true;
					 break;
				 }	
			 } 
		 }	
		
		 if(iGotIt)
		 {
			 //check for Bingo
			 boolean horizontalBingo;
			 boolean verticalBingo;
			 boolean diagnoalBingo;
			 
			 horizontalBingo= horizontal(bingoCard);
			 verticalBingo = vertical(bingoCard);
			 diagnoalBingo = diagnoal(bingoCard);
		
			 boolean bingo = false;
			 
			 if(horizontalBingo)
				 bingo = horizontalBingo;
			 
			 else if(verticalBingo)
				 bingo = verticalBingo;
			 
			 else
				 bingo = horizontalBingo;
		
			if(bingo)
			{		
				 System.out.println("BINGO!!!!");
				 System.out.println("Congratulations!!!  You won");
				 System.out.println("Press any key");
				 
				 //ends game 
				 Scanner finish = new Scanner(System.in);
				 String end  = finish.nextLine();
				 break;
			}
			
			 //no Bingo
			 
			 System.out.println("Done");
			 Scanner keyboard = new Scanner(System.in);
			 System.out.println("On to the next one (press any key)");
			 String next = keyboard.nextLine(); 

	 }
		 				 

		 //if you don't have the letter/number combination being called
		 else
		 {
			 System.out.println("You do not have that one. Press any key to go to the next one");
			 Scanner sc = new Scanner(System.in);
			 String next = sc.nextLine();
		 } 
		 
		 
		 numbers.add(n);
				 
		}
		System.out.println("Thanks for playing");
	}

	private static boolean horizontal(String[][] bingoCard) {
		// TODO Auto-generated method stub
		 
		 for(int i = 0; i < bingoCard.length; i++)
		 {
			 int horizontal = 0;
			 for(int j = 0; j < bingoCard[i].length; j++)
		 {		
				 	//horizontal
					 if(bingoCard[i][j].equals("*"))
						 horizontal++;
						 
						 // you got a bingo
						 if (horizontal == 5)
							 return true;
						 
			 }
		 }
	
		return false;
	}

	private static boolean vertical(String[][] bingoCard) {
		// TODO Auto-generated method stub
	
		 for(int i = 0; i < bingoCard.length; i++)
		 {
			 int vertical = 0; 
			 for(int j = 0; j < bingoCard[i].length; j++)
			 {		//vertical
				 if(bingoCard[j][i].equals("*")) 
					 vertical++;
				 
				 if(vertical == 5)
					 return true;
				 
			 }
		 }
		return false;
	}

	private static boolean diagnoal(String[][] bingoCard) {
		// TODO Auto-generated method stub
		
		//diagnoal
		int rightDiagnoal = 0;	
		int leftDiagnoal = 0;
		for(int i = 0; i < bingoCard.length; i++)
		{
			
			
			for(int j = 0; j < bingoCard[i].length; j++)
			{
				//right diagnoal
				if(bingoCard[i][j].equals("*") && i == j)
					rightDiagnoal++;
					

				
				//left diagnoal
				if(bingoCard[i][bingoCard[i].length - 1 - i].equals("*") && i + j == 4)
					leftDiagnoal++;
				
				//either diagnoal is a bingo
				if(rightDiagnoal == 5 || leftDiagnoal == 5)
					return true;
					
				
			}
		}
		
		return false;
	}


}
