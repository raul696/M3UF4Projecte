public class Plane {
    private int id;
    private String registrationCode;
    private String model;
    private String mainColor;
    private int hoursFlied;


    public Plane(int id, String registrationCode, String model, String mainColor, int hoursFlied) {
        this.id = id;
        this.registrationCode = registrationCode;
        this.model = model;
        this.mainColor = mainColor;
        this.hoursFlied = hoursFlied;
    }
    public Plane(int id, String registrationCode, String model) {
        this.id = id;
        this.registrationCode = registrationCode;
        this.model = model;
    }
    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", registrationCode='" + registrationCode + '\'' +
                ", model='" + model + '\'' +
                ", mainColor='" + mainColor + '\'' +
                ", hoursFlied=" + hoursFlied +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public String getModel() {
        return model;
    }

    public String getMainColor() {
        return mainColor;
    }

    public int getHoursFlied() {
        return hoursFlied;
    }
}
