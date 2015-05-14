package control;

import audio.SoundEffect;
import gamecomponent.PlanetEarth;
import gamedata.GameData;
import gamedata.TotalData;
import ui.FrameTotal;
import ui_game.PanelGame;
import ui_start.PanelSelectMission;
import ui_start.PanelStartGame;
/**
 * ��Ϸ�����������ڽ���PlayerControl�������Ϣ����ˢ��JPanelGame��
 * @author �����
 * 2015.4.13.
 */
public class GameControl {
	/**
	 * ��Ϸ����
	 */
	private FrameTotal frameTotal;
	/**
	 * ��ʼ�����
	 */
	private PanelStartGame panelStartGame;
	/**
	 * ѡ�ؽ����
	 */
	private PanelSelectMission panelSelectMission;
	/**
	 * ��Ϸ�����
	 */
	private PanelGame panelGame;
	/**
	 * ������Ϸ����
	 */
	private GameData gameData;
	
	public GameControl(){
	}
	
	/**
	 * ����Ϸ�������м������
	 * @param frameTotal
	 */
	public void addFrame(FrameTotal frameTotal) {
		this.frameTotal = frameTotal;	
	}
	
	public void setPanelStartGame(PanelStartGame panelStartGame) {
		this.panelStartGame = panelStartGame;
	}
	public void setPanelSelectMission(PanelSelectMission panelSelectMission) {
		this.panelSelectMission = panelSelectMission;
	}
	public void setPanelGame(PanelGame panelGame) {
		this.panelGame = panelGame;
	}
	
	//
	public void stopDrag(){
		this.panelGame.stopDrag();
	}
	
	/**
	 * �������
	 * @param launchX
	 * @param lightY
	 */
	public void launchLight() {
		if(this.panelGame!=null){
			this.gameData.getLightControl().launchLight(PlanetEarth.launchX, PlanetEarth.launchY, this.gameData.getLightDirectionX(), this.gameData.getLightDirectionY());
			this.panelGame.repaint();
			//��Ч
			SoundEffect.LIGHT.play();
		}	
	}
	//==========================�����Ǹ�����������ת����==============================
	/**
	 * �ӿ�ʼ������ת��ѡ�ؽ���
	 */
	public void toSelectMission() {
		this.frameTotal.musicStart.stop();
		this.frameTotal.remove(this.panelStartGame);
		this.panelStartGame = null;
		this.frameTotal.initPanelSelectMission();
	}
	
	/**
	 * ��ͨ�ؽ��淵����ѡ�ؽ���
	 */
	public void returnFromWin() {
		this.panelGame.closeFrameWin();
		this.frameTotal.remove(this.panelGame);
		this.panelGame = null;
		this.frameTotal.initPanelSelectMission();
	}
	
	/**
	 * ����Ϸ���淵��ѡ�ؽ���
	 */
	public void returnFromGame() {
		this.frameTotal.remove(this.panelGame);
		this.panelGame = null;
		this.frameTotal.initPanelSelectMission();
	}
	
	/**
	 * ��ѡ�ؽ��淵������ʼ����
	 */
	public void returnToStart() {
		this.frameTotal.remove(this.panelSelectMission);
		this.panelSelectMission = null;
		this.frameTotal.musicSelect.stop();
		this.frameTotal.initPanelStartGame();
	}
	
	/**
	 * �򿪰�������
	 */
	public void openFrameHelp(){
		this.panelStartGame.openFrameHelp();
	}
	
	/**
	 * �رհ�������
	 */
	public void closeFrameHelp() {
		this.panelStartGame.closeFrameHelp();	
	}

	/**
	 * ������һ��
	 */
	public void nextLevel() {
		//�ر�ͨ�ؽ���
		this.panelGame.closeFrameWin();
		
		//���½���������Ϸ����
		this.gameData = new GameData(this.gameData.getLevel() + 1);
		//�Ƴ�ԭ�е���Ϸ����
		this.frameTotal.remove(this.panelGame);
		this.panelGame = null;
		//��һ����Ϸ����
		this.frameTotal.initPanelGame(this.gameData);
	}
	
	/**
	 * �˳���Ϸ
	 */
	public void Quit() {
		FrameTotal.TOTALDATA.saveData();
		this.frameTotal.removeAll();
		this.frameTotal.dispose();
		System.exit(0);
	}

	/**
	 * ��ѡ�ؽ�����������Ϸ����
	 * @param level
	 */
	public void toGameLevel(int level) {
		this.gameData =new GameData(level);
		this.frameTotal.musicSelect.stop();
		this.frameTotal.remove(this.panelSelectMission);
		this.panelSelectMission = null;
		this.frameTotal.initPanelGame(this.gameData);
		
		this.panelGame.addControl(this);
	}
	
	/**
	 * �ı����ֱ���
	 * @param resolution �·ֱ���
	 */
	public void changeResolution(int resolution){
		if((FrameTotal.TOTALDATA.getResolution() != resolution)&&(this.panelStartGame != null)){
			FrameTotal.TOTALDATA.setResolution(resolution);
			FrameTotal.TOTALDATA.saveData();
			this.frameTotal.dispose();
			this.frameTotal = new FrameTotal(this);
		}
	}
}