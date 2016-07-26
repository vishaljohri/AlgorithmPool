
import java.util.LinkedList;

class Song {
	private String name;

	public Song(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}

class PlayList {
	LinkedList<Song> queue;
	
	PlayList() {
		queue = new LinkedList<>();
	}
	
	void addSong( Song s) {
		queue.add(s);
	}
	
	void playSongs() {
		for(int i = 0; i < queue.size(); i++) {
			System.out.println("Playing: " + queue.get(i).getName());
		}
	}
}

class Player {
	void playSong(Song s) {
		System.out.println("Now Playing: " + s.getName());
	}
	
	void startPlayList(PlayList list) {
		int i = 0;
		System.out.println("Playing playlist: ");
		list.playSongs();
	}
}
public class JukeBox {

	public static void main(String[] args) {
		Player vlc = new Player();
		Song s1 = new Song("Hello");
		Song s2 = new Song("Animals");
		
		vlc.playSong(s1);
		PlayList playList = new PlayList();
		playList.addSong(s1);
		playList.addSong(s2);
		
		vlc.startPlayList(playList);

	}

}
