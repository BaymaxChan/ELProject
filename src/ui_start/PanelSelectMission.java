/**
 * ѡ�ؽ������
 */
package ui_start;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import gamecomponent.Planet;
import gamedata.TotalData;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import audio.BackgroundMusic;
import audio.SoundEffect;
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
	private ImageIcon[] selectIcon;
	//���ذ�ť
	private ImageIcon imgReturn=Planet.getImageIcon("image/button/RETURN.png", (int)(FrameTotal.WINDOWW*0.098), (int)(FrameTotal.WINDOWW*0.020));
	//�ҷ�ҳ��ť
	private ImageIcon imgRight=Planet.getImageIcon("image/button/Right.png", (int)(FrameTotal.WINDOWW*0.036), (int)(FrameTotal.WINDOWW*0.036));
	//�����ؿ����밴ť
	private JButton jbtMission1;
	private JButton jbtMission2;
	private JButton jbtMission3;
	private JButton jbtMission4;
	private JButton jbtMission5;
	//���ذ�ť
	private JButton jbtBack;
	//��ҳ��ť
	private JButton jbtRight;
	
	public PanelSelectMission(BackgroundMusic bgm, BgmSyncData bgmData,SoundSyncData soundData, FrameTotal frameTotal){
		super(bgm, bgmData, soundData,frameTotal);
		
		//���ݹؿ������������ؿ��ȼ�������ť��ͼ��
		int imageW = (int)(FrameTotal.WINDOWW*0.112);
		int imageH = (int)(FrameTotal.WINDOWH*0.184);
		this.selectIcon = new ImageIcon[5];
		String address = new String();
		for (int i = 0; i < selectIcon.length; i++) {
			if(i<FrameTotal.TOTALDATA.getLevel()){
				address = "image/button/" + (i+1) + FrameTotal.TOTALDATA.getGrade(i+1)+".png";				
			}else{
				address = "image/button/" + (i+1) +"-1.png";
			}
			this.selectIcon[i] = Planet.getImageIcon(address, imageW, imageH);
		}
	
		//��ʾ��һ��ͼ��
		this.jbtMission1=new JButton(this.selectIcon[0]);
		this.jbtMission1.setBounds((int)(FrameTotal.WINDOWW*0.044), (int)(FrameTotal.WINDOWH*0.213), imageW, imageH);
		this.jbtMission1.setContentAreaFilled(false);
		this.jbtMission1.setBorderPainted(false);
		this.jbtMission1.setActionCommand("1");
		this.add(jbtMission1);
	
		//��ʾ�ڶ���ͼ��
		this.jbtMission2=new JButton(this.selectIcon[1]);
		this.jbtMission2.setBounds((int)(FrameTotal.WINDOWW*0.199), (int)(FrameTotal.WINDOWH*0.370), imageW, imageH);
		this.jbtMission2.setContentAreaFilled(false);
		this.jbtMission2.setBorderPainted(false);
		this.jbtMission2.setActionCommand("2");
		this.add(jbtMission2);
	
		//��ʾ������ͼ��
		this.jbtMission3=new JButton(this.selectIcon[2]);
		this.jbtMission3.setBounds((int)(FrameTotal.WINDOWW*0.432), (int)(FrameTotal.WINDOWH*0.427), imageW, imageH);
		this.jbtMission3.setContentAreaFilled(false);
		this.jbtMission3.setBorderPainted(false);
		this.jbtMission3.setActionCommand("3");
		this.add(jbtMission3);
	
		//��ʾ���Ĺ�ͼ��
		this.jbtMission4=new JButton(this.selectIcon[3]);
		this.jbtMission4.setBounds((int)(FrameTotal.WINDOWW*0.686), (int)(FrameTotal.WINDOWH*0.378), imageW, imageH);
		this.jbtMission4.setContentAreaFilled(false);
		this.jbtMission4.setBorderPainted(false);
		this.jbtMission4.setActionCommand("4");
		this.add(jbtMission4);
	
		//��ʾ�����ͼ��
		this.jbtMission5=new JButton(this.selectIcon[4]);
		this.jbtMission5.setBounds((int)(FrameTotal.WINDOWW*0.851), (int)(FrameTotal.WINDOWH*0.253), imageW, imageH);
		this.jbtMission5.setContentAreaFilled(false);
		this.jbtMission5.setBorderPainted(false);
		this.jbtMission5.setActionCommand("5");
		this.add(jbtMission5);

		//���ذ�ť
		this.jbtBack=new JButton(imgReturn);
		this.jbtBack.setBounds((int)(FrameTotal.WINDOWW*0.0156), (int)(FrameTotal.WINDOWH*0.015), (int)(FrameTotal.WINDOWW*0.098), (int)(FrameTotal.WINDOWW*0.036));
		this.jbtBack.setContentAreaFilled(false);
		this.jbtBack.setBorderPainted(false);
		this.jbtBack.addMouseMotionListener(new MouseMotion());
		this.jbtBack.setActionCommand("ReturnToStart");
		this.add(jbtBack);
		
		if(FrameTotal.TOTALDATA.getGrade(5) > 0){
			this.jbtRight=new JButton(imgRight);
			this.jbtRight.setBounds((int)(FrameTotal.WINDOWW*0.96), (int)(FrameTotal.WINDOWH*0.8), (int)(FrameTotal.WINDOWW*0.036), (int)(FrameTotal.WINDOWW*0.036));
			this.jbtRight.setContentAreaFilled(false);
			this.jbtRight.setBorderPainted(false);
			this.jbtRight.setActionCommand("5");
			this.add(jbtRight);
		}
		
		//�ڷֲ������뱳��ͼƬ���	
		this.backgroundImg=Planet.getImageIcon("image/background/Select.png", FrameTotal.WINDOWW, FrameTotal.WINDOWH);
		JLabel background = new JLabel(this.backgroundImg);
		background.setBounds(0,0,FrameTotal.WINDOWW,FrameTotal.WINDOWH);		
		this.add(background);
	}
	//����ƹ���ťʱ������Ч
	class MouseMotion extends MouseMotionAdapter{
		public void mouseMoved(MouseEvent e) {
			SoundEffect.SELECT.play();
		}
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
		case 5: jbtMission5.addActionListener(this.playerControl);
		case 4: jbtMission4.addActionListener(this.playerControl);
		case 3: jbtMission3.addActionListener(this.playerControl);
		case 2: jbtMission2.addActionListener(this.playerControl);
		case 1: jbtMission1.addActionListener(this.playerControl);
		}
		
		jbtBack.addActionListener(playerControl);
	}
}