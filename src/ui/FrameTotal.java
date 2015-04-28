package ui;

import gamedata.GameData;
import gameservice.GameService;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.GameControl;
import control.PlayerControl;
import ui_game.PanelGame;
import ui_start.PanelSelectMission;
import ui_start.PanelStartGame;
/**
 * �����ࣺ���н����ģ�壬����������������⣬��С��λ�õ���Ϣ
 * @author �����
 * 2015.4.8.
 * �Ķ���1�������С��Ϊ��Ļ��С��0.618����2��ȥ���˸߶ȡ���ȵľ�̬������3������̬����ȫ����д��by CX  2015.4.8
 * �Ķ����Ѵ�С��ʱ��Ϊ�̶���ֵ�� by CX 2015.4.15
 */

public class FrameTotal extends JFrame{
	//=================���������趨==================
	//Ŀ��ĵ�ַ���߶�
	private static final int WINDOW_UP = 16;
	//Frame��λ������
	protected static int WINDOWX;
	protected static int WINDOWY;
	//���ڴ�С
	public static final int WINDOWW = 1024;
	public static final int WINDOWH = 700;
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
	//========================��Ϸ�߼�����===========================
	//��Ϸ������
	private GameData gameData;
	//��Ϸ�߼���
	private GameService gameService;
	//��Ϸ������
	private GameControl gameControl;
	//��ҿ�����
	private PlayerControl playerControl;
	
	public FrameTotal(){		
		//====================Frame���������趨=======================
		//���ò��ɸı��С�Լ��رպ�ֹͣ����
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//������Ϊ�˴�ӡ����Ļ�м�
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();  

		this.setSize(WINDOWW, WINDOWH);   
		
		//������������ʾ��������
		WINDOWX = screen.width-this.getWidth()>>1;
		WINDOWY = (screen.height-this.getHeight()>>1)-WINDOW_UP;
		this.setLocation(WINDOWX, WINDOWY);
		//====================��Ϸ�߼�����=======================
		this.initGameLogic();
		//������Ч״̬
		this.bgmSyncData=new BgmSyncData();
		this.SoundSyncData=new SoundSyncData();
		
		this.initPanelStartGame();
		
		//��ʾ����
		this.setVisible(true);
		//�����������Ϸ��������
		this.gameControl.addFrame(this);
	}
	
	/**
	 * ��ʼ����Ϸ�߼�
	 */
	private void initGameLogic(){
		//��Ϸ������
		this.gameData = new GameData();
		//��Ϸ�߼���
		this.gameService = new GameService(gameData);
		//��Ϸ������
		this.gameControl = new GameControl(gameService, gameData);
		//��ҿ�����
		this.playerControl = new PlayerControl(gameControl);
	}
	//======================��������panel�ķ���========================
	/**
	 * ��ʼ����ʼ���
	 */
	public void initPanelStartGame(){
		this.panelStartGame = new PanelStartGame(this.bgmSyncData, this.SoundSyncData, this.gameData);
		this.panelStartGame.addControl(playerControl);
		this.add(panelStartGame);
		this.panelStartGame.setVisible(true);
		this.validate();
		this.gameControl.setPanelStartGame(this.panelStartGame);
	}
	/**
	 * ��ʼ��ѡ�����
	 */
	public void initPanelSelectMission(){
		this.panelSelectMission = new PanelSelectMission(this.bgmSyncData, this.SoundSyncData, this.gameData);
		this.panelSelectMission.addControl(playerControl);
		this.add(panelSelectMission);
		this.panelSelectMission.setVisible(true);
		this.validate();
		this.gameControl.setPanelSelectMission(this.panelSelectMission);
	}
	/**
	 * ��ʼ����Ϸ���
	 */
	public void initPanelGame(){
		this.panelGame = new PanelGame(gameData);
		this.panelGame.addControl(playerControl);
		this.add(panelGame);
		this.panelGame.setVisible(true);
		this.validate();
		this.gameControl.setPanelGame(this.panelGame);
	}
}
