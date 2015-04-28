/**
 * ��Ч���ذ�ť��
 */
package ui;

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
	private ImageIcon defaultIcon=new ImageIcon("image/button/��Ч��ť.png");
	private ImageIcon muteIcon=new ImageIcon("image/button/��Ч������ť.png");
	
	private ButtonSound b=this;
	private SoundSyncData soundSyncData;
	
	public ButtonSound(SoundSyncData data){		
		super();
		
		soundSyncData=data;
		
		this.setBounds((int)(w*0.9),(int)(h*0.1),50,49);
		
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