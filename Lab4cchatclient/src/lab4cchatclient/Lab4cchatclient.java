/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4cchatclient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Lab4cchatclient {

    public static void main(String[] args) {
        try {
            final Socket socket = new Socket("localhost", 5000);

            Scanner scanner = new Scanner(System.in);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            Thread serverListener = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Scanner serverScanner = new Scanner(socket.getInputStream());
                        while (serverScanner.hasNextLine()) {
                            String serverMessage = serverScanner.nextLine();
                            System.out.println("Server: " + serverMessage);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            serverListener.start();

            // Client input loop
            while (true) {
                String message = scanner.nextLine();
                writer.println(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}