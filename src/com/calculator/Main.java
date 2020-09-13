package com.calculator;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Display display = new Display();
        frame.setBounds(400,100,520,600);
        frame.setTitle("Calculator");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(display);
    }
}
