class Client extends Person {
    protected String licence;

    public Client(int id, String dni, String name, String surname1, String surname2, String licence) {
        super(id, dni, name, surname1, surname2);
        this.licence = licence;
    }

    @Override
    public String toString() {
        return "Person.Client{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surname1='" + surname1 + '\'' +
                ", surname2='" + surname2 + '\'' +
                ", licence='" + licence + '\'' +
                '}';
    }

    public String getLicence() {
        return licence;
    }
}
