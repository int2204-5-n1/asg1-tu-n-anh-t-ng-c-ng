package uet.oop.bomberman.entities.tile;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.graphics.Sprite;

public class Portal extends Tile {
    private Board _board;

    public Portal(int x, int y, Board board, Sprite sprite) {
        super(x, y, sprite);
        _board = board;
    }

    @Override
    public boolean collide(Entity e) {

        if(e instanceof Bomber ) {

            if(_board.detectNoEnemies() == false)
                return false;

            if(e.getXTile() == getX() && e.getYTile() == getY()) {
                if(_board.detectNoEnemies())
                    _board.nextLevel();
            }

            return true;
        }

        return false;
    }

}