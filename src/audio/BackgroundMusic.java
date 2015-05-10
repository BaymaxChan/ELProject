/**
 * ��Ϸ�������֣��ɵ��÷������Ż�رձ������֡����췽����Ҫ���������ļ������硰bgm01���������ļ������audio/music�ļ��С�
 */
package audio;

import java.io.File;

import javax.sound.midi.*;
/**
 * @author DorA
 *
 * 2015��4��16��22:36:01
 */
public class BackgroundMusic{

	private Sequence bgm;
	private Sequencer player;

	//��ʼ�����������������ļ�
	public BackgroundMusic(String musicFile){
		try{
			bgm =MidiSystem.getSequence(new File(musicFile));
			player=MidiSystem.getSequencer();
			player.setSequence(bgm);
			player.open();
			
		}catch(Exception e){}
	 }
	
	//��ͣ����
	public void stop(){		
		 if(player.isRunning()){
			 player.stop();
	//		 player.close();
		 }		 
	 }
	
	public void close(){
		player.close();
	}
	
	//��ʼ���ţ�����ͣ����ʼ��
	public  void play() {
		if (!player.isRunning()) {
			
			player.setLoopCount(player.LOOP_CONTINUOUSLY);
			player.start();
		}
	}
}