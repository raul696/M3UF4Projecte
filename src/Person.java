
public class Person {
    private int id;
    private String dni;
    private String name;
    private String surname;

    public Person(int id, String dni, String name, String surname) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.surname = surname;
    }
}

class Employer extends Person{

    private int id;
    private String dni;
    private String name;
    private String surname;

    public Employer(int id, String dni, String name, String surname) {
        super(id, dni, name, surname);

    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
class Client extends Person{
    private String licence;

    public Client(int id, String dni, String name, String surname,String licence) {
        super(id, dni, name, surname);
        this.licence = licence;
    }

    @Override
    public String toString() {
        return "Client{" +
                "licence='" + licence + '\'' +
                '}';
    }
}