/**
 * ��ʼ����İ�ť��壬Ӧ�ð�����ʼ��Ϸ���������˳���Ϸ�������İ�ť��������ť��
 * ������ť��ûд��������Ҳûд��yeah��
 */
package ui_start;
import javax.swing.*;
/**
 * @author DorA
 *
 * 2015��4��8������11:51:29
 */
public class PanelStartGame extends JPanel{
	private ImageIcon defaultIcon=new ImageIcon("image/button/img1.jpg");
	private ImageIcon rollIcon=new ImageIcon("image/button/img2.jpg");
	
	public PanelStartGame(){
		setLayout(null);
	//���һ����ʼ��Ϸ��ť
		JButton jbtStart=new JButton(defaultIcon);
		jbtStart.setBounds(600,400,100,100);
		jbtStart.setPressedIcon(rollIcon);
		jbtStart.setRolloverIcon(rollIcon);
		add(jbtStart);
		//���º�ʼ��Ϸ
		
	//���һ������&��ʾ��ť
		JButton jbtHelp=new JButton(defaultIcon);
		jbtHelp.setBounds(750,350,100,100);
		jbtHelp.setPressedIcon(rollIcon);
		jbtHelp.setRolloverIcon(rollIcon);
		add(jbtHelp);
		//�˴�Ӧ�м�����
		
	//���һ���˳���Ϸ��ť
		JButton jbtQuit=new JButton(defaultIcon);
		jbtQuit.setBounds(900,280,100,100);
		jbtQuit.setPressedIcon(rollIcon);
		jbtQuit.setRolloverIcon(rollIcon);
		this.add(jbtQuit);
		//�˴�Ӧ�м�����
	
	
	}
	
	
}
