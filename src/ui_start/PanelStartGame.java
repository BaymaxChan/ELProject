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
	private ImageIcon imgNewGame1 = new ImageIcon("image/button/��ť����1.png");
	private ImageIcon imgHelp1 = new ImageIcon("image/button/��ť����3.png");
	private ImageIcon imgQuit1 = new ImageIcon("image/button/��ť����4.png");
	//�仯��ͼ��
	private ImageIcon imgNewGame2 = new ImageIcon("image/button/��ť����1-1.gif");
	private ImageIcon imgHelp2 = new ImageIcon("image/button/��ť����3-1.gif");
	private ImageIcon imgQuit2 = new ImageIcon("image/button/��ť����4-1.gif");

	//��������
	private FrameHelp frameHelp;
	
	//��ʼ��ť
	private JButton jbtStart;
	//������ť
	private JButton jbtHelp;
	//�˳���ť
	private JButton jbtQuit;

	public PanelStartGame(BackgroundMusic bgm, BgmSyncData bgmData,SoundSyncData soundData, FrameTotal frameTotal){
		super(bgm, bgmData, soundData, frameTotal);

	/*	Timer t=new Timer(40,new TimerListener());
		t.start();*/
		//���һ����ʼ��Ϸ��ť
		this.jbtStart=new JButton(imgNewGame1);
		this.jbtStart.setBounds((int)(FrameTotal.WINDOWW*0.396),(int)(FrameTotal.WINDOWH*0.583),(int)(FrameTotal.WINDOWW*0.231),(int)(FrameTotal.WINDOWH*0.083));
		this.jbtStart.setContentAreaFilled(false);
		this.jbtStart.setBorderPainted(false);
		this.jbtStart.setPressedIcon(imgNewGame2);
		this.jbtStart.setRolloverIcon(imgNewGame2);
		//���º����ѡ�ؽ���	
		this.jbtStart.setActionCommand("ToSelectMission");
		this.add(jbtStart);
		
		//���һ������&��ʾ��ť
		this.jbtHelp=new JButton(imgHelp1);
		this.jbtHelp.setBounds((int)(FrameTotal.WINDOWW*0.452),(int)(FrameTotal.WINDOWH*0.708),(int)(FrameTotal.WINDOWW*0.115),(int)(FrameTotal.WINDOWH*0.083));
		this.jbtHelp.setContentAreaFilled(false);
		this.jbtHelp.setBorderPainted(false);
		this.jbtHelp.setPressedIcon(imgHelp2);
		this.jbtHelp.setRolloverIcon(imgHelp2);
		this.jbtHelp.setActionCommand("OpenPanelHelp");
		this.add(jbtHelp);

		//���һ���˳���Ϸ��ť
		this.jbtQuit=new JButton(imgQuit1);
		this.jbtQuit.setBounds((int)(FrameTotal.WINDOWW*0.452),(int)(FrameTotal.WINDOWH*0.833),(int)(FrameTotal.WINDOWW*0.115),(int)(FrameTotal.WINDOWH*0.083));
		this.jbtQuit.setContentAreaFilled(false);
		this.jbtQuit.setBorderPainted(false);
		this.jbtQuit.setPressedIcon(imgQuit2);
		this.jbtQuit.setRolloverIcon(imgQuit2);
		this.jbtQuit.setActionCommand("Quit");
		this.add(jbtQuit);
		
		//�ڷֲ������뱳��ͼƬ���	
		this.backgroundImg=Planet.getImageIcon("image/bg/���汳��.png", FrameTotal.WINDOWW,FrameTotal.WINDOWH);
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
		jbtQuit.addActionListener(playerControl);		
		jbtStart.addMouseMotionListener(new MouseMotion());
		jbtHelp.addMouseMotionListener(new MouseMotion());
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
//		this.frameTotal.setEnabled(false);
		this.frameHelp = new FrameHelp(this.playerControl);
		this.frameHelp.setAlwaysOnTop(true);
		WindowDragger.CANDRAGGER = false;
	}
	
	/**
	 * �رհ��������
	 */
	public void closeFrameHelp(){
//		this.frameTotal.setEnabled(true);
		WindowDragger.CANDRAGGER = true;
		this.frameHelp.dispose();
	}
}