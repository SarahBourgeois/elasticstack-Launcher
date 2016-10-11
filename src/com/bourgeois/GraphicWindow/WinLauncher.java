package com.bourgeois.graphicWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
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
import com.bourgeois.event.LaucherItemEvent;
import com.bourgeois.event.LauncherEvent;

/**
 * 
 * @author Sarah Bourgeois
 *
 */

public class WinLauncher extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final String picturePath = "Ressources/nudge45.png";
	final ResourceBundle bundle = ResourceBundle.getBundle("displaytext.ressources");
	LauncherEvent launcherEvent = new LauncherEvent();
	LaucherItemEvent launcherItem = new LaucherItemEvent();

	public WinLauncher() throws HeadlessException {
		super();

		JPanel principalPan = new JPanel();
		principalPan.setLayout(new GridLayout(5, 3));

		// ======================
		// Menu
		// ======================
		// JmenuBar
		JPanel fondMenu = new JPanel();
		fondMenu.setLayout(new BorderLayout());
		JMenuBar menuBar = new JMenuBar();

		// Jmenu file (principal tool bar)
		JMenu men_file = new JMenu(bundle.getString("file.jmenu"));
		JMenu men_log = new JMenu(bundle.getString("log.jmenu"));
		JMenu men_about = new JMenu(bundle.getString("help.jmenu"));
		menuBar.add(men_file);
		menuBar.add(men_log);
		menuBar.add(men_about);

		// item quit
		JMenuItem item_quit = new JMenuItem(bundle.getString("quit.item"));
		item_quit.addActionListener(launcherItem);
		men_file.add(item_quit);

		// item open log
		JMenuItem item_openLog = new JMenuItem(bundle.getString("openlog.item"));
		item_openLog.addActionListener(launcherItem);
		men_log.add(item_openLog);

		// item help
		JMenuItem item_helpConfigure = new JMenuItem(bundle.getString("help.item"));
		men_about.add(item_helpConfigure);
		// about
		JMenuItem item_about = new JMenuItem(bundle.getString("about.item"));
		men_about.addSeparator();
		men_about.add(item_about);

		// ==========================================
		// Picture
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
		// Elasticsearch and Kibana
		// ==========================================
		JPanel fondElasticButton = new JPanel();
		fondElasticButton.setLayout(new GridLayout(1, 2));

		// *** Elasticsearch ***
		JPanel panElastic = new JPanel();
		panElastic.setLayout(new GridLayout(2, 1));
		// Create cluster
		JButton btn_createcluster = new JButton(bundle.getString("createnode.elastic.button"));
		panElastic.add(btn_createcluster);
		btn_createcluster.addActionListener(launcherEvent);
		fondElasticButton.add(panElastic);
		// Open elastic
		JButton btn_connect_elastic = new JButton(bundle.getString("openelastic.button"));
		panElastic.add(btn_connect_elastic);
		btn_connect_elastic.addActionListener(launcherEvent);
		fondElasticButton.add(panElastic);

		// *** Kibana ***
		JPanel panKibana = new JPanel();
		panKibana.setLayout(new GridLayout(2, 1));
		// run kibana
		JButton btn_runkibana = new JButton(bundle.getString("runkibana.button"));
		panKibana.add(btn_runkibana);
		btn_runkibana.addActionListener(launcherEvent);
		fondElasticButton.add(panKibana);
		// open Kibana
		JButton btn_connect_kibana = new JButton(bundle.getString("openkibana.button"));
		panKibana.add(btn_connect_kibana);
		btn_connect_kibana.addActionListener(launcherEvent);
		fondElasticButton.add(panKibana);
		// Custom
		panElastic.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		panElastic.setBorder(BorderFactory.createTitledBorder(bundle.getString("elastic.border")));
		panKibana.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		panKibana.setBorder(BorderFactory.createTitledBorder(bundle.getString("kibana.border")));
		fondElasticButton.setBackground(Color.WHITE);

		// ==========================================
		// Configure button
		// ==========================================
		JPanel fondConfigure = new JPanel();
		fondConfigure.setLayout(new GridBagLayout());

		JPanel panConfigure = new JPanel();
		panConfigure.setLayout(new GridBagLayout());
		// button configure
		JButton btn_configuration = new JButton(bundle.getString("configure.button"));
		btn_configuration.setPreferredSize(new Dimension(300, 300));
		btn_configuration.addActionListener(launcherEvent);
		panConfigure.add(btn_configuration);
		fondConfigure.add(panConfigure);
		// Custom
		panConfigure.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		panConfigure.setBorder(BorderFactory.createTitledBorder(bundle.getString("configuration.border")));

		// ==========================================
		// Kill Processus
		// ==========================================
		JPanel fondKillProcess = new JPanel();
		fondKillProcess.setLayout(new GridBagLayout());
		
		JPanel panKillProcess = new JPanel();
		panKillProcess.setLayout(new GridBagLayout());
		// button
		JButton btn_killProcess = new JButton(bundle.getString("killprocess.pan"));
		btn_killProcess.setFont(new Font("Serif", Font.BOLD, 16));
		btn_killProcess.setBackground(new Color(0,51,204));//import java.awt.Color;
		btn_killProcess.setForeground(Color.darkGray);
		btn_killProcess.setFocusPainted(true);
		btn_killProcess.addActionListener(launcherEvent);
		panKillProcess.add(btn_killProcess);
		fondKillProcess.add(panKillProcess);
		fondKillProcess.setBorder(BorderFactory.createLineBorder(Color.blue));
		fondKillProcess.setBorder(BorderFactory.createTitledBorder(bundle.getString("killprocess.pan")));
		
		// ==========================================
		// add different pan to principal pan
		// ==========================================
		fondMenu.add(menuBar, BorderLayout.NORTH); // add menu
		principalPan.add(fondMenu);
		principalPan.add(fondPicture);
		principalPan.add(fondElasticButton);
		principalPan.add(fondConfigure);
		principalPan.add(fondKillProcess);
		this.setContentPane(principalPan);

		// ==========================================
		// Custom principal pan
		// ==========================================
		this.setTitle(bundle.getString("launcher.window.title"));
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
	}
}
