/**
 * ������Ϸ��Ч���������óɹر���Ч��Ҫ������Чʱ����SoundEffect.SOUND_NAME.play()��ͨ������volume�����Ƿ�ر���Ч��
 */
package audio;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
/**
 * @author DorA
 *
 * 2015��4��16��22:37:26
 */
public enum SoundEffect {
	//ö����Ϸ��Ч�ʹ洢λ��
	LIGHT("audio/sounds/light.wav");
	
	//��������Ϊ�ر���Чģʽ
	public static enum Volume{
		MUTE,MEDIUM
	}	
	public static Volume volume=Volume.MEDIUM;
	
	private Clip clip;
	
	SoundEffect(){		
	}	
	
	SoundEffect(String soundFileName){		
		try {
			AudioInputStream ais=AudioSystem.getAudioInputStream(new File(soundFileName));
			clip=AudioSystem.getClip();
			clip.open(ais);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();}
	}
	
	//����һ����Ч
	public void play() {		
		try{
			if(volume!=Volume.MUTE){
				if(clip.isRunning())
					clip.stop();
				clip.setFramePosition(0);
				clip.start();
			}
		}catch(Exception e){}
	      
	}
	
	//��Ч���ذ�ť����
	public static void setMute(boolean setMute){
		if(setMute==true){
			volume=Volume.MUTE;
		}else{
			volume=Volume.MEDIUM;
		}
	}
}