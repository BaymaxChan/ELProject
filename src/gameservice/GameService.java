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

	public void launchLight(int lightX,int lightY) {
		//TODO ��������  ��ʼX���꣬��ʼY���꣬��������X���꣬��������Y����
		this.gameData.getLightControl().launchLight(lightX, lightY, 10, 7);
	}


}
