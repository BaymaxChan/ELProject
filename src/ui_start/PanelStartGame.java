/**
 * ��ʼ�������
 */
package ui_start;

import gamedata.GameData;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.PlayerControl;
import audio.BackgroundMusic;
import ui.*;

/**
 * @author DorA
 *
 * 2015��4��17��00:20:14
 */
public class PanelStartGame extends PanelTotal{
	//��ť��ͼ��
	private ImageIcon defaultIcon=new ImageIcon("image/button/img1.jpg");
	private ImageIcon rollIcon=new ImageIcon("image/button/img2.jpg");

	//��ʼ��ť
	private JButton jbtStart;
	//������ť
	private JButton jbtHelp;
	//�˳���ť
	private JButton jbtQuit;
	
	public PanelStartGame(BgmSyncData bgmData,SoundSyncData soundData, GameData gameData){
		super(bgmData, soundData, gameData);

		//���һ����ʼ��Ϸ��ť
		this.jbtStart=new JButton(defaultIcon);
		this.jbtStart.setBounds((int)(width*0.2),(int)(height*0.5),100,100);
		this.jbtStart.setToolTipText("select mission");
		this.jbtStart.setPressedIcon(rollIcon);
		this.jbtStart.setRolloverIcon(rollIcon);
		//���º����ѡ�ؽ���	
		this.jbtStart.setActionCommand("ToSelectMission");
		this.add(jbtStart);
		
		//���һ������&��ʾ��ť
		this.jbtHelp=new JButton(defaultIcon);
		this.jbtHelp.setBounds((int)(width*0.45),(int)(height*0.5),100,100);
		this.jbtHelp.setPressedIcon(rollIcon);
		this.jbtHelp.setRolloverIcon(rollIcon);
		this.add(jbtHelp);

		//���һ���˳���Ϸ��ť
		this.jbtQuit=new JButton(defaultIcon);
		this.jbtQuit.setBounds((int)(width*0.7),(int)(height*0.5),100,100);
		this.jbtQuit.setToolTipText("Quit");
		this.jbtQuit.setPressedIcon(rollIcon);
		this.jbtQuit.setRolloverIcon(rollIcon);
		this.add(jbtQuit);

		//�ڷֲ������뱳��ͼƬ���	
		this.backgroundImg=new ImageIcon("image/bg/���汳��.png");
		JLabel background = new JLabel(this.backgroundImg);
		background.setBounds(0,0,width,height);		
		this.add(background);
			
	}	
	
	
	public void addControl(PlayerControl playerControl) {
		this.playerControl = playerControl;
		/**
		 * �����а�ť�������
		 */
		jbtStart.addActionListener(playerControl);
		jbtHelp.addActionListener(playerControl);
		jbtQuit.addActionListener(playerControl);
	}
}
