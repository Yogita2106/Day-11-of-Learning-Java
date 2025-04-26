package assignment7;

import java.io.*;
import java.net.*;

public class ReverseClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (
                Socket socket = new Socket(hostname, port);
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            System.out.print("Enter a string to reverse: ");
            String input = userInput.readLine();
            out.println(input);

            String reversed = in.readLine();
            System.out.println("Reversed from server: " + reversed);

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}

