import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private File f = new File("C:\\Users\\Tanver\\Documents\\Java code\\Console Based Project\\Vehicle Database\\VEHICLE_DATABASE\\Database.txt");


    // Reading vehicle data from the file
    public ArrayList<String[]> readFile() {
        ArrayList<String[]> vehicleData = new ArrayList<>();
        try {
            f.createNewFile();
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String line = br.readLine();
                if (line == null)
                    break;
                String[] data = line.split(",");
                vehicleData.add(data);
            }
            //closing file streams
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vehicleData;
    }

    // Writing vehicle data to the file
    public void writeFile(ArrayList<Vehicle> vehicles) {
        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);

            //looping through the vehicle arraylist
            for (int i = 0; i < vehicles.size(); i++) {

                if (vehicles.get(i) instanceof Car) {
                    Car c = (Car) vehicles.get(i);
                    String data = new String("car," + c.getSpeed() + "," + c.getAcceleration() + "," + c.getColor() + "," +
                            c.getCompany() + "," + c.getModel() + "," + c.getYearOfMaking() + "," + c.getRegistrationId() + "," +
                            c.getNumberOfSeats() + "," + c.isHasNitroBooster());
                    bw.write(data + "\n");
                } else if (vehicles.get(i) instanceof Pickup) {
                    Pickup p = (Pickup) vehicles.get(i);
                    String data = new String("pickup," + p.getSpeed() + "," + p.getAcceleration() + "," + p.getColor() + "," +
                            p.getCompany() + "," + p.getModel() + "," + p.getYearOfMaking() + "," + p.getRegistrationId() + "," +
                            p.getPickupType() + "," + p.getInnerSpace());
                    bw.write(data + "\n");
                }
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
