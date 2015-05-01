/**
 * ��Ϸ�������֣��ɵ��÷������Ż�رձ������֡����췽����Ҫ���������ļ������硰bgm01���������ļ������audio/music�ļ��С�
 */
package audio;

import java.io.File;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.*;
import javax.sound.midi.Sequencer;
/**
 * @author DorA
 *
 * 2015��4��16��22:36:01
 */
public class BackgroundMusic{

	private Sequence bgm;
	private Sequencer player;

	//��ʼ�����������������ļ�
	public BackgroundMusic(String musicName){
		try{
			bgm =MidiSystem.getSequence(new File("audio/music/"+musicName+".mid"));
			player=MidiSystem.getSequencer();
			player.setSequence(bgm);
			player.open();
			
		}catch(Exception e){}
		
	 }
	
	//��ͣ����
	public void stop(){		
		 if(player.isRunning()){
			 player.stop();
		 }		 
	 }
	
	//��ʼ���ţ�����ͣ����ʼ��
	public  void play() {
		if (!player.isRunning()) {
			player.setLoopCount(player.LOOP_CONTINUOUSLY);
			player.start();
		}
	}
}