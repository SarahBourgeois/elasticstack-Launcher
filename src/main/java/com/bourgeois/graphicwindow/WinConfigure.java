package com.bourgeois.graphicwindow;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.bourgeois.configuration.Configuration;
import com.bourgeois.event.ConfigurationEvent;

/**
 * 
 * @author Sarah Bourgeois
 *
 */

public class WinConfigure extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	Configuration configuration = new Configuration();
	ConfigurationEvent event = new ConfigurationEvent();
	Properties prop = new Properties();
	File fProp = new File(Configuration.getPropertiesfile());
	private static final ResourceBundle bundle = ResourceBundle.getBundle("displaytext.ressources");

	public WinConfigure() throws HeadlessException {
		super();

		JPanel principalPanConf = new JPanel();
		principalPanConf.setLayout(new GridLayout(4, 3));
		// ==========================================
		// elasticsearch configuration
		// ==========================================
		JPanel fondElastic = new JPanel();
		fondElastic.setLayout(new GridLayout(2, 1));

		// ******** Host *******
		JPanel panElasticSaisiHost = new JPanel();
		panElasticSaisiHost.setLayout(new GridLayout(1, 3));
		// Text
		JLabel txt_elastic_host = new JLabel(bundle.getString("elastic.host.label"));
		panElasticSaisiHost.add(txt_elastic_host);
		fondElastic.add(panElasticSaisiHost);
		// Field
		final JLabel sais_elastic_host = new JLabel(configuration.getElasticHost());
		panElasticSaisiHost.add(sais_elastic_host);
		fondElastic.add(panElasticSaisiHost);
		// Buttons
		JButton btn_elastic_host = new JButton(bundle.getString("edit.button"));
		btn_elastic_host.addActionListener(this);
		panElasticSaisiHost.add(btn_elastic_host);
		fondElastic.add(panElasticSaisiHost);

		// ******** Location *******
		JPanel panElasticSaisiLoc = new JPanel();
		panElasticSaisiLoc.setLayout(new GridLayout(1, 3));
		// Text
		JLabel txt_elastic_loc = new JLabel(bundle.getString("elastic.location.label"));
		panElasticSaisiLoc.add(txt_elastic_loc);
		fondElastic.add(panElasticSaisiLoc);
		// Field
		final JLabel sais_elastic_host1 = new JLabel(configuration.getElasticLocation());
		panElasticSaisiLoc.add(sais_elastic_host1);
		fondElastic.add(panElasticSaisiLoc);
		// Buttons
		JButton btn_elastic_loc = new JButton(bundle.getString("edit.button"));
		btn_elastic_loc.addActionListener(this);
		panElasticSaisiLoc.add(btn_elastic_loc);
		fondElastic.add(panElasticSaisiLoc);
		// Custom
		fondElastic.setBorder(BorderFactory.createTitledBorder(bundle.getString("elastic.border")));

		// ==========================================
		// Kibana configuration
		// ==========================================
		JPanel fondKibana = new JPanel();
		fondKibana.setLayout(new GridLayout(2, 1));

		// ******** Host *******
		JPanel panKibanaSaisiHost = new JPanel();
		panKibanaSaisiHost.setLayout(new GridLayout(1, 3));
		// Text
		JLabel txt_kibana_host = new JLabel(bundle.getString("kibana.host.label"));
		panKibanaSaisiHost.add(txt_kibana_host);
		fondKibana.add(panKibanaSaisiHost);
		// Field
		final JLabel sais_kibana_host = new JLabel(configuration.getKibanaHost());
		panKibanaSaisiHost.add(sais_kibana_host);
		fondKibana.add(panKibanaSaisiHost);
		// Buttons
		JButton btn_kibana_host = new JButton(bundle.getString("edit.button"));
		btn_kibana_host.addActionListener(this);
		panKibanaSaisiHost.add(btn_kibana_host);
		fondKibana.add(panKibanaSaisiHost);

		// ******** Location *******
		JPanel panKibanaSaisiLoc = new JPanel();
		panKibanaSaisiLoc.setLayout(new GridLayout(1, 3));
		// Text
		JLabel txt_kibana_loc = new JLabel(bundle.getString("kibana.location.label"));
		panKibanaSaisiLoc.add(txt_kibana_loc);
		fondKibana.add(panKibanaSaisiLoc);
		// Field
		final JLabel sais_kibana_loc = new JLabel(configuration.getKibanaLocation());
		panKibanaSaisiLoc.add(sais_kibana_loc);
		fondKibana.add(panKibanaSaisiLoc);
		// Button
		JButton btn_kibana_loc = new JButton(bundle.getString("edit.button"));
		btn_kibana_loc.addActionListener(this);
		panKibanaSaisiLoc.add(btn_kibana_loc);
		fondKibana.add(panKibanaSaisiLoc);
		// Custom
		fondKibana.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		fondKibana.setBorder(BorderFactory.createTitledBorder(bundle.getString("kibana.border")));

		// ==========================================
		// Log
		// ==========================================
		JPanel fondLog = new JPanel();
		fondLog.setLayout(new GridLayout(2, 1));

		JPanel panLogSaisi = new JPanel();
		panLogSaisi.setLayout(new GridLayout(1, 3));
		// Text
		JLabel txt_log = new JLabel(bundle.getString("path.log.label"));
		panLogSaisi.add(txt_log);
		fondLog.add(panLogSaisi);
		// Field
		final JLabel sai_log = new JLabel(configuration.getPathLog());
		panLogSaisi.add(sai_log);
		fondLog.add(panLogSaisi);
		// Buttons
		JButton btn_log = new JButton(bundle.getString("edit.button"));
		btn_log.addActionListener(this);
		panLogSaisi.add(btn_log);
		fondLog.add(panLogSaisi);
		// Custom
		fondLog.setBorder(BorderFactory.createTitledBorder(bundle.getString("log.border")));

		// ==========================================
		// Exit
		// ==========================================
		JPanel fondValidate = new JPanel();
		fondValidate.setLayout(new GridLayout(1, 1));
		// Validate
		JPanel panValidate = new JPanel();
		panValidate.setLayout(new GridBagLayout());
		JButton btn_validate = new JButton(bundle.getString("save.button"));
		btn_validate.addActionListener(this);
		panValidate.add(btn_validate);
		fondValidate.add(panValidate);

		// =========================
		// Buttons edit option
		// =========================
		btn_elastic_loc.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ConfigurationEvent.editConfiguration(sais_elastic_host1, configuration.getElasticLocation(),
						"elastic.location");
			}
		});
		btn_elastic_host.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ConfigurationEvent.editConfiguration(sais_elastic_host, configuration.getElasticHost(), "elastic.host");
			}
		});
		btn_kibana_loc.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ConfigurationEvent.editConfiguration(sais_kibana_loc, configuration.getKibanaLocation(),
						"kibana.location");
			}
		});
		btn_kibana_host.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ConfigurationEvent.editConfiguration(sais_kibana_host, configuration.getKibanaHost(), "kibana.host");
			}
		});
		btn_log.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ConfigurationEvent.editConfiguration(sai_log, configuration.getKibanaHost(), "kibana.host");
			}
		});
		btn_validate.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				close();
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
		this.setTitle(bundle.getString("configure.window.title"));
		this.setSize(800, 530);
		this.setLocationRelativeTo(null);
		this.setResizable(true);

	}

	public void close() {
		this.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
