package gameservice;

import gamedata.GameData;
import gamedata.TotalData;
/**
 * TODO
 * ��Ϸ�߼�����������������GameControl���źţ�ͬʱ������GameData������
 * @author �����
 *2015.4.14.
 */
public class GameService {
	//��Ϸ������
	TotalData totalData;
	//������Ϸ����
	GameData gameData;
	
	public GameService(TotalData totalData) {
		this.totalData = totalData;
	}

	public void refreshGameData(GameData gameData){
		this.gameData = gameData;
	}

	public void launchLight(int lightX,int lightY) {
		//TODO ��������  ��ʼX���꣬��ʼY���꣬��������X���꣬��������Y����
		this.gameData.getLightControl().launchLight(lightX, lightY, 10, 7);
	}


}
