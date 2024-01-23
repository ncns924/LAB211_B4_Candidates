
package Model;

public class Fresher extends Candidate {

    private int graduationDate;
private String graduationRank;

public Fresher(int graduationDate, String graduationRank, String id, String firstName, String lastName, int birthDate, String address, String phone, String email) {
    super(id, firstName, lastName, birthDate, address, phone, email);
    this.graduationDate = graduationDate;
    this.graduationRank = graduationRank;
}

@Override
public void display() {
    super.display();
    System.out.println("Graduation Date: " + graduationDate);
    System.out.println("Graduation Rank: " + graduationRank);
}
}