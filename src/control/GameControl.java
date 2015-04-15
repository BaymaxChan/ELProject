package control;

import gameservice.GameService;
import ui_game.PanelGame;
/**
 * ��Ϸ�����������ڽ���PlayerControl�������Ϣ��������Ϣ����GameService����ˢ��JPanelGame��
 * @author �����
 * 2015.4.13.
 */
public class GameControl {
	/**
	 * ��Ϸ�����
	 */
	private PanelGame panelGame;
	/**
	 * ��Ϸ�߼���
	 */
	private GameService gameService;
	
	public GameControl(PanelGame panelGame,GameService gameService){
		this.panelGame=panelGame;
		this.gameService=gameService;
	}

	public void launchLight() {
		System.out.println("GameControl");
		this.gameService.launchLight();
		this.panelGame.repaint();
	}
}
