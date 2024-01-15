package lab4iii;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab4iii {
    private static List<PrintWriter> clients = new ArrayList<>();
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                final Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                // Create a new thread for each client
                Thread clientThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            handleClient(clientSocket);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void handleClient(Socket clientSocket) throws IOException {
        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
        clients.add(writer);
        Scanner scanner = new Scanner(clientSocket.getInputStream());
        while (true) {
            String message = scanner.nextLine();
            broadcastMessage(message);
        }
    }
    private static void broadcastMessage(String message) {
        for (PrintWriter client : clients) {
            client.println(message);
        }
    }
}
