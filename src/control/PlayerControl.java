package control;

import gamecomponent.PlanetEarth;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
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
		String code = e.getActionCommand();
		if(code.equalsIgnoreCase("earth")){
			this.gameControl.launchLight(PlanetEarth.lightX,PlanetEarth.lightY);
//			System.out.println(PlanetEarth.lightX+" "+PlanetEarth.lightY);
		}
		else if(code.equalsIgnoreCase("sun")){
			
		}
		else if(code.equalsIgnoreCase("threeBody")){
			
		}
	}

}
