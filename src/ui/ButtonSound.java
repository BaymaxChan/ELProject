/**
 * ��Ч���ذ�ť��
 */
package ui;

import java.awt.Color;
import java.awt.event.*;

import audio.SoundEffect;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author DorA
 * 2015��4��20��00:34:26
 */
public class ButtonSound extends JButton{
	//������ť������ֵ
	private int control=0;
	//��ť��ͼ��
	private ImageIcon defaultIcon=new ImageIcon("image/button/img1.jpg");
	private ImageIcon muteIcon=new ImageIcon("image/button/img2.jpg");
	
	private ButtonSound b=this;
	
	public ButtonSound(){		
		super();
		
		this.setText("��Ч");
		this.setBounds((int)(1024*0.6),(int)(768*0.1),200,100);
		
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
					SoundEffect.setMute(false);
					b.setIcon(defaultIcon);
					control--;
				}else if( control==off){	
					SoundEffect.setMute(true);
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
	
}
