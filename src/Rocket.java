public class Rocket implements SpaceShip {
    
    // Recommendation: Make these values private and access them via getter methods
    int cost;
    int weight;
    int maxWeight;
    int currentCargo;
    int maxCargo = maxWeight - weight;
    double launchExplosion;
    double landCrash;
    String rocketStatus;
    Rocket(){
        int cost = 0;
        int weight = 0;
        int maxWeight = 0;
        int currentCargo = 0;
        int maxCargo = maxWeight - weight;
        double launchExplosion = 0.0;
        double landCrash = 0.0;
        String rocketStatus = "none";
    }
    @Override
    public boolean launch(){
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }
    
    /* You can simplify this entire method to:
      public boolean canCarry(Item cargo) {
        return (cargo.weight <= (maxCargo - currentCargo));
      }
    */
    public boolean canCarry(Item cargo){
        if(cargo.weight<= (maxCargo-currentCargo)){
            return true;
        }
        else{
            return false;
        }
    }
    
    // Methods should be lowercase
    public void Carry(Item cargo){
        currentCargo += cargo.weight;
    }
}
