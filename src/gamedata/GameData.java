package gamedata;

import gamecomponent.LightControl;

/**
 * ������Ϸ���ݣ�������Ϸ�������Ϸ����������
 * @author �����
 * 2015.4.15.
 */
public class GameData {
	private LightControl lightControl;
	
	public GameData(){
		lightControl = new LightControl();
	}

	public LightControl getLightControl() {
		return lightControl;
	}
}
