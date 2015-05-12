/**
 * ѡ�ؽ������
 */
package ui_start;

import gamecomponent.Planet;
import gamedata.TotalData;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import audio.BackgroundMusic;
import ui.BgmSyncData;
import ui.FrameTotal;
import ui.PanelTotal;
import ui.SoundSyncData;
import control.PlayerControl;

/**
 * @author DorA
 *
 * 2015��4��28������1:35:28
 */
public class PanelSelectMission extends PanelTotal{
	//��ť��ͼ��
	private ImageIcon icon1=Planet.getImageIcon("image/button/������������1.png", (int)(FrameTotal.WINDOWW*0.125), (int)(FrameTotal.WINDOWH*0.213));
	private ImageIcon icon2=Planet.getImageIcon("image/button/������������2.png", (int)(FrameTotal.WINDOWW*0.105), (int)(FrameTotal.WINDOWH*0.197));
	private ImageIcon icon3=Planet.getImageIcon("image/button/������������3.png", (int)(FrameTotal.WINDOWW*0.125), (int)(FrameTotal.WINDOWH*0.188));
	private ImageIcon icon4=Planet.getImageIcon("image/button/������������4.png", (int)(FrameTotal.WINDOWW*0.110), (int)(FrameTotal.WINDOWH*0.188));
	private ImageIcon icon5=Planet.getImageIcon("image/button/������������5.png", (int)(FrameTotal.WINDOWW*0.115), (int)(FrameTotal.WINDOWH*0.180));
	
	private ImageIcon imgReturn=Planet.getImageIcon("image/button/Return4.png", (int)(FrameTotal.WINDOWW*0.098), (int)(FrameTotal.WINDOWH*0.117));
	//�����ؿ����밴ť
	private JButton jbtMission1;
	private JButton jbtMission2;
	private JButton jbtMission3;
	private JButton jbtMission4;
	private JButton jbtMission5;
	//���ذ�ť
	private JButton jbtBack;
	public PanelSelectMission(BackgroundMusic bgm, BgmSyncData bgmData,SoundSyncData soundData, FrameTotal frameTotal){
		super(bgm, bgmData, soundData,frameTotal);
		
		//��ʾ��һ��ͼ��
		this.jbtMission1=new JButton(icon1);
		this.jbtMission1.setBounds((int)(FrameTotal.WINDOWW*0.044), (int)(FrameTotal.WINDOWH*0.213), (int)(FrameTotal.WINDOWW*0.125), (int)(FrameTotal.WINDOWH*0.213));
		this.jbtMission1.setContentAreaFilled(false);
		this.jbtMission1.setBorderPainted(false);
		this.jbtMission1.setActionCommand("1");
		this.add(jbtMission1);
	
		//��ʾ�ڶ���ͼ��
		this.jbtMission2=new JButton(icon2);
		this.jbtMission2.setBounds((int)(FrameTotal.WINDOWW*0.199), (int)(FrameTotal.WINDOWH*0.370), (int)(FrameTotal.WINDOWW*0.105), (int)(FrameTotal.WINDOWH*0.197));
		this.jbtMission2.setContentAreaFilled(false);
		this.jbtMission2.setBorderPainted(false);
		this.jbtMission2.setActionCommand("2");
		this.add(jbtMission2);
	
		//��ʾ������ͼ��
		this.jbtMission3=new JButton(icon3);
		this.jbtMission3.setBounds((int)(FrameTotal.WINDOWW*0.432), (int)(FrameTotal.WINDOWH*0.427), (int)(FrameTotal.WINDOWW*0.125), (int)(FrameTotal.WINDOWH*0.188));
		this.jbtMission3.setContentAreaFilled(false);
		this.jbtMission3.setBorderPainted(false);
		this.jbtMission3.setActionCommand("3");
		this.add(jbtMission3);
	
		//��ʾ���Ĺ�ͼ��
		this.jbtMission4=new JButton(icon4);
		this.jbtMission4.setBounds((int)(FrameTotal.WINDOWW*0.686), (int)(FrameTotal.WINDOWH*0.378), (int)(FrameTotal.WINDOWW*0.110), (int)(FrameTotal.WINDOWH*0.188));
		this.jbtMission4.setContentAreaFilled(false);
		this.jbtMission4.setBorderPainted(false);
		this.jbtMission4.setActionCommand("4");
		this.add(jbtMission4);
	
		//��ʾ�����ͼ��
		this.jbtMission5=new JButton(icon5);
		this.jbtMission5.setBounds((int)(FrameTotal.WINDOWW*0.851), (int)(FrameTotal.WINDOWH*0.253), (int)(FrameTotal.WINDOWW*0.115), (int)(FrameTotal.WINDOWH*0.180));
		this.jbtMission5.setContentAreaFilled(false);
		this.jbtMission5.setBorderPainted(false);
		this.jbtMission5.setActionCommand("5");
		this.add(jbtMission5);

		//���ذ�ť
		this.jbtBack=new JButton(imgReturn);
		this.jbtBack.setBounds((int)(FrameTotal.WINDOWW*0.0156), (int)(FrameTotal.WINDOWH*0.887), 100, 70);
		this.jbtBack.setContentAreaFilled(false);
		this.jbtBack.setBorderPainted(false);
		this.jbtBack.setActionCommand("ReturnToStart");
		this.add(jbtBack);

		//�ڷֲ������뱳��ͼƬ���	
		this.backgroundImg=Planet.getImageIcon("image/bg/��������.png", FrameTotal.WINDOWW, FrameTotal.WINDOWH);
		JLabel background = new JLabel(this.backgroundImg);
		background.setBounds(0,0,FrameTotal.WINDOWW,FrameTotal.WINDOWH);		
		this.add(background);
	}
	
	/**
	 * ������ҿ��������԰�ť���м���
	 * @param playerControl
	 */
	public void addControl(PlayerControl playerControl) {
		this.playerControl = playerControl;
		/**
		 * �����йؿ���ť������ҿ��������м���
		 */
		switch(FrameTotal.TOTALDATA.getLevel()){
		case 5: jbtMission5.addActionListener(playerControl);
		case 4: jbtMission4.addActionListener(playerControl);
		case 3: jbtMission3.addActionListener(playerControl);
		case 2: jbtMission2.addActionListener(playerControl);
		case 1: jbtMission1.addActionListener(playerControl);
		}
		
		jbtBack.addActionListener(playerControl);
	}
}