package exeptions.controllers;

import exeptions.trap.AppException;
import exeptions.trap.Messages;
import exeptions.core.Persons;
import java.io.FileWriter;
import java.io.IOException;

public class Writer implements AutoCloseable {
    private static Persons person;
    

    public Writer(Persons inPerson) {
        person = inPerson;
    }


    public void writePersonToFile() throws AppException {
        String fileName = person.getLastName() + ".txt";
        String data = person.getFullData()+"\n";

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(data);
        } catch (IOException e) {
            throw new AppException(Messages.fileWrite);
        }
    }

    @Override
    public void close() {
        System.gc();
    }
}
