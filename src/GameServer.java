import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    public static final int PORT = 8888;

    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Started Game Server at port " + PORT);
        System.out.println("Waiting for players to join...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Player joined.");
            GameService service = new GameService(game, socket);
            new Thread(service).start();
        }
    }

}
