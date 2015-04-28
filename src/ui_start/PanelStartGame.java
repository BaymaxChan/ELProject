package ui_start;

import gamedata.GameData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.PlayerControl;
import audio.BackgroundMusic;

public class PanelStartGame extends JPanel{
	//������Ϸ����
	private GameData gameData;
	//������ҿ�����
	private PlayerControl playControl;
	//��ʼ���汳��ͼƬ
	private static ImageIcon bg=new ImageIcon("image/bg/���汳��.png");
	//��������
	private BackgroundMusic bgm=new BackgroundMusic();
	//��ť��ͼ��
	private ImageIcon defaultIcon=new ImageIcon("image/button/img1.jpg");
	private ImageIcon rollIcon=new ImageIcon("image/button/img2.jpg");
	//������ť������ֵ
	private int set=0;
	//��ʼ��ť
	private JButton jbtStart;
	//������ť
	private JButton jbtHelp;
	//�˳���ť
	private JButton jbtQuit;
	//�������ְ�ť
	private JButton jbtSilence;
	
	public PanelStartGame(GameData gameData){
		this.gameData = gameData;
		
		//���ű�������
		bgm.play();
				
		
		
		//���һ����ʼ��Ϸ��ť
		jbtStart=new JButton(defaultIcon);
		jbtStart.setBounds((int)(1024*0.3),(int)(768*0.5),100,100);
		jbtStart.setToolTipText("select mission");
		jbtStart.setPressedIcon(rollIcon);
		jbtStart.setRolloverIcon(rollIcon);
		//���º����ѡ�ؽ���	
		jbtStart.setActionCommand("ToSelectMission");
		this.add(jbtStart);
		
		//���һ������&��ʾ��ť
		jbtHelp=new JButton(defaultIcon);
		jbtHelp.setBounds((int)(1024*0.1),(int)(768*0.3),100,100);
		jbtHelp.setPressedIcon(rollIcon);
		jbtHelp.setRolloverIcon(rollIcon);
		add(jbtHelp);

		//���һ���˳���Ϸ��ť
		jbtQuit=new JButton(defaultIcon);
		jbtQuit.setBounds((int)(1024*0.6),(int)(768*0.1),100,100);
		jbtQuit.setToolTipText("Quit");
		jbtQuit.setPressedIcon(rollIcon);
		jbtQuit.setRolloverIcon(rollIcon);
		add(jbtQuit);

		//�����������뱳�����ֿ��ذ�ť
		jbtSilence=new JButton();
		jbtSilence.setBounds((int)(1024*0.8),(int)(768*0.1),100,100);
		add(jbtSilence);
		
		//�ڷֲ������뱳��ͼƬ���	
		JLabel background = new JLabel(bg);
		background.setBounds(0,0,1024,768);		
		this.add(background);
		
		this.setLayout(null);
		
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

	public void addControl(PlayerControl playerControl) {
		this.playControl = playerControl;
		/**
		 * �����а�ť�������
		 */
		jbtStart.addActionListener(this.playControl);
		jbtHelp.addActionListener(playerControl);
		jbtQuit.addActionListener(playerControl);
	}
}
