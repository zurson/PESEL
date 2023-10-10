package Main.Utilities;

import Main.Exceptions.InvalidPeselException;

import java.util.Scanner;

import static java.lang.Character.isDigit;

/**
 * Utility class
 */
public class Utils {


    /**
     *
     * Takes input (PESEL) from keyboard
     *
     * @return keyboard input (PESEL)
     *
     */
    public static String getPESELFromUser() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter your PESEL: ");

        return scanner.nextLine();
    }


    /**
     *
     * Checks if given PESEL is valid
     *
     * @param pesel PESEL number
     * @throws InvalidPeselException thrown when given PESEL is invalid
     */
    public static void isCorrectPeselFormat(String pesel) throws InvalidPeselException {

        if (pesel == null)
            throw new InvalidPeselException("Invalid PESEL: null");

        if (pesel.isBlank())
            throw new InvalidPeselException("Invalid PESEL: no input");

        if (pesel.length() != 11)
            throw new InvalidPeselException("Invalid PESEL: invalid length");

        if (!hasOnlyDigits(pesel))
            throw new InvalidPeselException("Invalid PESEL: invalid characters");

    }

    /**
     *
     * Checks if given PESEL consists of only digits
     *
     * @param pesel PESEL number
     * @return true if given PESEL consists of only digits, false otherwise
     */
    private static boolean hasOnlyDigits(String pesel) {
        for (int i=0; i<pesel.length(); i++) {
            if (!isDigit(pesel.charAt(i)))
                return false;
        }

        return true;
    }

}
