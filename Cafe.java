/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements {


    //attributes
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    //constructor
    /**
     * @param name
     * @param address
     * @param nFloors
     * constructor for the Cafe class
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 10;
        this.nSugarPackets = 12;
        this.nCreams = 5;
        this.nCups = 100;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * sell a cup of coffe, but the material in inventory will be reduced as well
     * @param size,
     * @param nSugarPackets
     * @param nCreams 
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        //check if we have enough stock before we sell coffe
        if (this.nCoffeeOunces > size && this.nSugarPackets > nSugarPackets && this.nCreams > nCreams && this.nCups > 1){
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("You have "+this.nCoffeeOunces +" Ounces remaining, "+this.nSugarPackets+" packets sugar remaining, "+this.nCreams+" remaining sugar, "+this.nCups+" Cups remaining in inventory.");
        }else{
            //if the stock is not enough, throw an exception so that the Cafe would restock
            throw new RuntimeException("Sorry. you don't have enough stock. Please sell again.");
        }
    }

    /**
     * restock the material in inventory
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    
    public static void main(String[] args) {
        Cafe campuscafe = new Cafe("Campus cafe", "campus center first floor", 1);
        campuscafe.sellCoffee(12, 14, 8);
        campuscafe.restock(5, 5, 10, 100);
    }
    
}
