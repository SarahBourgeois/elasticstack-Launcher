package com.bourgeois.launcher;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FenConfigure extends JFrame {
	private static final long serialVersionUID = 1L;

	// ==========================================
	// Declare windows and components
	// ==========================================

	// principal pan
	JPanel principalPanConf;

	// secondary pan
	JPanel fondElastic;
	JPanel fondKibana;
	JPanel fondValidate;
	JPanel fondLog;

	// Component pan
	JPanel panElasticTextLoc;
	JPanel panElasticSaisiLoc;
	JPanel panElasticTextHost;
	JPanel panElasticSaisiHost;
	JPanel panKibanaTextLoc;
	JPanel panKibanaSaisiLoc;
	JPanel panKibanaTextHost;
	JPanel panKibanaSaisiHost;
	JPanel panLogSaisi;
	JPanel panLogText;
	JPanel panValidate;
	JPanel panPlugin;

	// ********** components *****************
	// elastic
	JLabel txt_elastic_loc;
	JLabel sais_elastic_loc;
	JLabel txt_elastic_host;
	JLabel sais_elastic_host;

	// kibana
	JLabel txt_kibana_host;
	JLabel sais_kibana_host;
	JLabel txt_kibana_loc;
	JLabel sais_kibana_loc;

	// log
	JLabel txt_log;
	JLabel sai_log;

	// button
	JButton btn_elastic_host;
	JButton btn_elastic_loc;
	JButton btn_kibana_host;
	JButton btn_kibana_loc;
	JButton btn_log;
	
	// chekbox
	JCheckBox check_plugin;

	JButton btn_validate;

	public FenConfigure() throws HeadlessException {
		super();

		Configuration conn = new Configuration();
		Properties prop = new Properties();
		File fProp = new File("config.properties");

		// ==========================================
		// create principal pan
		// ==========================================
		principalPanConf = new JPanel();
		principalPanConf.setLayout(new GridLayout(4, 3));

		// ==========================================
		// first block : elasticsearch configuration
		// ==========================================

		fondElastic = new JPanel();
		fondElastic.setLayout(new GridLayout(3, 1));

		// ******** Host Elastic *******
		panElasticSaisiHost = new JPanel();
		panElasticSaisiHost.setLayout(new GridLayout(1, 3));
		// Text
		txt_elastic_host = new JLabel("your elasticsearch output host : ");
		panElasticSaisiHost.add(txt_elastic_host);
		fondElastic.add(panElasticSaisiHost);
		// Field
		sais_elastic_host = new JLabel(conn.getElasticHost());
		panElasticSaisiHost.add(sais_elastic_host);
		fondElastic.add(panElasticSaisiHost);
		// Buttons
		btn_elastic_host = new JButton("edit");
		panElasticSaisiHost.add(btn_elastic_host);
		fondElastic.add(panElasticSaisiHost);

		// ******** Elastic Location *******
		panElasticSaisiLoc = new JPanel();
		panElasticSaisiLoc.setLayout(new GridLayout(1, 3));
		// Text
		txt_elastic_loc = new JLabel("your elasticsearch location  : ");
		panElasticSaisiLoc.add(txt_elastic_loc);
		fondElastic.add(panElasticSaisiLoc);
		// Field
		sais_elastic_loc = new JLabel(conn.getElasticLocation());
		panElasticSaisiLoc.add(sais_elastic_loc);
		fondElastic.add(panElasticSaisiLoc);
		// Buttons
		btn_elastic_loc = new JButton("edit");
		panElasticSaisiLoc.add(btn_elastic_loc);
		fondElastic.add(panElasticSaisiLoc);
		
		
		//************ Plugin head ********************** 
		panPlugin = new JPanel();
		panPlugin.setLayout(new GridLayout(1,1));
		check_plugin = new JCheckBox("plugin head");
		panPlugin.add(check_plugin);
		fondElastic.add(panPlugin);
		
		// Custom
		fondElastic.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		fondElastic.setBorder(BorderFactory.createTitledBorder("ElasticSearch"));
		
		

		// ==========================================
		// second block : kibana configuration
		// ==========================================

		// secondary pan
		fondKibana = new JPanel();
		fondKibana.setLayout(new GridLayout(2, 1));

		// ******** Host Kibana *******
		panKibanaSaisiHost = new JPanel();
		panKibanaSaisiHost.setLayout(new GridLayout(1, 3));
		// Text
		txt_kibana_host = new JLabel("your Kibana output host : ");
		panKibanaSaisiHost.add(txt_kibana_host);
		fondKibana.add(panKibanaSaisiHost);
		// Field
		sais_kibana_host = new JLabel(conn.getKibanaHost());
		panKibanaSaisiHost.add(sais_kibana_host);
		fondKibana.add(panKibanaSaisiHost);
		// Buttons
		btn_kibana_host = new JButton("edit");
		panKibanaSaisiHost.add(btn_kibana_host);
		fondKibana.add(panKibanaSaisiHost);

		// ******** Kibana location *******
		panKibanaSaisiLoc = new JPanel();
		panKibanaSaisiLoc.setLayout(new GridLayout(1, 3));
		// Text
		txt_kibana_loc = new JLabel("your Kibana location in computer : ");
		panKibanaSaisiLoc.add(txt_kibana_loc);
		fondKibana.add(panKibanaSaisiLoc);
		// Field
		sais_kibana_loc = new JLabel(conn.getKibanaLocation());
		panKibanaSaisiLoc.add(sais_kibana_loc);
		fondKibana.add(panKibanaSaisiLoc);
		// Button
		btn_kibana_loc = new JButton("edit");
		panKibanaSaisiLoc.add(btn_kibana_loc);
		fondKibana.add(panKibanaSaisiLoc);
		// Custom
		fondKibana.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		fondKibana.setBorder(BorderFactory.createTitledBorder("Kibana"));

		// ==========================================
		// third block : log
		// ==========================================
	
		fondLog = new JPanel();
		fondLog.setLayout(new GridLayout(2, 1));

		// ******** Host Elastic *******
		panLogSaisi = new JPanel();
		panLogSaisi.setLayout(new GridLayout(1, 3));
		// Text
		txt_log = new JLabel("your path log : ");
		panLogSaisi.add(txt_log);
		fondLog.add(panLogSaisi);
		// Field
		sai_log = new JLabel(conn.getPathLog());
		panLogSaisi.add(sai_log);
		fondLog.add(panLogSaisi);
		// Buttons
		btn_log = new JButton("edit");
		panLogSaisi.add(btn_log);
		fondLog.add(panLogSaisi);
		// Custom
		fondLog.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		fondLog.setBorder(BorderFactory.createTitledBorder("Logger Configuration"));

		// ==========================================
		// fourth block : kibana configuration
		// ==========================================

		fondValidate = new JPanel();
		fondValidate.setLayout(new GridLayout(1, 1));

		// Validate
		panValidate = new JPanel();
		panValidate.setLayout(new GridBagLayout());
		btn_validate = new JButton("Exit");
		panValidate.add(btn_validate);
		fondValidate.add(panValidate);

		// ==========================================
		// Action listeners
		// ==========================================

		// *********** elastic Host ***************** **********		
		btn_elastic_host.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				String saisie = JOptionPane.showInputDialog(null, "edit elasticsearch host", conn.getElasticHost());
				sais_elastic_host.setText(saisie);
				FileInputStream stream = null;
				try {
					stream = new FileInputStream(fProp);
				} catch (FileNotFoundException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				try {
					prop.load(stream);
				} catch (IOException e3) {
					e3.printStackTrace();
				}

				String taNouvelleValeur = saisie;
				prop.setProperty("elastic.host", taNouvelleValeur);

				FileOutputStream oStream = null;
				try {
					oStream = new FileOutputStream(fProp);
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					prop.store(oStream, saisie);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		// *********** Elastic localization *****************
		btn_elastic_loc.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				String saisie = JOptionPane.showInputDialog(null, "edit elasticsearch location", conn.getElasticLocation());
				sais_elastic_loc.setText(saisie);
				FileInputStream stream = null;
				try {
					stream = new FileInputStream(fProp);
				} catch (FileNotFoundException e3) {

					e3.printStackTrace();
				}
				try {
					prop.load(stream);
				} catch (IOException e3) {
					e3.printStackTrace();
				}

				String taNouvelleValeur = saisie;
				prop.setProperty("elastic.location", taNouvelleValeur);

				FileOutputStream oStream = null;
				try {
					oStream = new FileOutputStream(fProp);
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
				try {
					prop.store(oStream, saisie);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		// *********** Log Configuration *****************
		btn_log.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				String saisie = JOptionPane.showInputDialog(null, "edit log path", conn.getPathLog());
				sai_log.setText(saisie);

				FileInputStream stream = null;
				try {
					stream = new FileInputStream(fProp);
				} catch (FileNotFoundException e3) {

					e3.printStackTrace();
				}
				try {
					prop.load(stream);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}

				String taNouvelleValeur = saisie;
				prop.setProperty("path.log", taNouvelleValeur);

				FileOutputStream oStream = null;
				try {
					oStream = new FileOutputStream(fProp);
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
				try {
					prop.store(oStream, saisie);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		// *********** Kibana Host *****************
		btn_kibana_host.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				String saisie = JOptionPane.showInputDialog(null, "edit elasticsearch host", conn.getKibanaHost());
				sais_kibana_host.setText(saisie);

				FileInputStream stream = null;
				try {
					stream = new FileInputStream(fProp);
				} catch (FileNotFoundException e3) {
					e3.printStackTrace();
				}
				try {
					prop.load(stream);
				} catch (IOException e3) {
					e3.printStackTrace();
				}
				String taNouvelleValeur = saisie;
				prop.setProperty("kibana.host", taNouvelleValeur);
				FileOutputStream oStream = null;
				try {
					oStream = new FileOutputStream(fProp);
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
				try {
					prop.store(oStream, saisie);
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
		});

		// *********** Localization Kibana *****************
		btn_kibana_loc.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				String saisie = JOptionPane.showInputDialog(null, "edit kibana location", conn.getKibanaLocation());
				sais_kibana_loc.setText(saisie);

				FileInputStream stream = null;
				try {
					stream = new FileInputStream(fProp);
				} catch (FileNotFoundException e3) {
					e3.printStackTrace();
				}
				try {
					prop.load(stream);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				String taNouvelleValeur = saisie;
				prop.setProperty("kibana.location", taNouvelleValeur);
				FileOutputStream oStream = null;
				try {
					oStream = new FileOutputStream(fProp);
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
				try {
					prop.store(oStream, saisie);
				} catch (IOException e1) {

					e1.printStackTrace();
				}

			}
		});

		// ******** Button validate **********
		btn_validate.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				setVisible(false);
			}
		});
		
		check_plugin.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				String saisie = "";
				
				FileInputStream stream = null;
				try {
					stream = new FileInputStream(fProp);
				} catch (FileNotFoundException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				try {
					prop.load(stream);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}

				if (check_plugin.isSelected()) {
					saisie = "/_plugin/head/";
					prop.setProperty("elastic.plugin", saisie);
				}
				else {
					saisie = "";
				}
				

				FileOutputStream oStream = null;
				try {
					oStream = new FileOutputStream(fProp);
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					prop.store(oStream, saisie);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		});

		// ==========================================
		// add different pan to principal pan
		// ==========================================
		principalPanConf.add(fondElastic);
		principalPanConf.add(fondKibana);
		principalPanConf.add(fondLog);
		principalPanConf.add(fondValidate);
		this.setContentPane(principalPanConf);

		// ==========================================
		// Custom principal pan
		// ==========================================
		this.setTitle("Elastic stack Configuration");
		this.setSize(800, 530);
		this.setLocationRelativeTo(null);
		this.setResizable(true);

	} // end of constructor

	// getters and setters
	public JLabel getSais_elastic_loc() {
		return sais_elastic_loc;
	}

	public JLabel getSais_kibana_host() {
		return sais_kibana_host;
	}

	public JLabel getSais_kibana_loc() {
		return sais_kibana_loc;
	}

} // end of class
