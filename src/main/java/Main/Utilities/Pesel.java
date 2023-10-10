package Main.Utilities;

import Main.Exceptions.InvalidPeselException;

/**
 * Class for parsing and storing PESEL
 */
public class Pesel {

    /**
     * Index from which the program takes number to check sex
     */
    private final int PESEL_SEX_NUMBER_INDEX = 10 - 1;


    /**
     * There is PESEL in this variable
     */
    private String pesel;

    /**
     * Year of birth from given PESEL
     */
    private String birthYear;

    /**
     * Month of birth from given PESEL
     */
    private String birthMonth;

    /**
     * Day of birth from given PESEL
     */
    private String birthDay;

    /**
     * Sex from given PESEL
     */
    private String sex;

    /**
     * Flag that means if year of birth is under 2000
     */
    private boolean isUnderMillenium;


    /**
     *
     * Create a new instance of Pesel
     *
     * @param pesel pesel input
     * @throws InvalidPeselException exception which appears when pesel is invalid
     */
    public Pesel(String pesel) throws InvalidPeselException {

        Utils.isCorrectPeselFormat(pesel);
        this.isUnderMillenium = true;

        findBirthDate(pesel);
        setSex(pesel);

        this.pesel = pesel;
    }


    /**
     *
     * Finds sex from given pesel
     *
     * @param userPesel PESEL number
     */
    private void setSex(String userPesel) {
        this.sex = ((int) userPesel.charAt(PESEL_SEX_NUMBER_INDEX) % 2 == 0) ? "K" : "M";
    }


    /**
     *
     * Finds whole birthdate
     *
     * @param userPesel PESEL number
     * @throws InvalidPeselException exception thrown when given PESEL is invalid
     */
    private void findBirthDate(String userPesel) throws InvalidPeselException {

        String day = getCorrectDay(userPesel);
        String month = getCorrectMonth(userPesel);
        String year = findBirthYear(userPesel);

        String yearPrefix = isUnderMillenium ? "19" : "20";
        year = yearPrefix + year;

        this.birthDay = day;
        this.birthMonth = month;
        this.birthYear = year;
    }


    /**
     *
     * Finds correct month in given PESEL
     *
     * @param userPesel PESEL NUMBER
     * @return month of birth from given PESEL
     * @throws InvalidPeselException exception thrown when given PESEL contains incorrect month
     */
    private String getCorrectMonth(String userPesel) throws InvalidPeselException {
        String month = findBirthMonth(userPesel);

        char monthFirstChar = month.charAt(0);

        if (monthFirstChar != '0' && monthFirstChar != '1' && monthFirstChar != '2' && monthFirstChar != '3')
            throw new InvalidPeselException("Invalid PESEL: invalid month");


        this.isUnderMillenium = isUnderMillenium(month);

        if (!isUnderMillenium) {
            StringBuilder sb = new StringBuilder(month);
            sb.setCharAt(0, String.valueOf(Integer.valueOf("" + monthFirstChar) - 2).charAt(0));
            month = sb.toString();
        }

        return month;
    }


    /**
     *
     * Finds day of birth in given PESEL
     *
     * @param userPesel PESEL number
     * @return day of birth from given PESEL
     * @throws InvalidPeselException exception thrown when day of birth in given PESEL is invalid
     */
    private String getCorrectDay(String userPesel) throws InvalidPeselException {

        String day = findBirthDay(userPesel);
        if (day.charAt(0) == '0')
            return day;

        int dayAsInt = Integer.parseInt(day);
        if (dayAsInt > 31)
            throw new InvalidPeselException("Invalid PESEL: invalid day (" + dayAsInt + ")");

        return day;
    }


    /**
     *
     * Sets the flag that shows if year od birth is under 2000
     *
     * @param month month of birth
     * @return true if the month shows that the year is below 2000, false otherwise
     */
    private boolean isUnderMillenium(String month) {
        char monthFirstChar = month.charAt(0);
        return !(monthFirstChar == '2' || monthFirstChar == '3');
    }


    /**
     *
     * Finds substring that contains day of birth in given PESEL
     *
     * @param userPesel PESEL number
     * @return day of birth in given PESEL
     */
    private String findBirthDay(String userPesel) {
        return userPesel.substring(4, 6);
    }


    /**
     *
     * Finds substring that contains month of birth in given PESEL
     *
     * @param userPesel PESEL number
     * @return month of birth in given PESEL
     */
    private String findBirthMonth(String userPesel) {
        return userPesel.substring(2, 4);
    }


    /**
     *
     * Finds substring that contains year of birth in given PESEL
     *
     * @param userPesel PESEL number
     * @return year of birth in given PESEL
     */
    private String findBirthYear(String userPesel) {
        return userPesel.substring(0, 2);
    }


    /**
     *
     * Get PESEL number
     *
     * @return PESEL number
     */
    public String getPesel() {
        return pesel;
    }

    /**
     *
     * Get year of birth
     *
     * @return birth year
     */
    public String getBirthYear() {
        return birthYear;
    }

    /**
     *
     * Get month of birth
     *
     * @return birth month
     */
    public String getBirthMonth() {
        return birthMonth;
    }

    /**
     *
     * Get day of birth
     *
     * @return day of birth
     */
    public String getBirthDay() {
        return birthDay;
    }

    /**
     *
     * Get full birthdate formatted as dd.mm.yyyy
     *
     * @return full birthdate
     */
    public String getBirthDate() {
        return this.birthDay + "." + this.birthMonth + "." + this.birthYear;
    }

    /**
     *
     * Get sex
     *
     * @return sex in given PESEL
     */
    public String getSex() {
        return sex;
    }
}