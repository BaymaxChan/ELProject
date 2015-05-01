/**
 * ѡ�ؽ������
 */
package ui_start;

import gamedata.GameData;
import gamedata.TotalData;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import audio.BackgroundMusic;
import ui.BgmSyncData;
import ui.SoundSyncData;
import control.PlayerControl;


/**
 * @author DorA
 *
 * 2015��4��28������1:35:28
 */
public class PanelSelectMission extends ui.PanelTotal{
	//��ť��ͼ��
	private ImageIcon icon1=new ImageIcon("image/button/img1.jpg");	
	//���⣬��ֵӦ���ɸ��ؿ�����
	private boolean isPassed=true;
	
	//�����ؿ����밴ť
	private JButton jbtMission1;
	private JButton jbtMission2;
	private JButton jbtMission3;
	//���ذ�ť
	private JButton jbtBack;
	
	public PanelSelectMission(BackgroundMusic bgm, BgmSyncData bgmData,SoundSyncData soundData, TotalData totalData){
		super(bgm, bgmData, soundData, totalData);
		
		if(this.isPassed){
			//��ʾ��һ��ͼ��
			this.jbtMission1=new JButton(icon1);
			this.jbtMission1.setBounds((int)(width*0.2), (int)(height*0.4), 100, 100);
			this.jbtMission1.setActionCommand("ToFirstLevel");
			this.add(jbtMission1);
		}
		
		if(this.isPassed){
			//��ʾ�ڶ���ͼ��
			this.jbtMission2=new JButton(icon1);
			this.jbtMission2.setBounds((int)(width*0.5), (int)(height*0.4), 100, 100);
			this.add(jbtMission2);
		}
		
		if(this.isPassed){
			//��ʾ������ͼ��
			this.jbtMission3=new JButton(icon1);
			this.jbtMission3.setBounds((int)(width*0.8), (int)(height*0.4), 100, 100);
			this.add(jbtMission3);
		}
		
		//���ذ�ť
		this.jbtBack=new JButton(icon1);
		this.jbtBack.setBounds((int)(width*0.5), (int)(height*0.7), 100, 100);
		this.jbtBack.setActionCommand("ReturnToStart");
		this.add(jbtBack);

		//�ڷֲ������뱳��ͼƬ���	
		this.backgroundImg=new ImageIcon("image/bg/���汳��.png");
		JLabel background = new JLabel(this.backgroundImg);
		background.setBounds(0,0,width,height);		
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
		jbtBack.addActionListener(playerControl);
	}
}
