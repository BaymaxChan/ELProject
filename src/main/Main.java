package main;

import gamedata.GameData;
import gameservice.GameService;
import ui_game.FrameGame;
import ui_game.PanelGame;
import ui_start.FrameSelectMission;
import ui_start.FrameStartGame;
import ui_start.PanelSelectMission;
import ui_start.PanelStartGame;
import control.GameControl;
import control.PlayerControl;
/**
 * ���ṹ��������
 * @author �����
 * 2015.4.15.
 */

public class Main {

	public static void main(String[] args) {
	//��Ϸ������
	GameData gameData = new GameData();
	//��Ϸ�߼���
	GameService gameService = new GameService(gameData);
	//��Ϸ������
	GameControl gameControl = new GameControl(gameService, gameData);
	//��ҿ�����
	PlayerControl playerControl = new PlayerControl(gameControl);
	//����Ϸ��������������ҿ�����
	gameControl.addControl(playerControl);

	FrameStartGame frameStartGame = new FrameStartGame(playerControl, gameData);
	gameControl.gameStart(frameStartGame);
	}
}
