/**
 * ��Ч���ذ�ť��
 */
package ui;

import gamecomponent.Planet;

import java.awt.event.*;

import ui.SoundSyncData;
import audio.SoundEffect;

import javax.swing.*;

/**
 * @author DorA
 * 2015��4��20��00:34:26
 */
public class ButtonSound extends JButton{
	private int w=FrameTotal.WINDOWW;
	private int h=FrameTotal.WINDOWH;
	//������ť������ֵ
	private int control;
	//��ť��ͼ��
	private ImageIcon defaultIcon=Planet.getImageIcon("image/button/��Ч��ť2.png", 50, 50);
	private ImageIcon muteIcon=Planet.getImageIcon("image/button/������ť�汾2.png", 50, 50);
	
	private ButtonSound b=this;
	private SoundSyncData soundSyncData;
	
	public ButtonSound(SoundSyncData data){		
		super();
		
		soundSyncData=data;
		
		this.setBounds(960,532,50,50);
		
		//��ÿ���λ��ֵ
		control=soundSyncData.getControl();
		
		final int open=1,off=0;	
		
		//����ͬ����������ʾ��ͬ��ͼ��
		if(control==open){			
			b.setIcon(muteIcon);
		}else{
			b.setIcon(defaultIcon);
		}
	
		//������
		this.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){			
				if( control==open){
					SoundEffect.setMute(false);
					b.setIcon(defaultIcon);
					control--;
				}else if( control==off){	
					SoundEffect.setMute(true);
					b.setIcon(muteIcon);
					control++;
				}	
				soundSyncData.setControl(control);
			}	
		});

		//���ò����ƾ��ε�����
		this.setContentAreaFilled(false);
		//���ò����Ʊ߿�
		this.setBorderPainted(false);
		//���ÿɼ�
		this.setVisible(true);	
	}
}