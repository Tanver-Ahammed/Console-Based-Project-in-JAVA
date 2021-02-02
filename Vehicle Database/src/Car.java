public class Car extends Vehicle {

    private int numberOfSeats;
    protected boolean hasNitroBooster;

    public Car(double speed, double acceleration, String color, String company, String model, int yearOfMaking, int registrationId, int numberOfSeats, boolean hasNitroBooster) {
        super(speed, acceleration, color, company, model, yearOfMaking, registrationId);
        this.numberOfSeats = numberOfSeats;
        this.hasNitroBooster = hasNitroBooster;
    }

    @Override
    public void run(double speed) {
        System.out.println("Running at : " + speed);
    }

    @Override
    public void accelerate(double acceleration) {
        double realAcceleration = acceleration + (this.speed * .5);
        System.out.println("Acceleration at " + realAcceleration);
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean isHasNitroBooster() {
        return hasNitroBooster;
    }

    public void setHasNitroBooster(boolean hasNitroBooster) {
        this.hasNitroBooster = hasNitroBooster;
    }

    public void useNitro() {
        if (hasNitroBooster) {
            System.out.println("Using Nitro");
            System.out.println("Speed Increased By Two Folds!");
            System.out.println("Now Speed is : "+this.speed);
        }
        else {
            System.out.println("This Car has no Nitro Booster");
        }
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
                "\nNumber of Seats : " + this.getNumberOfSeats() +
                "\nNitro? : " + this.isHasNitroBooster();
    }
}