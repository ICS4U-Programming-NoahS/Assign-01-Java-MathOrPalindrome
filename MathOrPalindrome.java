import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;

/**
* The MathOrPalindrome.java is 2 programs in one.
* The user can choose the one they want to try.
* The first program evaluates arithmetic expressions.
* In the MathInput.txt file, there are various arithmetic expressions.
* The math program will read the file and evaluate the expressions.
* The program will display the result of each expression to MathOutput.txt.
* The second program checks if words are palindromes.
* In the PalindromeInput.txt file, there are various words.
* The palindrome program finds if each of those words are palindromes.
* The program will display whether or not each word is a palindrome
* to PalindromeOutput.txt.
* The program will keep looping until the user presses 'q' to quit.

*
* @author Noah Smith
* @version 1.0
* @since 2025-04-09
*/

final class MathOrPalindrome {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private MathOrPalindrome() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Function for the palindrome program.
     *
     * @param arrayWords The array of words.
     * @return What words are palindromes.
     */

    public static String findPalindromes(final String[] arrayWords) {

        // Initialize the palindrome message
        String palindromeMessage = "";

        // Loop through the array of words
        for (String word : arrayWords) {

            // initialize the reversed word
            String reversedWord = "";

            // Source: w3schools.com/java/tryjava.asp?...
            //...filename=demo_howto_reverse_string
            // Reverse the word, character by character
            for (int counter = 0; counter < word.length(); counter++) {
                reversedWord = word.charAt(counter) + reversedWord;
            }
            // Check if the word is a palindrome
            if (word.equals(reversedWord)) {
                // If the word is a palindrome
                palindromeMessage += word + " is a palindrome.\n";
            } else {
                // If the word is not a palindrome
                palindromeMessage += word + " is not a palindrome.\n";
            }
        }

        // Return the palindrome message
        return palindromeMessage;
    }

    /**
     * Function for addition.
     *
     * @param numA The first number.
     * @param numB The second number.
     * @return The sum of the two numbers.
     */
    public static double calcSum(final double numA, final double numB) {

        // Calculate and return sum
        return numA + numB;
    }

    /**
     * Function for subtraction.
     *
     * @param numA The first number.
     * @param numB The second number.
     * @return The difference of the two numbers.
     */
    public static double calcDifference(final double numA, final double numB) {

        // Calculate and return difference
        return numA - numB;
    }

    /**
     * Function for multiplication.
     *
     * @param numA The first number.
     * @param numB The second number.
     * @return The product of the two numbers.
     */
    public static double calcProduct(final double numA, final double numB) {

        // Calculate and return the product
        return numA * numB;
    }

    /**
     * Function for division.
     *
     * @param numA The first number.
     * @param numB The second number.
     * @return The quotient of the two numbers.
     */
    public static double calcQuotient(final double numA, final double numB) {
        // Check if the denominator is zero
        if (numB == 0) {

            // If the denominator is zero, return NaN
            return Double.NaN;
        } else {
            // Calculate and return the quotient
            return numA / numB;
        }
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(final String[] args) {

        // Using Scanner for getting input from user
        Scanner scanner = new Scanner(System.in);

        // Greet user
        System.out.println("Welcome!");

        // Initialize choice outside of the loop
        String programChoice = "";

        // Loop to give user another chance to enter valid input
        // and to run the program again
        do {

            // Tell the options to the user
            System.out.println(
                    "Enter 1 to use the arithmetic expressions program. "
                );
            System.out.println(
                    "Enter 2 to use the palindrome program. "
                );
            System.out.println(
                    "If you are done playing, enter 'q' to quit: "
                );

            // Get the choice from the user as a string
            programChoice = scanner.nextLine();

            // If the user enters 1
            if (programChoice.equals("1")) {
                // display instructions for the arithmetic expressions program
                System.out.println(
                            "You picked the arithmetic expressions program."
                        );
                System.out.println("\n");

                // Catch any file errors
                try {
                    // scanner object to read the file
                    File file = new File("./MathInput.txt");

                    // Create a file scanner object
                    Scanner fileScanner = new Scanner(file);

                    // Create the math output file
                    FileWriter myWriter = new FileWriter("./MathOutput.txt");

                    // while there is another line in the file
                    while (fileScanner.hasNextLine()) {

                        // Create a file writer object
                        String line = fileScanner.nextLine();

                        // If its an addition expression
                        if (line.contains("+")) {
                            // Split up the numbers by the operator and spaces
                            // The \\ is used to escape the + character,
                            // because it is a character with a special meaning
                            // Source: beginnersbook.com/2013/12/java-...
                            //...string-split-method-example
                            String[] arrayNumStr = line.split(" \\+ ");

                            // Convert the numbers from strings to doubles
                            double numA = Double.parseDouble(arrayNumStr[0]);
                            double numB = Double.parseDouble(arrayNumStr[1]);

                            // Call sum function
                            double sum = calcSum(numA, numB);

                            // Write the expression to the output file,
                            // rounded to 2 decimal places
                            myWriter.write(line + " = "
                                    + String.format("%.2f", sum) + "\n");

                        } else if (line.contains("-")) {

                            // Split up the numbers by the operator and spaces
                            String[] arrayNumStr = line.split(" - ");

                            // Convert the numbers from strings to doubles
                            double numA = Double.parseDouble(arrayNumStr[0]);
                            double numB = Double.parseDouble(arrayNumStr[1]);

                            // Call difference function
                            double difference = calcDifference(numA, numB);

                            // Write the expression to the output file,
                            // rounded to 2 decimal places
                            myWriter.write(line + " = "
                                    + String.format("%.2f", difference)
                                    + "\n");

                        } else if (line.contains("*")) {
                            // Split up the numbers by the operator and spaces
                            // The \\ is used to escape the + character,
                            // because it is a character with a special meaning
                            // Source: beginnersbook.com/2013/12/java-...
                            //...string-split-method-example
                            String[] arrayNumStr = line.split(" \\* ");

                            // Convert the numbers from strings to doubles
                            double numA = Double.parseDouble(arrayNumStr[0]);
                            double numB = Double.parseDouble(arrayNumStr[1]);

                            // Call product function
                            double product = calcProduct(numA, numB);

                            // Write the expression to the output file,
                            // rounded to 2 decimal places
                            myWriter.write(line + " = "
                                    + String.format("%.2f", product) + "\n");

                        } else if (line.contains("/")) {
                            // Split up the numbers by the operator and spaces
                            String[] arrayNumStr = line.split(" / ");

                            // Convert the numbers from strings to doubles
                            double numA = Double.parseDouble(arrayNumStr[0]);
                            double numB = Double.parseDouble(arrayNumStr[1]);

                            // Call quotient function
                            double quotient = calcQuotient(numA, numB);

                            // If the quotient is undefined
                            if (Double.isNaN(quotient)) {
                                myWriter.write(line + " is undefined.\n");
                            } else {
                                // Write the expression to the output file,
                                myWriter.write(line + " = "
                                        + String.format("%.2f", quotient)
                                        + "\n");
                            }
                        // If the expression is not valid
                        } else {
                            myWriter.write(line
                                    + " is not a valid expression.\n");
                        }
                    }
                    // Close file writer
                    myWriter.close();

                    // Close file scanner
                    fileScanner.close();

                    // Display success message
                    System.out.println(
                            "Successfully wrote to 'MathOutput.txt'"
                        );

                // Catch any file errors
                } catch (Exception exception) {
                    // Display error message
                    System.out.println("Unable to read the file.");
                }

            // If the user enters 2
            } else if (programChoice.equals("2")) {
                // Palindrome program
                System.out.println("You have chosen the palindrome program.");
                try {
                    // Open the input file for reading
                    File file = new File("./PalindromeInput.txt");

                    // Create a file scanner object
                    Scanner fileScanner = new Scanner(file);

                    // Initialize the number of lines
                    int lineNum = 0;

                    // While there is another line in the file
                    while (fileScanner.hasNextLine()) {

                        // Read the line
                        fileScanner.nextLine();

                        // Increment the number of lines
                        lineNum++;
                    }

                    // Create an array of strings to hold the words
                    String[] arrayWords = new String[lineNum];

                    // Create another file scanner object
                    Scanner scanner2 = new Scanner(file);

                    // Reset the counter
                    int counter = 0;

                    // Read the file again
                    while (scanner2.hasNextLine()) {

                        // Read the line
                        // and store it in the array
                        arrayWords[counter] = scanner2.nextLine();

                        // Increment the counter
                        counter++;
                    }

                    // Close the scanner
                    scanner2.close();

                    // Open output file for writing
                    FileWriter myWriter = new FileWriter(
                            "./PalindromeOutput.txt"
                        );

                    // Call the palindrome function
                    String palindromeMessage = findPalindromes(arrayWords);

                    // Write to the palindrome output file
                    myWriter.write(palindromeMessage);

                    // Close the file writer
                    myWriter.close();

                    // Close the file scanner
                    fileScanner.close();

                    // Display success message
                    System.out.println(
                            "Successfully wrote to 'PalindromeOutput.txt'"
                        );
                } catch (Exception exception) {
                    // Display error message
                    System.out.println("Unable to read the file.");
                }

            // If the user enters 'q'
            } else if (programChoice.equals("q")) {
                System.out.println("Thanks for playing!");
            // If the user enters anything else
        } else {
            System.out.println("Invalid choice. Try again.");
        }

        // Loop until the user enters 'q'
        } while (!programChoice.equals("q"));

        // Closing Scanner
        scanner.close();
    }
}
