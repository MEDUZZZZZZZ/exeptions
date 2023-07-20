package exeptions.trap;

public class Messages {
    private static final String constForName = "the text must consist of letters, ";
    private static final String tryAgain = "Try again\n";
    private static final String startFillFullName = "\n incorrectly set ";

    public static String name = startFillFullName + "name\n " + constForName + tryAgain;
    public static String surname = startFillFullName + "surname\n" + constForName + tryAgain;
    public static String lastName = startFillFullName + "lastName\n" + constForName + tryAgain;
    public static String wordsCountName = startFillFullName + "the number of words in the full name\n" + tryAgain;
    public static String wrongDate = "the date is set incorrectly (dd.mm.yyyy Example: 21.08.1985)\n" + tryAgain;
    public static String wrongPhone = "the phone number is set incorrectly (Example: 89798765432)\n" + tryAgain;
    public static String wrongGender = "the gender is set incorrectly (Example: male or female)\n" + tryAgain;
    public static String fileWrite = "error in writing the file\n" + tryAgain;
}
