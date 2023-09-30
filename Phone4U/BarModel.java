import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class BarModel implements Comparable<BarModel>, Repairable { // Uses Repairable interface.
    // Private variables.
    private String name;
    private int processor;
    private int cache;
    private int storage;

    // Sets defaults.
    public BarModel() {
        this.name = "DragonSlayer ";
        this.processor = 600;
        this.cache = 8;
        this.storage = 32;
    }

    // How to and cost to repair bar model.
    @Override
    public String howToRepair() {
        return "To repair a bar model, replace the batteries, unscrew the front, fix the circuit board and number pad.";
    }

    @Override
    public double costToRepair() {
        return 50.00;
    }

    // Getters and setters.
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProcessor() {
        return this.processor;
    }

    public void setProcessor(int processor) {
        this.processor = processor;
    }

    public int getCache() {
        return this.cache;
    }

    public void setCache(int cache) {
        this.cache = cache;
    }

    public int getStorage() {
        return this.storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    // toString method.
    @Override
    public String toString() {
        return "BarModel: " + name + " " + processor + " processor, " + cache + "MB cache, " + storage + "GB storage";
    }

    @Override
    public int compareTo(BarModel o) {
        Scanner s = new Scanner(System.in);
        System.out.print("Choose an area of comparison. 'cache' or 'storage'? ");
        String option = s.nextLine();

        if (option.equals("cache")) {
            if (this.getCache() == o.getCache()) {
                return 0;
            } else if (this.getCache() > o.getCache()) {
                return -1;
            } else {
                return -1;
            }
        }
        if (option.equals("storage")) {
            if (this.getStorage() == o.getStorage()) {
                return 0;
            } else if (this.getStorage() > o.getStorage()) {
                return -1;
            } else {
                return -1;
            }
        }
        return -1;
    }

    public ArrayList<Character> getIMEI() {

        ArrayList<Character> arr = new ArrayList<Character>();

        System.out.print("\nIMEI: ");
        for (int i = 0; i < 13; i++) {
            Random randGen = new Random();
            int number = randGen.nextInt(9);
            String str = Integer.toString(number);
            char ch = str.charAt(0);
            arr.add(ch);
        }
        System.out.print("\n");
        return arr;
    }

}
