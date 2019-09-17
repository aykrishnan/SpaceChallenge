public class U2 extends Rocket{
        U2(){//constructor initialization
            cost = 120;
            weight = 18;
            maxWeight = 29;
            currentCargo = 0;
            maxCargo = maxWeight - weight;
            launchExplosion = 1-(0.04*(currentCargo/maxCargo));
            landCrash = 1-(0.08*(currentCargo/maxCargo));

        }
        public boolean land(int cargo){
            int success = (int)(Math.random()*landCrash*10);
            if(success>=1){
                rocketStatus = "landed";
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


