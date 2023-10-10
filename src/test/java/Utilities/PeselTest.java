package Utilities;

import Main.Exceptions.InvalidPeselException;
import Main.Utilities.Pesel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeselTest {

    private final String INVALID_PESEL_1 = "01039005231"; // day is 90
    private final String INVALID_PESEL_2 = "01039x05231"; // day is 90

    private final String VALID_PESEL_M = "08242405251";
    private final String VALID_PESEL_K = "08242405221";


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }



    @Test
    @DisplayName("Checking Pesel class constructor")
    void Pesel() {

        assertThrows(InvalidPeselException.class, () -> {
            new Pesel(INVALID_PESEL_1);
        });

        assertThrows(InvalidPeselException.class, () -> {
            new Pesel(INVALID_PESEL_2);
        });

        assertThrows(InvalidPeselException.class, () -> {
            new Pesel(null);
        });

        assertThrows(InvalidPeselException.class, () -> {
            new Pesel("");
        });

        assertThrows(InvalidPeselException.class, () -> {
            new Pesel(" ");
        });

        assertThrows(InvalidPeselException.class, () -> {
            new Pesel("082424052511");
        });


        assertDoesNotThrow( () -> {
            new Pesel(VALID_PESEL_M);
        });

    }

    @Test
    void getPesel() throws InvalidPeselException {

        assertDoesNotThrow( () -> {
            Pesel testPesel = new Pesel(VALID_PESEL_M);
            String myPesel = testPesel.getPesel();

            assertEquals(VALID_PESEL_M, myPesel);
        });

    }


    @Test
    void getBirthYear() {

        assertDoesNotThrow( () -> {
            Pesel testPesel = new Pesel(VALID_PESEL_M);
            assertEquals("2008", testPesel.getBirthYear());
        });

    }

    @Test
    void getBirthMonth() {

        assertDoesNotThrow( () -> {
            Pesel testPesel = new Pesel(VALID_PESEL_M);
            assertEquals("04", testPesel.getBirthMonth());
        });

    }

    @Test
    void getBirthDay() {

        assertDoesNotThrow( () -> {
            Pesel testPesel = new Pesel(VALID_PESEL_K);
            assertEquals("24", testPesel.getBirthDay());
            assertEquals("K", testPesel.getSex());
        });

    }

    @Test
    void getBirthDate() {

        assertDoesNotThrow( () -> {
            Pesel testPesel = new Pesel(VALID_PESEL_M);
            assertEquals("24.04.2008", testPesel.getBirthDate());
            assertEquals("M", testPesel.getSex());
        });

    }

    @Test
    void getSex() {

        assertDoesNotThrow( () -> {
            Pesel testPesel_1 = new Pesel(VALID_PESEL_M);
            Pesel testPesel_2 = new Pesel(VALID_PESEL_K);

            assertEquals("M", testPesel_1.getSex());
            assertEquals("K", testPesel_2.getSex());
        });

    }
}