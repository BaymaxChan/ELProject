/**
 * ��ʼ�������
 */
package ui_start;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import gamecomponent.Planet;
import gamedata.TotalData;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

import control.PlayerControl;
import audio.BackgroundMusic;
import audio.SoundEffect;
import ui.*;

/**
 * @author DorA
 *
 * 2015��4��17��00:20:14
 */
public class PanelStartGame extends PanelTotal{
	//��ť��ͼ��
	private ImageIcon imgNewGame1 = Planet.getImageIcon("image/button/��ť����1.png", (int)(FrameTotal.WINDOWW*0.211),(int)(FrameTotal.WINDOWH*0.06));
	private ImageIcon imgHelp1 = Planet.getImageIcon("image/button/��ť����3.png", (int)(FrameTotal.WINDOWW*0.105),(int)(FrameTotal.WINDOWH*0.06));
	private ImageIcon imgConfig1 = Planet.getImageIcon("image/button/��ť����2.png", (int)(FrameTotal.WINDOWW*0.170),(int)(FrameTotal.WINDOWH*0.07));
	private ImageIcon imgQuit1 = Planet.getImageIcon("image/button/��ť����4.png", (int)(FrameTotal.WINDOWW*0.105),(int)(FrameTotal.WINDOWH*0.06));
//	//�仯��ͼ��
//	private ImageIcon imgNewGame2 = new ImageIcon("image/button/��ť����1-1.gif");
//	private ImageIcon imgHelp2 = new ImageIcon("image/button/��ť����3-1.gif");
//	private ImageIcon imgQuit2 = new ImageIcon("image/button/��ť����4-1.gif");

	//��������
	private FrameHelp frameHelp;
	//���ý���
	private FrameConfig frameConfig;
	//��ʼ��ť
	private JButton jbtStart;
	//������ť
	private JButton jbtHelp;
	//���ð�ť
	private JButton jbtConfig;
	//�˳���ť
	private JButton jbtQuit;

	public PanelStartGame(BackgroundMusic bgm, BgmSyncData bgmData,SoundSyncData soundData, FrameTotal frameTotal){
		super(bgm, bgmData, soundData, frameTotal);

	/*	Timer t=new Timer(40,new TimerListener());
		t.start();*/
		//���һ����ʼ��Ϸ��ť
		this.jbtStart=new JButton(imgNewGame1);
		this.jbtStart.setBounds((int)(FrameTotal.WINDOWW*0.396),(int)(FrameTotal.WINDOWH*0.583),(int)(FrameTotal.WINDOWW*0.231),(int)(FrameTotal.WINDOWH*0.06));
		this.jbtStart.setContentAreaFilled(false);
		this.jbtStart.setBorderPainted(false);
		this.jbtStart.setPressedIcon(imgNewGame1);
		this.jbtStart.setRolloverIcon(imgNewGame1);
		//���º����ѡ�ؽ���	
		this.jbtStart.setActionCommand("ToSelectMission");
		this.add(jbtStart);
		
		//���һ������&��ʾ��ť
		this.jbtHelp=new JButton(imgHelp1);
		this.jbtHelp.setBounds((int)(FrameTotal.WINDOWW*0.452),(int)(FrameTotal.WINDOWH*0.673),(int)(FrameTotal.WINDOWW*0.115),(int)(FrameTotal.WINDOWH*0.06));
		this.jbtHelp.setContentAreaFilled(false);
		this.jbtHelp.setBorderPainted(false);
		this.jbtHelp.setPressedIcon(imgHelp1);
		this.jbtHelp.setRolloverIcon(imgHelp1);
		this.jbtHelp.setActionCommand("OpenPanelHelp");
		this.add(jbtHelp);
		
		//���һ�����ð�ť
		this.jbtConfig=new JButton(imgConfig1);
		this.jbtConfig.setBounds((int)(FrameTotal.WINDOWW*0.423),(int)(FrameTotal.WINDOWH*0.763),(int)(FrameTotal.WINDOWW*0.185),(int)(FrameTotal.WINDOWH*0.07));
		this.jbtConfig.setContentAreaFilled(false);
		this.jbtConfig.setBorderPainted(false);
		this.jbtConfig.setPressedIcon(imgConfig1);
		this.jbtConfig.setRolloverIcon(imgConfig1);
		this.jbtConfig.setActionCommand("OpenPanelConfig");
		this.add(jbtConfig);

		//���һ���˳���Ϸ��ť
		this.jbtQuit=new JButton(imgQuit1);
		this.jbtQuit.setBounds((int)(FrameTotal.WINDOWW*0.452),(int)(FrameTotal.WINDOWH*0.853),(int)(FrameTotal.WINDOWW*0.115),(int)(FrameTotal.WINDOWH*0.06));
		this.jbtQuit.setContentAreaFilled(false);
		this.jbtQuit.setBorderPainted(false);
		this.jbtQuit.setPressedIcon(imgQuit1);
		this.jbtQuit.setRolloverIcon(imgQuit1);
		this.jbtQuit.setActionCommand("Quit");
		this.add(jbtQuit);
		
		//�ڷֲ������뱳��ͼƬ���	
		this.backgroundImg=Planet.getImageIcon("image/bg/��ʼ����.png", FrameTotal.WINDOWW,FrameTotal.WINDOWH);
		JLabel background = new JLabel(this.backgroundImg);
		background.setBounds(0,0,FrameTotal.WINDOWW,FrameTotal.WINDOWH);		
		this.add(background);			
	}
	private class TimerListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			repaint();
		}
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
		jbtConfig.addActionListener(playerControl);
		jbtQuit.addActionListener(playerControl);		
		jbtStart.addMouseMotionListener(new MouseMotion());
		jbtHelp.addMouseMotionListener(new MouseMotion());
		jbtConfig.addMouseMotionListener(new MouseMotion());
		jbtQuit.addMouseMotionListener(new MouseMotion());
	}
	
	//����ƹ���ťʱ������Ч
	class MouseMotion extends MouseMotionAdapter{
		public void mouseMoved(MouseEvent e) {
			SoundEffect.SELECT.play();
		}
	}
	
	/**
	 * �򿪰�������
	 */
	public void openFrameHelp() {
		this.frameTotal.setEnabled(false);
		this.frameHelp = new FrameHelp(this.playerControl);
	}
	
	/**
	 * �رհ�������
	 */
	public void closeFrameHelp(){
		this.frameTotal.setEnabled(true);	
		this.frameHelp.dispose();
	}

	public void openFrameConfig() {
		this.frameTotal.setEnabled(false);
		this.frameConfig = new FrameConfig(this.playerControl);
	}
	
	/**
	 * �ر����ý���
	 */
	public void closeFrameConfig(){
		this.frameTotal.setEnabled(true);	
		this.frameConfig.dispose();
	}
}