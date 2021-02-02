import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    private UiUtility uiUtility = new UiUtility();

    public void mainUI(ArrayList<Vehicle>vehicles){
        while (true){
            System.out.println("OPTIONS");
            System.out.println("(1) Search Vehicle");
            System.out.println("(2) Add Vehicle");
            System.out.println("(3) Delete Vehicle");
            System.out.println("(4) Show All Vehicle");
            System.out.println("(5) Simulate Action Vehicle");
            System.out.println("(6) Exit");

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("6")){
                // save information to file before Exit
                FileHandler handler = new FileHandler();
                handler.writeFile(vehicles);

                // Exit
                break;
            }

            // switch case
            switch (choice){
                case "1":{
                    searchComponent(vehicles);
                    break;
                }
                case "2":{
                    addComponent(vehicles);
                    break;
                }
                case "3":{
                    deleteComponent(vehicles);
                    break;
                }
                case "4":{
                    showAll(vehicles);
                    break;
                }
                case "5":{
                    simulate(vehicles);
                    break;
                }
                default:
                    System.out.println("Wrong Choice!!");
            }

        }
    }

    public void searchComponent(ArrayList<Vehicle> vehicles) {
        while (true){
            System.out.println("(1) By Registration ID");
            System.out.println("(2) By Company");
            System.out.println("(3) Back to Main Menu");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("3"))
                break;
            switch (choice){
                case "1":{
                    uiUtility.searchByRegistrationId(vehicles);
                    System.out.println();
                    break;
                }
                case "2":{
                    uiUtility.searchByCompany(vehicles);
                    System.out.println();
                    break;
                }
            }






        }
    }

    public void addComponent(ArrayList<Vehicle> vehicles) {
        String type = uiUtility.modifyChoice();

        if (type == null)
            System.out.println("Wrong Choice");
        else if (type.equalsIgnoreCase("car")) {
            System.out.println("Enter Registration ID please: ");
            Scanner scanner = new Scanner(System.in);
            String regID = scanner.nextLine();

            if (uiUtility.checkExistence(vehicles, regID) == -1) {

                System.out.println("Enter Year of Making please: ");
                String year = scanner.nextLine();
                System.out.println("Enter Model please: ");
                String model = scanner.nextLine();
                System.out.println("Enter Company name please: ");
                String company = scanner.nextLine();
                System.out.println("Enter color please: ");
                String color = scanner.nextLine();
                System.out.println("Enter Speed please: ");
                String speed = scanner.nextLine();
                System.out.println("Enter Acceleration please: ");
                String acceleration = scanner.nextLine();
                System.out.println("Enter Number of Seats please: ");
                String seats = scanner.nextLine();
                System.out.println("Does Have It Nitro?(yes/no): ");
                String nitro = scanner.nextLine();

                boolean hasNitro = false;
                if (nitro.equalsIgnoreCase("yes"))
                    hasNitro = true;

                vehicles.add((new Car(
                        Double.parseDouble(speed),
                        Double.parseDouble(acceleration),
                        color,
                        company,
                        model,
                        Integer.parseInt(year),
                        Integer.parseInt(regID),
                        Integer.parseInt(seats),
                        hasNitro
                )));
            }
            else {
                System.out.println("ERROR! CAR WITH SUCH REGISTRATION ID ALREADY EXIST");
            }
        }
        else if (type.equalsIgnoreCase("pickup")) {

            System.out.println("Enter Registration ID please: ");
            Scanner scanner = new Scanner(System.in);
            String regID = scanner.nextLine();

            if (uiUtility.checkExistence(vehicles, regID) == -1) {

                System.out.println("Enter Year of Making please: ");
                String year = scanner.nextLine();
                System.out.println("Enter Model please: ");
                String model = scanner.nextLine();
                System.out.println("Enter Company name please: ");
                String company = scanner.nextLine();
                System.out.println("Enter color please: ");
                String color = scanner.nextLine();
                System.out.println("Enter Speed please: ");
                String speed = scanner.nextLine();
                System.out.println("Enter Acceleration please: ");
                String acceleration = scanner.nextLine();
                System.out.println("Enter Pickup Type please: ");
                String pickupType = scanner.nextLine();
                System.out.println("Enter Inner Space please: ");
                String innerSpace = scanner.nextLine();

                vehicles.add((new Pickup(
                        Double.parseDouble(speed),
                        Double.parseDouble(acceleration),
                        color,
                        company,
                        model,
                        Integer.parseInt(year),
                        Integer.parseInt(regID),
                        pickupType,
                        Double.parseDouble(innerSpace)
                )));

            }
            else {
                System.out.println("ERROR! PICKUP WITH SUCH REGISTRATION ID ALREADY EXIST");
            }
        }
    }

    public void deleteComponent(ArrayList<Vehicle> vehicles) {
        System.out.println("Enter registration ID please: ");
        Scanner scanner = new Scanner(System.in);
        String regID = scanner.nextLine();
        int index = uiUtility.checkExistence(vehicles,regID);

        if (index!=-1){
            vehicles.remove(index);
            System.out.println("All information regarding vehicle with ID "+regID+" has been deleted!!");
        }
        else {
            System.out.println("ERROR!! VEHICLE SUCH REGISTRATION DOES NOT EXIST");
        }
    }

    // Method to show all the vehicles read from the file
    public void showAll(ArrayList<Vehicle>vehicles){
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i) instanceof Car){
                Car c =(Car) vehicles.get(i);
                System.out.println(c);
                System.out.println();
            }
            else if (vehicles.get(i) instanceof Pickup){
                Pickup p =(Pickup) vehicles.get(i);
                System.out.println(p);
                System.out.println();
            }

        }
    }

    public void simulate(ArrayList<Vehicle> vehicles) {
        while (true){
            System.out.println("(1) By Registration ID");
            System.out.println("(2) Back to Main Menu");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("2"))
                break;
            else if (choice.equalsIgnoreCase("1")){
                uiUtility.searchAndSimulate(vehicles);
            }
        }
    }


}
