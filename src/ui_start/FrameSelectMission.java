/**
 * ѡ�ؽ��棬Ӧ�ڰ��¿�ʼ���桰��ʼ��Ϸ����ť����롣�����Ƿ�����ùؿ��������Ƿ���Ե��ͼ�����ùؿ���
 * �Ƿ�����ùؿ�Ӧ����ÿ���ؿ��ṩһ������ֵ��
 */
package ui_start;

import java.awt.Image;

import javax.swing.ImageIcon;

import audio.BackgroundMusic;
import ui.*;

/**
 * @author DorA
 *
 * 2015��4��18������6:09:14
 */
public class FrameSelectMission extends ui.FrameTotal{

	private final FrameSelectMission f=this;
	private final BgmSyncData bgmData;
	private final SoundSyncData soundData;
	//����ͼƬ
	ImageIcon ic=new ImageIcon("image/bg/���汳��.png");
	
	//��������
	private static BackgroundMusic bgm=new BackgroundMusic("bgm02");
	
	public FrameSelectMission(BgmSyncData bgmSyncData,SoundSyncData soundSyncData){	//������Ӧ�ô�����ؿ��Ƿ�ͨ���Ĳ���ֵ
		super();
		bgmData=bgmSyncData;
		soundData=soundSyncData;
		
		this.setContentPane(new PanelSelectMission(ic,bgm,bgmData, soundData));
		
		
		
	}
	
	//�رմ��ڷ���
	public void closeFrame(){
		f.dispose();
	}

}