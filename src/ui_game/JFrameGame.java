package ui_game;

import java.awt.Graphics;

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
//		this.setUndecorated(true);
		super();
		
		//������Ϸ�������
		this.setContentPane(panelGame);
		//
//		panelGame.add(new PlanetEarth(90,600,50));
//		panelGame.add(new PlanetSun(320,440,100),null);
//		panelGame.add(new PlanetThreeBody(800,30,75));
//		this.setVisible(true);
		
	}
	
	
}
