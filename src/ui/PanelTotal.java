/**
 * �������ĳ����࣬�̳к����Զ����������Ч��ť�����ű������֣����ñ���ͼƬ����������С�봰�ڴ�С��ͬ��
 * ��Ҫ���뱳��ͼƬ���������֡���������ͬ�����ݺ���Чͬ�����ݡ�������ͼƬ���������ɸ������涨�岢���룬������Чͬ��������������Ϸʱ��ʼ��һ�μ��ɣ�
 */
package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import audio.BackgroundMusic;

/**
 * @author DorA
 *
 * 2015-4-28 15:24:40
 */
public abstract class PanelTotal extends JPanel{
	private int w=FrameTotal.WINDOWW;
	private int h=FrameTotal.WINDOWH;
	//����ͼƬ
	private Image bg;
	
	public PanelTotal(){		
	}

	
	 public PanelTotal(ImageIcon ic,BackgroundMusic bgm,BgmSyncData bgmSyncData,SoundSyncData soundSyncData){
		 
		 	//���ô�С
			this.setBounds(0, 0, w, h);
			
			//��ȡ����ͼƬ
			this.bg=ic.getImage();
			
			//���ɲ���
			setLayout(null);
		 
			//�������ֿ��ذ�ť
			ButtonBackgroundMusic jbtSilence=new ButtonBackgroundMusic(bgmSyncData);
			jbtSilence.setMusic(bgm);
			add(jbtSilence);
			
			//��Ч���ذ�ť
			ButtonSound jbtSound=new ButtonSound(soundSyncData);
			add(jbtSound);
			
			
	 }
	 
	 //���Ʊ���ͼƬ
	 public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(bg, 0, 0, w,h,this);

	}
}
