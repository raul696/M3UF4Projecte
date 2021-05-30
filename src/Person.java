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

    public int getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getSurname1() {
        return surname1;
    }

    public String getSurname2() {
        return surname2;
    }

}

