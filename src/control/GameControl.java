package control;

import gamecomponent.PlanetEarth;
import gamedata.GameData;
import gameservice.GameService;
import ui_game.FrameGame;
import ui_game.PanelGame;
import ui_start.FrameSelectMission;
import ui_start.FrameStartGame;
import ui_start.PanelSelectMission;
import ui_start.PanelStartGame;
/**
 * ��Ϸ�����������ڽ���PlayerControl�������Ϣ��������Ϣ����GameService����ˢ��JPanelGame��
 * @author �����
 * 2015.4.13.
 */
public class GameControl {
	/**
	 * ��Ϸ������
	 */
	private PlayerControl playerControl;
	/**
	 * ��ʼ����
	 */
	private FrameStartGame frameStartGame;
	/**
	 * ѡ�ؽ���
	 */
	private FrameSelectMission frameSelectMission;
	/**
	 * ��Ϸ����
	 */
	private FrameGame frameGame;
	/**
	 * ��ʼ�����
	 */
	private PanelStartGame panelStartGame;
	/**
	 * ѡ�ؽ����
	 */
	private PanelSelectMission panelSelectMission;
	/**
	 * ��Ϸ�����
	 */
	private PanelGame panelGame;
	/**
	 * ��Ϸ�߼���
	 */
	private GameService gameService;
	/**
	 * ��Ϸ���ݲ�
	 */
	private GameData gameData;
	
	public GameControl(GameService gameService, GameData gameData){		
		this.gameService=gameService;
		this.gameData =gameData;
	}

	/**
	 * ������ҿ�����
	 * @param playerControl
	 */
	public void addControl(PlayerControl playerControl) {
		this.playerControl = playerControl;
	}	
	/**
	 * ����Ϸ�������м������н���
	 * @param frameStartGame
	 * @param frameSelectMission
	 * @param frameGame
	 */
	public void gameStart(FrameStartGame frameStartGame) {
		this.frameStartGame = frameStartGame;
		this.frameStartGame.setVisible(true);
		this.panelStartGame = this.frameStartGame.panelStartGame;
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
		this.panelStartGame.removeAll();
		this.frameStartGame.dispose();
		this.frameStartGame.pack();
		this.frameSelectMission = new FrameSelectMission(playerControl, gameData);
		this.frameSelectMission.setVisible(true);
		this.panelSelectMission = this.frameSelectMission.panelSelectMission;
	}
	/**
	 * ��ѡ�ؽ�����ת����һ����Ϸ����
	 */
	public void toFirstLevel() {
		this.panelSelectMission.removeAll();
		this.frameSelectMission.dispose();
		this.frameSelectMission.pack();
		this.frameGame = new FrameGame(playerControl, gameData);
		frameGame.setVisible(true);
		this.panelGame = this.frameGame.panelGame;
	}
	/**
	 * ��ͨ�ؽ��淵����ѡ�ؽ���
	 */
	public void returnFromWin() {
		this.panelGame.removeAll();
		this.frameGame.dispose();
		this.frameGame.pack();
		this.frameSelectMission = new FrameSelectMission(playerControl, gameData);
		this.frameSelectMission.setVisible(true);
		this.panelSelectMission = this.frameSelectMission.panelSelectMission;
	}
	
}
