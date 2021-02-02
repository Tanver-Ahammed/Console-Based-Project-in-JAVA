import java.util.ArrayList;
import java.util.Scanner;

public class UiUtility {
    public String modifyChoice() {
        System.out.println("What kind of vehicle you want to add the database");
        System.out.println("(1) Car");
        System.out.println("(2) Pickup");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("car")) {
            return "car";
        } else if (choice.equalsIgnoreCase("pickup")) {
            return "pickup";
        }
        return null;
    }

    public int checkExistence(ArrayList<Vehicle> vehicles, String regID) {
        int index = -1;
        int reg = Integer.parseInt(regID);
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getRegistrationId() == reg) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void searchByRegistrationId(ArrayList<Vehicle> vehicles) {
        System.out.println("Enter registration ID please: ");
        Scanner scanner = new Scanner(System.in);
        String regID = scanner.nextLine();
        int index = checkExistence(vehicles, regID);

        if (index != -1) {
            if (vehicles.get(index) instanceof Car) {
                Car c = (Car) vehicles.get(index);
                System.out.println(c);
                System.out.println();
            } else if (vehicles.get(index) instanceof Pickup) {
                Pickup p = (Pickup) vehicles.get(index);
                System.out.println(p);
                System.out.println();
            }
        } else {
            System.out.println("ERROR!! VEHICLE SUCH REGISTRATION DOES NOT EXIST");
        }
    }

    public void searchByCompany(ArrayList<Vehicle> vehicles) {
        System.out.println("Enter Company Name please: ");
        Scanner scanner = new Scanner(System.in);
        String company = scanner.nextLine();
        boolean flag = false;
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getCompany().equalsIgnoreCase(company)) {
                flag = true;
                if (vehicles.get(i) instanceof Car) {
                    Car c = (Car) vehicles.get(i);
                    System.out.println(c);
                    System.out.println();
                } else if (vehicles.get(i) instanceof Pickup) {
                    Pickup p = (Pickup) vehicles.get(i);
                    System.out.println(p);
                    System.out.println();
                }
            }
        }
        if (!flag)
            System.out.println("ERROR!! VEHICLE SUCH REGISTRATION DOES NOT EXIST IN THE DATABASE");
    }

    public void searchAndSimulate(ArrayList<Vehicle> vehicles) {
        System.out.println("Enter registration ID please: ");
        Scanner scanner = new Scanner(System.in);
        String regID = scanner.nextLine();
        int index = checkExistence(vehicles, regID);

        if (index != -1) {
            if (vehicles.get(index) instanceof Car) {
                Car c = (Car) vehicles.get(index);
                while (true) {
                    System.out.println("What do you want to simulate for the car?");
                    System.out.println("(1) Start");
                    System.out.println("(2) Stop");
                    System.out.println("(3) Use Nitro Booster");
                    System.out.println("(4) Run");
                    System.out.println("(5) Accelerate");
                    System.out.println("(6) Quit");

                    String choice = scanner.nextLine();
                    if (choice.equalsIgnoreCase("6"))
                        break;
                    switch (choice) {
                        case "1": {
                            c.startVehicle();
                            System.out.println();
                            break;
                        }
                        case "2": {
                            c.stopVehicle();
                            System.out.println();
                            break;
                        }
                        case "3": {
                            c.useNitro();
                            System.out.println();
                            break;
                        }
                        case "4": {
                            c.run(c.getSpeed());
                            System.out.println();
                            break;
                        }
                        case "5": {
                            c.accelerate(c.getAcceleration());
                            break;
                        }

                    }

                }
            } else if (vehicles.get(index) instanceof Pickup) {
                Pickup p = (Pickup) vehicles.get(index);
                while (true) {
                    System.out.println("What do you want to simulate for the car?");
                    System.out.println("(1) Start");
                    System.out.println("(2) Stop");
                    System.out.println("(3) Load Pickup");
                    System.out.println("(4) Unload Pickup");
                    System.out.println("(5) Accelerate");
                    System.out.println("(6) Quit");

                    String choice = scanner.nextLine();
                    if (choice.equalsIgnoreCase("6"))
                        break;
                    switch (choice) {
                        case "1": {
                            p.startVehicle();
                            System.out.println();
                            break;
                        }
                        case "2": {
                            p.stopVehicle();
                            System.out.println();
                            break;
                        }
                        case "3": {
                            p.loadPickup();
                            System.out.println();
                            break;
                        }
                        case "4": {
                            p.unloadPickup();
                            System.out.println();
                            break;
                        }
                        case "5": {
                            p.accelerate(p.getAcceleration());
                            break;
                        }
                    }
                }
            }
        } else {
            System.out.println("ERROR!! VEHICLE SUCH REGISTRATION DOES NOT EXIST");
        }
    }
}
