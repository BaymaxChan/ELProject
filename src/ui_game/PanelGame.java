package ui_game;

import gamecomponent.Light;
import audio.SoundEffect;
import gamecomponent.Planet;
import gamecomponent.PlanetBlackHole;
import gamecomponent.PlanetDragger;
import gamecomponent.PlanetEarth;
import gamecomponent.PlanetReflection;
import gamecomponent.PlanetRefraction;
import gamecomponent.PlanetSun;
import gamecomponent.PlanetThreeBody;
import gamecomponent.PlanetWhiteDwarf;
import gamecomponent.PlanetWormHole;
import gamedata.GameData;
import gamedata.TotalData;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import ui.BgmSyncData;
import ui.FrameTotal;
import ui.PanelTotal;
import ui.SoundSyncData;
import ui.WindowDragger;
import audio.BackgroundMusic;
import control.GameControl;
import control.KeyControl;
import control.PlanetControl;
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
	
	private int count=0;
	private GameData gameData;
	private PlanetEarth earth;
	private PlanetSun sun;
	private PlanetThreeBody threeBody;
	private PlanetBlackHole[] blackHoles;
	private PlanetWhiteDwarf[] whiteDwarfs;
	private PlanetReflection[] reflections;
	private PlanetRefraction[] refractions;
	private PlanetWormHole wormHole;
	//��Ϸʤ��
	private boolean isGameWin;
	//��Ϸ����ˢ��һ��
	private boolean isGameRefresh;
	private boolean isGameLose;
	
	private PlanetDragger dragger;
	//��ʱ�� TODO
	public long totalMillis=180000;
	public Clock clock;
	//�ؿ���Ϸ����
	private int grade;
	//���ذ�ť
	private JButton returnButton;
	//��һ�ذ�ť(��ͨ�غ���ʾ)
	private JButton nextButton;
	//���ذ�ťͼƬ
	private static final ImageIcon BUTTON_RETURN = Planet.getImageIcon("image/button/RETURN.png", (int)(FrameTotal.WINDOWW*0.098), (int)(FrameTotal.WINDOWW*0.020));
	//��һ�ذ�ťͼƬ
	private static final ImageIcon BUTTON_NEXT = Planet.getImageIcon("image/button/NEXT.png", (int)(FrameTotal.WINDOWW*0.065), (int)(FrameTotal.WINDOWW*0.020));
	//����ͼƬ
	private ImageIcon[] backgroundDemo=new ImageIcon[16];
	private Image[] background=new Image[16];
	
	public PanelGame(BackgroundMusic bgm, BgmSyncData bgmData,SoundSyncData soundData, FrameTotal frameTotal, GameData gameData){
		super(bgm, bgmData, soundData, frameTotal);
		this.gameData=gameData;
		//��ʼ���Ƿ������Ϸ
		this.isGameWin = false;
		this.isGameLose = false;
		this.isGameRefresh = false;
		
		this.setVisible(false);
		this.setLayout(null);
		
		String address = new String();
		for (int i = 0; i < 16; i++) {
			address = "image/background/" + (i+1) + ".jpg";
			backgroundDemo[i] = new ImageIcon(address);
		}

		//���ñ���ͼƬ
		for(int i=0;i<16;i++){
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
		this.returnButton.setBounds((int)(FrameTotal.WINDOWW*0.0156), (int)(FrameTotal.WINDOWH*0.015), (int)(FrameTotal.WINDOWW*0.098), (int)(FrameTotal.WINDOWW*0.036));
		this.returnButton.setContentAreaFilled(false);
		this.returnButton.setBorderPainted(false);
		this.returnButton.addMouseMotionListener(new MouseMotion());
		this.returnButton.setActionCommand("ReturnFromGame");
		this.returnButton.setVisible(true);
		this.add(returnButton);
		
		//�������
		this.earth = this.gameData.getPlanetEarth();
		this.earth.setActionCommand("earth");;
		this.add(this.earth);
		
		this.sun = this.gameData.getPlanetSun();
		this.add(this.sun);
		
		//��������
		this.threeBody = this.gameData.getPlanetThreeBody();
		this.threeBody.setActionCommand("threeBody");;
		this.add(this.threeBody);

		//���뷴��
		this.reflections = new PlanetReflection[this.gameData.getPlanetReflections().size()];
		for (int i = 0; i < this.reflections.length; i++) {
			this.reflections[i] = this.gameData.getPlanetReflections().get(i);
			PlanetControl pc = new PlanetControl(this.reflections[i]);
			this.reflections[i].addKeyListener(pc);
			this.dragger=new PlanetDragger(this.reflections[i],this,this.gameData);
			this.add(this.reflections[i]);
		}
				
		//��������
		this.refractions = new PlanetRefraction[this.gameData.getPlanetRefractions().size()];
		for (int i = 0; i < this.refractions.length; i++) {
			this.refractions[i] = this.gameData.getPlanetRefractions().get(i);
			PlanetControl pc = new PlanetControl(this.refractions[i]);
			this.refractions[i].addKeyListener(pc);
			this.dragger=new PlanetDragger(this.refractions[i],this,this.gameData);
			this.add(this.refractions[i]);		
		}
				
		//����ڶ�
		this.blackHoles = new PlanetBlackHole[this.gameData.getPlanetBlackHoles().size()];
		for (int i = 0; i < this.blackHoles.length; i++) {
			this.blackHoles[i] = this.gameData.getPlanetBlackHoles().get(i);
			this.add(this.blackHoles[i]);		
		}
		
		//����װ���
		this.whiteDwarfs = new PlanetWhiteDwarf[this.gameData.getPlanetWhiteDwarfs().size()];
		for (int i = 0; i < this.whiteDwarfs.length; i++) {
			this.whiteDwarfs[i] = this.gameData.getPlanetWhiteDwarfs().get(i);
			this.add(this.whiteDwarfs[i]);
		}
		
		//����涴
		if(this.gameData.haveWornhole){
			this.add(this.gameData.getPlanetWormHole().getWormHole());
			this.add(this.gameData.getPlanetWormHole().getAnotherWormHole());
		}
	}
	
	/**
	 * ������ҿ������������������м���
	 * @param playerControl
	 */
	public void addControl(PlayerControl playerControl){
		this.playerControl = playerControl;		
		this.returnButton.addActionListener(this.playerControl);
		
		this.earth.addActionListener(this.playerControl);
		this.threeBody.addActionListener(this.playerControl);
	}
	
	/**
	 * ��Ϸͨ�أ�������Ϸ
	 * ֹͣ��Ϸ�����̣߳�����ͨ�ؽ���
	 */
	public void gameOver(){
		//������һ�ذ�ť
		this.nextButton = new JButton();
		this.nextButton.setIcon(BUTTON_NEXT);
		this.nextButton.setBounds((int)(FrameTotal.WINDOWW*0.15), (int)(FrameTotal.WINDOWH*0.018), (int)(FrameTotal.WINDOWW*0.065), (int)(FrameTotal.WINDOWW*0.036));
		this.nextButton.setContentAreaFilled(false);
		this.nextButton.setBorderPainted(false);
		this.nextButton.setActionCommand("NextLevel");
		this.nextButton.addActionListener(playerControl);
		this.nextButton.addMouseMotionListener(new MouseMotion());
		this.nextButton.setVisible(true);
		this.add(nextButton);
				
		int level = this.gameData.getLevel();
		this.computeGrade(this.clock.getMillis());
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
		WindowDragger.CANDRAGGER = false;
		this.winFrame = new FrameWin(this.playerControl, this.grade);
		this.winFrame.setAlwaysOnTop(true);
		//��ʱ��ֹͣ��ʱ
		this.clock.stop();
	}
	
	//time is over, game stops
	public void gameLose(){
		this.grade=0;
		this.isGameLose=true;
		//�ر�bgm
		this.frameTotal.musicGame.stop();
		SoundEffect.LOSE.play();
		//������ʧȥ����Ȩ
		WindowDragger.CANDRAGGER = false;
		this.winFrame = new FrameWin(this.playerControl, this.grade);
		this.winFrame.setAlwaysOnTop(true);
		//��ʱ��ֹͣ��ʱ
		this.clock.stop();
		try {
			Thread.sleep(25);
		} catch (Exception e) {}
	}
	
	//����ƹ���ťʱ������Ч
	public class MouseMotion extends MouseMotionAdapter{
		public void mouseMoved(MouseEvent e) {
			SoundEffect.SELECT.play();
		}
	}
	
	/**
	 * ����ʱ�������ؿ�����
	 * @param sec ͨ��ʱ��
	 */
	private void computeGrade(long millis) {
		int sec=(int)(totalMillis-millis);
		if (sec<=60000){
			this.grade = 5;
		}else if(sec<=90000){
			this.grade = 4;
		}else if(sec<=120000){
			this.grade = 3;
		}else if(sec<=150000){
			this.grade = 4;
		}else if(sec>150000){
			this.grade = 5;
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
		if(this.winFrame != null){
			WindowDragger.CANDRAGGER = true;
			this.winFrame.dispose();	
		}
	}
	
	

	/**
	 * �ж�ĳ�������Ƿ�����߽�
	 * @param light
	 * @return ������߽��򷵻�true����֮����false
	 */
	public boolean isContactBorder(Light light){
		int endX = light.getEndX();
		int endY = light.getEndY();
		if((endX<0)||(endX>FrameTotal.WINDOWW)||(endY<FrameTotal.WINDOWH*0.082)||(endY>FrameTotal.WINDOWH)){
			return true;
		}
		
		if(!Planet.isGAMECONTINUE()){
			return true;
		}
		
		return false;		
	}
	
	public void run() {
		while((!this.isGameWin)&&(!this.isGameRefresh)&&(!this.isGameLose)){
			try {
				Thread.sleep(25);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			//�жϹ����Ƿ��������Χ��(�������빤���ǲ�ͬ��������ɾ�����й��߶����������Ǿ�ֹһ�����߲����������һ������)
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
		this.earth.initeCondition();
		this.sun.initeCondition();
		this.reDrag();
		this.gameData.getLightControl().deleteLights();
		this.gameData.refreshLight();
		Planet.setGAMECONTINUE();
	}

	/**
	 * �滭��Ϸ���ĸ������
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//����ͼƷˢ��
		g.drawImage(background[count/3], 0, 0, null);
		count ++;
		if(count>44){
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
		dragger.stop();
	}
	/**
	 * �������й�������ָ��ƶ�
	 */
	private void reDrag(){
		dragger.start();
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