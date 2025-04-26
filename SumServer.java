package assignment7;

import java.io.*;
import java.net.*;

public class SumServer {
    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running and waiting for a connection...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Input from client
            DataInputStream input = new DataInputStream(socket.getInputStream());
            int num1 = input.readInt();
            int num2 = input.readInt();

            System.out.println("Received numbers: " + num1 + " and " + num2);

            int sum = num1 + num2;

            // Output to client
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            output.writeInt(sum);

            System.out.println("Sent sum: " + sum);

            // Close connections
            input.close();
            output.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
