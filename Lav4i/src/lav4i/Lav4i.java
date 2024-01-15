package Lav4i;
import java.net.MalformedURLException;
import java.net.URL;

public class Lav4i {

    public static void main(String[] args) {
        String urlString = "http://example.com:80/docs/books/tutorial/index.html?name=networking#DOWNLOADING";

        try {
            URL url = new URL(urlString);

            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Authority: " + url.getAuthority());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("File Name: " + url.getFile());
            System.out.println("Reference: " + url.getRef());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}