package exeptions.controllers;
import exeptions.core.Exam;
import exeptions.trap.AppException;
import exeptions.trap.Messages;
import exeptions.view.View;
import exeptions.view.PromptMessage;
import exeptions.core.Exam;
import java.util.Objects;

public class Conroller {
    private final View view;
    private final Exam entry;


    public Conroller() {
            view = new View();
            entry = new Exam();
    }


    public void run() {
        String input = "";
        while (!Objects.equals(input, "EXIT")) {
            try {
                input = view.enterText(PromptMessage.fullNameMsg);
                setFullName(input);

                input = view.enterText(PromptMessage.dateMsg);
                entry.setBirthDate(input);

                input = view.enterText(PromptMessage.phoneNumberMsg);
                entry.setPhoneNumber(input);

                input = view.enterText(PromptMessage.genderMsg);
                entry.setGender(input);

                try (Writer person = new Writer(entry.getEntry())) {
                    person.writePersonToFile();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    throw new AppException(e.getMessage());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                System.gc();
            }


        }
    }

    private void setFullName(String msg) throws AppException {
        String[] splitInput = msg.split(" ");
        verifyWordsCount(splitInput);
        entry.setName(splitInput[1]);
        entry.setSecondname(splitInput[0]);
        entry.setLastName(splitInput[2]);
    }

    private void verifyWordsCount(String[] splitInput) throws AppException {
        if (splitInput.length == 3) {
            return;
        }
        throw new AppException(Messages.wordsCountName);
    }

}