package gamedata;

import gamecomponent.LightControl;

/**
 * ��Ϸ�����࣬��ź���Ϸ�����йص���Ϣ�����Դ���GameService��JPanelGame��
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
