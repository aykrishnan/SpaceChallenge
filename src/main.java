import java.util.Scanner;
public class main {
    public static void print(String s) {
        System.out.println(s);
    }

    public static int simulate(int i) throws Exception {
        Simulation s = new Simulation();
        int cost=0;
        switch (i){
            case 1:
                cost = s.runSimulation("u1", 1) + s.runSimulation("u1", 2);
                break;
            case 2:
                cost = s.runSimulation("u2", 1) + s.runSimulation("u2", 2);
                break;
            default:
                print("Invalid input");
        }
        return cost;
    }
    public static void main(String[] args) throws Exception{

        print("\nPlease select the rocket type by enter number \"1\" for U1 rocket, or \"2\" for U2 rocket" +
                "\nEnter number");
        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        String rocket = new String();
        switch (type) {
            case 1:
                rocket = "U1";
                break;
            case 2:
                rocket = "U2";
                break;
        }
        int cost = simulate(type);
        print("The total cost of the mission using \"" + rocket + "\" rocket is: " + cost + " $ millions.");

    }
}

