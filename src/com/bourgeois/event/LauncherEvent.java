package com.bourgeois.event;

import java.awt.Desktop;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.bourgeois.GraphicWindow.WinConfigure;
import com.bourgeois.GraphicWindow.WinLauncher;
import com.bourgeois.configuration.Configuration;
import com.bourgeois.displayText.WinLauncherText;

public class LauncherEvent extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final String commandKibana = "./kibana";
	private static final String commandElastic = "./elasticsearch";

	public void actionPerformed(ActionEvent e) {

		JButton btn = (JButton) (e.getSource());
		Configuration conn = new Configuration();

		if (btn.getText().equals(WinLauncherText.getButtonOpenElastic())) {
			OpenStack(conn.getElasticHost());
		}

		if (btn.getText().equals(WinLauncherText.getButtonOpenKibana())) {
			OpenStack(conn.getKibanaHost());
		}

		if (btn.getText().equals(WinLauncherText.getButtonLaunchKibana())) {
			RunStack(conn.getKibanaLocation(), commandKibana, WinLauncherText.getKibanaNodeValidation());
		}

		if (btn.getText().equals(WinLauncherText.getButtoncreateNodeElastic())) {
			RunStack(conn.getElasticLocation(), commandElastic,
					WinLauncherText.getElasticNodeValidation());
		}

		if (btn.getText().equals(WinLauncherText.getButtonConfigure())) {
			new WinConfigure().setVisible(true);
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

} // end of class
