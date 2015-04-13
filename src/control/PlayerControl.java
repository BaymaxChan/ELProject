package control;

import gamecomponent.LightControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * ��ҵ����ť�ź�������ҿ���̨����ҿ���̨������Ϸ����̨��
 * @author �����
 * 2015.4.13.
 */

public class PlayerControl implements ActionListener{
	private GameControl gameControl;
	
	public PlayerControl(GameControl gameControl){
		this.gameControl = gameControl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String code = e.getActionCommand();
		if(code.equals("launchLight")){
			this.gameControl.launchLight();
		}
	}

}
