package edu.frcc.csc1061.myarraylist;

public class TestPhone {

    public static void main(String args[]) {

        // Flip models.
        FlipModel flip1 = new FlipModel();
        flipIMEI(flip1);

        System.out.println("\n" + flip1.toString());
        System.out.println(flip1.howToRepair() + " Cost for repair: " + flip1.costToRepair());

        FlipModel flip2 = new FlipModel();

        flip2.setName("AnotherPhone");
        flip2.setProcessor(200);
        flip2.setCache(3);
        flip2.setStorage(40);

        flipIMEI(flip2);

        System.out.println("\n" + flip2.toString());
        System.out.print(flip2.compareTo(flip1));

        // Fold models.
        FoldModel fold1 = new FoldModel();
        foldIMEI(fold1);

        System.out.println("\n" + fold1.toString());

        FoldModel fold2 = new FoldModel();

        fold2.setName("AnotherPhone");
        fold2.setProcessor(200);
        fold2.setCache(5);
        fold2.setStorage(64);

        foldIMEI(fold2);

        System.out.println("\n" + fold2.toString());

        System.out.print(fold2.compareTo(fold1));

        // Bar models.
        BarModel bar1 = new BarModel();
        barIMEI(bar1);

        System.out.println("\n" + bar1.toString());
        System.out.println(bar1.howToRepair() + " Cost for repair: " + bar1.costToRepair());

        BarModel bar2 = new BarModel();

        bar2.setName("AnotherPhone");
        bar2.setProcessor(400);
        bar2.setCache(2);
        bar2.setStorage(15);

        barIMEI(bar2);

        System.out.println("\n" + bar2.toString());

        System.out.print(bar2.compareTo(bar1));

    }

    public static void flipIMEI(FlipModel myPhone) {
        MyArrayList<Character> arr = new MyArrayList<Character>();
        arr = myPhone.getIMEI();
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i));
        }
    }

    public static void foldIMEI(FoldModel myPhone) {
        MyArrayList<Character> arr = new MyArrayList<Character>();
        arr = myPhone.getIMEI();
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i));
        }
    }

    public static void barIMEI(BarModel myPhone) {
        MyArrayList<Character> arr = new MyArrayList<Character>();
        arr = myPhone.getIMEI();
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i));
        }
    }
}