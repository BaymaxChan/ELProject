/**
 * ��ʼ�������
 */
package ui_start;

import gamecomponent.Planet;
import gamedata.TotalData;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

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
	private ImageIcon imgNewGame1 = Planet.getImageIcon("image/button/��ť����1.png", 200, 50);
	private ImageIcon imgHelp1 = Planet.getImageIcon("image/button/��ť����3.png", 80, 50);
	private ImageIcon imgQuit1 = Planet.getImageIcon("image/button/��ť����4.png", 80, 50);
	//�仯��ͼ��
	private ImageIcon imgNewGame2 = Planet.getImageIcon("image/button/��ť����1.png", 250, 75);
	private ImageIcon imgHelp2 = Planet.getImageIcon("image/button/��ť����3.png", 250, 75);
	private ImageIcon imgQuit2 = Planet.getImageIcon("image/button/��ť����4.png", 250, 75);

	//��������
	private FrameHelp frameHelp;
	
	//��ʼ��ť
	private JButton jbtStart;
	//������ť
	private JButton jbtHelp;
	//�˳���ť
	private JButton jbtQuit;

	public PanelStartGame(BackgroundMusic bgm, BgmSyncData bgmData,SoundSyncData soundData, TotalData totalData, FrameTotal frameTotal){
		super(bgm, bgmData, soundData, totalData, frameTotal);

		//���һ����ʼ��Ϸ��ť
		this.jbtStart=new JButton(imgNewGame1);
		this.jbtStart.setBounds(412,354,200,50);
		this.jbtStart.setContentAreaFilled(false);
		this.jbtStart.setBorderPainted(false);
		this.jbtStart.setPressedIcon(imgNewGame2);
		this.jbtStart.setRolloverIcon(imgNewGame2);
		//���º����ѡ�ؽ���	
		this.jbtStart.setActionCommand("ToSelectMission");
		this.add(jbtStart);
		
		//���һ������&��ʾ��ť
		this.jbtHelp=new JButton(imgHelp1);
		this.jbtHelp.setBounds(472,436,80,50);
		this.jbtHelp.setContentAreaFilled(false);
		this.jbtHelp.setBorderPainted(false);
		this.jbtHelp.setPressedIcon(imgHelp2);
		this.jbtHelp.setRolloverIcon(imgHelp2);
		this.jbtHelp.setActionCommand("OpenPanelHelp");
		this.add(jbtHelp);

		//���һ���˳���Ϸ��ť
		this.jbtQuit=new JButton(imgQuit1);
		this.jbtQuit.setBounds(472,508,80,50);
		this.jbtQuit.setContentAreaFilled(false);
		this.jbtQuit.setBorderPainted(false);
		this.jbtQuit.setPressedIcon(imgQuit2);
		this.jbtQuit.setRolloverIcon(imgQuit2);
		this.jbtQuit.setActionCommand("Quit");
		this.add(jbtQuit);
		
		//�ڷֲ������뱳��ͼƬ���	
		this.backgroundImg=new ImageIcon("image/bg/���汳��.png");
		JLabel background = new JLabel(this.backgroundImg);
		background.setBounds(0,0,width,height);		
		System.out.println(width);
		System.out.println(height);
		this.add(background);
			
	}
	
	/**
	 * ������ҿ��������԰�ť���м���
	 * @param playerControl
	 */
	public void addControl(PlayerControl playerControl) {
		this.playerControl = playerControl;
		/**
		 * �����а�ť�������
		 */
		jbtStart.addActionListener(playerControl);
		jbtHelp.addActionListener(playerControl);
		jbtQuit.addActionListener(playerControl);
	}

	/**
	 * �򿪰�������
	 */
	public void openFrameHelp() {
		this.frameTotal.setEnabled(false);
		this.frameHelp = new FrameHelp(this.playerControl);
	}
	
	/**
	 * �رհ��������
	 */
	public void closeFrameHelp(){
		this.frameTotal.setEnabled(true);	
		this.frameHelp.dispose();
	}
}