abstract class Vehicle implements VehicleDynamicFunction,VehicleStaticFunction {
    protected double speed;
    protected double acceleration;
    protected String color;
    protected String company;
    protected String model;
    protected int yearOfMaking;
    protected int registrationId;

    public Vehicle(double speed, double acceleration, String color, String company, String model, int yearOfMaking, int registrationId) {
        this.speed = speed;
        this.acceleration = acceleration;
        this.color = color;
        this.company = company;
        this.model = model;
        this.yearOfMaking = yearOfMaking;
        this.registrationId = registrationId;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfMaking() {
        return yearOfMaking;
    }

    public void setYearOfMaking(int yearOfMaking) {
        this.yearOfMaking = yearOfMaking;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }
}
