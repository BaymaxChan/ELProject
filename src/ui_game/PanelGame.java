package ui_game;

import gamecomponent.Light;
import gamecomponent.Planet;
import gamecomponent.PlanetDragger;
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
import javax.swing.JButton;

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
	
	/**
	 * ��������
	 */
	private static final int WIDTH = FrameTotal.WINDOWW;
	private static final int HEIGHT = FrameTotal.WINDOWH;
	
	private TotalData totalData;
	private GameData gameData;
	private PlanetEarth earth;
	private PlanetThreeBody threeBody;
	
	private boolean isGameOver;
	
	//��ʱ��
	private Clock clock=new Clock();
	private int secPassed;
	//���ذ�ť
	private JButton returnButton;
	//�رհ�ť
	private JButton closeButton;
	
	//���ذ�ťͼƬ
	private static final ImageIcon BUTTON_RETURN = Planet.getImageIcon("image/button/Return4.png", (int)(WIDTH*0.1), (int)(HEIGHT*0.1));
	//�رհ�ť
	private static final ImageIcon BUTTON_CLOSE = Planet.getImageIcon("image/button/�رհ�ť.png", (int)(HEIGHT*0.1), (int)(HEIGHT*0.1));
	//����ͼƬ
	private ImageIcon backgroundDemo=new ImageIcon("image/bg/����.jpg");
	private Image background=backgroundDemo.getImage();
	
	public PanelGame(BackgroundMusic bgm, BgmSyncData bgmData,SoundSyncData soundData, TotalData totalData, FrameTotal frameTotal, GameData gameData){
		super(bgm, bgmData, soundData, totalData, frameTotal);
		this.gameData=gameData;
		this.totalData = totalData;
		//��ʼ���Ƿ������Ϸ
		this.isGameOver = false;
		
		this.setLayout(null);
		//���ñ���ͼƬ
		background=background.getScaledInstance(FrameTotal.WINDOWW, FrameTotal.WINDOWH, Image.SCALE_SMOOTH);//����ͼƬ�ĺ��ķ���
		backgroundDemo.setImage(background);
		background=backgroundDemo.getImage();
		
		//��ʼ�����а�ť
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
		//���뷵�ذ�ť
		this.returnButton = new JButton();
		this.returnButton.setIcon(BUTTON_RETURN);
		this.returnButton.setBounds((int)(WIDTH*0.88), (int)(HEIGHT*0.9), (int)(WIDTH*0.1), (int)(HEIGHT*0.1));
		this.returnButton.setContentAreaFilled(false);
		this.returnButton.setBorderPainted(false);
		this.returnButton.setActionCommand("ReturnFromGame");
		this.returnButton.setVisible(true);
		this.add(returnButton);
		//���뷵�ذ�ť
		this.closeButton = new JButton();
		this.closeButton.setIcon(BUTTON_CLOSE);
		this.closeButton.setBounds((int)(WIDTH*0.88), (int)(HEIGHT*0.2), (int)(HEIGHT*0.1), (int)(HEIGHT*0.1));
		this.closeButton.setContentAreaFilled(false);
		this.closeButton.setBorderPainted(false);
		this.closeButton.setActionCommand("Quit");
		this.closeButton.setVisible(true);
		this.add(closeButton);
		
		//�������
		this.earth = this.gameData.getPlanetEarth();
		this.earth.setActionCommand("earth");
		this.add(this.earth);
		
		//��������
		this.threeBody = this.gameData.getPlanetThreeBody();
		this.threeBody.setActionCommand("threeBody");;
		this.add(this.threeBody);
		
		//���뷴��
		for (int i = 0; i < this.gameData.getPlanetReflections().size(); i++) {
			new PlanetDragger(this.gameData.getPlanetReflections().get(i),this);
			this.add(this.gameData.getPlanetReflections().get(i));
		}
		
		//��������
		for (int i = 0; i < this.gameData.getPlanetRefractions().size(); i++) {
			new PlanetDragger(this.gameData.getPlanetRefractions().get(i),this);
			this.add(this.gameData.getPlanetRefractions().get(i));		
		}
		
		//�����ʱ��
		this.add(clock);
		clock.setOpaque(false);
		clock.setBounds(850,200,150,200);
	}
	
	/**
	 * ������ҿ������������������м���
	 * @param playerControl
	 */
	public void addControl(PlayerControl playerControl){
		this.playerControl = playerControl;
		this.returnButton.addActionListener(playerControl);
		this.closeButton.addActionListener(playerControl);
		
		this.earth.addActionListener(this.playerControl);
		this.threeBody.addActionListener(this.playerControl);
	}
	
	/**
	 * ��Ϸͨ�أ�������Ϸ
	 * ֹͣ��Ϸ�����̣߳�����ͨ�ؽ���
	 */
	private void gameOver(){
		this.isGameOver = true;
		//�ر�bgm
		this.frameTotal.musicGame.stop();
		//������ʧȥ����Ȩ
		this.frameTotal.setEnabled(false);
		this.winFrame = new FrameWin(this.playerControl, this.clock.getSec());
		//��ʱ��ֹͣ��ʱ
		this.clock.stop();
	}
	
	/**
	 * ˢ����Ϸ����
	 * @param gameData
	 */
	public void initGameData(GameData gameData) {
		this.gameData = gameData;
	}
	
	/**
	 * �ر�ͨ�ؽ���
	 */
	public void closeFrameWin() {
		//�����ڵõ�����Ȩ
		this.frameTotal.setEnabled(true);
		this.winFrame.dispose();	
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
}