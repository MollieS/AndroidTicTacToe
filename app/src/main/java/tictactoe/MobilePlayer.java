package tictactoe;

import ttt.Player;
import ttt.game.Board;
import ttt.game.Marks;

public class MobilePlayer implements Player {

    private Marks mark;

    public MobilePlayer(Marks mark) {
        this.mark = mark;
    }

    @Override
    public Marks getMark() {
        return mark;
    }

    @Override
    public int getLocation(Board board) throws Exception {
        return 0;
    }

    @Override
    public Class playerType() {
        return getClass();
    }
}
