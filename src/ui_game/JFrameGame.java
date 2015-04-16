package ui_game;

import gamecomponent.PlanetEarth;
import gamecomponent.PlanetSun;
import gamecomponent.PlanetThreeBody;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import ui.JFrameTotal;
/**
 * ��Ϸ������
 * @author �����
 * 2015.4.8.
 */

public class JFrameGame extends JFrameTotal{

	
	public JFrameGame(PanelGame panelGame){
		super();
		//������Ϸ�������

		this.setContentPane(panelGame);
		
		panelGame.add(new PlanetEarth(90,340,150),null);
		panelGame.add(new PlanetSun(320,440,200),null);
		panelGame.add(new PlanetThreeBody(800,-300,200));
		

		
	}

}
