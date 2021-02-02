public class Pickup extends Vehicle {

    private String pickupType;
    private double innerSpace;

    public Pickup(double speed, double acceleration, String color, String company, String model, int yearOfMaking, int registrationId, String pickupType, double innerSpace) {
        super(speed, acceleration, color, company, model, yearOfMaking, registrationId);
        this.pickupType = pickupType;
        this.innerSpace = innerSpace;
    }

    @Override
    public void run(double speed) {
        System.out.println("Running at : " + speed / 3);
    }

    @Override
    public void accelerate(double acceleration) {
        System.out.println("Acceleration at " + acceleration / 3);
    }

    public String getPickupType() {
        return pickupType;
    }

    public void setPickupType(String pickupType) {
        this.pickupType = pickupType;
    }

    public double getInnerSpace() {
        return innerSpace;
    }

    public void setInnerSpace(double innerSpace) {
        this.innerSpace = innerSpace;
    }

    public void loadPickup(){
        System.out.println("Loading Pickup Filling Space : "+this.innerSpace);
    }

    public void unloadPickup(){
        System.out.println("Unloading Pickup Emptying Space : "+this.innerSpace);
    }


    @Override
    public String toString() {
        return "Registration ID : " + this.getRegistrationId() +
                "\nYear of Making : " + this.getYearOfMaking() +
                "\nModel : " + this.getModel() +
                "\nCompany : " + this.getCompany() +
                "\nColor : " + this.getColor() +
                "\nSpeed : " + this.getSpeed() +
                "\nAcceleration : " + this.getAcceleration() +
                "\nType of Pickup : " + this.getPickupType() +
                "\nInner Space : " + this.getInnerSpace();
    }
}
