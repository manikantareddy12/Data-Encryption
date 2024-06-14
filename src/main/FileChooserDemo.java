package main;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileChooserDemo extends JFrame implements ActionListener {
    private JButton button;

    public FileChooserDemo() {
        button = new JButton("Choose File");
        button.addActionListener(this);
        add(button);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            List<String> fileContents = readingFiles(selectedFile);
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            System.out.println("File contents:");
            for (String line : fileContents) {
                System.out.println(line);
            }
            dispose();

        }
    }
    private List<String> readingFiles(File file) {
        List<String> contents = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                contents.add(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return contents;
    }


}
