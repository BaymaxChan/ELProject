/**
 * ��ʼ����
 */
package ui_start;

import javax.swing.ImageIcon;

import audio.BackgroundMusic;
import ui.*;

/**
 * @author DorA
 *
 * 2015��4��17��00:20:14
 */
public class FrameStartGame extends FrameTotal{
	
	//��ʼ���汳��ͼƬ
	ImageIcon ic=new ImageIcon("image/bg/���汳��.png");	
	//��������
	public static BackgroundMusic bgm=new BackgroundMusic("bgm01");

	final BgmSyncData bgmSyncData;
	final SoundSyncData soundSyncData;
	
	
	public FrameStartGame(BgmSyncData bgmData,SoundSyncData soundData){
		super();
		
		bgmSyncData=bgmData;
		soundSyncData=soundData;
	
		this.setContentPane(new PanelStartGame(ic,bgm,bgmSyncData,soundSyncData));

	}
	
	
/*	public void closeFrame(){
		f.dispose();
	}*/
		
	
	public static void main(String[]args){
		BgmSyncData bgmSyncData=new BgmSyncData();
		SoundSyncData soundSyncData=new SoundSyncData();
		final FrameStartGame frame=new FrameStartGame(bgmSyncData, soundSyncData);

	}
	



}