package Main;

import Main.Exceptions.InvalidPeselException;
import Main.Utilities.Pesel;
import Main.Utilities.Utils;


/**
 * Main.Main program class
 */
public class Main {

    /**
     *
     * Main.Main program method
     *
     * @param args program arguments (unused)
     */
    public static void main(String[] args) {

        Pesel pesel = null;
        boolean isValid = false;

        do {

            try {
                pesel = new Pesel(Utils.getPESELFromUser());
                isValid = true;
            } catch (InvalidPeselException e) {
                System.out.println(e.getMessage());
            }

        } while (!isValid);

        System.out.println("PESEL: " + pesel.getPesel());
        System.out.println("DATA URODZENIA: " + pesel.getBirthDate());
        System.out.println("PLEC: " + pesel.getSex());
    }

}