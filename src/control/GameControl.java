package control;

import gameservice.GameService;
import ui_game.JPanelGame;
/**
 * ��Ϸ�����������ڽ���PlayerControl�������Ϣ��������Ϣ����GameService����ˢ��JPanelGame��
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

	public void launchLight(int lightX,int lightY) {
		this.gameService.launchLight(lightX,lightY);
		this.panelGame.repaint();
	}
}
