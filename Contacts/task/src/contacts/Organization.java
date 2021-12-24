package contacts;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Organization extends Entity {
    private String organizationName;
    private String organizationAddress;
    private transient Scanner s ;

    @Override
    public Entity createEntity() {
        System.out.println("Enter the organization name: ");
        this.setOrganizationName();
        System.out.println("Enter the organization address: ");
        this.setOrganizationAddress();
        System.out.print("Enter the number: ");
        this.setNumber();
        System.out.println("The record added.\n");
        return this;
    }

    @Override
    public String displayFullName() {
        return organizationName;
    }

    @Override
    public Entity modifyEntity() {
        Scanner s = new Scanner(System.in);
        System.out.print("Select a field (name, address, number): ");
        String choiceEdit = s.nextLine();
        switch (choiceEdit) {
            case "name":
                System.out.print("Enter name: ");
                this.setOrganizationName();
                break;
            case "address":
                System.out.print("Enter new organization address: ");
                this.setOrganizationAddress();
                break;
            case "number":
                System.out.print("Enter new number: ");
                this.setNumber();
                break;
            default:
                System.out.println("Wrong entry!\n");
                break;
        }
        this.setTimeEdited(LocalDateTime.now());
        return this;
    }

    public Organization() {}

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName() {
        s = new Scanner(System.in);
        this.organizationName = s.nextLine();
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress() {
        s=new Scanner(System.in);
        this.organizationAddress = s.nextLine();
    }

    @Override
    public String toString() {
        return String.format("Organization name: %s%nAddress: %s%nNumber: %s%nTime created: %s%nTime last edit: %s%n",getOrganizationName(),getOrganizationAddress(),getNumber(),getTimeCreated().toString(),getTimeEdited().toString() );
    }
}
