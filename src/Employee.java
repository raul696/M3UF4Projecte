class Employee extends Person {

    public Employee(int id, String dni, String name, String surname1, String surname2) {
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
