package omnirobcontroller;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import omnirobcontroller.Rule;

public class application {

	private JFrame frame;
	private JTextField restURIInput;
	private JTextField authTokenInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					application window = new application();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 690, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOmnirobcontrollerApp = new JLabel("OmniRob-Controller App");
		lblOmnirobcontrollerApp.setBounds(262, 6, 169, 16);
		frame.getContentPane().add(lblOmnirobcontrollerApp);
		
		JLabel lblRestApiUri = new JLabel("REST API URI");
		lblRestApiUri.setBounds(29, 43, 117, 16);
		frame.getContentPane().add(lblRestApiUri);
		
		JLabel lblToken = new JLabel("Auth Token");
		lblToken.setBounds(29, 71, 90, 16);
		frame.getContentPane().add(lblToken);
		
		restURIInput = new JTextField();
		restURIInput.setText("http://austria.omilab.org/omirob/dobot1/rest");
		restURIInput.setBounds(129, 38, 385, 26);
		frame.getContentPane().add(restURIInput);
		restURIInput.setColumns(10);
		
		authTokenInput = new JTextField();
		authTokenInput.setText("6RKOOt1WVvoDfQ==");
		authTokenInput.setColumns(10);
		authTokenInput.setBounds(129, 66, 385, 26);
		frame.getContentPane().add(authTokenInput);

		final JLabel lblInfoText = new JLabel("Please enter your Auth Token an select a drink to initiate to robot arm.");
		lblInfoText.setForeground(Color.RED);
		lblInfoText.setBounds(29, 278, 633, 16);
		frame.getContentPane().add(lblInfoText);
		
		JButton btnEspresso = new JButton("Make an Espresso");
		btnEspresso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Rule drink = new Rule();
				String resp = drink.applyRule("espresso", restURIInput.getText(), authTokenInput.getText());
				System.out.print(resp);
				lblInfoText.setText("Response: "+resp);
			}
		});
		btnEspresso.setBounds(29, 121, 195, 133);
		frame.getContentPane().add(btnEspresso);
		
		JButton btnSoyCappuccino = new JButton("Make a Soy-Cappuccino");
		btnSoyCappuccino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Rule drink = new Rule();
				String resp = drink.applyRule("soyCappuccino", restURIInput.getText(), authTokenInput.getText());
				System.out.print(resp);
				lblInfoText.setText("Response: "+resp);	
			}
		});
		btnSoyCappuccino.setBounds(249, 121, 195, 133);
		frame.getContentPane().add(btnSoyCappuccino);
		
		JButton btnTea = new JButton("Make a Tea");
		btnTea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Rule drink = new Rule();
				String resp = drink.applyRule("tea", restURIInput.getText(), authTokenInput.getText());
				System.out.print(resp);
				lblInfoText.setText("Response: "+resp);	
			}
		});
		btnTea.setBounds(467, 121, 195, 133);
		frame.getContentPane().add(btnTea);
		
		JButton btnResetArm = new JButton("Reset Arm");
		btnResetArm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Rule reset = new Rule();
				String resp = reset.applyRule("reset", restURIInput.getText(), authTokenInput.getText());
				System.out.print(resp);
				lblInfoText.setText("Response: "+resp);
			}
		});
		btnResetArm.setForeground(Color.BLUE);
		btnResetArm.setBounds(531, 38, 127, 54);
		frame.getContentPane().add(btnResetArm);
		
	}
}
