package main;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import control.GameControl;
import control.PlayerControl;
import ui.FrameTotal;
import ui_game.PanelGame;
/**
 * ��Ϸ���
 * @author �����
 * 2015.4.15.
 */
public class Main {
	public static void main(String[] args) {
		//��Ϸ������
		GameControl gameControl = new GameControl();
		
		FrameTotal frameTotal = new FrameTotal(gameControl);
		
		if(SystemTray.isSupported()){
			SystemTray tray=SystemTray.getSystemTray();
			Image image=PanelGame.getImage(new ImageIcon("image/bg/���汳��.png"), 20, 20);
			TrayIcon trayIcon=new TrayIcon(image,"ϵͳ��Ϣ");
			try {
				tray.add(trayIcon);
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}
	}
}