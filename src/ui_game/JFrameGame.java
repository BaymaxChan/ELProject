package ui_game;

import gamecomponent.PlanetEarth;
import gamecomponent.PlanetSun;
import gamecomponent.PlanetThreeBody;
import ui.JFrameTotal;
/**
 * ��Ϸ������
 * @author �����
 * 2015.4.8.
 */

public class JFrameGame extends JFrameTotal{

	
	public JFrameGame(JPanelGame panelGame){
		super();
		//������Ϸ�������
		this.setContentPane(panelGame);
		//
		panelGame.add(new PlanetEarth(90,340,150));
		panelGame.add(new PlanetSun(320,440,200),null);
		panelGame.add(new PlanetThreeBody(800,-300,200));
		
	}

}
