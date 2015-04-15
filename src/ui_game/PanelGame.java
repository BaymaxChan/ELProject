package ui_game;


import gamecomponent.Light;
import gamecomponent.LightControl;
import gamedata.GameData;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import control.PlayerControl;
/**
 * ��Ϸ����࣬���Ҵ���GameData�����ݺ�����PlayerControl������ϵĲ������м����������߳�
 * @author �����
 * 2015.4.15.
 */

public class PanelGame extends JPanel implements Runnable{
	PlayerControl playerControl;
	
	private GameData gameData;
	private LightControl lightControl;
	private JButton testButton;
	
	public PanelGame(GameData gameData){
		this.gameData = gameData;
		
	}

	/**
	 * ������ҿ������������������м���
	 * @param playerControl
	 */
	public void addControl(PlayerControl playerControl){
		this.playerControl = playerControl;
	}
	
	//===================����=====================
	public void Test(){
        testButton = new JButton("���Թ���");
		
		testButton.addActionListener(playerControl);
		testButton.setActionCommand("launchLight");
		
		this.add(testButton);
	}
	public void run() {
		try {
			Thread.sleep(50);
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.repaint();
	}
	
	/**
	 * �滭��Ϸ���ĸ������
	 */
	public void paintComponent(Graphics g){
		//�滭�������������еĹ���
		ArrayList<Light> lightList = this.gameData.getLightControl().getLightList();
		for (int i = 0; i < lightList.size(); i++) {
			lightList.get(i).paint(g);
		}
		
	}
}
