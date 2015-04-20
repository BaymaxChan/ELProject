/**
 * ��ʼ����
 * ����ʵ�֣���ʾ����ͼƬ��������Ϸ�Զ����ű����֣����˳���ť�ر���Ϸ����������ť���ر����֡�
 */
package ui_start;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.PlayerControl;

import javax.swing.*;

import control.GameControl;
import audio.BackgroundMusic;


/**
 * @author DorA
 *
 * 2015��4��17��00:20:14
 */
public class FrameStartGame extends ui.JFrameTotal{

	//��ʼ���汳��ͼƬ
	private static ImageIcon bg=new ImageIcon("image/bg/���汳��.png");
	//��������
	private BackgroundMusic bgm=new BackgroundMusic();
	//��ť��ͼ��
	private ImageIcon defaultIcon=new ImageIcon("image/button/img1.jpg");
	private ImageIcon rollIcon=new ImageIcon("image/button/img2.jpg");
	//������ť������ֵ
	private int set=0;
	//��ҿ�����
	//private PlayerControl pc=new PlayerControl(new GameControl());
	
	//FrameSelectMission fsm=new FrameSelectMission();
	
	public FrameStartGame(){
		super();
		final FrameStartGame f=this;
		
		//���ű�������
		bgm.play();
		
		//�ڷֲ������뱳��ͼƬ���	
		JLabel background = new JLabel(bg);
		background.setBounds(0,0,1024,768);		
		this.getLayeredPane().add(background);
		
		//�������������Ϊ͸��	
		Container cp=this.getContentPane();
		((JPanel)cp).setOpaque(false);
		

		//���ɲ���
		setLayout(null);
		
		//���һ����ʼ��Ϸ��ť
		JButton jbtStart=new JButton(defaultIcon);
		jbtStart.setBounds((int)(1024*0.3),(int)(768*0.5),100,100);
		jbtStart.setToolTipText("select mission");
			jbtStart.setPressedIcon(rollIcon);
			jbtStart.setRolloverIcon(rollIcon);
		f.add(jbtStart);
		
		//���º����ѡ�ؽ���	
		jbtStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//add(panel);
			//	closeFrame();
				f.dispose();
				FrameSelectMission fsm=new FrameSelectMission();
				
			}
		});	

		
		
		//���һ������&��ʾ��ť
		JButton jbtHelp=new JButton(defaultIcon);
		jbtHelp.setBounds((int)(1024*0.1),(int)(768*0.3),100,100);
		jbtHelp.setPressedIcon(rollIcon);
		jbtHelp.setRolloverIcon(rollIcon);
		add(jbtHelp);
			//�˴�Ӧ�м�����
		jbtHelp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//add(panel);
				
			}
		});
			
		//���һ���˳���Ϸ��ť
		JButton jbtQuit=new JButton(defaultIcon);
		jbtQuit.setBounds((int)(1024*0.6),(int)(768*0.1),100,100);
		jbtQuit.setToolTipText("Quit");
		jbtQuit.setPressedIcon(rollIcon);
		jbtQuit.setRolloverIcon(rollIcon);
		add(jbtQuit);
		
			
		//�����������°�ť��ر���Ϸ	
		jbtQuit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);		
			}
		});
		
		//�����������뱳�����ֿ��ذ�ť
		JButton jbtSilence=new JButton();
		jbtSilence.setBounds((int)(1024*0.8),(int)(768*0.1),100,100);
		add(jbtSilence);
		
		//��ť���������������ֿ���
		jbtSilence.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				final int open=1,off=0;	
				if(set==open){
					bgm.play();			//���ű�������
					set--;
				}else if(set==off){					
					bgm.stop();			//ֹͣ����
					set++;
				}				
			}	
		});

	}
	

	
/*	public static void main(String[]args){
		final FrameStartGame frame=new FrameStartGame();

	}*/

}
