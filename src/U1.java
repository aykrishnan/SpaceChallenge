public class U1 extends Rocket {
    U1(){//constructor initialization
         cost = 100;
         weight = 10;
         maxWeight = 18;
         currentCargo = 0;
         maxCargo = maxWeight - weight;
         launchExplosion = 1-(0.05*(currentCargo/maxCargo));
         landCrash = 1-(0.01*(currentCargo/maxCargo));

    }
    
    // Why are these methods returning a boolean if they're setting an internal property anyway?
    public boolean land(int cargo){
        int success = (int)(Math.random()*landCrash*10);
        if(success>=1){
            rocketStatus = "landed";  // Consider using an enum instead
            return true;
        }
        else{
            rocketStatus = "crashed";
            return false;
        }
    }
    public boolean launch(int cargo){
        int success = (int)(Math.random()*launchExplosion*10);
        if(success>=1){
            rocketStatus = "launched";
            return true;
        }
        else{
            rocketStatus = "exploded";
            return false;
        }
    }
}
