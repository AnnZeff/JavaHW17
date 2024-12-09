package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void shouldSecondPlayerWin() {
        Player pit85 = new Player(35, "Pit85", 150);
        Player vovan = new Player(229, "Vovan", 100);
        Game game = new Game();

        game.register(pit85);
        game.register(vovan);

        int actual = game.round("Vovan", "Pit85");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFirstPlayerWin() {
        Player vovan = new Player(1, "Vovan", 150);
        Player pit85 = new Player(2, "Pit85", 100);
        Game game = new Game();

        game.register(vovan);
        game.register(pit85);

        int actual = game.round("Vovan", "Pit85");
        int expected = 1;
    }

    @Test
    public void shouldStrenghtsBeEqual() {
        Player vovan = new Player(1, "Vovan", 100);
        Player pit85 = new Player(2, "Pit85", 100);
        Game game = new Game();

        game.register(vovan);
        game.register(pit85);

        int actual = game.round("Vovan", "Pit85");
        int expected = 0;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player vovan = new Player(25, "Vovan", 200);
        Game game = new Game();

        game.register(vovan);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("GrayCat", "Vovan")
        );

    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player vovan = new Player(23, "Vovan", 150);
        Game game = new Game();

        game.register(vovan);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Vovan", "GrayCat")
                );
    }

}