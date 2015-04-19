/**
 * �������ֿ��ذ�ť���ڽ����е��ø���֮������趨һ�ױ������֡�
 */
package ui;

import java.awt.Color;
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
	private int control=0;
	//��ť��ͼ��
	private ImageIcon defaultIcon=new ImageIcon("image/button/img1.jpg");
	private ImageIcon muteIcon=new ImageIcon("image/button/img2.jpg");
	
	//�������֣��ɸ����洫��
	private BackgroundMusic bgm;
	
	private final ButtonBackgroundMusic b=this;
	
	public ButtonBackgroundMusic(){		
		super();
		
		this.setText("����");
		this.setBounds((int)(1024*0.7),(int)(768*0.1),100,100);
		
		final int open=1,off=0;	
		
		//���ݾ����Ƿ�����ʾͼ�꣬������䱣��ͬ��
		if(control==open){			
			b.setIcon(muteIcon);
		}else{
			b.setIcon(defaultIcon);
		}
	
		//������
		this.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){			
				if( control==open){
					bgm.play();			//���ű�������
					b.setIcon(defaultIcon);
					control--;
				}else if( control==off){					
					bgm.stop();			//ֹͣ����
					b.setIcon(muteIcon);
					control++;
				}				
			}	
		});
		
		setControl(control);
	}
	
	//�ı侲������ֵ
	public void setControl(int control){
		this.control=control;
	}
	
	//��ȡ��������ֵ
	public int getControl(){
		return control;
	}
	
	//����ͬ���������ľ�������
	public void setMusic(BackgroundMusic bgm){
		this.bgm=bgm;
	}
	

}
