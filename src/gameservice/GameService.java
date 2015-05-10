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
	/**
	 * ���캯������ʼ������Ϸ����
	 */
	public GameService(TotalData totalData) {
		this.totalData = totalData;
	}
	
	/**
	 * ��һ�ֿ�ʼ��ˢ����Ϸ����
	 * @param gameData
	 */
	public void refreshGameData(GameData gameData){
		this.gameData = gameData;
	}
	
	/**
	 * �������
	 * @param lightX
	 * @param lightY
	 */
	public void launchLight(int lightX,int lightY) {
		//TODO ��������  ��ʼX���꣬��ʼY���꣬��������X���꣬��������Y����
		this.gameData.getLightControl().launchLight(300, 300, -10, 4);
	}
}