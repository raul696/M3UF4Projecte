
public class Person {
    protected int id;
    protected String dni;
    protected String name;
    protected String surname1;
    protected String surname2;

    public Person(int id, String dni, String name, String surname1, String surname2) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
    }
}

class Employer extends Person{

    public Employer(int id, String dni, String name, String surname1, String surname2) {
        super(id, dni, name, surname1, surname2);

    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surname1='" + surname1 + '\'' +
                ", surname2='" + surname2 + '\'' +
                '}';
    }
}
class Client extends Person{
    private String licence;

    public Client(int id, String dni, String name, String surname1, String surname2, String licence) {
        super(id, dni, name, surname1, surname2);
        this.licence = licence;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surname1='" + surname1 + '\'' +
                ", surname2='" + surname2 + '\'' +
                ", licence='" + licence + '\'' +
                '}';
    }
}