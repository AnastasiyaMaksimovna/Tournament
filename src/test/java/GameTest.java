import org.example.Game;
import org.example.NotRegisterException;
import org.example.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {
    @Test
    public void roundTest1() {
        Game game = new Game();
        Player player1 = new Player(11, "Petya", 30);
        game.register(player1);
        Player player2 = new Player(12, "Kolya", 29);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Petya", "Kolya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundTest2() {
        Game game = new Game();
        Player player1 = new Player(11, "Petya", 35);
        game.register(player1);
        Player player2 = new Player(12, "Kolya", 40);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Petya", "Kolya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundTest0() {
        Game game = new Game();
        Player player1 = new Player(11, "Petya", 30);
        game.register(player1);
        Player player2 = new Player(12, "Kolya", 30);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Petya", "Kolya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundExceptionTest() {
        Game game = new Game();
        Player player1 = new Player(11, "Petya", 30);
        game.register(player1);
        Player player2 = new Player(12, "Kolya", 29);

        Assertions.assertThrows(NotRegisterException.class, () -> {
            game.round("Petya", "Kolya");
        });
    }

    @Test
    public void roundExceptionTest2() {
        Game game = new Game();
        Player player1 = new Player(11, "Petya", 30);
        Player player2 = new Player(12, "Kolya", 29);
        game.register(player2);

        Assertions.assertThrows(NotRegisterException.class, () -> {
            game.round("Petya", "Kolya");
        });
    }
}
