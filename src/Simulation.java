import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
public class Simulation {
    public static void print(String s) {
        System.out.println(s);
    }
    private static ArrayList<Item> load = new ArrayList<>();
    private static ArrayList<U1> loadedU1 = new ArrayList<>();
    private static ArrayList<U2> loadedU2 = new ArrayList<>();
    private int totalCost = 0;
    public Simulation() throws Exception{}
        public ArrayList <Item> loadItems(String s) throws Exception {
        File file = new File(s);
        Scanner inp = new Scanner(file);
        while(inp.hasNextLine()){
            String line = inp.nextLine();
            String inpArray[] = line.split("=");
            Item item = new Item(inpArray[0],Integer.parseInt(inpArray[1]));/*after splitting the text file would be of
            String in order to change to int, we are using Integer.parseInt*/
            load.add(item);
        }
        return load;
        }
        public ArrayList<U1> loadu1(ArrayList<Item>inpArray){
        U1 u1 = new U1();
        while(inpArray.size()>0){
            for(int i=inpArray.size();i>0;i--){
               Item item = inpArray.get(i-1);
               if(u1.canCarry(item)){
                   u1.Carry(item);
                   inpArray.remove(i-1);
               }
            }
            loadedU1.add(u1);
            u1 = new U1();
        }
        return loadedU1;
        }
    public ArrayList<U2> loadu2(ArrayList<Item>inpArray){
        U2 u2 = new U2();
        while(inpArray.size()>0){
            for(int i=inpArray.size();i>0;i--){
                Item item = inpArray.get(i-1);
                if(u2.canCarry(item)){
                    u2.Carry(item);
                    inpArray.remove(i-1);
                }
            }
            loadedU2.add(u2);
            u2 = new U2();
        }
        return loadedU2;
    }
    public int runSimulation (String rocketType, int phase) throws Exception {
        //Determining the phase
        String fileName;
        switch (phase) {
            case 1:
                fileName = "phase_1.txt";
                break;
            case 2:
                fileName = "phase_2.txt";
                break;
            default:
                print("Invalid input (possible mis-spelling)");
                return -1;
        } //switch

        ArrayList<Item> itemList = this.loadItems(fileName);

        //Determining the ship type for simulation
        switch (rocketType) {
            case "u1": case "U1":
                U1 u1 = new U1();
                ArrayList<U1> U1Array = this.loadu1(itemList);

                while (U1Array.size() > 0) {
                    for (int i = U1Array.size(); i>0; i--) {
                        u1 = U1Array.get(i - 1);
                        int counter = 1;
                        while (!(u1.land(u1.currentCargo) && u1.launch(u1.currentCargo))) {
                            counter++;
                        } //while
                        totalCost += u1.cost * counter;
                        U1Array.remove(i-1);
                    } //if
                } //while
                return totalCost;

            case "u2": case "U2":
                U2 u2 = new U2();
                ArrayList<U2> U2Array = this.loadu2(itemList);

                while (U2Array.size() > 0) {
                    for (int i = U2Array.size(); i>0; i--) {
                        u2 = U2Array.get(i - 1);
                        int counter = 1;
                        while (!(u2.land(u2.currentCargo) && u2.launch(u2.currentCargo))) {
                            counter++;
                        } //while
                        totalCost += u2.cost * counter;
                        U2Array.remove(i-1);
                    } //if
                } //while
                return totalCost;

            default:
                print("Invalid input (possible mis-spelling)");
                return -1; //We can use -1 in the method call in Main to handle all invalid inputs since cost can never be negative
        } //switch

    } //runSimulation

} //main
