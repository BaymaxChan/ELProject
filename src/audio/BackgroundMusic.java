/**
 * ��Ϸ�������֣��ɵ��÷������Ż�رձ������֡�
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

	private Sequence bgm01;
	private Sequencer player;

	//��ʼ�����������������ļ�
	public BackgroundMusic(){
		try{
			bgm01 =MidiSystem.getSequence(new File("audio/music/bgm01.mid"));
			player=MidiSystem.getSequencer();
			player.setSequence(bgm01);
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