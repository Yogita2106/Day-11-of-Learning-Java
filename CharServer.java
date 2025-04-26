package assignment7;

import java.io.*;
import java.net.*;

public class CharServer {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("CharServer is listening on port " + port);

            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
                ) {
                    System.out.println("Client connected");

                    String input = in.readLine();
                    if (input != null && input.length() == 1) {
                        char c = Character.toLowerCase(input.charAt(0));
                        String result;

                        if (!Character.isLetter(c)) {
                            result = "Invalid input. Please enter an alphabetic character.";
                        } else if ("aeiou".indexOf(c) >= 0) {
                            result = c + " is a vowel.";
                        } else {
                            result = c + " is a consonant.";
                        }

                        out.println(result);
                        System.out.println("Processed: " + result);
                    } else {
                        out.println("Invalid input. Please send a single character.");
                    }
                } catch (IOException e) {
                    System.out.println("Error handling client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}

