package seatOrganiser;

import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.filechooser.*;

import org.apache.commons.io.FileUtils;

@SuppressWarnings({ "unused", "serial" })
public class FileChooser extends JPanel implements ActionListener {
    static private final String newline = "\n";
    JButton openButton;
    JTextArea log;
    JFileChooser fc;

    public FileChooser() {
        super(new BorderLayout());

        // Create log
        log = new JTextArea(2,20);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        // Create file chooser
        fc = new JFileChooser();

        // Create open button
        openButton = new JButton("Choose database...", createImageIcon("images/Open16.gif"));
        openButton.addActionListener(this);
        
        // Layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);

        // Add buttons and log
        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }
        
    public void actionPerformed(ActionEvent e) {
    	
        // Handle open button
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(FileChooser.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                File dest = new File("Filemaker.xls");
                
                try {
					FileUtils.copyFile(file, dest);
				} catch (IOException e1) {}
                
                log.append("Opening: " + file.getName() + "." + newline);
            } else {
                log.append("Open command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
        } 
    }

    /** Returns ImageIcon if path is correct.*/
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = FileChooser.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**Create the GUI and show it.  Thread unsafe if not run from SwingUtilities.invokeLater.*/
    private static void createAndShowGUI() {
        // Create and display window.
        JFrame frame = new JFrame("Pick a File");
        frame.add(new FileChooser());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Schedule creating and showing the GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Turn off bold
                UIManager.put("swing.boldMetal", Boolean.FALSE); 
                createAndShowGUI();
            }
        });
    }
}
