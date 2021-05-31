
public class Model {
    private int id;
    private String modelName;
    private String brand;
    private short pax;
    private String licenceType;
    private float fuelCapacity;
    private short maxSpeed;
    private int consumPerHour;
    private int maxTakeoffWeight;
    private int emptyWeight;

    public Model(int id, String modelName, String brand, short pax, String licenceType, float fuelCapacity, short maxSpeed, int consumPerHour, int maxTakeoffWeight, int emptyWeight) {
        this.id = id;
        this.modelName = modelName;
        this.brand = brand;
        this.pax = pax;
        this.licenceType = licenceType;
        this.fuelCapacity = fuelCapacity;
        this.maxSpeed = maxSpeed;
        this.consumPerHour = consumPerHour;
        this.maxTakeoffWeight = maxTakeoffWeight;
        this.emptyWeight = emptyWeight;
    }
    public Model(int id, String modelName, String brand, short pax) {
        this.id = id;
        this.modelName = modelName;
        this.brand = brand;
        this.pax = pax;
    }
    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", brand='" + brand + '\'' +
                ", pax=" + pax +
                ", licenceType='" + licenceType + '\'' +
                ", fuelCapacity=" + fuelCapacity +
                ", maxSpeed=" + maxSpeed +
                ", consumPerHour=" + consumPerHour +
                ", maxTakeoffWeight=" + maxTakeoffWeight +
                ", emptyWeight=" + emptyWeight +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getModelName() {
        return modelName;
    }

    public String getBrand() {
        return brand;
    }

    public short getPax() {
        return pax;
    }

    public String getLicenceType() {
        return licenceType;
    }

    public float getFuelCapacity() {
        return fuelCapacity;
    }

    public short getMaxSpeed() {
        return maxSpeed;
    }

    public int getConsumPerHour() {
        return consumPerHour;
    }

    public int getMaxTakeoffWeight() {
        return maxTakeoffWeight;
    }

    public int getEmptyWeight() {
        return emptyWeight;
    }
}