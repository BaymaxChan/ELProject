package ui;

import java.awt.Graphics;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.sun.awt.*;


public class IrregularFormSample extends JFrame {
    private static final long serialVersionUID = 1L;
    private Point origin; // �����ƶ�����
    private BufferedImage img; // �����趨���岻������ʽ��ͼƬ
    int[] pix=new int[3];

    public IrregularFormSample() throws Exception {
        super();
        /*
         * ���ȳ�ʼ��һ��ͼƬ�����ǿ���ѡ��һ����͸�����ֵĲ�����ͼƬ (��Ȼ����Ҫѡ��֧��Alpha(͸��)���ͼƬ��ʽ����PNG)������
         * ͼƬ������������������״��ͬ�Ĳ�������
         */
        MediaTracker mt = new MediaTracker(this);
//      img = new ImageIcon("image/����1.png").getImage();
        File file=new File("image/����/����4.png");
        img=ImageIO.read(file);

        mt.addImage(img, 0);
        try {
            mt.waitForAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            initialize();// �����ʼ��
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Thread t=new Thread();
//        t.start();
    }

    /**
     * �����ʼ��
     */
    private void initialize() throws IOException {
        // �趨�����С��ͼƬһ����
        this.setSize(img.getWidth(null), img.getHeight(null));
        // �趨���ô���װ�Σ�������ȡ����Ĭ�ϵĴ���ṹ
        this.setUndecorated(true);
        // ���øô����������������ڵ����Ϸ�
        this.setAlwaysOnTop(true);
        // ��ʼ�������ƶ������ԭ��
        this.origin = new Point();

        // ����AWTUtilities��setWindowShape�����趨������Ϊ�ƶ���Shape��״
        extracted();
        // �趨����ɼ���
        extracted1();

        this.setLocationRelativeTo(null);

        // ����ȡ����Ĭ�ϵĴ���ṹ����������Ҫ�ֶ�����һ���ƶ�����ķ���
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                origin.x = e.getX();
                origin.y = e.getY();
            }

            // �����ϵ�������Ҽ��رճ���
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3)
                    System.exit(0);
            }

            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point p = getLocation();
                setLocation(p.x + e.getX() - origin.x, p.y + e.getY()
                        - origin.y);
            }
        });
    }

	private void extracted() {
		AWTUtilities.setWindowOpacity(this, 1.0f);
	}

	private void extracted1() {
		AWTUtilities.setWindowShape(this, getImageShape(img));
	}

    /**
     * ��Imageͼ��ת��ΪShapeͼ��
     */
    public Shape getImageShape(BufferedImage img) {
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();
        int width = img.getWidth(null);// ͼ����
        int height = img.getHeight(null);// ͼ��߶�

        // ɸѡ����
        // ���Ȼ�ȡͼ�����е�������Ϣ
        PixelGrabber pgr = new PixelGrabber(img, 0, 0, -1, -1, true);
        try {
            pgr.grabPixels();
        } catch (InterruptedException ex) {
            ex.getStackTrace();
        }
        int pixels[] = (int[]) pgr.getPixels();

        // ѭ������
        for (int i = 0; i < pixels.length; i++) {
            // ɸѡ������͸�������ص�������뵽����ArrayList x��y��
            int alpha = getAlpha(pixels[i]);
            int rgb=img.getRGB(i%width,i/width);
//            pix[0]=(rgb&0xff0000)>>16;
//        	pix[1]=(rgb&0xff00)>>8;
//        	pix[2]=(rgb&0xff);
            
//            int rgb=
//            System.out.println(rgb);
            if ((alpha != 0)/*&&(pix[0]>200)&&(pix[1]>200)&&(pix[2]>200)*/) {
                x.add(i % width > 0 ? i % width - 1 : 0);
                y.add(i % width == 0 ? (i == 0 ? 0 : i / width - 1) : i / width);
            }
        }
        // ����ͼ�����(0Ϊ͸��,1Ϊ��͸��)
        int[][] matrix = new int[height][width];
        // ��������ArrayList�еĲ�͸��������Ϣ
        for (int c = 0; c < x.size(); c++) {
            matrix[y.get(c)][x.get(c)] = 1;
        }
        /*
         * ����Area������ʾ������Խ��кϲ���������һˮƽ"ɨ��"ͼ������ÿһ�У�
         * ����͸������������ΪRectangle���ٽ�ÿһ�е�Rectangleͨ��Area���rec
         * ������кϲ�������γ�һ��������Shapeͼ��
         */
        Area rec = new Area();
        int temp = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 1) {
                    if (temp == 0)
                        temp = j;
                    else if (j == width) {
                        if (temp == 0) {
                            Rectangle rectemp = new Rectangle(j, i, 1, 1);
                            rec.add(new Area(rectemp));
                        } else {
                            Rectangle rectemp = new Rectangle(temp, i,
                                    j - temp, 1);
                            rec.add(new Area(rectemp));
                            temp = 0;
                        }
                    }
                } else {
                    if (temp != 0) {
                        Rectangle rectemp = new Rectangle(temp, i, j - temp, 1);
                        rec.add(new Area(rectemp));
                        temp = 0;
                    }
                }
            }
            temp = 0;
        }
        return rec;
    }

    /**
     * ��ȡ���ص�Alphaֵ
     */
    private int getAlpha(int pixel) {
        return (pixel >> 24) & 0xff;
    }

    /*
     * ���ǿ���ѡ���ڴ����ϻ���ͼƬ���Ǵ�����ȫ���ֳ�ͼƬ����ʽ�� ��Ȼ����Ҳ���Ը�����Ҫ��������������ȡ��������
     */
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(img, 0, 0, null);
    }

    public static void main(String[] args) throws Exception {
        IrregularFormSample sample = new IrregularFormSample();
        sample.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sample.setVisible(true);
    }

//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		while(true){
//			try{
//				Thread.sleep(50);
//			}
//			catch(Exception e){}
//			this.repaint();
//		}
//	}
}
