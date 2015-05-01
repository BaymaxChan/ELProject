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
			this.gameControl.launchLight();
		}else if(code.equalsIgnoreCase("sun")){
			
		}else if(code.equalsIgnoreCase("threeBody")){
			
		}else if(code.equalsIgnoreCase("ReturnFromWin")){
			this.gameControl.returnFromWin();
		}else if(code.equalsIgnoreCase("ToSelectMission")){
			this.gameControl.toSelectMission();
		}else if(code.equalsIgnoreCase("ToFirstLevel")){		
			this.gameControl.toFirstLevel();
		}else if(code.equalsIgnoreCase("ReturnToStart")){
			this.gameControl.returnToStart();
		}else if(code.equalsIgnoreCase("OpenPanelHelp")){
			this.gameControl.openPanelHelp();
		}
	}
}
