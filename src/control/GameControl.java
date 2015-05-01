package control;

import gamecomponent.PlanetEarth;
import gamedata.GameData;
import gamedata.TotalData;
import gameservice.GameService;
import ui.FrameTotal;
import ui_game.PanelGame;
import ui_start.PanelSelectMission;
import ui_start.PanelStartGame;
/**
 * ��Ϸ�����������ڽ���PlayerControl�������Ϣ��������Ϣ����GameService����ˢ��JPanelGame��
 * @author �����
 * 2015.4.13.
 */
public class GameControl {
	/**
	 * ��Ϸ����
	 */
	private FrameTotal frameTotal;
	/**
	 * ��ʼ�����
	 */
	private PanelStartGame panelStartGame;
	/**
	 * ѡ�ؽ����
	 */
	private PanelSelectMission panelSelectMission;
	/**
	 * ��Ϸ������
	 */
	private TotalData totalData;
	/**
	 * ��Ϸ�����
	 */
	private PanelGame panelGame;
	/**
	 * ��Ϸ�߼���
	 */
	private GameService gameService;
	/**
	 * ������Ϸ����
	 */
	private GameData gameData;
	
	public GameControl(TotalData totalData){
		//������Ϸ������
		this.totalData = totalData;
		//��ʼ����Ϸ�߼�
		this.gameService = new GameService(this.totalData);
	}
	
	/**
	 * ����Ϸ�������м������
	 * @param frameTotal
	 */
	public void addFrame(FrameTotal frameTotal) {
		this.frameTotal = frameTotal;	
	}
	
	public void setPanelStartGame(PanelStartGame panelStartGame) {
		this.panelStartGame = panelStartGame;
	}
	public void setPanelSelectMission(PanelSelectMission panelSelectMission) {
		this.panelSelectMission = panelSelectMission;
	}
	public void setPanelGame(PanelGame panelGame) {
		this.panelGame = panelGame;
	}
	
	public void launchLight() {
		this.gameService.launchLight(PlanetEarth.lightX, PlanetEarth.lightY);
		this.panelGame.repaint();
	}
	//==========================�����Ǹ�����������ת����==============================
	/**
	 * �ӿ�ʼ������ת��ѡ�ؽ���
	 */
	public void toSelectMission() {
		this.frameTotal.remove(this.panelStartGame);
		this.frameTotal.initPanelSelectMission();
	}
	
	/**
	 * ��ѡ�ؽ�����ת����һ����Ϸ����
	 */
	public void toFirstLevel() {
		this.gameData =new GameData();
		this.gameService.refreshGameData(this.gameData);	
		this.frameTotal.remove(this.panelSelectMission);
		this.frameTotal.initPanelGame(this.gameData);
	}
	
	/**
	 * ��ͨ�ؽ��淵����ѡ�ؽ���
	 */
	public void returnFromWin() {
		this.panelGame.closeFrameWin();
		
		this.frameTotal.remove(this.panelGame);
		this.frameTotal.initPanelSelectMission();
	}
	
	/**
	 * ����Ϸ���淵��ѡ�ؽ���
	 */
	public void returnFromGame() {
		this.frameTotal.remove(this.panelGame);
		this.frameTotal.initPanelSelectMission();
	}
	
	/**
	 * ��ѡ�ؽ��淵������ʼ����
	 */
	public void returnToStart() {
		this.frameTotal.remove(this.panelSelectMission);
		this.frameTotal.initPanelStartGame();
	}
	
	/**
	 * �򿪰�������
	 */
	public void openFrameHelp(){
		this.panelStartGame.openFrameHelp();
	}
	
	/**
	 * �رհ�������
	 */
	public void closeFrameHelp() {
		this.panelStartGame.closeFrameHelp();	
	}
	
	/**
	 * ������һ��
	 */
	public void nextLevel() {
		//�ر�ͨ�ؽ���
		this.panelGame.closeFrameWin();
		//���½���������Ϸ����
		this.gameData =new GameData();
		//ˢ����Ϸ����
		this.gameService.refreshGameData(this.gameData);
		//�Ƴ�ԭ�е���Ϸ����
		this.frameTotal.remove(this.panelGame);		
		//��һ����Ϸ����
		this.frameTotal.initPanelGame(this.gameData);
	}
	
	/**
	 * �˳���Ϸ
	 */
	public void Quit() {
		this.frameTotal.removeAll();
		this.frameTotal.dispose();
		System.exit(0);
	}
}