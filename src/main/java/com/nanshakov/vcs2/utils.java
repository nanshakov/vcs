package com.nanshakov.vcs2;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

public class utils {
    public static String openBrowser(String link) throws IOException, URISyntaxException {
        //Opens link in default browser
        Desktop.getDesktop().browse(new URI(link));

        //Asks user to input token from browser manually
        return JOptionPane.showInputDialog("Please input access_token param from browser: ");
    }
}
