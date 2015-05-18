package ui;

import gamedata.GameData;
import gamedata.TotalData;

import java.awt.AWTEvent;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.sun.awt.AWTUtilities;

import ui_game.PanelGame;
import ui_start.PanelEdit;
import ui_start.PanelSelectDIY;
import ui_start.PanelSelectMission;
import ui_start.PanelStartGame;
import audio.BackgroundMusic;
import control.GameControl;
import control.KeyControl;
import control.PlayerControl;
/**
 * �����ࣺ���н����ģ�壬����������������⣬��С��λ�õ���Ϣ
 * @author �����
 * 2015.4.8.
 * �Ķ���1�������С��Ϊ��Ļ��С��0.618����2��ȥ���˸߶ȡ���ȵľ�̬������3������̬����ȫ����д��by CX  2015.4.8
 * �Ķ����Ѵ�С��ʱ��Ϊ�̶���ֵ�� by CX 2015.4.15
 * �Ķ����Ұѱ߿��ȥ���ˣ����ڹرհ�ťת������ү�£�������ʱ��͵�С������
 */

public class FrameTotal extends JFrame{
	//=================���������趨==================
	//Frame��λ������
	public static int WINDOWX;
	public static int WINDOWY;
	//���ڴ�С
	public static int WINDOWW;
	public static int WINDOWH;
	//====================�����������======================
	//������Ч�ļ�
	final BgmSyncData bgmSyncData;
	final SoundSyncData SoundSyncData;
	/*
	 * �����������
	 */
	private PanelStartGame panelStartGame;
	private PanelSelectMission panelSelectMission;
	public PanelGame panelGame;
	private PanelSelectDIY panelSelectDIY;
	private PanelEdit panelEdit;
	private PanelLoading panelLoading;
	/**
	 * ��������
	 * TODO δ���������ز�
	 */
	public BackgroundMusic musicStart;
	public BackgroundMusic musicSelect;
	public BackgroundMusic musicGame;
	//���ָ��
	//========================��Ϸ�߼�����===========================
	//��Ϸ������
	public static TotalData TOTALDATA;
	//��Ϸ������
	private GameControl gameControl;
	//��ҿ�����
	private PlayerControl playerControl;
	//���̿�����
	private KeyControl keyControl;
	static{
		TOTALDATA = new TotalData();
	}
	public FrameTotal(GameControl gameControl){
		this.setIconImage(new ImageIcon("image/button/LOGO.png").getImage());
		//��Ϸ������
		this.gameControl = gameControl;
		//��ҿ�����
		this.playerControl = new PlayerControl(gameControl);
				
		try {
			musicStart=new BackgroundMusic("audio/music/Cornfield Chase.wav");
			musicSelect=new BackgroundMusic("audio/music/Cornfield Chase.wav");
			musicGame=new BackgroundMusic("audio/music/Cornfield Chase.wav");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//====================Frame���������趨=======================
		//������Ϊ�˴�ӡ����Ļ�м�
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();  
		
		WINDOWW = TOTALDATA.getResolution();
		WINDOWH = (int) (WINDOWW * 0.586);
		if(WINDOWW == 9999){
			WINDOWW = screen.width;
			WINDOWH = screen.height;
		}
	
		this.setSize(WINDOWW, WINDOWH);   

		//������������ʾ��������
		WINDOWX = screen.width-this.getWidth()>>1;
		WINDOWY = (screen.height-this.getHeight()>>1);
		this.setLocation(WINDOWX, WINDOWY);
		//��������϶�
		new WindowDragger(this,this.getContentPane());
		//====================��Ϸ�߼�����=======================
		this.initGameLogic();
		//������Ч״̬
		this.bgmSyncData=new BgmSyncData();
		this.SoundSyncData=new SoundSyncData();
		
		this.initPanelStartGame();
		this.setUndecorated(true);
		
		if(FrameTotal.TOTALDATA.getResolution()!=9999){
		AWTUtilities.setWindowShape(this,  new RoundRectangle2D.Double(0.0, 0.0, this.getWidth(), this.getHeight(), FrameTotal.WINDOWW*0.02, FrameTotal.WINDOWH*0.04));	
		}
		
		//��ʾ����
		this.setVisible(true);
		//�����������Ϸ��������
		this.gameControl.addFrame(this);
		
		//���ָ��
		this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
			    Toolkit.getDefaultToolkit().getImage("image/cursor/Arrow.png"), new Point(0, 0),
			    "Slef"));
		
		this.keyControl = new KeyControl(this.gameControl);
		
		Toolkit.getDefaultToolkit().addAWTEventListener(this.keyControl, AWTEvent.KEY_EVENT_MASK);
	}
	
	/**
	 * ��ʼ����Ϸ�߼�
	 */
	private void initGameLogic(){
		//��Ϸ������
		this.gameControl = new GameControl();
		//��ҿ�����
		this.playerControl = new PlayerControl(gameControl);
	}
	
	//======================��������panel�ķ���========================
	/**
	 * ��ʼ����ʼ���
	 */
	public void initPanelStartGame(){
		this.panelStartGame = new PanelStartGame(this.musicStart, this.bgmSyncData, this.SoundSyncData, this);
		this.panelStartGame.addControl(playerControl);
		this.add(panelStartGame);
		this.panelStartGame.setVisible(true);
		this.validate();
		this.gameControl.setPanelStartGame(this.panelStartGame);
		this.repaint();
		this.requestFocus();
	}
	
	/**
	 * ��ʼ��ѡ�����
	 */
	public void initPanelSelectMission(){
		this.panelSelectMission = new PanelSelectMission(this.musicSelect, this.bgmSyncData, this.SoundSyncData, this);
		this.panelSelectMission.addControl(playerControl);
		this.add(panelSelectMission);
		this.panelSelectMission.setVisible(true);
		this.validate();
		this.gameControl.setPanelSelectMission(this.panelSelectMission);
		this.repaint();
		this.requestFocus();
	}
	
	/**
	 * ��ʼ��loading���
	 */
	public void initPanelLoading(){
		this.panelLoading=new PanelLoading(this);
		this.add(panelLoading);
		this.panelLoading.setVisible(true);
		this.validate();
		this.gameControl.setPanelSelectMission(this.panelSelectMission);
		this.repaint();
		this.requestFocus();
	}
	public void removePanelLoading(){
		this.remove(panelLoading);
	}
	
	/**
	 * ��ʼ����Ϸ���
	 * @param gameData 
	 */
	public void initPanelGame(GameData gameData){
		this.initPanelLoading();
		this.panelGame = new PanelGame(this.musicGame, this.bgmSyncData, this.SoundSyncData, this, gameData);
		this.panelGame.addControl(playerControl);
		this.add(panelGame);
		this.validate();
		this.gameControl.setPanelGame(this.panelGame);
		this.repaint();
		this.requestFocus();
	}
	
	/**
	 * ��ʼ����ϷDIY��� 
	 */
	public void initPanelGameSelectDIY() {
		this.panelSelectDIY = new PanelSelectDIY(this.musicSelect, this.bgmSyncData, this.SoundSyncData, this);
		this.panelSelectDIY.addControl(playerControl);
		this.add(panelSelectDIY);
		this.panelSelectDIY.setVisible(true);
		this.validate();
		this.gameControl.setPanelSelectDIY(this.panelSelectDIY);
		this.repaint();
		this.requestFocus();
	}

	/**
	 * ��ʼ���༭��� 
	 * @param gameData 
	 */
	public void initPanelEdit(GameData gameData) {
		this.panelEdit = new PanelEdit(this.musicStart, this.bgmSyncData, this.SoundSyncData, this, gameData);
		this.panelEdit.addControl(playerControl);
		this.add(panelEdit);
		this.panelEdit.setVisible(true);
		this.validate();
		this.gameControl.setPanelEdit(this.panelEdit);
		this.repaint();
		this.requestFocus();
	}
	
	/**
	 * ���ݱ���ת�������
	 */
	public static int TRANSFERW(double ratioW){
		return (int)(ratioW * WINDOWW);
	}
	
	/**
	 * ���ݱ���ת�����߶�
	 */
	public static int TRANSFERH(double ratioH){
		return (int)(ratioH * WINDOWH);
	}
	
	/**
	 * �õ�����
	 */
	public static double getRatioW(int w){
		return ((double)w / (double)WINDOWW);
	}
	
	public static double getRatioH(int h){
		return ((double)h / (double)WINDOWH);
	}
}