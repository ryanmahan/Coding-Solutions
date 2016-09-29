package palindromeMaker;

import java.util.Scanner;

public class PalindromeMaker {
	/*
	 * A Helper method used to get user input and import it into the main method.
	 * @return a String[] filled with
	 * n = the length of input number to palindrome
	 * k = the number of characters that we can change to palindrome
	 * num = the number needing to be "palindromed"
	 */
	public static String[] userInputHelper(){
		String[] inputs = new String[3];
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter 2 numbers, seperated by a space, n, the length of your number, and k, the allowed number of changes to your number");
		System.out.println("Example input 4 2 \n 4242");
		
		String firstLine = input.nextLine();
		
		String[] breakup = firstLine.split(" "); //get first 2 variables delimited by space and split them
		inputs[0] = breakup[0];
		inputs[1] = breakup[1];
		
		inputs[2] = input.next(); //get next variable
		
		input.close();
		return inputs; //return all 3 variables
	}

	/*
	* Recursively creates the palindrome while counting changes and distance from endpoints
	* @param Char[] num - character array of numbers to change
	* 	 int maxChanges - maximum number of changes allowed before printing -1
	*	 int dist - distance from endpoints, starts at 0 and increases with iterations
	*	 int changes - tracks the number of changes done to the char[], increases when changes are made
	* @return the palindromed char[] or -1, if changes > maxChanges
	*/
	public static char[] recursiveSwitcher(char[] num, int maxChanges, int dist, int changes) throws Exception{
		int upperBound = num.length - dist -1;
		if(changes > maxChanges){
			char[] changeOver = {'-','1'};
			return changeOver;
		}else if(dist >= (num.length/2)){
			return num;
		}else if(num[dist] == num[upperBound]){
			num = recursiveSwitcher(num, maxChanges, dist+1, changes);
		}else if(num[dist] > num[upperBound]){
			num[upperBound] = num[dist];
			num = recursiveSwitcher(num, maxChanges, dist+1, changes+1);
		}else if(num[dist] < num[upperBound]){
			num[dist] = num[upperBound];
			num = recursiveSwitcher(num, maxChanges, dist+1, changes+1);
		}else{
			throw new Exception("parameters did not match recursive switcher requirements");
		}
		return num;
	}
	
	public static void main(String[] args) throws Exception {
		String[] inputs = userInputHelper();
		
		int n = Integer.parseInt(inputs[0]);
		int k = Integer.parseInt(inputs[1]);
		String palen = inputs[2];

		char[] palenC = palen.toCharArray();
		char[] mark = new char[palenC.length];
		char[] output = recursiveSwitcher(palenC, k, 0 , 0);
		for( char c : output){
			System.out.print(c);
		}
	}
}
