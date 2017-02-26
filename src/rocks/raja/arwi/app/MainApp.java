package rocks.raja.arwi.app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rocks.raja.api.Debug;
import rocks.raja.arwi.command.CommandRegistry;
import rocks.raja.arwi.command.CreateCreatureCommand;
import rocks.raja.arwi.command.EditCreatureCommand;
import rocks.raja.arwi.command.StopCommand;
import rocks.raja.arwi.command.TestCommand;

import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class MainApp extends JFrame implements ActionListener {

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	
	public Debug DEBUG;
	
	public ARWI arwi = new ARWI(this);
	private JScrollPane scrollPane;
	private JTextPane textPane;
	
	private Timer timer = new Timer(500, this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp frame = new MainApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainApp() {
		preInit();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		init();
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arwi.proccessCommand(textField.getText());
				textField.setText("");
			}
		});
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		
		DEBUG = new Debug(textPane);
		
		arwi.init();
		
		postInit();
	}
	
	/**
	 * Anything related with registries can go here.
	 */
	
	public void preInit() {
		CommandRegistry.register(new TestCommand());
		CommandRegistry.register(new StopCommand());
		CommandRegistry.register(new CreateCreatureCommand());
		CommandRegistry.register(new EditCreatureCommand());
	}
	
	/**
	 * Usually used for making the app look nice.
	 */
	
	public void init() {
		timer.start();
	}
	
	/**
	 * Only logging can be done in {@code postInit()}. This is because the {@code DEBUG} variable is created before this is called.
	 */
	
	public void postInit() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		arwi.update();
	}

}
