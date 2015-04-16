
//package ui_game;
/**
 * ��������ΰ���ĸ��
 * ͼƬֻ���ȵ�ͼ��
 * @author CX
 *2015.4.13
 */
//=======
package gamecomponent;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class PlanetEarth extends Planet implements ActionListener{
	/**
	 * ���췽����������򣬲���������õļ�����
	 * @param x �����ˮƽ����
	 * @param y �������ֱ����
	 * @param Radius ����İ뾶
	 * @author CX
	 */
	public PlanetEarth(int x,int y,int Radius){
		//����Ĳ�������
		this.locationX=x;
		this.locationY=y;
		this.radius=Radius;
		//���찴ť��ͼƬ���Զ�����
		this.planetImg=this.getImageIcon("image/����/����2.png", 2*radius, (int)(2*radius*1.414));
		this.setIcon(planetImg);
		//��ť��λ��
		this.setBounds(locationX, locationY, 2*radius, (int)(2*radius*1.414));
		//�����������˱Ƚ�ϲ������
		this.addActionListener(this);
		//���ò����ƾ��ε�����
		this.setContentAreaFilled(false);
		//���ò����Ʊ߿�
		this.setBorderPainted(false);
		//���ÿɼ�
		this.setVisible(true);
	}

	
	@Override
	/**
	 * �¼�����������ʵ�����Ժ�Ҫ���������ࣻ���������һ��ʾ��
	 * @author CX
	 */
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JOptionPane.showConfirmDialog(null, "׼��������", "��������", JOptionPane.PLAIN_MESSAGE	);
		
	}
	
}
