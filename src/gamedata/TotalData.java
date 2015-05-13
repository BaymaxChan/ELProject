package gamedata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * ��Ϸ�����ݳɼ��洢��,���ؿ������������Ϣ
 */
public class TotalData {
	/**
	 * ÿ���ؿ�����
	 * ��Ϊ0����ʾδͨ��
	 * ��Ϊ1�����D�ȼ�
	 * ��Ϊ2�����C�ȼ�
	 * ��Ϊ3�����B�ȼ�
	 * ��Ϊ4�����A�ȼ�
	 * ��Ϊ5�����S�ȼ�
	 */
	private int[] grade;
	//������߹ؿ��ȼ�
	private int level;
	//��Ļ�ֱ���
	private int resolution;
	//���������ļ�
	private File baseData;
	//�ļ��йؿ�����ǰ׺
	private String frontGrade;
	//�ļ�����߽����ؿ�ǰ׺
	private String frontLevel;
	//�ļ�����Ļ�ֱ���ǰ׺
	private String frontResolution;
	
	public TotalData(){
		this.loadData();
	}
	/**
	 * ��Ϸͨ��һ�غ�����һ��
	 */
	public void levelUp(){
		this.level ++;
	}
	
	/**
	 * Ϊÿ���ؿ���������
	 * @param level ��Ҫ���������Ĺؿ�
	 * @param nowGrade �ùؿ���õ�����
	 */
	public void setGrade(int level, int nowGrade){
		this.grade[level - 1] = nowGrade;
	}
	public int getGrade(int level) {
		return grade[level - 1];
	}

	public int getLevel() {
		return level;
	}
		
	public int getResolution() {
		return resolution;
	}
	public void setResolution(int resolution) {
		this.resolution = resolution;
	}
	
	/**
	 * ��ȡ�ļ������ݲ���ֵ
	 */
	private void loadData(){
		String line = new String();
		
		baseData = new File("data/BaseData");
		try {
			BufferedReader br = new BufferedReader(new FileReader(baseData));
			
			//Ϊ���йؿ��������з���
			this.grade = new int[5];
			for (int i = 0; i < grade.length; i++) {
				line = br.readLine();
				this.frontGrade = line.split(":")[0]+":";
				grade[i] = Integer.parseInt(line.split(":")[1]);
			}
			
			//Ϊ�����ؿ���ߵȼ���ֵ
			line = br.readLine();
			this.frontLevel = line.split(":")[0]+":";
			this.level = Integer.parseInt(line.split(":")[1]);
			
			//Ϊ�����ؿ���ߵȼ���ֵ
			line = br.readLine();
			this.frontResolution = line.split(":")[0]+":";
			this.resolution = Integer.parseInt(line.split(":")[1]);
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �ر���Ϸʱ��������
	 */
	public void saveData() {
		String line;
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(baseData));
			
			for (int i = 0; i < grade.length; i++) {
				line = this.frontGrade + Integer.toString(grade[i]) + "\n";
				bw.write(line);
			}
			
			line = this.frontLevel + Integer.toString(level) + "\n";
			bw.write(line);
			
			line = this.frontResolution + Integer.toString(resolution) + "\n";
			bw.write(line);
			
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}