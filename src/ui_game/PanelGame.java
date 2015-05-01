package ui_game;


import gamecomponent.Light;
import gamecomponent.PlanetEarth;
import gamecomponent.PlanetReflection;
import gamecomponent.PlanetRefraction;
import gamecomponent.PlanetSun;
import gamecomponent.PlanetThreeBody;
import gamedata.GameData;
import gamedata.TotalData;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import ui.BgmSyncData;
import ui.FrameTotal;
import ui.PanelTotal;
import ui.SoundSyncData;
import audio.BackgroundMusic;
import control.PlayerControl;
/**
 * ��Ϸ����࣬���Ҵ���GameData�����ݺ�����PlayerControl������ϵĲ������м����������߳�
 * @author �����
 * 2015.4.15.
 */

public class PanelGame extends PanelTotal implements Runnable{
	PlayerControl playerControl;
	FrameWin winFrame;
	
	private TotalData totalData;
	private GameData gameData;
	private PlanetEarth earth;
	private PlanetSun sun;
	private PlanetThreeBody threeBody;
	private PlanetReflection reflection;
	private PlanetRefraction refraction;
	
	private boolean isGameOver;
	
//	private static final Image background=backgroundDemo.getImage();
	public PanelGame(BackgroundMusic bgm, BgmSyncData bgmData,SoundSyncData soundData, TotalData totalData, FrameTotal frameTotal){
		super(bgm, bgmData, soundData, totalData, frameTotal);
		
		this.totalData = totalData;
		//��ʼ���Ƿ������Ϸ
		this.isGameOver = false;
		
		this.initButton();
		
		Thread t = new Thread(this);
		t.start();
	}
	/**
	 * TODO ���ְ�ťͼƬδ��λ
	 * TODO ��ť������ݱ�����
	 * ��ʼ�����еİ�ť
	 */
	private void initButton(){
		this.setLayout(null);
		//�������
		this.earth=new PlanetEarth(90,90,50);
		this.earth.setActionCommand("earth");
		this.add(earth);
		//����̫��
		this.sun=new PlanetSun(320,250,100);
		this.add(sun);
		//��������
		this.threeBody=new PlanetThreeBody(700, 550, 75);
		this.threeBody.setActionCommand("threeBody");
		this.add(threeBody);
//		//���뷴��
//		this.reflection=new PlanetReflection(500, 400, 75, gameData);
//		this.add(reflection);
//		//��������
//		this.refraction=new PlanetRefraction(500, 200, 75, gameData);
//		this.add(refraction);
	}
	/**
	 * ������ҿ������������������м���
	 * @param playerControl
	 */
	public void addControl(PlayerControl playerControl){
		this.playerControl = playerControl;
		this.earth.addActionListener(this.playerControl);
		this.sun.addActionListener(this.playerControl);
		this.threeBody.addActionListener(this.playerControl);
	}
	/**
	 * ��Ϸͨ�أ�������Ϸ
	 * ֹͣ��Ϸ�����̣߳�����ͨ�ؽ���
	 */
	private void gameOver(){
		this.isGameOver = true;
		//������ʧȥ����Ȩ
		this.frameTotal.setEnabled(false);;
		this.winFrame = new FrameWin(this.playerControl);
	}

	public void run() {
		while(!this.isGameOver){
			try {
				Thread.sleep(25);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			// TODO �жϹ����Ƿ��������Χ��(�������빤���ǲ�ͬ��������ɾ�����й��߶����������Ǿ�ֹһ�����߲����������һ������)
			ArrayList<Light> lightList = this.gameData.getLightControl().getLightList();
			if(!lightList.isEmpty()){
				for (int i = 0; i < lightList.size(); i++) {
					threeBody.getLight(lightList.get(i));
					//������ߵִ���ֹͣ����ǰ������֮�����в���
					threeBody.stopLight(this.gameData.getLightControl());
				}
			}
			this.repaint();
		}	
	}
	
	/**
	 * �滭��Ϸ���ĸ������
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		/*
		 * ����Ĵ��볬���ƣ������⻹��ֱ�����Һ��ˣ�by CX
		 * ������������ʲô�ֱ��ʵ������ͼƬ�����Զ��ķŴ���С������Ӧ��ͬ��ϵͳ
		 * ���һ�ǣ��������Ĵ���
		 * */
		ImageIcon backgroundDemo=new ImageIcon("image/bg/����.jpg");
		Image background=backgroundDemo.getImage();
		background=background.getScaledInstance(FrameTotal.WINDOWW, FrameTotal.WINDOWH, Image.SCALE_SMOOTH);//����ͼƬ�ĺ��ķ���
		backgroundDemo.setImage(background);
		background=backgroundDemo.getImage();
		g.drawImage(background, 0, 0, null);

		//�滭�������������еĹ���
		if(this.gameData.getLightControl().getisExist()){
			//�����߿��������ڣ�˵�����߲�δ���������ǣ���Ϸ����
			ArrayList<Light> lightList = this.gameData.getLightControl().getLightList();
			for (int i = 0; i < lightList.size(); i++) {
				lightList.get(i).paint(g);
			}	
		}else if(!this.isGameOver){
			//�����߿����������ڣ�˵����Ϸ��������ʾͨ�ؽ���
			this.gameOver();
		}
	}
	public void initGameData(GameData gameData) {
		this.gameData = gameData;
	}
	public void closeFrameWin() {
		//�����ڵõ�����Ȩ
		this.frameTotal.setEnabled(true);
		this.winFrame.dispose();	
	}
}
