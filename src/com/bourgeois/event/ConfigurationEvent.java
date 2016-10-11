package com.bourgeois.event;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import com.bourgeois.configuration.Configuration;

/**
 * 
 * @author Sarah Bourgeois
 *
 */

public class ConfigurationEvent extends JFrame {
	private static final long serialVersionUID = 1L;

	Configuration configuration = new Configuration();
	ResourceBundle bundle = ResourceBundle.getBundle("displaytext.ressources");

	public static void editConfiguration(JLabel label, String conf, String setProperty) {
		Properties prop = new Properties();
		File fProp = new File(Configuration.getPropertiesfile());
		String userConfig = JOptionPane.showInputDialog(null, "edit", conf);
		label.setText(userConfig);
		FileInputStream stream = null;
		try {
			stream = new FileInputStream(fProp);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		try {
			prop.load(stream);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		String newValue = userConfig;
		prop.setProperty(setProperty, newValue);
		FileOutputStream oStream = null;
		try {
			oStream = new FileOutputStream(fProp);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		try {
			prop.store(oStream, userConfig);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
