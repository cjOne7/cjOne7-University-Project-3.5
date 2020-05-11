package therapistData;

public class Person {

    private String name;
    private Surname surname;

    public static final Person EMPTY_PERSON = new Person("", Surname.EMPTY_SURNAME);

    public Person(final String name, final Surname surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public Surname getSurname() {
        return surname;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setSurname(final Surname surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return String.format("%s %s", name, surname);
    }

    public String toMyOwnString() {
        return "Person: name: " + name + ", surname: " + surname + ".";
    }
}
