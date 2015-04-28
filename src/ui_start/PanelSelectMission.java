/**
 * 
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
public class PanelSelectMission extends JPanel{
	private int w=FrameTotal.WINDOWW;
	private int h=FrameTotal.WINDOWH;
	//��ť��ͼ��
	private ImageIcon icon1=new ImageIcon("image/button/img1.jpg");
	//����ͼƬ
	ImageIcon ic=new ImageIcon("image/bg/���汳��.png");
	Image bg=ic.getImage();
	//��������
	private static BackgroundMusic bgm=new BackgroundMusic("bgm02");
	//����������ť����
	public static ButtonBackgroundMusic jbtBgm;
	public static ButtonSound jbtS;

	//���⣬��ֵӦ���ɸ��ؿ�����
	private boolean isPassed=true;
	
	private final BgmSyncData bgmSyncData;
	private final SoundSyncData soundSyncData;
	
	
	public PanelSelectMission(FrameSelectMission f, BgmSyncData data, SoundSyncData soundData){
		final FrameSelectMission frame=f;
		bgmSyncData=data;
		soundSyncData=soundData;

		
		this.setBounds(0, 0, w, h);
		setLayout(null);
		
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
		
		
		//�����������뱳�����ֿ��ذ�ť
		ButtonBackgroundMusic jbtSilence=new ButtonBackgroundMusic(bgmSyncData);
		jbtSilence.setMusic(bgm);
		add(jbtSilence);
		
		//��Ч���ذ�ť
		ButtonSound jbtSound=new ButtonSound(soundSyncData);
		add(jbtSound);
		
		
		//���ذ�ť
		JButton jbtBack=new JButton(icon1);
		jbtBack.setBounds((int)(w*0.5), (int)(h*0.7), 100, 100);
		add(jbtBack);
		
		//�����������ͼ����뿪ʼ����
		jbtBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				bgm.stop();			//�رձ�������
				frame.dispose();		//�رոý���
				FrameStartGame fsm=new FrameStartGame(bgmSyncData, soundSyncData);	//���½���	
			}	
		});
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, w,h,this);


	}
	

}
