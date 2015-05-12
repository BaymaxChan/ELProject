package ui_game;

import gamecomponent.Light;
import audio.SoundEffect;
import gamecomponent.Planet;
import gamecomponent.PlanetBlackHole;
import gamecomponent.PlanetDragger;
import gamecomponent.PlanetEarth;
import gamecomponent.PlanetThreeBody;
import gamecomponent.PlanetWormHole;
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
import control.GameControl;
import control.PlayerControl;
/**
 * ��Ϸ����࣬���Ҵ���GameData�����ݺ�����PlayerControl������ϵĲ������м����������߳�
 * @author �����
 * 2015.4.15.
 */
public class PanelGame extends PanelTotal implements Runnable{
	PlayerControl playerControl;
	GameControl gameControl;
	FrameWin winFrame;
	
	/**
	 * ��������
	 */
	private static final int WIDTH = FrameTotal.WINDOWW;
	private static final int HEIGHT = FrameTotal.WINDOWH;
	
	private int count=0;
	private GameData gameData;
	private PlanetEarth earth;
	private PlanetThreeBody threeBody;
	private PlanetBlackHole blackHole;
	private PlanetWormHole wormHole;
	//��Ϸʤ��
	private boolean isGameWin;
	//��Ϸ����ˢ��һ��
	private boolean isGameRefresh;
	//
	private PlanetDragger[] dragger=new PlanetDragger[2];
	//��ʱ��
	private Clock clock=new Clock();
	private int secPassed;
	//�ؿ���Ϸ����
	private int grade;
	//���ذ�ť
	private JButton returnButton;
	//�رհ�ť
	private JButton closeButton;
	
	//���ذ�ťͼƬ
	private static final ImageIcon BUTTON_RETURN = Planet.getImageIcon("image/button/Return4.png", (int)(WIDTH*0.1), (int)(HEIGHT*0.1));
	//�رհ�ť
	private static final ImageIcon BUTTON_CLOSE = Planet.getImageIcon("image/button/�رհ�ť.png", (int)(HEIGHT*0.1), (int)(HEIGHT*0.1));
	//����ͼƬ
	private ImageIcon[] backgroundDemo=new ImageIcon[3];
	private Image[] background=new Image[3];
	
	public PanelGame(BackgroundMusic bgm, BgmSyncData bgmData,SoundSyncData soundData, FrameTotal frameTotal, GameData gameData){
		super(bgm, bgmData, soundData, frameTotal);
		this.gameData=gameData;
		//��ʼ���Ƿ������Ϸ
		this.isGameWin = false;
		this.isGameRefresh = false;
		
		this.setLayout(null);
		//
		backgroundDemo[0]=new ImageIcon("image/bg/����1.png");
		backgroundDemo[1]=new ImageIcon("image/bg/����2.png");
		backgroundDemo[2]=new ImageIcon("image/bg/����3.png");
		//���ñ���ͼƬ
		for(int i=0;i<3;i++){
			background[i]=getImage(backgroundDemo[i], this.width, this.height);
		}
		
		//��ʼ�����а�ť
		this.initButton();
		
		Thread thread = new Thread(this);
		thread.start();
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
		
		this.add(this.gameData.getPlanetSun());
		
		//��������
		this.threeBody = this.gameData.getPlanetThreeBody();
		this.threeBody.setActionCommand("threeBody");;
		this.add(this.threeBody);
		
		//���뷴��
		for (int i = 0; i < this.gameData.getPlanetReflections().size(); i++) {
			dragger[0]=new PlanetDragger(this.gameData.getPlanetReflections().get(i),this);
			this.add(this.gameData.getPlanetReflections().get(i));
		}
		
		//��������
		for (int i = 0; i < this.gameData.getPlanetRefractions().size(); i++) {
			dragger[1]=new PlanetDragger(this.gameData.getPlanetRefractions().get(i),this);
			this.add(this.gameData.getPlanetRefractions().get(i));		
		}
		//����ڶ�
		for (int i = 0; i < this.gameData.getPlanetBlackHoles().size(); i++) {
			this.add(this.gameData.getPlanetBlackHoles().get(i));		
		}
		//����涴
		if(this.gameData.haveWornhole){
			this.add(this.gameData.getPlanetWormHole().getWormHole());
			this.add(this.gameData.getPlanetWormHole().getAnotherWormHole());
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
		int level = this.gameData.getLevel();
		this.computeGrade(this.clock.getSec());
		if(FrameTotal.TOTALDATA.getGrade(level) == 0){
			FrameTotal.TOTALDATA.levelUp();
		}
		if(FrameTotal.TOTALDATA.getGrade(level) < this.grade){
			FrameTotal.TOTALDATA.setGrade(level, this.grade);
		}
		this.isGameWin = true;
		//���Ź�����Ч
		SoundEffect.WIN.play();
		//�ر�bgm
		this.frameTotal.musicGame.stop();
		//������ʧȥ����Ȩ
		this.frameTotal.setEnabled(false);
		this.winFrame = new FrameWin(this.playerControl, this.grade);
		//��ʱ��ֹͣ��ʱ
		this.clock.stop();
	}
	
	/**
	 * ����ʱ�������ؿ�����
	 * @param sec ͨ��ʱ��
	 */
	private void computeGrade(int sec) {
		if (sec<=60){
			this.grade = 5;
		}else if(sec<=120){
			this.grade = 4;
		}else if(sec<=180){
			this.grade = 3;
		}else if(sec<=240){
			this.grade = 2;
		}else if(sec>240){
			this.grade = 1;
		}
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

	/**
	 * �ж�ĳ�������Ƿ�����߽�
	 * @param light
	 * @return ������߽��򷵻�true����֮����false
	 */
	public boolean isContactBorder(Light light){
		int endX = light.getEndX();
		int endY = light.getEndY();
		if((endX<0)||(endX>WIDTH)||(endY<0)||(endY>HEIGHT)){
			return true;
		}
		return false;		
	}
	
	public void run() {
		while((!this.isGameWin)&&(!this.isGameRefresh)){
			try {
				Thread.sleep(25);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			// TODO �жϹ����Ƿ��������Χ��(�������빤���ǲ�ͬ��������ɾ�����й��߶����������Ǿ�ֹһ�����߲����������һ������)
			ArrayList<Light> lightList = this.gameData.getLightControl().getLightList();
			if(!lightList.isEmpty()){
				for (int i = 0; i < lightList.size(); i++) {
					if(this.isContactBorder(lightList.get(i))){
						this.refreshGame();
					}
					threeBody.getLight(lightList.get(i));
					//������ߵִ���ֹͣ����ǰ������֮�����в���
					threeBody.stopLight(this.gameData.getLightControl());
				}
			}
			this.repaint();
		}	
	}
	
	/**
	 * ����ˢ��һ����Ϸ
	 */
	private void refreshGame() {
		this.reDrag();
		this.gameData.getLightControl().deleteLights();
		this.gameData.refreshLight();
	}

	/**
	 * �滭��Ϸ���ĸ������
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//����ͼƷˢ��
		g.drawImage(background[count/8], 0, 0, null);
		count ++;
		if(count>23){
			count=0;
		}
		
		//�滭�������������еĹ���
		if(this.gameData.getLightControl().getisExist()){
			//�����߿��������ڣ�˵�����߲�δ���������ǣ���Ϸ����
			ArrayList<Light> lightList = this.gameData.getLightControl().getLightList();
			for (int i = 0; i < lightList.size(); i++) {
				lightList.get(i).paint(g);
			}	
		}else if(!this.isGameWin){
			//�����߿����������ڣ�˵����Ϸ��������ʾͨ�ؽ���
			this.gameOver();
		}
	}
	/**
	 * �������й������򲻿��ƶ�
	 */
	public void stopDrag(){
		for(PlanetDragger cell:dragger){
			cell.stop();
		}
	}
	/**
	 * �������й�������ָ��ƶ�
	 */
	private void reDrag(){
		for(PlanetDragger cell:dragger){
			cell.start();
		}
	}

	public void addControl(GameControl gameControl) {

		this.gameControl = gameControl;
	}
	/**
	 * ��ͼƬ���ŵ�ָ����ʽ
	 * @author CX
	 * @param filename·����
	 * @param width�����Ŀ��
	 * @param height�����ĸ߶�
	 * @return ���ź��ͼ��Ϊimage��ʽ
	 */
	public static Image getImage(ImageIcon temp,int width,int height){
		Image alsoTemp=temp.getImage();
		alsoTemp=alsoTemp.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING);
		return alsoTemp;
	}
}