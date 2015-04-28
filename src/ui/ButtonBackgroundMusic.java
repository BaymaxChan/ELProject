/**
 * �������ֿ��ذ�ť���ڽ����е��ø���֮��������setMusic�����趨һ�ױ������֡�
 */
package ui;


import java.awt.Graphics;
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
	private int w=JFrameTotal.WINDOWW;
	private int h=JFrameTotal.WINDOWH;
	//������ť������ֵ
	private int control;
	//��ť��ͼ��
	private ImageIcon defaultIcon=new ImageIcon("image/button/���ְ�ť.png");
	private ImageIcon muteIcon=new ImageIcon("image/button/���־�����ť.png");

	//�������֣��ɸ����洫��
	private BackgroundMusic bgm;
	
	private ButtonBackgroundMusic b=this;
	BgmSyncData bgmSyncData;
	
	public ButtonBackgroundMusic(BgmSyncData data){		
		super();

		bgmSyncData=data;
		this.setBounds((int)(w*0.82),(int)(h*0.1),50,49);

		
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


