package Model;

public class Candidate {

private String id;
private String firstName;
private String lastName;
private int birthDate;
private String address;
private String phone;
private String email;

public Candidate(String id, String firstName, String lastName, int birthDate, String address, String phone, String email) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.address = address;
    this.phone = phone;
    this.email = email;
}

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public void display() {
    System.out.println("Id: " + id);
    System.out.println("First Name: " + firstName);
    System.out.println("Last Name: " + lastName);
    System.out.println("Birth Date: " + birthDate);
    System.out.println("Address: " + address);
    System.out.println("Phone: " + phone);
    System.out.println("Email: " + email);
}
}