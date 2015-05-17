/**
 * �������ֿ��ذ�ť���ڽ����е��ø���֮��������setMusic�����趨һ�ױ������֡�
 */
package ui;

import gamecomponent.Planet;

import java.awt.event.*;

import audio.BackgroundMusic;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author DorA
 *
 * 2015��4��19������10:07:42
 */
public class ButtonBackgroundMusic extends JButton{
	//������ť������ֵ
	private int control;
	//��ť��ͼ��
	private ImageIcon defaultIcon=Planet.getImageIcon("image/button/������ť.png", (int)(FrameTotal.WINDOWW*0.036), (int)(FrameTotal.WINDOWW*0.036));
	private ImageIcon muteIcon=Planet.getImageIcon("image/button/��������ť.png", (int)(FrameTotal.WINDOWW*0.036), (int)(FrameTotal.WINDOWW*0.036));

	//�������֣��ɸ����洫��
	private BackgroundMusic bgm;
	
	private ButtonBackgroundMusic b=this;
	BgmSyncData bgmSyncData;
	
	public ButtonBackgroundMusic(BgmSyncData data){		
		super();

		bgmSyncData=data;
		this.setBounds((int)(FrameTotal.WINDOWW*0.852), (int)(FrameTotal.WINDOWH*0.02), (int)(FrameTotal.WINDOWW*0.036), (int)(FrameTotal.WINDOWW*0.036));
		
		control=bgmSyncData.getControl();
		final int open=1,off=0;	
		
		//����ͬ����������ʾ��ͬ��ͼ��
		if(control==open){			
			b.setIcon(muteIcon);	
		}else{
			b.setIcon(defaultIcon);
		}
	
		//������
		this.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){			
				if( control==open){
					bgm.play();			//���ű�������
					b.setIcon(defaultIcon);
					control--;
				}else if( control==off){					
					bgm.stop();			//ֹͣ����
					b.setIcon(muteIcon);
					control++;
				}	
				bgmSyncData.setControl(control);
			}	
			
		});
		//���ò����ƾ��ε�����
		this.setContentAreaFilled(false);
		//���ò����Ʊ߿�
		this.setBorderPainted(false);
		//���ÿɼ�
		this.setVisible(true);
				
	}	

	//�ڸ����������ñ�������Ŀ,�����Ƿ��������Ƿ񲥷ű�����
	public void setMusic(BackgroundMusic bgm){
		//set
		this.bgm=bgm;
		//play
		if(bgmSyncData.getControl()==0){
			
			this.bgm.play();					
		}
	}
}