public class Item {
    
    // Recommendation: Make these parameters private and access them via getter methods
    String name;
    int weight;
    
    // You can remove this consructor - it exists by default
    public Item(){

    }
    public Item(String name,int weight){
       this.name = name;
       this.weight = weight;
    }
}
