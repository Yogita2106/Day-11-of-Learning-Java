package assignment7;

import java.io.*;
import java.net.*;

public class CharClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (
                Socket socket = new Socket(hostname, port);
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            System.out.print("Enter a single character: ");
            String input = userInput.readLine();

            if (input.length() != 1) {
                System.out.println("Please enter only one character.");
                return;
            }

            out.println(input);
            String response = in.readLine();
            System.out.println("Server response: " + response);

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}

