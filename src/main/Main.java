package main;

import java.awt.Panel;

import gamedata.GameData;
import gameservice.GameService;
import ui_game.JFrameGame;
import ui_game.JPanelGame;
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
	//��Ϸ���
	JPanelGame panelGame = new JPanelGame(gameData);
	//��Ϸ������
	GameControl gameControl = new GameControl(panelGame, gameService);
	//��ҿ�����
	PlayerControl playerControl = new PlayerControl(gameControl);
	//������м�����ҿ�������������м���
	panelGame.addControl(playerControl);
	//�԰�ť���м���(���Է���)
	panelGame.Test();

	JFrameGame frameGame = new JFrameGame(panelGame);
	}

}
