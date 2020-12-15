/**
Programmer: Akash Shah
Program Name: SlotMachineSimulation
Date: 10/29/20
Description: The program simulates a virtual slot machine. The program asks the user how much money they want to bet, and then the random operator will pick three random numbers.
Depending on what numbers are picked, different words or options will be selected. The program will save the three words chosen, and display them to the user.
The program will calcualte and display the bet amount and the amount won before asking the user if the want to play again.
If the user says yes, then the program will repeat the slot machine sinulation, and if the user says no, then the program will display the total bet amount, the total amount won, and the net win/loss.
*/

/**
Pseudocode:
1. Create Message Box
2. Create random operator
3. Define all variables
4. Add random command
5. Make while loop for inputs and outputs
6. Display "Enter bet amount: "
7. Input bet amount
8. Calculate the bet amount
9. Make for loop for random command
10. Add every option for the random command in the if statements
11. Pick a random word and plug it into a variable to hold it
12. Display the three random words
13. Display the amount won, the total bet amount, and total amount won
14. Display "Do you want to play again (y,n)? "
15. Input y or n
16. Rerun code if input is 'y'
17. Display total bet amount, total amount won, and net win/loss if input is 'n'
*/

import javax.swing.JOptionPane; // Adds the message box for user bet and output
import java.util.Random; // Adds the random operator 

public class SlotMachineSimulation
{
   public static void main(String [] args)
   {
      String bet;// Holds the bet amount inputed
      double amount;// Holds the bet amount
      int wordindex;// Holds the random value
      String word = ""; // Holds the word options
      int wordCount;// Holds the number of times the random operator is used
      String output = "";// Holds the displayed messages
      String word1 = "";// Holds the first word displayed
      String word2 = "";// Holds the second word displayed
      String word3 = "";// Holds the third word displayed
      char repeat = 'y';// Holds the play again answer
      double totalEntered = 0;// Holds the total bet amount
      double totalWon = 0;// Holds the total amount won
      
      Random random = new Random(); // Holds the random command

      // Continues to display the slot machine, the money given and won, and continues to ask the user for money and if they want to play again
      while (repeat == 'y')
      {
         output = "";// Holds the output displayed
         bet = JOptionPane.showInputDialog("Enter bet amount: ");// Asks the user for their bet amount
         amount = Double.parseDouble(bet);// Holds the bet amount
         totalEntered = totalEntered + amount;// Calculates to the total bet
      
         // Random operator to find the different words
         for (wordCount = 1; wordCount <= 3; wordCount++)
         {
            wordindex = random.nextInt(6);// Holds the random values
      
            if (wordindex == 0)
            {
               word = "Cherries";// Holds the first option
            }
            else if (wordindex == 1)
            {
               word = "Oranges";// Holds the second option
            }
            else if (wordindex == 2)
            {
               word = "Plums";// Holds the third option
            }
            else if (wordindex == 3)
            {
               word = "Bells";// Holds the fourth option
            }
            else if (wordindex == 4)
            {
               word = "Melons";// Holds the fifth option
            }
            else if (wordindex == 5)
            {
               word = "Bars";// Holds the sixth option
            }
         
            // If statement to plug in and hold the three different words
            if (wordCount == 1)
            {
               word1 = word;// Holds the first random option
            }
            else if (wordCount == 2)
            {
               word2 = word;// Holds the second random option
            }
            else if (wordCount == 3)
            {
               word3 = word;// Holds the third random option
            }
         }
         
         // Displays the three words
         JOptionPane.showMessageDialog(null, "[ " + word1 + " ]\t\t\t\t\t\t[ " + word2 + " ]\t\t\t\t\t\t[ " + word3 + " ]");
      
         // Displays the winnings from the round
         // No words are the same
         if (word1 != word2 && word1 != word3 && word2 != word3)
         {
            output = output + "\n\n You won $0.00";// Displays the money won
            totalWon = totalWon + 0;// Calculates the total money won from the round
         }
         // Two words are the same
         else if (word1 == word2 && word1 != word3 || word1 == word3 && word1 != word2 || word2 == word3 && word2 != word1)
         {
            output = output + String.format("\n\n You won $%,.2f", (amount * 2));// Displays the money won and multiplies the bet amount by 2
            totalWon = totalWon + (amount * 2);// Calculates the total money won from the round
         }
         // All three words are the same
         else if (word1 == word2 && word1 == word3 && word2 == word3)
         {
            output = output + String.format("\n\n You won $%,.2f", (amount * 3));// Displays the money won and multipolies the bet amount by 3
            totalWon = totalWon + (amount * 3);// Calculates the total money won from the round
         }
         
         // Displays the total bet amount and the total amount won
         output = output + String.format("\n\n Amount inserted: $%,.2f \n Amount won: $%,.2f", totalEntered,totalWon);
                  
         // Asks the user if they want to play again
         repeat = JOptionPane.showInputDialog(output + "\n\n\n Do you want to play again (y,n)? ").charAt(0);
      }
      
      // Displays the total bet amount, the total amount won, and the total net win/loss
      // The bet amount is greater than the amount won
      if (totalEntered > totalWon)
      {
         JOptionPane.showMessageDialog(null, String.format("Total amount inserted: $%,.2f \nTotal amount won: $%,.2f \nNet loss: -$%,.2f", totalEntered, totalWon, (totalEntered - totalWon)));
      }
      // The bet amount is less than the amount won
      else if (totalEntered < totalWon)
      {
         JOptionPane.showMessageDialog(null, String.format("Total amount inserted: $%,.2f \nTotal amount won: $%,.2f \nNet win: $%,.2f", totalEntered, totalWon, (totalWon - totalEntered)));
      }
      // The bet amount is the same as the amount won
      else
      {
         JOptionPane.showMessageDialog(null, String.format("Total amount inserted: $%,.2f \nTotal amount won: $%,.2f \nNet win/loss: $0.00", totalEntered, totalWon));
      }
      
      // Closes the message box
      System.exit(0);
   }
}
