package gamedata;
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
	//��Ϸ�ؿ��ȼ�
	private int level;
	
	public TotalData(){
		this.grade = new int[5];
		for (int i = 0; i < grade.length; i++) {
			grade[i] = 0;
		}
		
		this.level = 1;
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
	public int[] getGrade() {
		return grade;
	}

	public int getLevel() {
		return level;
	}
}