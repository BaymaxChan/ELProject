package ui;

import gamedata.GameData;
import gamedata.TotalData;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

import ui_game.PanelGame;
import ui_start.PanelSelectMission;
import ui_start.PanelStartGame;
import audio.BackgroundMusic;
import control.GameControl;
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
	private PanelGame panelGame;
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
	
	static{
		TOTALDATA = new TotalData();
	}
	public FrameTotal(){
		try {
			musicStart=new BackgroundMusic("audio/music/Cornfield Chase.wav");
			musicSelect=new BackgroundMusic("audio/music/Cornfield Chase.wav");
			musicGame=new BackgroundMusic("audio/music/Cornfield Chase.wav");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//====================Frame���������趨=======================
		//������Ϊ�˴�ӡ����Ļ�м�
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();  
		
		WINDOWW = (int) (screen.width * 0.8);
		WINDOWH = (int) (screen.height * 0.8);
		
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
		//��ʾ����
		this.setVisible(true);
		//�����������Ϸ��������
		this.gameControl.addFrame(this);
		
		//���ָ��
		this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
			    Toolkit.getDefaultToolkit().getImage("image/cursor/cur.png"), new Point(0, 0),
			    "Slef"));
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
	}
	
	/**
	 * ��ʼ����Ϸ���
	 * @param gameData 
	 */
	public void initPanelGame(GameData gameData){
		this.panelGame = new PanelGame(this.musicGame, this.bgmSyncData, this.SoundSyncData, this,gameData);
		this.panelGame.addControl(playerControl);
		this.add(panelGame);
		this.panelGame.setVisible(true);
		this.validate();
		this.gameControl.setPanelGame(this.panelGame);
		this.repaint();
	}
}