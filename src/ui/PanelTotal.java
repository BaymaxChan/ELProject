/**
 * �������ĳ����࣬�̳к����Զ����������Ч��ť�����ű������֣����ñ���ͼƬ����������С�봰�ڴ�С��ͬ��
 * ��Ҫ���뱳��ͼƬ���������֡���������ͬ�����ݺ���Чͬ�����ݡ�������ͼƬ���������ɸ������涨�岢���룬������Чͬ��������������Ϸʱ��ʼ��һ�μ��ɣ�
 */
package ui;

import gamecomponent.Planet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import audio.BackgroundMusic;
import control.PlayerControl;

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
	//��С����ťͼƬ
	protected ImageIcon mininum=Planet.getImageIcon("image/button/��С����ť.png",55,55);
	//����ͼƬ
	public ImageIcon backgroundImg;
	//��ҿ�����
	protected PlayerControl playerControl;
	//��������
	protected static BackgroundMusic bgm;
	//������
	protected FrameTotal frameTotal;
	
	public PanelTotal(BackgroundMusic bgmusic, BgmSyncData bgmSyncData,SoundSyncData soundSyncData, FrameTotal frame){	
		frameTotal = frame;
		bgm = bgmusic;
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
		
		//��С����ť
		JButton jbtMin=new JButton(mininum);
		jbtMin.addActionListener(new ActionListener(){
	        @Override public void actionPerformed(ActionEvent e){
	            frameTotal.setExtendedState(JFrame.ICONIFIED);
	        }
	    });
		jbtMin.setContentAreaFilled(false);
		jbtMin.setBorderPainted(false);
		jbtMin.setBounds((int)(width*0.85),(int)(height*0.02),(int)(width*0.054),(int)(height*0.092));
		this.add(jbtMin);
	 }
}