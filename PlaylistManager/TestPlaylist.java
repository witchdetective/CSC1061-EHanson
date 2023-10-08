import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestPlaylist { // Driver class.
    static final Scanner SCANNER = new Scanner(System.in); // For user input.

    public static void main(String args[]) throws FileNotFoundException {
        // For new user playlist.
        MyDoubleLinkedList<Song> playlist = new MyDoubleLinkedList<Song>();

        // Menu for all user options for their playlist.
        System.out.println("Hello! This is an interactive playlist manager.");

        while (SCANNER != null) {
            System.out.println("\nEnter in the following options: \nAdd song = 1" +
                    "\nRemove song = 2\nNumber of songs printed = 3\nPlay = 4\nShuffle = 5" +
                    "\nOrder reverse = 6\nFile save = 7\nLoad = 8\nQuit = 9");

            int option = SCANNER.nextInt();

            if (option == 1) {
                Song song = new Song();
                System.out.println("Enter song artist or band:");
                SCANNER.nextLine();
                String artist = SCANNER.nextLine();
                song.setArtist(artist);

                System.out.println("Enter name of track :");
                String title = SCANNER.nextLine();
                song.setTitle(title);
                playlist.add(song);
            }
            if (option == 2) {
                System.out.print("Which track number indicates the song you want to remove? ");
                int number = SCANNER.nextInt();
                playlist.remove(number - 1);
                System.out.print("...\nIt is removed.");
            }
            if (option == 3) {
                System.out.print("The number of tracks are: " + playlist.count());
            }
            if (option == 4) {
                System.out.println("Playling trackist...\n");
                printTracklist(playlist);
            }
            if (option == 5) {
                System.out.println("Shuffling trackist...\n");
                playlist = playlist.shuffle(playlist);
            }
            if (option == 6) {
                System.out.println("Reversing tracklist...\n");
                playlist = playlist.reverse();
            }
            if (option == 7) {
                System.out.print("What will you name your file? ");
                String fileName = SCANNER.next() + ".txt";
                File file = new File(fileName);

                System.out.println("Printing tracklist to file...");
                for (Song song : playlist) {
                    writeSong(song, file);
                }
            }
            if (option == 8) {
                try { // For making sure the file exists.
                    System.out.print("What is the name of your file? ");
                    String fileName = SCANNER.next() + ".txt";
                    playlist = new MyDoubleLinkedList<Song>();

                    Scanner fileScanner = new Scanner(new File(fileName));
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        String[] tokens = line.split(" - ");
                        Song song = new Song();
                        song.setArtist(tokens[0]);
                        song.setTitle(tokens[1]);
                        System.out.println(song.toString());
                        playlist.add(song);
                    }
                    fileScanner.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else if (option == 9) {
                System.out.println("Bye-bye.");
                break; // Quitting by breaking from the loop.
            }
        }
        SCANNER.close();
    }

    public static void printTracklist(MyDoubleLinkedList<Song> playlist) { // For printout.
        for (Song song : playlist) {
            System.out.println(song.toString());
        }
    }

    public static void writeSong(Song song, File file) { // Writes to file.
        try { // For input/output exception.
            PrintWriter print = new PrintWriter(new FileOutputStream(file, true));
            print.println(song.toString());

            if (print.checkError()) {
                System.out.println("There were errors in writing the file");
            }
            print.close();

        } catch (IOException e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }
}