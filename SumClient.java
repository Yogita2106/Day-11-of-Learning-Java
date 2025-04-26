package assignment7;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SumClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(host, port)) {
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            DataInputStream input = new DataInputStream(socket.getInputStream());

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            // Send numbers to server
            output.writeInt(num1);
            output.writeInt(num2);

            // Receive sum from server
            int sum = input.readInt();
            System.out.println("Sum received from server: " + sum);

            // Close connections
            scanner.close();
            output.close();
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

