package ui_game;


import gamecomponent.Light;
import gamecomponent.LightControl;
import gamecomponent.PlanetEarth;
import gamecomponent.PlanetSun;
import gamecomponent.PlanetThreeBody;
import gamedata.GameData;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;





import ui.JFrameTotal;
import control.PlayerControl;
/**
 * ��Ϸ����࣬���Ҵ���GameData�����ݺ�����PlayerControl������ϵĲ������м����������߳�
 * @author �����
 * 2015.4.15.
 */

public class JPanelGame extends JPanel implements Runnable{
	PlayerControl playerControl;
	
	private GameData gameData;
	private PlanetEarth earth;
	private PlanetSun sun;
	private PlanetThreeBody threeBody;
	
//	private static final Image background=backgroundDemo.getImage();
	public JPanelGame(GameData gameData){
		this.gameData = gameData;
		
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
	
	public void run() {
		while(true){
			try {
				Thread.sleep(25);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			ArrayList<Light> lightList = this.gameData.getLightControl().getLightList();
			if(!lightList.isEmpty()){
				for (int i = 0; i < lightList.size(); i++) {
					threeBody.getLight(lightList.get(i));
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
		background=background.getScaledInstance(JFrameTotal.WINDOWW, JFrameTotal.WINDOWH, Image.SCALE_SMOOTH);//����ͼƬ�ĺ��ķ���
		backgroundDemo.setImage(background);
		background=backgroundDemo.getImage();
		g.drawImage(background, 0, 0, null);

		//�滭�������������еĹ���
		if(this.gameData.getLightControl().getisExist()){
			ArrayList<Light> lightList = this.gameData.getLightControl().getLightList();
			for (int i = 0; i < lightList.size(); i++) {
				lightList.get(i).paint(g);
			}	
		}	
	}
}
