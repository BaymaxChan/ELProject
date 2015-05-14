package gamecomponent;

public class WormHole extends Planet{
	private static final long serialVersionUID = 1L;
	public WormHole(int x,int y,int Radius){
		//����Ĳ�������
		this.locationX=x;
		this.locationY=y;
		this.radius=Radius;
		//���찴ť��ͼƬ���Զ�����
		this.planetImg=getImageIcon("image/����/����4.png", 2*radius,2*radius);
		this.setIcon(planetImg);
		//��ť��λ��
		this.setBounds(locationX, locationY, 2*radius, 2*radius);
		//���ò���ӡ���ε�����
		this.setContentAreaFilled(false);
		//���ò���ӡ�߿�
		this.setBorderPainted(false);
		//���ÿɼ�
		this.setVisible(true);
	}
}
