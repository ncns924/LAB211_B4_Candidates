package Model;

public class Experience extends Candidate {

private int yearExperience;
private String proSkill;

public Experience(int yearExperience, String proSkill, String id, String firstName, String lastName, int birthDate, String address, String phone, String email) {
    super(id, firstName, lastName, birthDate, address, phone, email);
    this.yearExperience = yearExperience;
    this.proSkill = proSkill;
}

@Override
public void display() {
    super.display();
    System.out.println("Year Experience: " + yearExperience);
    System.out.println("Professional Skill: " + proSkill);
}
}