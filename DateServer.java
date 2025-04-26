package assignment7;

import java.io.*;
import java.net.*;
import java.util.Date;

public class DateServer {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("DateServer is listening on port " + port);

            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
                ) {
                    System.out.println("Client connected");
                    String currentDateTime = new Date().toString();
                    out.println(currentDateTime);
                    System.out.println("Sent date/time: " + currentDateTime);
                } catch (IOException e) {
                    System.out.println("Error handling client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
