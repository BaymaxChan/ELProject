package gameservice;

import gamecomponent.LightControl;
/**
 * TODO
 * ��Ϸ�߼�����������������GameControl���źţ�ͬʱ��������߿�������JPanelGame������
 * @author �����
 *2015.4.14.
 */
public class GameService {
	LightControl lightControl;

	public void launchLight() {
		//TODO ��ʼ�����߿�����
		lightControl = new LightControl();
		//TODO ��������
		lightControl.launchLight(0, 0, 1, 1);
	}


}
