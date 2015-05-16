/**
 * ��Ϸ�������֣��ɵ��÷������Ż�رձ������֡����췽����Ҫ���������ļ������硰bgm01���������ļ������audio/music�ļ��С�
 */
package audio;


import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

//import javax.sound.midi.MidiSystem;
//import javax.sound.midi.Sequence;
//import javax.sound.midi.Sequencer;
/**
 * @author DorA
 *
 * 2015��4��16��22:36:01
 */
public class BackgroundMusic{
//	private Sequence bgm;
//	private Sequencer player;
	private AudioClip clip;
	//��ʼ�����������������ļ�
	public BackgroundMusic(String musicFile) throws Exception{
		File file=new File(musicFile);
		URI uri=file.toURI();
		URL url=uri.toURL();
			
		this.clip=Applet.newAudioClip(url);			
	}
//		try{
//			bgm =MidiSystem.getSequence(new File(musicFile));
//			player=MidiSystem.getSequencer();
//			player.setSequence(bgm);
//			player.open();
//			
//		}catch(Exception e){}
	
	//��ͣ����
	public void stop(){	
		this.clip.stop();
//		 if(player.isRunning()){
//			 player.stop();
//		 }		 
	 }
	
	//��ʼ���ţ�����ͣ����ʼ��
	public  void play() {
		this.clip.play();
		this.clip.loop();
//		if (!player.isRunning()) {
//			
//			player.setLoopCount(player.LOOP_CONTINUOUSLY);
//			player.start();
//		}
	}
}