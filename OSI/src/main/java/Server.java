import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(ServerConfig.PORT)){
            System.out.println("Сервер запущен");

            while(true) {

                try (Socket client = server.accept();
                     PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                     BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {

                    System.out.println("Подключен клиент " + client.getPort());
                    writer.println(String.format("Hi, %s, your port is %d", reader.readLine(), client.getPort()));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
