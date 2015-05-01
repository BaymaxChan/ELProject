/**
 * �������ĳ����࣬�̳к����Զ����������Ч��ť�����ű������֣����ñ���ͼƬ����������С�봰�ڴ�С��ͬ��
 * ��Ҫ���뱳��ͼƬ���������֡���������ͬ�����ݺ���Чͬ�����ݡ�������ͼƬ���������ɸ������涨�岢���룬������Чͬ��������������Ϸʱ��ʼ��һ�μ��ɣ�
 */
package ui;

import gamedata.GameData;
import gamedata.TotalData;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;

import control.PlayerControl;
import audio.BackgroundMusic;

/**
 * @author DorA
 *
 * 2015-4-28 15:24:40
 */
public abstract class PanelTotal extends JDesktopPane{
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
	protected TotalData totalData;
	//��������
	protected static BackgroundMusic bgm;
	//������
	protected FrameTotal frameTotal;
	
	public PanelTotal(BackgroundMusic bgm, BgmSyncData bgmSyncData,SoundSyncData soundSyncData, TotalData totalData, FrameTotal frameTotal){	
		this.totalData = totalData;
		this.frameTotal = frameTotal;
		this.bgm = bgm;
	 	//���ô�С
		this.setBounds(0, 0, width, height);
		
		//���ɲ���
		this.setLayout(null);
	 
		//�������ֿ��ذ�ť
		this.jbtSilence=new ButtonBackgroundMusic(bgmSyncData);
		this.jbtSilence.setMusic(this.bgm);
		this.add(jbtSilence);
		
		//��Ч���ذ�ť
		this.jbtSound=new ButtonSound(soundSyncData);
		this.add(jbtSound);			
	 }
}
