import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ClassesObjects {

    public static void main(String[] args) {

        IO.display(MainMenu.greeting);
        MainMenu.menuLoop();
    }
}

/*
 * This class represents office supplies. Instances of the class are specific office supplies,
 * like pen, notebook, stapler, etc. The user is able to create their own office supplies
 * (featuring a name, and a brand) that are stored in a static variable <code>list</code> of type
 * ArrayList. These office supplies are then used as blueprints when adding office supplies to
 * a specific office worker (that is, the name and brand of the blueprint are assigned as the name
 * and brand of the worker office supplies). At that time the price field gets read from the console
 * as user input, and the new instance of the class is stored in the stationery variable of type
 * ArrayList<OfficeSupplies> of an instance of class OfficePlankton (office worker class).
 */
class OfficeSupplies {

    //Is it ok to store an array of class instances as that class' static variable?
    static ArrayList<OfficeSupplies> list = new ArrayList<>();
    static int suppliesCount;

    private int id;
    private final String name;
    private final String brand;
    private double price;

 /*
  * The OfficeSupplies class has a class variable suppliesCount that stores the total number of class
  * instances created from the class. The variable's value is used as the id of each successive
  * instance of office supplies created from the class. However, some of the instances are created
  * as blueprints and stored in the static <code>list</code> variable and the suppliesCount variable
  * need not get increased upon their creation. To distinguish between these two cases (the creation
  * of a blueprint instance and the creation of an instance for a specific office worker) a boolean
  * isGeneral parameter is used in the class constructor.
  */
    public OfficeSupplies(String name, String brand, boolean isGeneral) {
        this.name = name;
        this.brand = brand;
        if (!isGeneral)
            this.id = ++suppliesCount;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    static void createBlueprint() {
        System.out.println("Enter the name of the office supplies, e.g. pen, notebook, etc.:");
        String name = IO.sc.nextLine();
        System.out.println("Enter the brand of the product:");
        String brand = IO.sc.nextLine();
        list.add(new OfficeSupplies(name, brand, true));
        System.out.println("Added: Name: " + name + ". Brand: " + brand);
    }

    @Override
    public String toString() {
        if (this.price != 0)
            return "id: " + id + ". A " + brand + " " + name + ", with a cost of $" + price;
        else
            return "id: " + id + ". A " + brand + " " + name;
    }
}


class OfficePlankton {

    // Is it ok to store an array of class objects as that class' variable?
    private static ArrayList<OfficePlankton> planktons = new ArrayList<>();
    private static int planktonsCount;

    private int id;
    private final String name;
    private ArrayList<OfficeSupplies> stationery;

    OfficePlankton(String name) {
        this.id = ++planktonsCount;
        this.name = name;
        this.stationery = new ArrayList<>();
    }

    public static ArrayList<OfficePlankton> getPlanktons() {
        return planktons;
    }

    public ArrayList<OfficeSupplies> getStationery() {
        return stationery;
    }

    // How about this method - would it be better to limit it to creating a new office
    // worker and return the instance from the method instead of the return type being void?
    // Or it doesn't matter at all?
    static void addPlankton() {
        System.out.println("Enter plankton's name:");
        String name = IO.sc.nextLine();
        planktons.add(new OfficePlankton(name));
        System.out.println("Added. Plankton #" + planktonsCount + ". Name: " + name + ".");
    }

    // Same question for this method.
    static void addProduct(OfficePlankton plankton) {
        System.out.println("Choose the office product to add:");
        IO.display(OfficeSupplies.list);
        int stationeryNumber = IO.getInput(OfficeSupplies.list.size());

        double price = 0;
        System.out.println("Enter its price:");

        // Is this the best practice for coding input from user that needs to be validated
        // in two ways: that it's, say, a double or integer and that it's in a certain range?
        //  Or is there a better / more elegant way?
        do {
            try {
                price = IO.sc.nextDouble();
                if (price <= 0)
                    System.out.println("Your input is invalid. Please enter a single positive floating-point number:");
                else
                    break;
            } catch (InputMismatchException exc) {
                System.out.println("Your input is invalid. Please enter a single positive floating-point number:");
            } finally {
                IO.sc.nextLine();
            }
        } while (true);

        // What would be the best way for this step? Is there a better way instead of creating
        // "blueprint" instances and then passing their name and brand fields' values as arguments
        // to the constructor to create 'true' instances? That would probably also solve the problem
        // of isGeneral - that is, the need for 'true' instances to increase the counter as opposed
        // to the blueprint instances.
        OfficeSupplies newStationery = new OfficeSupplies(
                OfficeSupplies.list.get(stationeryNumber - 1).getName(),
                OfficeSupplies.list.get(stationeryNumber - 1).getBrand(),
                false);
        newStationery.setPrice(price);
        plankton.stationery.add(newStationery);
        System.out.println("Added: " + newStationery.toString() + " to " + plankton.toString());
    }

    static OfficePlankton choosePlankton() {
        System.out.println("Choose the office plankton:");
        IO.display(planktons);
        int planktonNumber = IO.getInput(planktons.size());
        return planktons.get(planktonNumber - 1);
    }

    static void displayStationeryCost(OfficePlankton plankton) {
        System.out.println("The total cost of stationery for " + plankton.toString() + " is: $" +
                plankton.calculateStationeryCost() + ".");
    }
    
    // The method that calculates the cost of all stationery for a given office worker -
    // should it be a method of the OfficePlankton class or OfficeStationery class?
    // I can't figure this logic-wise.
    private double calculateStationeryCost() {
        double result = 0;
        for (OfficeSupplies element : this.stationery)
            result += element.getPrice();
        return result;
    }

    @Override
    public String toString() {
        return "id: " + id + "; name: " + name;
    }
}

class MainMenu {

    static final String[] greeting = {"Hey there. I'm a simple application that allows you\n" +
            "to calculate stationery cost for a given office worker."};

    static final String[] options = {
            "1. Add an office plankton.",
            "2. Display a list of all office planktons.",
            "3. Create a new office product.",
            "4. Display a list of all available office products.",
            "5. Add an office product to an office plankton.",
            "6. Display a list of all office products for a specific office plankton.",
            "7. Calculate total cost of office products for an office plankton.",
            "8. Exit the application."
    };

    static void menuLoop() {

        do {
            System.out.println("\nWhat do you want to do next?");
            IO.display(MainMenu.options);
            int chosenOption = IO.getInput(options.length);

            if (chosenOption == 8) return;

            switch (chosenOption) {
                case 1:
                    OfficePlankton.addPlankton();
                    break;
                case 2:
                    System.out.println("There are following office planktons in the office:");
                    IO.display(OfficePlankton.getPlanktons());
                    break;
                case 3:
                    OfficeSupplies.createBlueprint();
                    break;
                case 4:
                    System.out.println("There are following office products available:");
                    IO.display(OfficeSupplies.list);
                    break;
                case 5:
                    OfficePlankton.addProduct(OfficePlankton.choosePlankton());
                    break;
                case 6:
                    IO.display(OfficePlankton.choosePlankton().getStationery());
                    break;
                case 7:
                    OfficePlankton.displayStationeryCost(OfficePlankton.choosePlankton());
                    break;
            }
        } while (true);
    }
}

// How about this IO class? Would it be better to implement input / output inside the other classes?
class IO {

    static final Scanner sc = new Scanner(System.in);

    static void display(List list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ". " + list.get(i).toString());
        }
    }

    static void display(String[] array) {
        for (String s : array)
            System.out.println(s);
    }

    static int getInput(int optionsCount) {

        int i;

        do {
            try {
                i = Integer.parseInt(sc.nextLine());
                if (i < 1 || i > optionsCount) {
                    System.out.println("Seems your input is invalid. Please enter a single number from 1 " +
                            "to " + optionsCount + ":");
                } else {
                    return i;
                }
            } catch (NumberFormatException exc) {
                System.out.println("Seems your input is invalid. Please enter a single number from 1 " +
                        "to " + optionsCount + ":");
            }
        } while (true);
    }
}
