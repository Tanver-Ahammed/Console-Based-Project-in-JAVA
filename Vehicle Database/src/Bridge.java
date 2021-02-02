import java.util.ArrayList;

public class Bridge {
    public ArrayList<Vehicle>vehicles = new ArrayList<>();

    //This method load database data to the memory or vehicle list
    public void loadDataBase(){
        FileHandler handler = new FileHandler();
        ArrayList<String []> vehicleData = new ArrayList<>();
        vehicleData = handler.readFile();

        for (int i = 0; i < vehicleData.size(); i++) {
            String type = vehicleData.get(i)[0];

            //check for vehicle type from array of string data about a single vehicle
            if (type.equalsIgnoreCase("car")){
                vehicles.add(new Car(
                        Double.parseDouble(vehicleData.get(i)[1]),
                        Double.parseDouble(vehicleData.get(i)[2]),
                        vehicleData.get(i)[3],
                        vehicleData.get(i)[4],
                        vehicleData.get(i)[5],
                        Integer.parseInt(vehicleData.get(i)[6]),
                        Integer.parseInt(vehicleData.get(i)[7]),
                        Integer.parseInt(vehicleData.get(i)[8]),
                        Boolean.parseBoolean(vehicleData.get(i)[9])
                ));
            }
            else if (type.equalsIgnoreCase("pickup")){
                vehicles.add(new Pickup(
                        Double.parseDouble(vehicleData.get(i)[1]),
                        Double.parseDouble(vehicleData.get(i)[2]),
                        vehicleData.get(i)[3],
                        vehicleData.get(i)[4],
                        vehicleData.get(i)[5],
                        Integer.parseInt(vehicleData.get(i)[6]),
                        Integer.parseInt(vehicleData.get(i)[7]),
                        vehicleData.get(i)[8],
                        Double.parseDouble(vehicleData.get(i)[9])
                ));
            }

        }
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void showData(){
        System.out.println("------------------------------------------------------------------");
        System.out.println("******************************************************************");
        System.out.println();
        for (Vehicle v : vehicles) {
            System.out.println("RegID : "+v.getRegistrationId()+" ");
            System.out.println("Company : " +v.getCompany()+" ");
            System.out.println("Model : "+v.getModel()+" ");
            System.out.println("Year : "+v.getYearOfMaking()+" ");
            System.out.println("Color : "+v.getColor()+" ");
            System.out.println("Speed : "+v.getSpeed()+" ");
            System.out.println("Acceleration : "+v.getAcceleration()+" ");
            if (v instanceof Car){
                System.out.println("Seats : "+((Car)v).getNumberOfSeats()+" ");
                System.out.println("Nitro? : "+((Car)v).isHasNitroBooster()+" ");
            }
            else if (v instanceof Pickup){
                System.out.println("Pickup Type : "+((Pickup)v).getPickupType()+" ");
                System.out.println("Inner Space : "+((Pickup)v).getInnerSpace()+" ");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------------------------");
        System.out.println("******************************************************************");

    }

}
