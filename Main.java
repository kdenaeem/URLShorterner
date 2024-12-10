// Considerations
// Where The shorterned URL will redirect us to the longer URL
// The REST API should allow a client to add a URL to the list of URLs

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter long url: ");
        String longURL = scanner.nextLine();
        Shorterner shortObject = new Shorterner();
        String shortURL = shortObject.shorten(longURL);
        System.out.println(shortURL);

        boolean running = true;
        System.out.println("Enter URL");
        while (running) {
            System.out.println("> ");
            String input = scanner.nextLine().trim();
            shortURL = shortObject.shorten(input);
            System.out.println(shortURL);
        }
    }

}