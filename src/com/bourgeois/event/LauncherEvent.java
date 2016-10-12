package com.bourgeois.event;

import java.awt.Desktop;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.bourgeois.configuration.Configuration;
import com.bourgeois.graphicWindow.WinConfigure;

public class LauncherEvent extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final String commandKibana = "./kibana";
	private static final String commandElastic = "./elasticsearch";
	private static final String killCommand = "pkill -f elasticsearch";
	private static final ResourceBundle bundle = ResourceBundle.getBundle("displaytext.ressources");

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) (e.getSource());
		Configuration conn = new Configuration();

		if (btn.getText().equals(bundle.getString("openelastic.button"))) {
			OpenStack(conn.getElasticHost());
		}
		if (btn.getText().equals(bundle.getString("openkibana.button"))) {
			OpenStack(conn.getKibanaHost());
		}
		if (btn.getText().equals(bundle.getString("runkibana.button"))) {
			RunStack(conn.getKibanaLocation(), commandKibana, bundle.getString("kibanaValidation.pane"));
		}
		if (btn.getText().equals(bundle.getString("createnode.elastic.button"))) {
			RunStack(conn.getElasticLocation(), commandElastic, bundle.getString("elasticValidation.pane"));
		}
		if (btn.getText().equals(bundle.getString("configure.button"))) {
			new WinConfigure().setVisible(true);
		}
		if (btn.getText().equals(bundle.getString("killprocess.pan"))) {
			killStackProcess(killCommand, "Process kill");
		}
	}

	public static void RunStack(String conn, String pathCommand, String validation) {
		String command = conn + pathCommand;
		try {
			Runtime.getRuntime().exec(command);
			JOptionPane.showMessageDialog(null, validation);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void OpenStack(String conn) {
		Desktop desktop;
		java.net.URI url;
		try {
			url = new java.net.URI(conn);
			if (Desktop.isDesktopSupported()) {
				desktop = Desktop.getDesktop();
				desktop.browse(url);
			}
		} catch (Exception ex) {
			Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void killStackProcess(String commandKill, String validation) {
		String command = commandKill;
		try {
			Runtime.getRuntime().exec(command);
			JOptionPane.showMessageDialog(null, validation);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

} // end of class
