package com.bourgeois.GraphicWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import com.bourgeois.displayText.WinLauncherText;
import com.bourgeois.event.LaucherItemEvent;
import com.bourgeois.event.LauncherEvent;


/*
 * @author: Bourgeois Sarah
 */

public class WinLauncher extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final String picturePath = "Ressources/nudge45.png";
	
	LauncherEvent launcherEvent = new LauncherEvent();
	LaucherItemEvent launcherItem = new LaucherItemEvent();

	public WinLauncher() throws HeadlessException {
		super();

		// principal pan
		JPanel principalPan = new JPanel();
		principalPan.setLayout(new GridLayout(5, 3));

		// ======================
		// Block : Menu
		// ======================
		// JmenuBar
		JPanel fondMenu = new JPanel();
		fondMenu.setLayout(new BorderLayout());
		JMenuBar menuBar = new JMenuBar();

		// Jmenu file (principal tool bar)
		JMenu men_file = new JMenu("File");
		JMenu men_log = new JMenu("Elastic Log");
		JMenu men_about = new JMenu("Help");
		menuBar.add(men_file);
		menuBar.add(men_log);
		menuBar.add(men_about);

		// item quit
		JMenuItem item_quit = new JMenuItem(WinLauncherText.getItemQuit());
		item_quit.addActionListener(launcherItem);
		men_file.add(item_quit);

		// item open log
		JMenuItem item_openLog = new JMenuItem("Open elasticsearch log");
		item_openLog.addActionListener(launcherItem);
		men_log.add(item_openLog);

		// item help
		JMenuItem item_helpConfigure = new JMenuItem("help for configuration");
		men_about.add(item_helpConfigure);
		// about
		JMenuItem item_about = new JMenuItem("about the application");
		men_about.addSeparator();
		men_about.add(item_about);

		// ==========================================
		// first block : Picture
		// ==========================================
		JPanel fondPicture = new JPanel();
		fondPicture.setLayout(new GridLayout(1, 1));

		// picture
		BufferedImage picture = null;
		try {
			picture = ImageIO.read(new File(picturePath));
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		JLabel photo = new JLabel("");
		photo.setHorizontalAlignment(SwingConstants.CENTER);
		photo.setBounds(55, 224, 510, 850);
		photo.setIcon(new ImageIcon(picture));
		fondPicture.add(photo);

		// ==========================================
		// Second block : Elasticsearch and Kibana
		// ==========================================
		JPanel fondElasticButton = new JPanel();
		fondElasticButton.setLayout(new GridLayout(1, 2));

		// Elasticsearch
		JPanel panElastic = new JPanel();
		panElastic.setLayout(new GridLayout(2, 1));
		// Create cluster
		JButton btn_createcluster = new JButton(WinLauncherText.getButtoncreateNodeElastic());
		panElastic.add(btn_createcluster);
		btn_createcluster.addActionListener(launcherEvent);
		fondElasticButton.add(panElastic);
		// Open elastic
		JButton btn_connect_elastic = new JButton(WinLauncherText.getButtonOpenElastic());
		panElastic.add(btn_connect_elastic);
		btn_connect_elastic.addActionListener(launcherEvent);
		fondElasticButton.add(panElastic);

		// Kibana
		JPanel panKibana = new JPanel();
		panKibana.setLayout(new GridLayout(2, 1));
		// run kibana
		JButton btn_runkibana = new JButton(WinLauncherText.getButtonLaunchKibana());
		panKibana.add(btn_runkibana);
		btn_runkibana.addActionListener(launcherEvent);
		fondElasticButton.add(panKibana);
		// open Kibana
		JButton btn_connect_kibana = new JButton(WinLauncherText.getButtonOpenKibana());
		panKibana.add(btn_connect_kibana);
		btn_connect_kibana.addActionListener(launcherEvent);
		fondElasticButton.add(panKibana);

		// Custom
		panElastic.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		panElastic.setBorder(BorderFactory.createTitledBorder("Elasticsearch"));
		panKibana.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		panKibana.setBorder(BorderFactory.createTitledBorder("Kibana"));
		fondElasticButton.setBackground(Color.WHITE);

		// ==========================================
		// Third block : Configure button
		// ==========================================
		JPanel fondConfigure = new JPanel();
		fondConfigure.setLayout(new GridBagLayout());

		JPanel panConfigure = new JPanel();
		panConfigure.setLayout(new GridBagLayout());
		// bouton configure
		JButton btn_configuration = new JButton(WinLauncherText.getButtonConfigure());
		btn_configuration.setPreferredSize(new Dimension(300, 300));
		btn_configuration.addActionListener(launcherEvent);
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
		principalPan.add(fondElasticButton);
		principalPan.add(fondConfigure);
		this.setContentPane(principalPan);

		// ==========================================
		// Custom principal pan
		// ==========================================
		this.setTitle(WinLauncherText.getPrincipalPanTitle());
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);

		// ==========================================

	} // end of constructor

	@Override
	public void actionPerformed(ActionEvent e) {



	}

} // end of class
