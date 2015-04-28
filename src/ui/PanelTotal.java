/**
 * �������ĳ����࣬�̳к����Զ����������Ч��ť�����ű������֣����ñ���ͼƬ����������С�봰�ڴ�С��ͬ��
 * ��Ҫ���뱳��ͼƬ���������֡���������ͬ�����ݺ���Чͬ�����ݡ�������ͼƬ���������ɸ������涨�岢���룬������Чͬ��������������Ϸʱ��ʼ��һ�μ��ɣ�
 */
package ui;

import gamedata.GameData;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import control.PlayerControl;
import audio.BackgroundMusic;

/**
 * @author DorA
 *
 * 2015-4-28 15:24:40
 */
public abstract class PanelTotal extends JPanel{
	//Panel�ĳ���
	protected int width=FrameTotal.WINDOWW;
	protected int height=FrameTotal.WINDOWH;
	//�������ֿ��ذ�ť
	protected ButtonBackgroundMusic jbtSilence;
	//��Ч���ذ�ť
	protected ButtonSound jbtSound;
	//����ͼƬ
	public ImageIcon backgroundImg;
	//��ҿ�����
	protected PlayerControl playerControl;
	//������Ϸ����
	protected GameData gameData;
	//��������
	protected static BackgroundMusic bgm=new BackgroundMusic("bgm01");
	
	public PanelTotal(BgmSyncData bgmSyncData,SoundSyncData soundSyncData, GameData gameData){	
		this.gameData = gameData;
	 	//���ô�С
		this.setBounds(0, 0, width, height);
		
		//���ɲ���
		this.setLayout(null);
	 
		//�������ֿ��ذ�ť
		this.jbtSilence=new ButtonBackgroundMusic(bgmSyncData);
		this.jbtSilence.setMusic(bgm);
		this.add(jbtSilence);
		
		//��Ч���ذ�ť
		this.jbtSound=new ButtonSound(soundSyncData);
		this.add(jbtSound);			
	 }
}
