package assignment7;

import java.io.*;
import java.net.*;

public class DateClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (
                Socket socket = new Socket(hostname, port);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            String serverDateTime = in.readLine();
            System.out.println("Current Date & Time from Server: " + serverDateTime);

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
