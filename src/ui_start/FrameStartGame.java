/**
 * ��ʼ����
 * ����ʵ�֣���ʾ����ͼƬ��������Ϸ�Զ����ű����֣����˳���ť�ر���Ϸ����������ť���ر����֡�
 */
package ui_start;

import java.awt.Container;

import ui.*;

import java.awt.event.*;

import javax.swing.*;

import audio.*;


/**
 * @author DorA
 *
 * 2015��4��17��00:20:14
 */
public class FrameStartGame extends JFrameTotal{

	//��ʼ���汳��ͼƬ
	private static ImageIcon bg=new ImageIcon("image/bg/���汳��.png");
	//��������
	public static BackgroundMusic bgm=new BackgroundMusic("bgm01");
	//��ť��ͼ��
	private ImageIcon defaultIcon=new ImageIcon("image/button/img1.jpg");
	private ImageIcon rollIcon=new ImageIcon("image/button/img2.jpg");
	//����������ť����
	public static ButtonBackgroundMusic jbtBgm;
	public static ButtonSound jbtS;
/*	//������ť������ֵ
	private int set=0;*/
	//��ҿ�����
	//private PlayerControl pc=new PlayerControl(new GameControl());
	
	//FrameSelectMission fsm=new FrameSelectMission();
	
	public FrameStartGame(){
		super();
		final FrameStartGame f=this;
		
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
				bgm.stop();			//�رձ�������
				f.dispose();		//�رոý���
				FrameSelectMission fsm=new FrameSelectMission();	//���½���
				
			}
		});	

		
		
		//���һ������&��ʾ��ť
		JButton jbtHelp=new JButton(defaultIcon);
		jbtHelp.setBounds((int)(1024*0.1),(int)(768*0.3),100,100);
		jbtHelp.setToolTipText("Help");
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
		jbtQuit.setBounds((int)(1024*0.3),(int)(768*0.1),100,100);
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
		ButtonBackgroundMusic jbtSilence=new ButtonBackgroundMusic();
		jbtBgm=jbtSilence;
		if(jbtSilence.getControl()==0){
			bgm.play();					//�����Ƿ��������Ƿ񲥷ű�����
		}
		jbtSilence.setMusic(bgm);
		add(jbtSilence);
		
		//������Ч���ذ�ť
		ButtonSound jbtSound=new ButtonSound();
		jbtS=jbtSound;
		add(jbtSound);
		

	}
	
	
	
	public static void main(String[]args){
		final FrameStartGame frame=new FrameStartGame();

	}

}
