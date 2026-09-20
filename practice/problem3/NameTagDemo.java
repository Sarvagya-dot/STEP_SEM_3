public class NameTagDemo {

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname());
    }
}

class NameTag {
    private final String firstName;
    private final String lastName;

    public NameTag(String fullName) {
        String[] nameParts = fullName.split(" ");
        this.firstName = nameParts[0];
        this.lastName = nameParts[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }
}
