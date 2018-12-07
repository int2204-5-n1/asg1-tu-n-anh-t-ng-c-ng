package uet.oop.bomberman.level;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.LayeredEntity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.Balloon;
import uet.oop.bomberman.entities.character.enemy.Oneal;
import uet.oop.bomberman.entities.tile.Grass;
import uet.oop.bomberman.entities.tile.Portal;
import uet.oop.bomberman.entities.tile.Wall;
import uet.oop.bomberman.entities.tile.destroyable.Brick;
import uet.oop.bomberman.entities.tile.item.BombItem;
import uet.oop.bomberman.entities.tile.item.LivesItem;
import uet.oop.bomberman.entities.tile.item.FlameItem;
import uet.oop.bomberman.entities.tile.item.SpeedItem;
import uet.oop.bomberman.exceptions.LoadLevelException;
import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.graphics.Sprite;

import java.io.*;


public class FileLevelLoader extends LevelLoader {

	/**
	 * Ma trận chứa thông tin bản đồ, mỗi phần tử lưu giá trị kí tự đọc được
	 * từ ma trận bản đồ trong tệp cấu hình
	 */
	private static char[][] _map;

	public FileLevelLoader(Board board, int level) throws LoadLevelException {
		super(board, level);
	}
	
	@Override
	public void loadLevel(int level) {
        // TODO: đọc dữ liệu từ tệp cấu hình /levels/Level{level}.txt
        String path = "res/levels/Level"  +String.valueOf(level) + ".txt";

        //URL a = this.getClass().getResource(file);
        //System.out.println(path);

        String[] a = new String[100];
        int dem=0;
        try{
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null){
                a[dem] = s;
                dem++;
            }
            br.close();
            fr.close();

        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("dme");
        }


        // TODO: cập nhật các giá trị đọc được vào _width, _height, _level, _map
        _level = Integer.parseInt(a[0].substring(0,1));
        _height = Integer.parseInt(a[0].substring(2,4));
        _width = Integer.parseInt(a[0].substring(5,7));
        _map = new char[_height][_width];
        for(int i=0;i<_height;i++){
            _map[i] = a[i+1].toCharArray();
        }

	}

	@Override
	public void createEntities() {
		// TODO: tạo các Entity của màn chơi
		// TODO: sau khi tạo xong, gọi _board.addEntity() để thêm Entity vào game

		// TODO: phần code mẫu ở dưới để hướng dẫn cách thêm các loại Entity vào game
		// TODO: hãy xóa nó khi hoàn thành chức năng load màn chơi từ tệp cấu hình
		/*// thêm Wall
		for (int x = 0; x < _width; x++) {
			for (int y = 0; y < _height; y++) {
				int pos = x + y * _width;
				Sprite sprite = y == 0 || x == 0 || x == _width-1 || y == _height-1 ? Sprite.wall : Sprite.grass;
				_board.addEntity(pos, new Grass(x, y, sprite));
			}
		}

		// thêm Bomber
		int xBomber = 1, yBomber = 1;
		_board.addCharacter( new Bomber(Coordinates.tileToPixel(xBomber), Coordinates.tileToPixel(yBomber) + Game.TILES_SIZE, _board) );
		Screen.setOffset(0, 0);
		_board.addEntity(xBomber + yBomber * _width, new Grass(xBomber, yBomber, Sprite.grass));

		// thêm Enemy
		int xE = 2, yE = 1;
		_board.addCharacter( new Balloon(Coordinates.tileToPixel(xE), Coordinates.tileToPixel(yE) + Game.TILES_SIZE, _board));
		_board.addEntity(xE + yE * _width, new Grass(xE, yE, Sprite.grass));

		// thêm Brick
		int xB = 3, yB = 1;
		_board.addEntity(xB + yB * _width,
				new LayeredEntity(xB, yB,
					new Grass(xB, yB, Sprite.grass),
					new Brick(xB, yB, Sprite.brick)
				)
		);

		// thêm Item kèm Brick che phủ ở trên
		int xI = 1, yI = 2;
		_board.addEntity(xI + yI * _width,
				new LayeredEntity(xI, yI,
					new Grass(xI ,yI, Sprite.grass),
					new SpeedItem(xI, yI, Sprite.powerup_flames),
					new Brick(xI, yI, Sprite.brick)
				)
		);*/

		for (int x = 0; x<_width; x++){
		    for (int y = 0; y < _height; y++){
		        switch (_map[y][x]){
                        // TODO: thêm Wall
                    case '#':
                        _board.addEntity(x + y * _width, new Wall(x, y, Sprite.wall));
                        break;

                        // TODO: thêm Brick
                    case '*':
                        _board.addEntity(x + y * _width,
                                new LayeredEntity(x, y,
                                        new Grass(x, y, Sprite.grass),
                                        new Brick(x, y, Sprite.brick)
                                )
                        );
                        break;

                        //TODO: thêm FlameItem kèm Brick che phủ ở trên
                    case 'f':
                        _board.addEntity(x + y * _width,
                                new LayeredEntity(x, y,
                                        new Grass(x ,y, Sprite.grass),
                                        new FlameItem(x, y, Sprite.powerup_flames),
                                        new Brick(x, y, Sprite.brick)
                                )
                        );
                        break;

                        //TODO: thêm BombItem kèm Brick che phủ ở trên
                    case 'b':
                        _board.addEntity(x + y * _width,
                                new LayeredEntity(x, y,
                                        new Grass(x ,y, Sprite.grass),
                                        new BombItem(x, y, Sprite.powerup_bombs),
                                        new Brick(x, y, Sprite.brick)
                                )
                        );
                        break;

                        //TODO: thêm SpeedItem kèm Brick che phủ ở trên
                    case 's':
                        _board.addEntity(x + y * _width,
                                new LayeredEntity(x, y,
                                        new Grass(x ,y, Sprite.grass),
                                        new SpeedItem(x, y, Sprite.powerup_speed),
                                        new Brick(x, y, Sprite.brick)
                                )
                        );
                        break;

                        // TODO: thêm Bomber
                    case 'p':
                        _board.addCharacter( new Bomber(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board) );
                        Screen.setOffset(0, 0);
                        _board.addEntity(x + y * _width, new Grass(x, y, Sprite.grass));
                        break;

                        // TODO: thêm Enemy Balloon
                    case '1':
                        _board.addCharacter( new Balloon(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
                        _board.addEntity(x + y * _width, new Grass(x, y, Sprite.grass));
                        break;

                        // TODO: thêm Enemy Oneal
                    case '2':
                        _board.addCharacter( new Oneal(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
                        _board.addEntity(x + y * _width, new Grass(x, y, Sprite.grass));
                        break;

                        // TODO: thêm portal
                    case 'x':
                        _board.addEntity(x + y * _width,
                                new LayeredEntity(x, y,
                                        new Grass(x ,y, Sprite.grass),
                                        new Portal(x ,y, _board, Sprite.portal),
                                        new Brick(x, y, Sprite.brick)
                                )
                        );
                        break;
                    case'l' :
                        _board.addEntity(x + y * _width,
                                new LayeredEntity(x, y,
                                        new Grass(x ,y, Sprite.grass),
                                        new LivesItem(x, y, Sprite.powerup_lives),
                                        new Brick(x, y, Sprite.brick)
                                )
                        );
                        break;


                    // TODO: thêm grass
                    default:
                        //int pos = x + y * _width;
                        //Sprite sprite = y == 0 || x == 0 || x == _width-1 || y == _height-1 ? Sprite.wall : Sprite.grass;
                        _board.addEntity(x + y * _width, new Grass(x, y, Sprite.grass));
                }
            }
        }
	}

}
