package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * ��ҵ����ť�ź�������ҿ���̨��������GameControl��
 * @author �����
 * 2015.4.13.
 */

public class PlayerControl implements ActionListener{
	private GameControl gameControl;
	
	public PlayerControl(GameControl gameControl){
		this.gameControl = gameControl;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("PlayerControl");
		String code = e.getActionCommand();
		if(code.equals("launchLight")){
			this.gameControl.launchLight();
		}
	}

}
