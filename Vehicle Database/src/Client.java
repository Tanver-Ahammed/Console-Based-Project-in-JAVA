public class Client {
    public static void main(String[] args) {
        Bridge bridge = new Bridge();

        // loading the data from the database to memory
        bridge.loadDataBase();

//        bridge.showData();

        UI ui = new UI();
        ui.mainUI(bridge.getVehicles());

    }
}
