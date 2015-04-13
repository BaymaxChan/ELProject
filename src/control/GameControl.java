package control;

import gameservice.GameService;
import ui_game.JPanelGame;
/**
 * ��Ϸ�����������ڽ�����ҿ������������Ϣ��������Ϣ������Ϸ�߼�����(gameService)����ˢ�½���
 * @author �����
 * 2015.4.13.
 */
public class GameControl {
	/**
	 * ��Ϸ�����
	 */
	private JPanelGame panelGame;
	/**
	 * ��Ϸ�߼���
	 */
	private GameService gameService;
	
	public GameControl(JPanelGame panelGame,GameService gameService){
		this.panelGame=panelGame;
		this.gameService=gameService;
	}

	public void launchLight() {
		this.gameService.launchLight();
		this.panelGame.repaint();
	}
}
