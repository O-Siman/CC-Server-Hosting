import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) {
        // Declare a variable of type HttpServer
        HttpServer server;
        try {
            // Create the server on port 8080
            server = HttpServer.create(new InetSocketAddress(8080), 0);
        } catch (IOException e) {
            // If it fails, then exit the program
            e.printStackTrace();
            System.exit(1);
            return;
        }
        // Any request, no matter the URL path, will go to our RequestHandler
        server.createContext("/", new RequestHandler());
        // Default executor just manages the connections 1 by 1
        server.setExecutor(null); // creates a default executor
        // Start the server!
        server.start();
        System.out.println("Server started!");
    }
}
