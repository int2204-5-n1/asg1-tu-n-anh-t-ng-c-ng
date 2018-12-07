package uet.oop.bomberman.sound;

import java.applet.Applet;
import java.applet.AudioClip;
import java.util.HashMap;

public class GameSound {
	public static GameSound instance;

	public static final String MENU = "/sounds/menu.wav";
	public static final String PLAYGAME = "/sounds/playgame.wav";
	public static final String BOMB = "/sounds/newbomb.wav";
	public static final String BOMBER_DIE = "/sounds/bomber_die.wav";
	public static final String BOMBER_DieDRINK = "/sounds/bomDrink.wav";
	public static final String MONSTER_DIE = "/sounds/monster_die.wav";
	public static final String BONG_BANG = "/sounds/bomb_bang.wav";
	public static final String ITEM = "/sounds/item.wav";
	public static final String WIN = "/sounds/win.wav";
	public static final String LOSE = "/sounds/lose.mid";
	public static final String FOOT = "/sounds/foot.wav";
	public HashMap<String, AudioClip> audioMap =  new HashMap<>();

	public GameSound() {
		//audioMap = new HashMap<>();
		loadAllAudio();
	}

	public static GameSound getIstance() {
		if (instance == null) {
			instance = new GameSound();
		}

		return instance;
	}

	public void loadAllAudio() {
		try {
			putAudio(MENU);
			putAudio(PLAYGAME);
			putAudio(BOMB);
			putAudio(MONSTER_DIE);
			putAudio(BOMBER_DieDRINK);
			putAudio(BOMBER_DIE);
			putAudio(BONG_BANG);
			putAudio(ITEM);
			putAudio(WIN);
			putAudio(LOSE);
			putAudio(FOOT);
		}catch (Exception e){
			System.out.println("DMM");
		}
	}

	public void stop() {
		getAudio(MENU).stop();
		getAudio(PLAYGAME).stop();
		getAudio(BOMB).stop();
		getAudio(MONSTER_DIE).stop();
		getAudio(BOMBER_DieDRINK).stop();
		getAudio(BOMBER_DIE).stop();
		getAudio(BONG_BANG).stop();
		getAudio(ITEM).stop();
		getAudio(WIN).stop();
		getAudio(LOSE).stop();
	}

	public void putAudio(String name) {
		try {
			AudioClip auClip = Applet.newAudioClip(GameSound.class.getResource(name));
			audioMap.put(name, auClip);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public AudioClip getAudio(String name) {
		return audioMap.get(name);
	}
}
