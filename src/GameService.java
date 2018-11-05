import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GameService implements Runnable {
    private Scanner in;
    private PrintWriter out;
    private String player;
    private boolean login;
    private Game game;

    public GameService(Game game, Socket socket) {
        this.game = game;
        player = null;
        login = false;
        try {
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        login();
        while (login) {
            try {
                PlayCard card = PlayCard.parse(in.nextLine());
                String response = execute(game, card);
                // note use of \r\n for CRLF
                out.println(response + "\r\n");
            } catch (NoSuchElementException e) {
                login = false;
            }
        }
        logout();
    }

    public void login() {
        out.println("Please enter your customer id");
        try {
            String input = in.nextLine().trim();
            if (game.getCustomers().contains(input)) {
                player = input;
                out.println("Welcome " + player + "!");
                System.out.println("Login: " + player);
                login = true;
            } else {
                out.println("Invalid login attempt!");
            }
            out.println(); // don't forget empty line terminator!
        } catch (NoSuchElementException e) {
        }
    }

    public void logout() {
        if (player != null) {
            System.out.println("Logout: " + player);
        }
        try {
            Thread.sleep(2000);
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String execute(Game game, PlayCard card) {
        try {
            switch (card.type) {
                case NONE:
                    break;
                // TODO: 2018/11/5 more cards
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
