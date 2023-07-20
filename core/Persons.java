package exeptions.core;


public class Persons {
    protected String name;
    protected String secondname;
    protected String lastName;
    protected String birthDate;
    protected long phoneNumber;
    protected Gender gender;

    protected enum Gender {
        male,
        female
    }

    public String getLastName() {
        return secondname;
    }
    public String getFullData(){
        return "<"+secondname+">" + "<"+name+">" + "<"+lastName+">" + "<"+birthDate+">" + " " + "<"+phoneNumber+">" + " " + "<"+gender+">" + "\n";
    }

    public Persons() {
        new Persons(
                "",
                "",
                "",
                "",
                0,
                Gender.male);
    }

    public Persons(String name, String secondname, String lastNme, String birthDate, long phoneNumber, Gender gender) {
        this.name = name;
        this.secondname = secondname;
        this.lastName = lastNme;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
}
