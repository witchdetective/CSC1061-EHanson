
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class TestSentiments { // Driver class to test HashMap.

    static final Scanner SCANNER = new Scanner(System.in); // For user input.

    public static void main(String[] args) {
        MyHashMap<String, Integer> sentMap = new MyHashMap<>(); // New HashMap.

        try { // For making sure the file exists.
            String sentiment;
            String score;
            File file = new File("src\\main\\java\\sentiments.txt");
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] tokens = line.split(",");
                sentiment = tokens[0];
                score = tokens[1];
                sentMap.put(sentiment, Integer.parseInt(score)); // Parsing score to int so it can be totalled.

            }
            fileScanner.close(); // Closer fileScanner.
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Sentiment analysis. Write text: ");
        // String inString = SCANNER.nextLine();
        ArrayList<String> words = new ArrayList<String>(); // List for words.
        while (SCANNER.hasNextLine()) {
            String inString = SCANNER.nextLine();
            if (!inString.equals("END")) {
                words.addAll(Arrays.asList(inString.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+")));
            } else {
                break; // Breaks when END has been entered by the user.
            }
        }

        String prev = ""; // Keeps track of previous word for two word phrases.
        int total = 0;

        for (String word : words) {
            Integer score = sentMap.get(word);
            Integer twoWordScore = sentMap.get(prev + " " + word);
            if (twoWordScore != null) {
                total = total + twoWordScore;
            } else if (score != null) {
                total = total + score;
            }

            prev = word;
        }
        System.out.println("Total sentiment score: " + total);
        System.out.println("Number of words: " + words.size());
        double average = (double) (total / (double) words.size());
        System.out.print("Average: ");
        System.out.printf("%.2f", average);
        System.out.println("");
        total = 0;

    }
}