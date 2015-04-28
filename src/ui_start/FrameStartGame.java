/**
 * ��ʼ����
 * ����ʵ�֣���ʾ����ͼƬ��������Ϸ�Զ����ű����֣����˳���ť�ر���Ϸ����������ť���ر����֡�
 */
package ui_start;

import gamedata.GameData;
import gameservice.GameService;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.PlayerControl;

import javax.swing.*;

import ui_game.FrameGame;
import ui_game.PanelGame;
import control.GameControl;
import audio.BackgroundMusic;


/**
 * @author DorA
 *
 * 2015��4��17��00:20:14
 */
public class FrameStartGame extends ui.FrameTotal{
	public PanelStartGame panelStartGame;
	
	public FrameStartGame(PlayerControl playerControl, GameData gameData){
		super();
		
		panelStartGame = new PanelStartGame(gameData);
		panelStartGame.addControl(playerControl);
		this.setContentPane(panelStartGame);
//		//���ű�������
//		bgm.play();
//		
//		//�ڷֲ������뱳��ͼƬ���	
//		JLabel background = new JLabel(bg);
//		background.setBounds(0,0,1024,768);		
//		this.getLayeredPane().add(background);
//		
//		//�������������Ϊ͸��	
//		Container cp=this.getContentPane();
//		((JPanel)cp).setOpaque(false);
		

//		//���ɲ���
//		setLayout(null);
		
//		//���һ����ʼ��Ϸ��ť
//		JButton jbtStart=new JButton(defaultIcon);
//		jbtStart.setBounds((int)(1024*0.3),(int)(768*0.5),100,100);
//		jbtStart.setToolTipText("select mission");
//		jbtStart.setPressedIcon(rollIcon);
//		jbtStart.setRolloverIcon(rollIcon);
//		f.add(jbtStart);
//		
//		//���º����ѡ�ؽ���	
//		jbtStart.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//				//add(panel);
//			//	closeFrame();
//				f.dispose();
//				FrameSelectMission fsm=new FrameSelectMission();
//			}
//		});	
////		jbtStart.addActionListener(playerControl);
////		jbtStart.setActionCommand("ToSelectedFrame");
//
//		
//		
//		//���һ������&��ʾ��ť
//		JButton jbtHelp=new JButton(defaultIcon);
//		jbtHelp.setBounds((int)(1024*0.1),(int)(768*0.3),100,100);
//		jbtHelp.setPressedIcon(rollIcon);
//		jbtHelp.setRolloverIcon(rollIcon);
//		add(jbtHelp);
//			//�˴�Ӧ�м�����
////		jbtHelp.addActionListener(playerControl);
//			
//		//���һ���˳���Ϸ��ť
//		JButton jbtQuit=new JButton(defaultIcon);
//		jbtQuit.setBounds((int)(1024*0.6),(int)(768*0.1),100,100);
//		jbtQuit.setToolTipText("Quit");
//		jbtQuit.setPressedIcon(rollIcon);
//		jbtQuit.setRolloverIcon(rollIcon);
//		add(jbtQuit);
//		
//			
//		//�����������°�ť��ر���Ϸ	
////		jbtQuit.addActionListener(playerControl);
//		
//		//�����������뱳�����ֿ��ذ�ť
//		JButton jbtSilence=new JButton();
//		jbtSilence.setBounds((int)(1024*0.8),(int)(768*0.1),100,100);
//		add(jbtSilence);
//		
//		//��ť���������������ֿ���
//		jbtSilence.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//				final int open=1,off=0;	
//				if(set==open){
//					bgm.play();			//���ű�������
//					set--;
//				}else if(set==off){					
//					bgm.stop();			//ֹͣ����
//					set++;
//				}				
//			}	
//		});

	}
}
