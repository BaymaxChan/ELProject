/**
 * ѡ�ؽ��棬Ӧ�ڰ��¿�ʼ���桰��ʼ��Ϸ����ť����롣�����Ƿ�����ùؿ��������Ƿ���Ե��ͼ�����ùؿ���
 * �Ƿ�����ùؿ�Ӧ����ÿ���ؿ��ṩһ������ֵ��
 */
package ui_start;

import java.awt.Container;
import java.awt.event.*;

import javax.swing.*;

import audio.BackgroundMusic;
import audio.SoundEffect;
import ui.ButtonBackgroundMusic;
import ui.ButtonSound;


/**
 * @author DorA
 *
 * 2015��4��18������6:09:14
 */
public class FrameSelectMission extends ui.JFrameTotal{
	//��ʼ���汳��ͼƬ
	private static ImageIcon bg=new ImageIcon("image/bg/���汳��.png");
	//��ť��ͼ��
	private ImageIcon icon1=new ImageIcon("image/button/img1.jpg");
	//��������
	private static BackgroundMusic bgm=new BackgroundMusic("bgm02");
	//����������ť����
	public static ButtonBackgroundMusic jbtBgm;
	public static ButtonSound jbtS;
	//���⣬��ֵӦ���ɸ��ؿ�����
	private boolean isPassed=true;
	
	public FrameSelectMission(){	//������Ӧ�ô�����ؿ��Ƿ�ͨ���Ĳ���ֵ
		super();
		
		final FrameSelectMission f=this;
		
		//�ڷֲ������뱳��ͼƬ���	
		JLabel background = new JLabel(bg);
		background.setBounds(0,0,1024,768);		
		this.getLayeredPane().add(background);
		
		//�������������Ϊ͸��	
		Container cp=this.getContentPane();
		((JPanel)cp).setOpaque(false);
		
		//���ɲ���
		setLayout(null);
		
		if(isPassed){
			//��ʾ��һ��ͼ��
			JButton jbtMission1=new JButton(icon1);
			jbtMission1.setBounds((int)(1024*0.2), (int)(768*0.4), 100, 100);
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
			jbtMission2.setBounds((int)(1024*0.5), (int)(768*0.4), 100, 100);
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
			jbtMission3.setBounds((int)(1024*0.8), (int)(768*0.4), 100, 100);
			add(jbtMission3);
			
			//�����������ͼ�����ؿ���
			jbtMission3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//mission3();		
				}	
			});
		}
		
		
		//�����������뱳�����ֿ��ذ�ť
		ButtonBackgroundMusic jbtSilence=FrameStartGame.jbtBgm;
		if(jbtSilence.getControl()==0){
			bgm.play();					//�����Ƿ��������Ƿ񲥷ű�����
		}
		jbtBgm=jbtSilence;
		jbtSilence.setMusic(bgm);
		jbtSilence.setBounds((int)(1024*0.8),(int)(768*0.1),100,100);
		add(jbtSilence);
		
		//��Ч���ذ�ť
		ButtonSound jbtSound=FrameStartGame.jbtS;
		jbtS=jbtSound;
		add(jbtSound);
		
		
		//���ذ�ť
		JButton jbtBack=new JButton(icon1);
		add(jbtBack);
		
		//�����������ͼ����뿪ʼ����
		jbtBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				bgm.stop();			//�رձ�������
				f.dispose();		//�رոý���
				FrameStartGame fsm=new FrameStartGame();	//���½���	
			}	
		});
	}

}
