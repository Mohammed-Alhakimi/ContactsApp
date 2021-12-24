package contacts;
//Pe
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class Person extends Entity {
    private String name;
    private String surName;
    private String birthDate;
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender() {
        Scanner s = new Scanner(System.in);
        String gender = s.nextLine();
        if (!gender.equalsIgnoreCase("m") && !gender.equalsIgnoreCase("f")) {
            System.out.println("Bad gender!");
            this.gender = "[no data]";
        } else {
            this.gender = gender.toUpperCase(Locale.ROOT);
        }
    }

    public String getName() {
        return name;
    }

    public void setName() {
        Scanner s = new Scanner(System.in);
        this.name = s.nextLine();
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName() {
        Scanner s = new Scanner(System.in);
        this.surName = s.nextLine();
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate() {
        Scanner s = new Scanner(System.in);
        String birthDate = s.nextLine();
        try {
            LocalDate birth = LocalDate.parse(birthDate);
            this.birthDate = birth.toString();
        } catch (DateTimeParseException e) {
            System.out.println("Bad birth date!");
            this.birthDate = "[no data]";
        }
    }

    @Override
    public Entity createEntity() {
        System.out.print("Enter the name: ");
        this.setName();
        System.out.print("Enter the surname: ");
        this.setSurName();
        System.out.print("Enter the birth date: ");
        this.setBirthDate();
        System.out.print("Enter the gender (M, F): ");
        this.setGender();
        System.out.print("Enter the number: ");
        this.setNumber();
        System.out.println("The record added.\n");
        return this;
    }

    @Override
    public String displayFullName() {
        return getName()+" "+getSurName();
    }

    @Override
    public Entity modifyEntity() {
        Scanner s = new Scanner(System.in);
        System.out.println("Select a field (name, surname, birth, gender, number): ");
        String choiceEdit = s.nextLine();
        switch (choiceEdit) {
            case "name":
                System.out.print("Enter name: ");
                this.setName();
                break;
            case "surname":
                System.out.print("Enter surname: ");
                this.setSurName();;
                break;
            case "number":
                System.out.print("Enter number: ");
                this.setNumber();
                break;
            case "birth":
                System.out.print("Enter a birth date: ");
                this.setBirthDate();
                break;
            case "gender":
                System.out.print("Enter a gender: ");
                this.setGender();
                break;
            default:
                System.out.println("Wrong entry!\n");
                break;
        }
        this.setTimeEdited(LocalDateTime.now());
        return this;
    }

    public Person() {}

    @Override
    public String toString() {
        return "Name: " + getName() +
                "\nSurname: " + getSurName() +
                "\nBirth date: " + getBirthDate() +
                "\nGender: " + getGender() +
                "\nNumber: " + getNumber() +
                "\nTime created: " + getTimeCreated().toString() +
                "\nTime last edit: " + getTimeEdited().toString() + "\n";
    }
}