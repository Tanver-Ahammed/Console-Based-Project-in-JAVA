public interface VehicleStaticFunction {
    default void startVehicle() {
        System.out.println("Starting vehicle in 1... 2... 3...");
        System.out.println("Vehicle Started");
    }

    default void stopVehicle() {
        System.out.println("Starting vehicle in 3... 2... 1...");
        System.out.println("Vehicle Stopped");
    }
}
