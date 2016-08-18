package com.example.molliestephenson.tictactoe;

import org.junit.Test;

import ttt.game.Board;
import ttt.game.Marks;

import static org.junit.Assert.assertEquals;

public class MobilePlayerTest {

   private MobilePlayer player = new MobilePlayer(Marks.X);

    @Test
    public void knowsItsMark() {
        assertEquals(Marks.X, player.getMark());
    }

    @Test
    public void returns0ForLocation() throws Exception {
        Board board = new Board(3);
        assertEquals(0, player.getLocation(board));
    }

    @Test
    public void testPlayerType() throws Exception {
        assertEquals(MobilePlayer.class, player.playerType());
    }
}