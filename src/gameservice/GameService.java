package gameservice;

import gamecomponent.LightControl;
import gamedata.GameData;
/**
 * TODO
 * ��Ϸ�߼�����������������GameControl���źţ�ͬʱ������GameData������
 * @author �����
 *2015.4.14.
 */
public class GameService {
	GameData gameData;
	
	public GameService(GameData gameData){
		this.gameData = gameData;
	}

	public void launchLight() {
		//TODO ��������  ��ʼX���꣬��ʼY���꣬��������X���꣬��������Y����
		this.gameData.getLightControl().launchLight(0, 100, 10, 7);
	}


}
