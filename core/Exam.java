package exeptions.core;
import exeptions.trap.AppException;
import exeptions.trap.Messages;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Exam {
    private final Persons person;

    private enum EntryFromFullName {
        NAME,
        SECONDNAME,
        LASTNAME
    }

    public Exam() {
        person = new Persons();
    }

    public Persons getEntry() {
        return person;
    }

    public void setGender(String input) throws AppException {
        Map<String, Persons.Gender> gender = new HashMap<>();
        gender.put("f", Persons.Gender.female);
        gender.put("m", Persons.Gender.male);
        try {
            compareWithEnum(String.valueOf(gender.get(input)));
        } catch (IllegalArgumentException e){
            throw new AppException(Messages.wrongGender);
        }
    }

    private void compareWithEnum(String text) throws AppException {
        try {
            person.gender = Persons.Gender.valueOf(text);
        } catch (IllegalArgumentException e) {
            throw new AppException(Messages.wrongGender);
        }
    }

    private boolean VerifyEntryFromFullName(String name) {
        return containsDigitsOrSpecialChars(name);
    }

    private static boolean containsDigitsOrSpecialChars(String input) {
        Pattern pattern = Pattern.compile("[0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]");
        Matcher matcher = pattern.matcher(input);
        return !matcher.find();
    }

    private void fillEntryFromFullName(String nameText, String exceptionText, EntryFromFullName inNamePart) throws AppException {

        if (VerifyEntryFromFullName(nameText)) {
            switch (inNamePart) {
                case NAME -> person.name = nameText;
                case LASTNAME -> person.lastName = nameText;
                case SECONDNAME -> person.secondname = nameText;
            }

            return;
        }
        throw new AppException(exceptionText);

    }

    private boolean isValidBirthday(String birthday) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthDate;

        try {
            birthDate = LocalDate.parse(birthday, formatter);
        } catch (Exception e) {
            return false;
        }

        LocalDate now = LocalDate.now();
        long age = ChronoUnit.YEARS.between(birthDate, now);

        return age >= 0 && age <= 150;
    }

    private static boolean isValidNumber(String text) throws AppException {
        try {
            long number = Long.parseLong(text);
            return String.valueOf(number).length() == 11;
        } catch (NumberFormatException e) {
            throw new AppException(Messages.wrongPhone);
        }
    }

    public void setName(String name) throws AppException {
        fillEntryFromFullName(name, Messages.name, EntryFromFullName.NAME);
    }

    public void setSecondname(String secondname) throws AppException {
        fillEntryFromFullName(secondname, Messages.surname, EntryFromFullName.SECONDNAME);
    }

    public void setLastName(String lastName) throws AppException {
        fillEntryFromFullName(lastName, Messages.lastName, EntryFromFullName.LASTNAME);
    }

    public void setBirthDate(String date) throws AppException {
        if (isValidBirthday(date)) {
            person.birthDate = date;
            return;
        }
        throw new AppException(Messages.wrongDate);
    }

    public void setPhoneNumber(String number) throws AppException {
        if (isValidNumber(number)) {
            person.phoneNumber = Long.parseLong(number);
        }
    }

}