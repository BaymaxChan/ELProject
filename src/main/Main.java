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
	//��ʼ���
	PanelStartGame panelStartGame = new PanelStartGame(gameData);
	//ѡ�����
	PanelSelectMission panelSelectMission = new PanelSelectMission(gameData);
	//��Ϸ���
	PanelGame panelGame = new PanelGame(gameData);
	//��Ϸ������
	GameControl gameControl = new GameControl(panelStartGame, panelSelectMission, panelGame, gameService);
	//��ҿ�����
	PlayerControl playerControl = new PlayerControl(gameControl);
	//������м�����ҿ�������������м���
	panelStartGame.addControl(playerControl);
	panelSelectMission.addControl(playerControl);
	panelGame.addControl(playerControl);
	//����������Ϸ���棬���к���������ʾ
	FrameStartGame frameStartGame = new FrameStartGame(panelStartGame);
	FrameSelectMission frameSelectMission = new FrameSelectMission(panelSelectMission);
    FrameGame frameGame = new FrameGame(panelGame);
    //��������Ϸ���������ҿ����������ڽ�����ת
    frameStartGame.addControl(playerControl);
    frameSelectMission.addControl(playerControl);
    frameGame.addControl(playerControl);
    
    gameControl.addFrames(frameStartGame, frameSelectMission, frameGame);
	}

}
