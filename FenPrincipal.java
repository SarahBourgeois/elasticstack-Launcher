package com.bourgeois;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/*
 * @author: Bourgeois Sarah
 */

public class WinPrincipal extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	// ==========================================
	// Declare windows and components
	// ==========================================

	// principal pan
	JPanel principalPan;

	// secondary pan
	JPanel fondMenu;
	JPanel fondPicture;
	JPanel fondBoutonElastic;
	JPanel fondConfigure;
	JPanel fondEmpty;

	// component pan
	JPanel panElastic;
	JPanel panKibana;
	JPanel panConfigure;
	JPanel panPicture;

	// Components
	JLabel photo;
	JLabel empty;
	JButton btn_connect_elastic;
	JButton btn_connect_kibana;
	JButton btn_configuration;
	JButton btn_createcluster;
	JButton btn_runkibana;

	// Jmenu
	JMenu men_file;
	JMenu men_log;
	JMenu men_about;

	// JMenuItem
	JMenuItem item_quit;
	JMenuItem item_openLog;
	JMenuItem item_helpConfigure;
	JMenuItem item_about;

	public WinPrincipal() throws HeadlessException {
		super();
		WinConfigure fc = new WinConfigure();
		Configuration conn = new Configuration();
		// ==========================================
		// create principal pan
		// ==========================================

		principalPan = new JPanel();
		principalPan.setLayout(new GridLayout(5, 3));

		// ============================
		// Menu
		// =================================
		// JmenuBar
		fondMenu = new JPanel();
		fondMenu.setLayout(new BorderLayout());
		// fondMenu.setBounds(10, 10, 10, 50);
		JMenuBar menuBar = new JMenuBar();

		// Jmenu file
		men_file = new JMenu("File");
		men_log = new JMenu("Elastic Log");
		men_about = new JMenu("Help");
		menuBar.add(men_file);
		menuBar.add(men_log);
		menuBar.add(men_about);

		// item quit
		item_quit = new JMenuItem("Quit");
		men_file.add(item_quit);

		// item open log
		item_openLog = new JMenuItem("Open elasticsearch log");
		men_log.add(item_openLog);

		// item help
		item_helpConfigure = new JMenuItem("help for configuration");
		men_about.add(item_helpConfigure);
		item_about = new JMenuItem("about the application");
		men_about.addSeparator();
		men_about.add(item_about);

		// ==========================================
		// first block : Picture
		// ==========================================
		fondPicture = new JPanel();
		fondPicture.setLayout(new GridLayout(1, 1));

		// picture
		BufferedImage picture = null;
		try {
			picture = ImageIO.read(new File("Ressources/nudge45.png"));
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		photo = new JLabel("");
		photo.setHorizontalAlignment(SwingConstants.CENTER);
		photo.setBounds(55, 224, 510, 850);
		photo.setIcon(new ImageIcon(picture));
		fondPicture.add(photo);

		// ==========================================
		// Second block : Elasticsearch and Kibana
		// ==========================================

		fondBoutonElastic = new JPanel();
		fondBoutonElastic.setLayout(new GridLayout(1, 2));

		// Elasticsearch
		panElastic = new JPanel();
		panElastic.setLayout(new GridLayout(2, 1));
		// Create cluster
		btn_createcluster = new JButton("create node elastic");
		panElastic.add(btn_createcluster);
		btn_createcluster.addActionListener(this);
		fondBoutonElastic.add(panElastic);
		// Open elastic
		btn_connect_elastic = new JButton("open elastic");
		panElastic.add(btn_connect_elastic);
		btn_connect_elastic.addActionListener(this);
		fondBoutonElastic.add(panElastic);

		// Kibana
		panKibana = new JPanel();
		panKibana.setLayout(new GridLayout(2, 1));
		// run kibana
		btn_runkibana = new JButton("launch kibana");
		panKibana.add(btn_runkibana);
		btn_runkibana.addActionListener(this);
		fondBoutonElastic.add(panKibana);
		// open Kibana
		btn_connect_kibana = new JButton("open kibana");
		panKibana.add(btn_connect_kibana);
		btn_connect_kibana.addActionListener(this);
		fondBoutonElastic.add(panKibana);

		// Custom
		panElastic.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		panElastic.setBorder(BorderFactory.createTitledBorder("Elasticsearch"));
		panKibana.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		panKibana.setBorder(BorderFactory.createTitledBorder("Kibana"));
		fondBoutonElastic.setBackground(Color.WHITE);

		// ==========================================
		// Third block : Configure button
		// ==========================================
		fondConfigure = new JPanel();
		fondConfigure.setLayout(new GridBagLayout());

		panConfigure = new JPanel();
		panConfigure.setLayout(new GridBagLayout());
		// bouton configure
		btn_configuration = new JButton("Configure");
		btn_configuration.setPreferredSize(new Dimension(300, 300));
		btn_configuration.addActionListener(this);
		panConfigure.add(btn_configuration);
		fondConfigure.add(panConfigure);
		// Custom
		panConfigure.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		panConfigure.setBorder(BorderFactory.createTitledBorder("Configuration"));

		// ==========================================
		// add different pan to principal pan
		// ==========================================
		fondMenu.add(menuBar, BorderLayout.NORTH); // add menu
		principalPan.add(fondMenu);
		principalPan.add(fondPicture);
		// principalPan.add(fondEmpty);
		principalPan.add(fondBoutonElastic);
		principalPan.add(fondConfigure);
		this.setContentPane(principalPan);

		// ==========================================
		// Custom principal pan
		// ==========================================
		this.setTitle("Nudge Elastic Launcher");
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);

		// ==========================================
		// Action Listeners JMenu
		// ==========================================
		item_quit.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.exit(1);
			}
		});

		item_openLog.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Desktop desk = Desktop.getDesktop();
				try {
					desk.open(new File(conn.getPathLog()));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

	} // end of constructor

	// ==========================================
	// Action Listeners : Button
	// =========================================

	public void actionPerformed(ActionEvent arg0) {
		JButton btn = (JButton) (arg0.getSource());
		// JMenuItem item = (JMenuItem) (arg0.getSource());
		Configuration conn = new Configuration();

		// *********** Open elasticSearch *****************
		if (btn.getText().equals("open elastic")) {
			Desktop desktop = null;
			java.net.URI url;
			try {
				url = new java.net.URI(conn.getElasticHost());
				if (Desktop.isDesktopSupported()) {
					desktop = Desktop.getDesktop();
					desktop.browse(url);
				}
			} catch (Exception ex) {
				Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		// ************ Run elasticSearh ********************
		if (btn.getText().equals("create node elastic")) {
			String command = conn.getElasticLocation() + "./elasticsearch";
			try {
				@SuppressWarnings("unused")
				Process child = Runtime.getRuntime().exec(command);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Node elastic create. If your configuration file is ok, you can now open ElasticSearch .");
		}

		// ************* Open kibana **************
		if (btn.getText().equals("open kibana")) {
			Desktop desktop = null;
			java.net.URI url;
			try {
				url = new java.net.URI(conn.getKibanaHost());
				if (Desktop.isDesktopSupported()) {
					desktop = Desktop.getDesktop();
					desktop.browse(url);
				}
			} catch (Exception ex) {
				Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		if (btn_runkibana.getText().equals("launch kibana")) {
			String command = conn.getKibanaHost() + "./kibana";
			try {
				@SuppressWarnings("unused")
				Process child = Runtime.getRuntime().exec(command);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "If your config is ok, Kibana can now be open.");
		}
		// *************** Configure **********************
		if (btn.getText().equals("Configure")) {
			new WinConfigure().setVisible(true);
		}

		// if (item.getText().equals("about the application")){
		// WinHelp help = new WinHelp();
		// help.setVisible(true);
		// }

	} // end of action listenners

} // end of class