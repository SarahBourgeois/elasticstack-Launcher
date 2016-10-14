package com.bourgeois.event;

import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;

import com.bourgeois.configuration.Configuration;
import com.googlecode.htmlcompressor.compressor.HtmlCompressor;

/**
 * 
 * @author Sarah Bourgeois
 *
 */

public class LaucherItemEvent extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final ResourceBundle bundle = ResourceBundle.getBundle("displaytext.ressources");
	Configuration conn = new Configuration();
	Desktop desk;

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) (e.getSource());

		if (item.getText().equals(bundle.getString("quit.item"))) {
			System.exit(1);
		}

		if (item.getText().equals(bundle.getString("openlog.item"))) {
			desk = Desktop.getDesktop();
			try {
				desk.open(new File(conn.getPathLog()));
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, bundle.getString("error.logSystem"));
				e1.printStackTrace();
			}
		}
		
		if (item.getText().equals(bundle.getString("about.item"))) {
			try {
				JOptionPane.showMessageDialog(null, InsertHtml("document.html"));
			} catch (HeadlessException | IOException e1) {
				JOptionPane.showMessageDialog(null, bundle.getString("error.htmlDocument"));
				e1.printStackTrace();
			}
		}

		if (item.getText().equals(bundle.getString("help.item"))) {
			try {
				JOptionPane.showMessageDialog(null, InsertHtml("Html-Documents/helpFile.html"));
			} catch (HeadlessException | IOException e1) {
				JOptionPane.showMessageDialog(null, bundle.getString("error.htmlDocument"));
				e1.printStackTrace();
			}
		}
		
		

	}

	public static String InsertHtml(String file) throws IOException {
		String html = FileUtils.readFileToString(new File(file));
		HtmlCompressor compressor = new HtmlCompressor();
		html = compressor.compress(html);
		return html;
	}

}