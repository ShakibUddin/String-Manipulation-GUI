package com.sakib.mypackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JButton count;
    private JPanel panelMain;
    private JTextArea input;
    private JTextArea output;
    private JLabel inputLabel;
    private JLabel outputLabel;
    private JTextArea search;
    private JLabel searchLabel;
    private JButton capitalizeButton;
    private JButton searchButton;

    public static void main(String[] args){
        JFrame jFrame = new JFrame("String Manipulation");
        jFrame.setPreferredSize(new Dimension(500,500));
        jFrame.setContentPane(new App().panelMain);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public App() {
        count.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText("Total "+String.valueOf(getWordCount(input.getText()))+" words.");
            }
        });
        capitalizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(capitalizeAllWordsFirstLetter(input.getText()));
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkIfWordExists(input.getText(),search.getText())){
                    output.setText(search.getText()+" exists");
                }
                else{
                    output.setText(search.getText()+ " does not exist");
                }

            }
        });
    }

    int getWordCount(String input){
        if(input.length() == 0)return 0;
        return input.split(" ").length;
    }

    String capitalizeAllWordsFirstLetter(String input){
        if(input.length() == 0)return "Please enter a string first";
        StringBuilder stringBuilder = new StringBuilder();
        for(String word : input.split(" ")){
            String newString = "";
            newString += word.substring(0,1).toUpperCase();
            newString += word.substring(1);
            stringBuilder.append(newString+" ");
        }
        return stringBuilder.toString();
    }

    boolean checkIfWordExists(String mainString,String input){
        if(input.length() == 0 || mainString.length() == 0)return false;
        if(mainString.contains(input))return true;
        return false;
    }

}
