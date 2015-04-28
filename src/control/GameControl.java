package control;

import gamecomponent.PlanetEarth;
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
	
	public GameControl(PanelStartGame panelStartGame, PanelSelectMission panelSelectMission, PanelGame panelGame,GameService gameService){
		this.panelGame=panelGame;
		this.panelStartGame = panelStartGame;
		this.panelSelectMission = panelSelectMission;
		this.gameService=gameService;
	}

	/**
	 * ����Ϸ�������м������н���
	 * @param frameStartGame
	 * @param frameSelectMission
	 * @param frameGame
	 */
	public void addFrames(FrameStartGame frameStartGame, FrameSelectMission frameSelectMission, FrameGame frameGame) {
		this.frameStartGame = frameStartGame;
		this.frameSelectMission = frameSelectMission;
		this.frameGame = frameGame;
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
		this.frameStartGame.setVisible(false);
		this.frameSelectMission.setVisible(true);
	}
	/**
	 * ��ѡ�ؽ�����ת����һ����Ϸ����
	 */
	public void toFirstLevel() {
		this.frameSelectMission.setVisible(false);
		this.frameGame.setVisible(true);
	}
	/**
	 * ��ͨ�ؽ��淵����ѡ�ؽ���
	 */
	public void returnFromWin() {
		this.frameSelectMission.setVisible(true);
		this.frameGame.setVisible(false);	
	}	
}
