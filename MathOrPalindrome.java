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

            // If the denominator is zero, return -1
            return -1;
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

                            // call sum function
                            double sum = calcSum(numA, numB);

                            // Write the expression to the math output file
                            // rounded to 2 decimal places
                            myWriter.write(line + " = "
                            + String.format("%.2f", sum) + "\n");

                            // If its a subtraction expression
                        } else if (line.contains("-")) {
                            // Split up the numbers by the operator and spaces
                            String[] arrayNumStr = line.split(" - ");

                            // Convert the numbers from strings to doubles
                            double numA = Double.parseDouble(arrayNumStr[0]);
                            double numB = Double.parseDouble(arrayNumStr[1]);

                            // call difference function
                            double difference = calcDifference(numA, numB);

                            // Write the expression to the math output file
                            // rounded to 2 decimal places
                            myWriter.write(line + " = "
                            + String.format("%.2f", difference) + "\n");

                            // If its a multiplication expression
                        } else if (line.contains("*")) {

                            // Split up the numbers by the operator and spaces
                            // Source: https://beginnersbook.com/2013/12/...
                            //...java-string-split-method-example
                            // The \\ is used to escape the * character,
                            // because it is a character with a special meaning
                            String[] arrayNumStr = line.split(" \\* ");

                            // Convert the numbers from strings to doubles
                            double numA = Double.parseDouble(arrayNumStr[0]);
                            double numB = Double.parseDouble(arrayNumStr[1]);

                            // call product function
                            double product = calcProduct(numA, numB);

                            // Write the expression to the math output file
                            // rounded to 2 decimal places
                            myWriter.write(line + " = "
                            + String.format("%.2f", product) + "\n");

                            // If its a division expression
                        } else if (line.contains("/")) {

                            // Split up the numbers by the operator and spaces
                            String[] arrayNumStr = line.split(" / ");

                            // Convert the numbers from strings to doubles
                            double numA = Double.parseDouble(arrayNumStr[0]);
                            double numB = Double.parseDouble(arrayNumStr[1]);

                            // call quotient function
                            double quotient = calcQuotient(numA, numB);

                            // If the denominator is 0
                            if (quotient == -1) {
                                // Write the error message
                                // to the math output file
                                myWriter.write(line + " is undefined.\n");
                            } else {
                                // Write the expression to the math output file
                                // rounded to 2 decimal places
                                myWriter.write(line + " = "
                                + String.format("%.2f", quotient) + "\n");
                            }
                        } else {

                            // Write the error message to the math output file
                            myWriter.write(line
                            + " is not a valid expression.\n");
                        }
                    }

                    // Close the file writer
                     myWriter.close();

                    // Close the file scanner
                    fileScanner.close();

                    // Display success message
                    System.out.println(
                            "Successfully wrote to 'MathOutput.txt'"
                        );

                } catch (Exception exception) {
                    // Display error message
                    System.out.println("Unable to read the file.");
                }
            // If the user enters 2
            } else if (programChoice.equals("2")) {
                // display instructions for the palindrome program
                System.out.println(
                        "You have chosen the palindrome program."
                    );
                try {
                    // scanner object to read the input file
                    File file = new File("./PalindromeInput.txt");

                    // Create a file scanner object
                    Scanner fileScanner = new Scanner(file);

                    // initialize the number of lines
                    int lineNum = 0;

                    // While it has a next line in the file
                    while (fileScanner.hasNextLine()) {

                        // Read the next line
                        fileScanner.nextLine();

                        // increment the number of lines
                        lineNum++;
                    }

                    // initialize the array of words
                    String[] arrayWords = new String[lineNum];

                    // Create a new file scanner object
                    Scanner scanner2 = new Scanner(file);

                    // initialize counter
                    int counter = 0;

                    // while it has a next line in the file
                    while (scanner2.hasNextLine()) {

                        // Read the next line
                        arrayWords[counter] = scanner2.nextLine();

                        // increment the counter
                        counter++;
                    }

                    // Close the file scanner
                    scanner2.close();

                    // Create the palindrome output file
                    FileWriter myWriter = new FileWriter(
                            "./PalindromeOutput.txt"
                        );

                    // call palindrome function
                    String palindromeMessage = findPalindromes(arrayWords);

                    // Write the palindrome message
                    // to the palindrome output file
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
            // If the user enters q
            } else if (programChoice.equals("q")) {
                // display goodbye message
                System.out.println("Thanks for playing!");
            } else {
                // If the user enters an invalid choice
                System.out.println("Invalid choice. Try again.");
            }

        // While the user does not enter q
        } while (!programChoice.equals("q"));

        // Closing Scanner
        scanner.close();
    }
}
