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
	private ImageIcon icon1=Planet.getImageIcon("image/button/������������1.png", 128, 128);
	private ImageIcon icon2=Planet.getImageIcon("image/button/������������2.png", 108, 118);
	private ImageIcon icon3=Planet.getImageIcon("image/button/������������3.png", 128, 113);
	private ImageIcon icon4=Planet.getImageIcon("image/button/������������4.png", 113, 113);
	private ImageIcon icon5=Planet.getImageIcon("image/button/������������5.png", 118, 108);
	
	private ImageIcon imgReturn=Planet.getImageIcon("image/button/Return4.png", 100, 70);
	//�����ؿ����밴ť
	private JButton jbtMission1;
	private JButton jbtMission2;
	private JButton jbtMission3;
	private JButton jbtMission4;
	private JButton jbtMission5;
	//���ذ�ť
	private JButton jbtBack;
	public PanelSelectMission(BackgroundMusic bgm, BgmSyncData bgmData,SoundSyncData soundData, FrameTotal frameTotal){
		super(bgm, bgmData, soundData, frameTotal);
		
		//��ʾ��һ��ͼ��
		this.jbtMission1=new JButton(icon1);
		this.jbtMission1.setBounds(45, 128, 128, 128);
		this.jbtMission1.setContentAreaFilled(false);
		this.jbtMission1.setBorderPainted(false);
		this.jbtMission1.setActionCommand("1");
		this.add(jbtMission1);
	
		//��ʾ�ڶ���ͼ��
		this.jbtMission2=new JButton(icon2);
		this.jbtMission2.setBounds(204, 222, 108, 118);
		this.jbtMission2.setContentAreaFilled(false);
		this.jbtMission2.setBorderPainted(false);
		this.jbtMission1.setActionCommand("2");
		this.add(jbtMission2);
	
		//��ʾ������ͼ��
		this.jbtMission3=new JButton(icon3);
		this.jbtMission3.setBounds(442, 256, 128, 113);
		this.jbtMission3.setContentAreaFilled(false);
		this.jbtMission3.setBorderPainted(false);
		this.jbtMission1.setActionCommand("3");
		this.add(jbtMission3);
	
		//��ʾ���Ĺ�ͼ��
		this.jbtMission4=new JButton(icon4);
		this.jbtMission4.setBounds(702, 227, 113, 113);
		this.jbtMission4.setContentAreaFilled(false);
		this.jbtMission4.setBorderPainted(false);
		this.jbtMission1.setActionCommand("4");
		this.add(jbtMission4);
	
		//��ʾ�����ͼ��
		this.jbtMission5=new JButton(icon5);
		this.jbtMission5.setBounds(871, 152, 118, 108);
		this.jbtMission5.setContentAreaFilled(false);
		this.jbtMission5.setBorderPainted(false);
		this.jbtMission1.setActionCommand("5");
		this.add(jbtMission5);

		//���ذ�ť
		this.jbtBack=new JButton(imgReturn);
		this.jbtBack.setBounds(16, 532, 100, 70);
		this.jbtBack.setContentAreaFilled(false);
		this.jbtBack.setBorderPainted(false);
		this.jbtBack.setActionCommand("ReturnToStart");
		this.add(jbtBack);

		//�ڷֲ������뱳��ͼƬ���	
		this.backgroundImg=Planet.getImageIcon("image/bg/��������.png", width, height);
		JLabel background = new JLabel(this.backgroundImg);
		background.setBounds(0,0,width,height);		
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
		case 5: jbtMission1.addActionListener(playerControl);
		case 4: jbtMission2.addActionListener(playerControl);
		case 3: jbtMission3.addActionListener(playerControl);
		case 2: jbtMission4.addActionListener(playerControl);
		case 1: jbtMission5.addActionListener(playerControl);
		}
		
		jbtBack.addActionListener(playerControl);
	}
}