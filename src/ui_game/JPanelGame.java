package ui_game;

import gamecomponent.PlanetEarth;
import gamecomponent.PlanetSun;
import gamecomponent.PlanetThreeBody;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;


public class JPanelGame extends JPanel{
	public JPanelGame(){
	}
	
	//����paintComponent���������Ʊ���ͼ
	/**
	 * @author CX
	 */
	@Override
	public void paintComponent(Graphics g){
		
		int height=768;
		int width=1024;
		/*
		 * ����Ĵ��볬���ƣ������⻹��ֱ�����Һ��ˣ�by CX
		 * ������������ʲô�ֱ��ʵ������ͼƬ�����Զ��ķŴ���С������Ӧ��ͬ��ϵͳ
		 * ���һ�ǣ��������Ĵ���
		 * */
		ImageIcon backgroundDemo=new ImageIcon("image/bg/����.jpg");
		Image background=backgroundDemo.getImage();
		background=background.getScaledInstance(width, height, Image.SCALE_SMOOTH);//����ͼƬ�ĺ��ķ���
		backgroundDemo.setImage(background);
		background=backgroundDemo.getImage();
		g.drawImage(background, 0, 0, null);
		this.repaint();
	}
	

}
