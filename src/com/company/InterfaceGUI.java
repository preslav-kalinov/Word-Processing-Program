package com.company;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;

public class InterfaceGUI extends JFrame {
    private JTextArea TextDisplay;
    private JPanel panelMain;
    private JButton SaveButton;
    private JButton LoadButton;
    private JButton swapLinesButton;
    private JButton swapWordsButton;
    private JTextField pathField;
    private JTextField wordIndex1;
    private JTextField lineIndex1;
    private JTextField lineIndex2;
    private JTextField wordIndex2;
   // private JScrollBar scrollBar;

    public InterfaceGUI() throws IndexOutOfBoundsException{
        WordProcess wProcess = new WordProcess();
        setTitle("Word-Process Program");
        add(panelMain);
        setSize(1200, 700);
        swapLinesButton.addActionListener(e -> {
            try{
                wProcess.linesSwap(Integer.parseInt(lineIndex1.getText()), Integer.parseInt(lineIndex2.getText()));
            }
            catch (IndexOutOfBoundsException iobe){
                JOptionPane.showMessageDialog(panelMain, "Invalid input. Please enter a valid indexes!");
            }
            printWords(wProcess);
        });

        swapWordsButton.addActionListener(e -> {
            try{
                wProcess.wordsSwap(Integer.parseInt(lineIndex1.getText()), Integer.parseInt(lineIndex2.getText()), Integer.parseInt(wordIndex1.getText()), Integer.parseInt(wordIndex2.getText()));
            }
            catch (IndexOutOfBoundsException iobe){
                JOptionPane.showMessageDialog(panelMain, "Invalid input. Please enter a valid indexes!");
            }
            printWords(wProcess);
        });

        pathField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
            }
        });

        LoadButton.addActionListener(e -> {
            try{
                wProcess.reading(pathField.getText());
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(panelMain, "Unable to load the file. Please enter a valid path!");
            }
            finally {
                JOptionPane.showMessageDialog(panelMain, "File was successfully loaded!");
            }
            printWords(wProcess);
        });

        SaveButton.addActionListener(e -> {
            try{
                wProcess.wordWriting(pathField.getText());
            }
            catch (IOException ioe){
                JOptionPane.showMessageDialog(panelMain, "File couldn't save!");
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(panelMain, "Error!");
                TextDisplay.append("Error!");
                TextDisplay.append(ex.getMessage());
            }
            finally {
                JOptionPane.showMessageDialog(panelMain, "File was successfully saved!");
            }
        });
       // scrollBar.addFocusListener(new FocusAdapter() { });
    }

    private void printWords(WordProcess wProcess){
        int i;
        TextDisplay.setText("");
        for(i=0; i < wProcess.Lines.size(); i++){
            TextDisplay.append(wProcess.Lines.get(i));
            TextDisplay.append("\n");
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
