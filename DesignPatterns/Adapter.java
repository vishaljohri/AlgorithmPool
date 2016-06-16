
interface MediaPlayer {
	public void play(String audioType, String fileNAme);
}

interface AdvancedMediaPlayer {
	public void playVlc(String fileName);
	public void playMp4(String fileName);
}

class VlcPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVlc(String fileName) {
		System.out.println("Playing the vlc file : " + fileName);
		
	}

	@Override
	public void playMp4(String fileName) {
		// TODO Auto-generated method stub
		
	}
	
}

class Mp4Player implements AdvancedMediaPlayer {

	@Override
	public void playVlc(String fileName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playMp4(String fileName) {
		System.out.println("Playing the mp4 file : " + fileName);
		
	}
	
}

class MediaAdapter implements MediaPlayer {
	AdvancedMediaPlayer advancedMediaPlayer;
	
	public MediaAdapter(String audioType) {
		if(audioType.equals("vlc"))
			advancedMediaPlayer = new VlcPlayer();
		else if(audioType.equals("mp4"))
			advancedMediaPlayer = new Mp4Player();
	}
	@Override
	public void play(String audioType, String fileName) {
		if(audioType.equals("vlc"))
			advancedMediaPlayer.playVlc(fileName);
		else if(audioType.equals("mp4"))
			advancedMediaPlayer.playMp4(fileName);
		
	}
	
}

class AudioPlayer implements MediaPlayer {
	MediaAdapter mediaAdapter;
	@Override
	public void play(String audioType, String fileName) {
		if(audioType.equals("mp3"))
			System.out.println("Playing the mp3 file : " + fileName);
		else if(audioType.equals("vlc") || audioType.equals("mp4")) {
				mediaAdapter = new MediaAdapter(audioType);
				mediaAdapter.play(audioType, fileName);
		}
		else {
			System.out.println("Invalid media");
		}
	}
}

public class Adapter {

	public static void main(String[] args) {
		AudioPlayer ap = new AudioPlayer();
		ap.play("mp3", "mp3File");
		ap.play("mp4", "mp4File");
		ap.play("vlc", "vlcFile");
		ap.play("xyz", "xyzFile");

	}

}
