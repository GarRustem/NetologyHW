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
            String currentCity = "Name a City";

            while(true) {

                try (Socket client = server.accept();
                     PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                     BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {

                    System.out.println("Подключен клиент " + client.getPort());
                    writer.println(String.format(currentCity));

                    String city = reader.readLine();
                    System.out.println(city);

                    if(currentCity.equals("Name a City")) {
                        currentCity = city;
                        writer.println(String.format("Ok"));
                        System.out.println("New City is: " + currentCity);
                    } else if(city.startsWith(currentCity.substring(currentCity.length() - 1))) {
                        writer.println(String.format("Ok"));
                        currentCity = city;
                        System.out.println("New City is: " + currentCity);
                    } else {
                        writer.println(String.format("Not Ok"));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
