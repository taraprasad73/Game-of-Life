import java.awt.CardLayout;

import javax.swing.JApplet;

/**
 * Applet for Game of Life Is composed of two objects - 1) simulation :
 * Simulation -> JComponent 2) gameOptionsPanel : StartPanel -> JPanel Uses Card
 * Layout to switch between them.
 * 
 * @author TaraPrasad
 */

public class Game extends JApplet {
	private CardLayout cardLayout;
	private Simulation simulationPanel;
	private StartPanel startPanel;
	private RulesPanel rulesPanel;
	private AboutPanel aboutPanel;
//	private GroupInfoPanel groupInfoPanel;
	public static int WIDTH = 1290;
	public static int HEIGHT = 640;

	@Override
	public void init() {
		super.init();
		simulationPanel = new Simulation(this);
		startPanel = new StartPanel();
		rulesPanel = new RulesPanel(this);
		aboutPanel = new AboutPanel(this);
		
//		groupInfoPanel = new GroupInfoPanel(this);
		setSize(WIDTH, HEIGHT);
		// Using Card Layout to switch between panels
		cardLayout = new CardLayout();
		getContentPane().setLayout(cardLayout);
		getContentPane().add(startPanel, "start");
		getContentPane().add(simulationPanel, "simulation");
		getContentPane().add(rulesPanel, "rules");
		getContentPane().add(aboutPanel, "about");
//		getContentPane().add(groupInfoPanel, "group");
		startPanel.setStartPanelListener(new StartPanelListener() {
			@Override
			public void enterButtonClicked() {
				cardLayout.show(Game.this.getContentPane(), "simulation");
			}

			@Override
			public void exitButtonClicked() {
				System.exit(0);
			}

			@Override
			public void rulesButtonClicked() {
				cardLayout.show(Game.this.getContentPane(), "rules");
			}

			@Override
			public void aboutButtonClicked() {
				cardLayout.show(Game.this.getContentPane(), "about");
			}

			@Override
			public void groupInfoButtonClicked() {
				cardLayout.show(Game.this.getContentPane(), "group");
			}
		});
	}

	@Override
	public void start() {
		super.start();
	}

	@Override
	public void stop() {
		super.stop();
	}

	public void backButtonFromChild() {
		cardLayout.show(Game.this.getContentPane(), "start");
	}
}