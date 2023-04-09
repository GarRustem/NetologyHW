package ru.netology;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private final ExecutorService executorService = Executors.newFixedThreadPool(64);

    public void serverStart() {
        try (final ServerSocket serverSocket = new ServerSocket(9999)) {
            while (true) {
                        final Socket socket = serverSocket.accept();
                        Handler thread = new Handler(socket);
                        executorService.submit(thread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
