package edu.frcc.csc1061.myarraylist;

import java.util.Scanner;
import java.util.Random;

public class FoldModel implements Comparable<FoldModel> {
    private String name;
    private int processor;
    private int cache;
    private int storage;

    public FoldModel() {
        this.name = "SpeedRacer ";
        this.processor = 800;
        this.cache = 6;
        this.storage = 64;
    }

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

    @Override
    public String toString() {
        return "FoldModel: " + name + " " + processor + " processor, " + cache + "MB cache, " + storage + "GB storage";
    }

    @Override
    public int compareTo(FoldModel o) {
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

    public MyArrayList<Character> getIMEI() {

        MyArrayList<Character> arr = new MyArrayList<Character>();

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
