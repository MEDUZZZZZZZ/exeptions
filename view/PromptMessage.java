package exeptions.view;

public class PromptMessage {
    public static String  defaultMsg = "(To exit, type EXIT) Enter: ";
    public static String  fullNameMsg = defaultMsg+" surname, name, lastname\n" +
            "(Example: Popov Oleg Romanovich) Enter: ";
    public static String  dateMsg = defaultMsg+" birth date\n" +
            "(Example: dd.mm.yyyy) Enter: ";
    public static String  phoneNumberMsg = defaultMsg+" phone number as an integer\n" +
            "(Example: 89161443710) Enter: ";
    public static String  genderMsg = defaultMsg+" gender\n" +
            "(Enter f- woman, m - man) Enter: ";
}
