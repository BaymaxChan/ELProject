package ui_start;

import gamedata.GameData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.PlayerControl;

public class PanelSelectMission extends JPanel{
	//������Ϸ����
	private GameData gameData;
	//������ҿ�����
	private PlayerControl playerControl;
	//��ʼ���汳��ͼƬ
	private static ImageIcon bg=new ImageIcon("image/bg/���汳��.png");
	//��ť��ͼ��
	private ImageIcon icon1=new ImageIcon("image/button/img1.jpg");
	
	// TODO���⣬��ֵӦ���ɸ��ؿ�����,��ȷ���ؿ���������Ϊ����
	private boolean isPassed=true;
		
	//�����ؿ����밴ť
	private JButton jbtMission1;
	private JButton jbtMission2;
	private JButton jbtMission3;
	
	public PanelSelectMission(GameData gameData){
		this.gameData = gameData;
		
		this.setLayout(null);
		
		if(isPassed){
			//��ʾ��һ��ͼ��
			jbtMission1=new JButton(icon1);
			jbtMission1.setBounds((int)(1024*0.2), (int)(768*0.4), 100, 100);
			jbtMission1.setActionCommand("ToFirstLevel");
			add(jbtMission1);
		}
		
		if(isPassed){
			//��ʾ�ڶ���ͼ��
			jbtMission2=new JButton(icon1);
			jbtMission2.setBounds((int)(1024*0.5), (int)(768*0.4), 100, 100);
			add(jbtMission2);
		}
		
		if(isPassed){
			//��ʾ������ͼ��
			jbtMission3=new JButton(icon1);
			jbtMission3.setBounds((int)(1024*0.8), (int)(768*0.4), 100, 100);
			add(jbtMission3);
		}
		
		//�ڷֲ������뱳��ͼƬ���	
		JLabel background = new JLabel(bg);
		background.setBounds(0,0,1024,768);		
		this.add(background);
	}

	public void addControl(PlayerControl playerControl) {
		this.playerControl = playerControl;
		/**
		 * �����йؿ���ť������ҿ��������м���
		 */
		jbtMission1.addActionListener(playerControl);
		jbtMission2.addActionListener(playerControl);
		jbtMission3.addActionListener(playerControl);
	}
}
