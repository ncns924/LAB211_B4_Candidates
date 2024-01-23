package Model;

public class Internship extends Candidate {

    private String major;
    private String semester;
    private String universityName;

    public Internship(String major, String semester, String universityName, String id, String firstName, String lastName, int birthDate, String address, String phone, String email) {
        super(id, firstName, lastName, birthDate, address, phone, email);
        this.major = major;
        this.semester = semester;
        this.universityName = universityName;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Major: " + major);
        System.out.println("Semester: " + semester);
        System.out.println("University Name: " + universityName);
    }
}