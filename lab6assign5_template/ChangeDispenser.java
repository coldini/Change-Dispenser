package lab6assign5_template;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/* CIS 2168 Data Structures
 *  Section Number: 003
 *  Colden Jeanmonod tur26337@temple.edu
 *  Assignment Name: Assign 5
 *  ChangeDispenser
 *  This class makes a change dispenser that uses a recursive function to 
 *  throught the amounts 1 by 1 and eventaully stops when there is no more change to be given.
 *  
 */
public class ChangeDispenser {

    //public wrapper
    //NOTE - your wrapper method does NOT have to be a void method.
	
	/*
	 * makeChange
	 * parameters amount, the amount that the user inputs
	 * returns: none
	 * this class goes just initializes everything like the names and values of the coins
	 * and then calls the recursive function.
	 */
    public static void makeChange(int amount) {
        //add your code
        
        //Hints:
        //Use a list to store the denomination values of coins in decreasing order.
        //          //100, 50, 25, 10, 5, 1
        //          //$, 50c, 25c, 10c, 5c, 1c
	//Use a second list to store the names of coins in the same order as their denomination value list.
        //          //"DOLLAR", "HALF-DOLLAR", "DIME"...
      
        //call the private recursive counterpart and pass the corresponding
        //   arguments.
    	
    	
    	int[] coinCost = {100, 50, 25, 10, 5, 1};
    	LinkedList<Integer> coinValues = new LinkedList<>();
    	//adds all the coin costs to the linked list, seemed easier than saying add a bunch
    	for(int i = 0; i < coinCost.length; i++) {
    		coinValues.add(coinCost[i]);
    	}
    	
    	String[] coinNames = {"DOLLAR", "HALF-DOLLAR", "QUARTER","DIME", "NICKEL", "PENNY"};
    	LinkedList<String> namesOfCoins = new LinkedList<>();
    	//same as the last one, just seemed easier then going add a bunch of times
    	for(int j = 0; j < coinNames.length; j++) {
    		namesOfCoins.add(coinNames[j]);
    	}
    	
    	makeChange(amount, coinValues, namesOfCoins);
    	
    	
    }

    
    /*
     * MakeChange
     * This is the recursive class for this  and calls itself and prints out how many of 
     * each coin type is used
     * Parameters: Amount, the amount of money, coinValues: the values of the coins, and coinNames, all the names of the coins
     * returns: none
     */
    private static void makeChange(int amount, LinkedList<Integer> coinValues, LinkedList<String> coinNames) {
    	//checks to make sure there is an amount to be broken down
    	if(amount == 0) {
    		return;
    	}
    	
    	int count =  amount / coinValues.get(0);
    	
    	
    	System.out.print(count + " ");
    	//checks to see if the coin name needs to be made plural
    	if(count == 1) {
    		System.out.println(coinNames.get(0));
    	}
    	else {
    		System.out.println(makeCoinsPlural(coinNames.get(0)));
    	}
    	
    	int remainingAmount = amount % coinValues.get(0);
    	
    	coinValues.remove(0);
    	coinNames.remove(0);
    	
    	
    	
    	makeChange(remainingAmount, coinValues,coinNames);
    }
    
    
    /*
     * makeCoinsPlural
     * this will take a coin name and check and see if it needs to be made plural or not
     * parameters, coinName: the name of the coin that is being used
     * returns, the name of the coin but made plural
     */
    private static String makeCoinsPlural(String coinName) {
    	//This if else statement just checks all of the coins to see how they would be made plural and returns that statement.
    	if(coinName.equals("PENNY")) {
    		return "PENNIES";
    		
    	}
    	else if(coinName.equals("NICKEL")){
    		return "NICKELS";
    	}
    	else if(coinName.equals("DIME")) {
    		return "DIMES";
    	}
    	else if(coinName.equals("QUARTER")) {
    		return "QUARTERS";
    	}
    	else if(coinName.equals("HALF-DOLLAR")) {
    		return "HALF-DOLLARS";
    	}
    	else {
    		return coinName + "s";
    	}
    	
    }
    		//$, 50c, 25c, 10c, 5, 1c
    //dollar, half-dollar, 
    //private static void makeChange(parameter list) {
    //private recursive counterpart
    //NOTE - your recursive method does NOT have to be a void method.
    // example:
    // private static void makeChange(parameter list) {
    //   HintS -
    //       Your recursive method uses the coin value list and the coin name list. 
    //       In each call to the recursive method, the count of the first coin in the list 
    //          (coin in largest denomination value) is calculated and printed out. 
    //           Required: print singular or plural names based on coin count.
    //             e.g. 1 PENNY, 2 PENNIES, etc.
    //       Then the first coin is removed from both lists. 
    //       The remaining amount of money is calculated. 
    //       The coin lists and the remaining amount are passed to the next recursive call. 
    //       The recursion ends when no money is left.
    //}
    
    
    //print: count, demoniation: PENNY, PENNIES
    
    public static void main(String[] args) {

        //add your code to do the following:
        
        //prompt the user to enter the amount in dollars and cents
        //get the amount
        //convert the amount to all cents
        //call the public wrapper method
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Please put in the amount of money in dollars and cents, for example 0.00.");
        double amount = userInput.nextDouble();
        
        int newAmount = (int)(amount * 100);
        
        makeChange(newAmount);
        //NOTE -
        // test your code using $2.93, $0.91, $0.78, $0
    }

}
