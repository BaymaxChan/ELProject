/**
 * ѡ�ؽ������
 */
package ui_start;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import audio.BackgroundMusic;
import ui.*;


/**
 * @author DorA
 *
 * 2015��4��28������1:35:28
 */
public class PanelSelectMission extends ui.PanelTotal{
	private int w=FrameTotal.WINDOWW;
	private int h=FrameTotal.WINDOWH;
	//��ť��ͼ��
	private ImageIcon icon1=new ImageIcon("image/button/img1.jpg");	
	//���⣬��ֵӦ���ɸ��ؿ�����
	private boolean isPassed=true;
	

	public PanelSelectMission(ImageIcon bg,BackgroundMusic bgm,BgmSyncData bgmData,SoundSyncData soundData){
		super();
		
		if(isPassed){
			//��ʾ��һ��ͼ��
			JButton jbtMission1=new JButton(icon1);
			jbtMission1.setBounds((int)(w*0.2), (int)(h*0.4), 100, 100);
			add(jbtMission1);
			
			//�����������ͼ�����ؿ�һ
			jbtMission1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//mission1();		
				}	
			});
		}
		
		if(isPassed){
			//��ʾ�ڶ���ͼ��
			JButton jbtMission2=new JButton(icon1);
			jbtMission2.setBounds((int)(w*0.5), (int)(h*0.4), 100, 100);
			add(jbtMission2);
			
			//�����������ͼ�����ؿ���
			jbtMission2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//mission2();		
				}	
			});
		}
		
		if(isPassed){
			//��ʾ������ͼ��
			JButton jbtMission3=new JButton(icon1);
			jbtMission3.setBounds((int)(w*0.8), (int)(h*0.4), 100, 100);
			add(jbtMission3);
			
			//�����������ͼ�����ؿ���
			jbtMission3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//mission3();		
				}	
			});
		}
		
		

		
		
		//���ذ�ť
		JButton jbtBack=new JButton(icon1);
		jbtBack.setBounds((int)(w*0.5), (int)(h*0.7), 100, 100);
		add(jbtBack);
		
	/*	//�����������ͼ����뿪ʼ����
		jbtBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				bgm.stop();			//�رձ�������
				frame.dispose();		//�رոý���
				FrameStartGame fsm=new FrameStartGame(bgmSyncData, soundSyncData);	//���½���	
			}	
		});*/
	}


	
	
	
	

}
