// What's the point of having both a Rocket and a SpaceShip class? Why not make Rocket an abstract class?
public interface SpaceShip {
    boolean launch();
    boolean land();
    boolean canCarry(Item cargo);
    void Carry(Item cargo);
}
