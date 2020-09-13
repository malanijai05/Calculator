package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Display extends JPanel implements KeyListener, ActionListener, MouseListener, MouseMotionListener {
    private final Timer timer;
    private char num;
    private char onButton;
    private int a = 0;
    private int randr = 0;
    private int randg = 0;
    private int randb = 0;
    private String repeat = null;
    private int i = 0;
    private int count = 0;
    private int textX = 391;
    private String[] part = new String[50];
    private double first;
    private double second;
    private double answer;
    private String result = null;
    private int c = 0;
    private String value = " ";
    public Display () {
        addMouseListener(this);
        addMouseMotionListener(this);

        for(int i = 0; i < 49; i++) {
            part[i] = "";
        }
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        int delay = 100;
        timer = new Timer(delay, this);
        timer.start();
    }
    public void paint(Graphics g) {
        //font
        g.setColor(Color.BLACK);
        g.setFont(new Font("serif",Font.BOLD,50));
        //backGround
        g.setColor(Color.white);
        g.fillRect(0,0,520,600);
        //body
        g.setColor(Color.darkGray);
        g.fillRoundRect(32,20,420,500,50,50);
        g.setColor(Color.BLACK);
        g.fillRoundRect(42,30,420,500,50,50);
        //screen
        D3(g);
        if(value.equals(" Never Settle")) {
            g.setColor(Color.red);
        }
        else
            g.setColor(new Color(0xBFE2C4));
        g.fillRoundRect(60,55,384,50,30,30);
        //Button
        screenText(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("serif",Font.BOLD,50));
        g.setColor(Color.WHITE);
        //firstRow
        if(num == '7') {
            g.setColor(new Color(0x6ED5B0));
            g.fillRoundRect(57,145,60,60,10,10);
            g.setColor(Color.BLACK);
            g.drawString("7", 72, 195);
            num = 'z';
        }
        else {
            g.setColor(Color.WHITE);
            g.fillRoundRect(62,150,60,60,10,10);
            g.setColor(Color.BLACK);
            g.drawString("7", 77, 200);
        }
        if(num == '8') {
            g.setColor(new Color(0x6ED5B0));
            g.fillRoundRect(137, 145, 60, 60, 10, 10);
            g.setColor(Color.BLACK);
            g.drawString("8",152,195);
            num = 'z';
        }
        else {
            g.setColor(Color.WHITE);
            g.fillRoundRect(142, 150, 60, 60, 10, 10);
            g.setColor(Color.BLACK);
            g.drawString("8",157,200);
        }
        if(num == '9'){
            g.setColor(new Color(0x6ED5B0));
            g.fillRoundRect(217, 145, 60, 60, 10, 10);
            g.setColor(Color.BLACK);
            g.drawString("9",232,195);
            num = 'z';

        }
        else{
            g.setColor(Color.WHITE);
            g.fillRoundRect(222, 150, 60, 60, 10, 10);
            g.setColor(Color.BLACK);
            g.drawString("9",237,200);
        }

        //secondRow
        if(num == '4') {
            g.setColor(new Color(0x6ED5B0));
            g.fillRoundRect(57,245,60,60,10,10);
            g.setColor(Color.BLACK);
            g.drawString("4", 72, 295);
            num = 'z';
        }
        else {
            g.setColor(Color.WHITE);
            g.fillRoundRect(62,250,60,60,10,10);
            g.setColor(Color.BLACK);
            g.drawString("4", 77, 300);
        }
        if(num == '5') {
            g.setColor(new Color(0x6ED5B0));
            g.fillRoundRect(137, 245, 60, 60, 10, 10);
            g.setColor(Color.BLACK);
            g.drawString("5",152,295);
            num = 'z';
        }
        else {
            g.setColor(Color.WHITE);
            g.fillRoundRect(142, 250, 60, 60, 10, 10);
            g.setColor(Color.BLACK);
            g.drawString("5",157,300);
        }
        if(num == '6'){
            g.setColor(new Color(0x6ED5B0));
            g.fillRoundRect(217, 245, 60, 60, 10, 10);
            g.setColor(Color.BLACK);
            g.drawString("6",232,295);
            num = 'z';

        }
        else{
            g.setColor(Color.WHITE);
            g.fillRoundRect(222, 250, 60, 60, 10, 10);
            g.setColor(Color.BLACK);
            g.drawString("6",237,300);
        }
        //thirdRow
        if(num == '1') {
            g.setColor(new Color(0x6ED5B0));
            g.fillRoundRect(57,345,60,60,10,10);
            g.setColor(Color.BLACK);
            g.drawString("1", 72, 395);
            num = 'z';
        }
        else {
            g.setColor(Color.WHITE);
            g.fillRoundRect(62,350,60,60,10,10);
            g.setColor(Color.BLACK);
            g.drawString("1", 77, 400);
        }
        if(num == '2') {
            g.setColor(new Color(0x6ED5B0));
            g.fillRoundRect(137, 345, 60, 60, 10, 10);
            g.setColor(Color.BLACK);
            g.drawString("2",152,395);
            num = 'z';
        }
        else {
            g.setColor(Color.WHITE);
            g.fillRoundRect(142, 350, 60, 60, 10, 10);
            g.setColor(Color.BLACK);
            g.drawString("2",157,400);
        }
        if(num == '3'){
            g.setColor(new Color(0x6ED5B0));
            g.fillRoundRect(217, 345, 60, 60, 10, 10);
            g.setColor(Color.BLACK);
            g.drawString("3",232,395);
            num = 'z';

        }
        else{
            g.setColor(Color.WHITE);
            g.fillRoundRect(222, 350, 60, 60, 10, 10);
            g.setColor(Color.BLACK);
            g.drawString("3",237,400);
        }
        //finalRow
        if(num == '0') {
            g.setColor(new Color(0x6ED5B0));
            g.fillRoundRect(137, 445, 60, 60, 10, 10);
            g.setColor(Color.BLACK);
            g.drawString("0",152,495);
            num = 'z';
        }
        else {
            g.setColor(Color.WHITE);
            g.fillRoundRect(142, 450, 60, 60, 10, 10);
            g.setColor(Color.BLACK);
            g.drawString("0",157,500);
        }
        if(num == '.') {
            g.setColor(new Color(0x6ED5B0));
            g.fillRoundRect(57,445,60,60,10,10);
            g.setColor(Color.BLACK);
            g.drawString(".", 72, 495);
            num = 'z';
        }
        else {
            g.setColor(new Color(0x999CA1));
            g.fillRoundRect(62,450,60,60,10,10);
            g.setColor(Color.BLACK);
            g.drawString(".", 77, 500);
        }
        if(num == 'c'){
            g.setColor(new Color(0x6ED5B0));
            g.fillRoundRect(217, 445, 60, 60, 10, 10);
            g.setColor(Color.BLACK);
            g.setFont(new Font("serif",Font.BOLD,25));
            g.drawString("CE",232,485);
            num = 'z';

        }
        else{
            g.setColor(new Color(0x999CA1));
            g.fillRoundRect(222, 450, 60, 60, 10, 10);
            g.setColor(Color.BLACK);
            g.setFont(new Font("serif",Font.BOLD,25));
            g.drawString("CE",237,490);
        }
        g.setFont(new Font("serif",Font.BOLD,50));

        //symbol


        g.setColor(new Color(0x999CA1));
        //row1
        if(num == '÷') {
            g.setColor(new Color(0x6ED5B0));
            g.fillRoundRect(297,145,60,60,10,10);
            g.setColor(Color.BLACK);
            g.drawString("÷",312,190);
            num = 'z';
        }
        else {
            g.setColor(new Color(0x999CA1));
            g.fillRoundRect(302,150,60,60,10,10);
            g.setColor(Color.BLACK);
            g.drawString("÷",317,195);
        }
        if(num == 'a'){
            g.setColor(new Color(0x6ED5B0));
            g.fillRoundRect(377, 145, 60, 60, 10, 10);
            g.setColor(Color.BLACK);
            g.setFont(new Font("serif",Font.BOLD,25));
            g.drawString("AC",392,185);
            num = 'z';

        }
        else{
            g.setColor(new Color(0x999CA1));
            g.fillRoundRect(382, 150, 60, 60, 10, 10);
            g.setColor(Color.BLACK);
            g.setFont(new Font("serif",Font.BOLD,25));
            g.drawString("AC",397,190);
        }
        g.setFont(new Font("serif",Font.BOLD,50));
        g.setColor(new Color(0x999CA1));
        //row2
        if(num == 'x') {
            g.setColor(new Color(0x6ED5B0));
            g.fillRoundRect(297,245,60,60,10,10);
            g.setColor(Color.BLACK);
            g.drawString("x",312,290);
            num = 'z';
        }
        else {
            g.setColor(new Color(0x999CA1));
            g.fillRoundRect(302,250,60,60,10,10);
            g.setColor(Color.BLACK);
            g.drawString("x",317,295);
        }
        if(num == '^'){
            g.setColor(new Color(0x6ED5B0));
            g.fillRoundRect(377, 245, 60, 60, 10, 10);
            g.setColor(Color.BLACK);
            g.drawString("^",382,295);
            num = 'z';

        }
        else{
            g.setColor(new Color(0x999CA1));
            g.fillRoundRect(382, 250, 60, 60, 10, 10);
            g.setColor(Color.BLACK);
            g.drawString("^",387,300);
        }
        if(num == '-') {
            g.setColor(new Color(0x6ED5B0));
            g.fillRoundRect(297,345,60,60,10,10);
            g.setColor(Color.BLACK);
            g.drawString("_",312,370);
            num = 'z';
        }
        else {
            g.setColor(new Color(0x999CA1));
            g.fillRoundRect(302,350,60,60,10,10);
            g.setColor(Color.BLACK);
            g.drawString("_",317,375);
        }
        if(num == '+') {
            g.setColor(new Color(0x6ED5B0));
            g.fillRoundRect(297,445,60,60,10,10);
            g.setColor(Color.BLACK);
            g.drawString("+",312,490);
            num = 'z';
        }
        else {
            g.setColor(new Color(0x999CA1));
            g.fillRoundRect(302,450,60,60,10,10);
            g.setColor(Color.BLACK);
            g.drawString("+",317,495);
        }
        if(num == '='){
            g.setColor(new Color(0x6ED5B0));
            g.fillRoundRect(377,345,60,160,10,10);
            g.setColor(Color.BLACK);
            g.drawString("=",392,435);
            num = 'z';

        }
        else{
            g.setColor(new Color(0x999CA1));
            g.fillRoundRect(382,350,60,160,10,10);
            g.setColor(Color.BLACK);
            g.drawString("=",397,440);
        }
        mouseOnButton(g);
        g.setColor(new Color(0x999CA1));
        g.dispose();
    }
    private void mouseOnButton (Graphics g) {
        if(onButton == '7') {
            g.setColor(new Color(0x5737FF00, true));
            g.fillRoundRect(62,150,60,60,10,10);
        }
        if(onButton == '8') {
            g.setColor(new Color(0x5737FF00, true));
            g.fillRoundRect(142, 150, 60, 60, 10, 10);
        }
        if(onButton == '9') {
            g.setColor(new Color(0x5737FF00, true));
            g.fillRoundRect(222, 150, 60, 60, 10, 10);
        }
        if(onButton == '4') {
            g.setColor(new Color(0x5737FF00, true));
            g.fillRoundRect(62,250,60,60,10,10);
        }
        if(onButton == '5') {
            g.setColor(new Color(0x5737FF00, true));
            g.fillRoundRect(142, 250, 60, 60, 10, 10);
        }
        if(onButton == '6') {
            g.setColor(new Color(0x5737FF00, true));
            g.fillRoundRect(222, 250, 60, 60, 10, 10);
        }
        if(onButton == '1') {
            g.setColor(new Color(0x5737FF00, true));
            g.fillRoundRect(62,350,60,60,10,10);
        }
        if(onButton == '2') {
            g.setColor(new Color(0x5737FF00, true));
            g.fillRoundRect(142, 350, 60, 60, 10, 10);
        }
        if(onButton == '3') {
            g.setColor(new Color(0x5737FF00, true));
            g.fillRoundRect(222, 350, 60, 60, 10, 10);
        }
        if(onButton == '0') {
            g.setColor(new Color(0x5737FF00, true));
            g.fillRoundRect(142, 450, 60, 60, 10, 10);
        }
        if(onButton == '.') {
            g.setColor(new Color(0x5737FF00, true));
            g.fillRoundRect(62,450,60,60,10,10);
        }
        if(onButton == 'c') {
            g.setColor(new Color(0x5737FF00, true));
            g.fillRoundRect(222,450,60,60,10,10);
        }
        if(onButton == '+') {
            g.setColor(new Color(0x5737FF00, true));
            g.fillRoundRect(302,450,60,60,10,10);
        }
        if(onButton == '-') {
            g.setColor(new Color(0x5737FF00, true));
            g.fillRoundRect(302,350,60,60,10,10);
        }
        if(onButton == 'x') {
            g.setColor(new Color(0x5737FF00, true));
            g.fillRoundRect(302,250,60,60,10,10);
        }
        if(onButton == '÷') {
            g.setColor(new Color(0x5737FF00, true));
            g.fillRoundRect(302,150,60,60,10,10);
        }
        if(onButton == '^') {
            g.setColor(new Color(0x5737FF00, true));
            g.fillRoundRect(382,250,60,60,10,10);
        }
        if(onButton == '=') {
            g.setColor(new Color(0x5737FF00, true));
            g.fillRoundRect(382,350,60,160,10,10);
        }
        if(onButton == 'a') {
            g.setColor(new Color(0x5737FF00, true));
            g.fillRoundRect(382,150,60,60,10,10);
        }
    }
    private void screenText(Graphics g) {
        g.setColor(Color.BLACK);
        if(i==17) {
            textX = 151;
        }
        if(i>16) {
            g.setFont(new Font("serif", Font.BOLD, 30));
            a++;
        }
        else {
            g.setFont(new Font("serif", Font.BOLD, 40));
            if(a>0) {
                textX = 60;
                a=0;
            }
        }
        if(num == 'a') {
            value=" ";
            i = 0;
            textX = 391;
            count = 0;
            g.setFont(new Font("serif", Font.BOLD, 40));
        }
        if(value.equals(repeat) && num == 'c') {
            value=" ";
            i = 0;
            textX = 391;
            count = 0;
            g.setFont(new Font("serif", Font.BOLD, 40));
        }
        if(!(value.equals(" NaN") || value.equals(" Infinity") || value.equals(" Invalid Input") || value.equals(" Never Settle")))
        if(((num == '+' || num == '-' || num == 'x' || num == '^' || num == '÷') && value.equals(repeat)) || value.equals(" ")) {
            i = value.length()-1;
            textX = 380 - i*20;
            part[0] = " ";
            count = 0;
            if(i>16) {
                textX = 406 - i*15;
            }
        }
        if(i>0 && textX >= 60)
            if(num == 'c') {
                value=value.substring(0,i);
                i--;
                if(i<=16)
                    textX+=20;
                else
                    textX+=15;
            }
        if(num == '=' && !value.equals(repeat)) {
            if(value.endsWith("÷") || value.endsWith("x") || value.endsWith("^")) {
                value = value + "1";
            }
            if (value.endsWith("+") || value.endsWith("-") || value.endsWith(".")) {
                value = value + "0";
            }
            if(value.equals(" 1+0")) {
                value = " Never Settle";
                repeat = value;
            }
            else {
                value = " " + answer(value);
                repeat = value;
            }

            textX = 60;
            for(int i = 0; i < 49; i++) {
                part[i] = "0";
            }
            i = value.length();
            count = 0;
            c = 0;
            if(i>18) {
                g.setFont(new Font("serif", Font.BOLD, 30));
            }

        }
        if(textX > 61) {
            if (num >= 48 && num <= 58) {
                value = value + num;
                count++;
                i++;
                if (count >= 2) {
                    if(i<=16)
                        textX -= 20;
                    else
                        textX -= 15;
                    count--;
                }
            }
            if(i>0 && !(value.endsWith("+") || value.endsWith("-")|| value.endsWith("÷") || value.endsWith("x") || value.endsWith(".") || value.endsWith("^")))
                if(num == '^' || num == 'x' || num == '-' || num == '+' || num == '÷' || num == '.'){
                    if(num == '.') {
                        value = value + ".";
                    }
                    else {
                        value = value + num;
                    }
                    count++;
                    i++;
                    if (count >= 2) {
                        if(i<=16)
                            textX -= 20;
                        else
                            textX -= 15;
                        count--;
                    }
                }
        }
        if (value.equals(" Never Settle")) {
            g.setColor(Color.WHITE);
        }
        //System.out.println(textX);
        g.drawString(value,textX,95);
    }

    private String answer(String value) {
        int j = 0;
        for(int i = 1; i < value.length(); i++) {
            if(value.charAt(i)=='+' || value.charAt(i) == '-' || value.charAt(i) == 'x' || value.charAt(i) == '÷' || value.charAt(i) == '^'){
                j++;
                part[j] = part[j] + value.charAt(i);
                j++;
            }
            else {
                part[j] = part[j] + value.charAt(i);
            }
        }
        int length = j;
        int deciCount;
        for(int i = 0; i <= j; i++) {
            deciCount = 0;
            for(int k = 0; k < part[i].length(); k++) {
                if (part[i].charAt(k) == '.') {
                    deciCount++;
                }
            }
            if(deciCount>1) {
                return "Invalid Input";
            }
        }
        for(int i = length; i >= 0; i--) {
            if(part[i].endsWith("^")) {
                first = Double.parseDouble(part[i-1]);
                second = Double.parseDouble(part[i+1]);
                answer = Math.pow(first,second);
                result = String.valueOf(answer);
                part[i-1] = result;
                if (length - 1 - i >= 0) {
                    System.arraycopy(part, i + 2, part, i, length - 1 - i);
                }
                c+=2;
            }
        }

        for(int i = 0; i <= length-c; i++) {
            if(part[i].endsWith("÷")) {
                first = Double.parseDouble(part[i-1]);
                second = Double.parseDouble(part[i+1]);
                answer = first/second;
                result = String.valueOf(answer);
                part[i-1] = result;
                for(int k = i; k < length-1; k++) {
                    part[k] = part[k+2];
                }
                c+=2;
                i = 0;
            }
        }
        for(int i = 0; i <= length-c; i++) {
            if(part[i].endsWith("x")) {
                first = Double.parseDouble(part[i-1]);
                second = Double.parseDouble(part[i+1]);
                answer = first*second;
                result = String.valueOf(answer);
                part[i-1] = result;
                for(int k = i; k < length-1; k++) {
                    part[k] = part[k+2];
                }
                c+=2;
                i = 0;
            }
        }
        for(int i = 0; i <= length-c; i++) {
            if(part[i].endsWith("+")) {
                first = Double.parseDouble(part[i-1]);
                second = Double.parseDouble(part[i+1]);
                answer = first+second;
                result = String.valueOf(answer);
                part[i-1] = result;
                for(int k = i; k < length-1; k++) {
                    part[k] = part[k+2];
                }
                c+=2;
                i = 0;
            }
            if(part[i].endsWith("-")) {
                first = Double.parseDouble(part[i-1]);
                second = Double.parseDouble(part[i+1]);
                answer = first-second;
                result = String.valueOf(answer);
                part[i-1] = result;
                for(int k = i; k < length-1; k++) {
                    part[k] = part[k+2];
                }
                c+=2;
                i = 0;
            }
        }
        for(int i =0; i < length+1-c; i++) {
            System.out.println(part[i]);
        }
        System.out.println("AAAA");
        return part[0];
    }

    public void  D3(Graphics g) {
        //screen
        if(value.equals(" Never Settle")) {
            g.setColor(new Color(0x720404));
        }
        else {
            g.setColor(new Color(0x1E4C27));
        }
        g.fillRoundRect(52,50,400,60,30,30);
        g.setColor(Color.darkGray);
        //firstRow
        g.fillRoundRect(57,145,60,60,10,10);
        g.fillRoundRect(137,145,60,60,10,10);
        g.fillRoundRect(217,145,60,60,10,10);
        //secondRow
        g.fillRoundRect(57,245,60,60,10,10);
        g.fillRoundRect(137,245,60,60,10,10);
        g.fillRoundRect(217,245,60,60,10,10);
        //thirdRow
        g.fillRoundRect(57,345,60,60,10,10);
        g.fillRoundRect(137,345,60,60,10,10);
        g.fillRoundRect(217,345,60,60,10,10);
        //finalRow
        g.fillRoundRect(137,445,60,60,10,10);

        //symbol
        //row1
        g.fillRoundRect(297,145,60,60,10,10);
        g.fillRoundRect(377,145,60,60,10,10);
        //row2
        g.fillRoundRect(298,245,60,60,10,10);
        g.fillRoundRect(377,245,60,60,10,10);
        //row3
        g.fillRoundRect(297,345,60,60,10,10);
        //row4
        g.fillRoundRect(57,445,60,60,10,10);
        g.fillRoundRect(217,445,60,60,10,10);
        g.fillRoundRect(297,445,60,60,10,10);
        g.fillRoundRect(377,345,60,160,10,10);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD9) {
            num = '9';
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD8) {
            num = '8';
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD7) {
            num = '7';
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD6) {
            num = '6';
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD5) {
            num = '5';
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
            num = '4';
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD3) {
            num = '3';
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
            num = '2';
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
            num = '1';
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD0) {
            num = '0';
        }
        if(e.getKeyCode() == KeyEvent.VK_DECIMAL) {
            num = '.';
        }
        if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            num = 'c';
        }
        if(e.getKeyCode() == KeyEvent.VK_DIVIDE) {
            num = '÷';
        }
        if(e.getKeyCode() == KeyEvent.VK_DELETE) {
            num = 'a';
        }
        if(e.getKeyCode() == KeyEvent.VK_MULTIPLY) {
            num = 'x';
        }
        if(e.getKeyCode() == KeyEvent.VK_6 && e.isShiftDown()) {
            num = '^';
        }
        if(e.getKeyCode() == KeyEvent.VK_ADD) {
            num = '+';
        }
        if(e.getKeyCode() == KeyEvent.VK_SUBTRACT) {
            num = '-';
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            num = '=';
        }
    }
    @Override
    public void keyReleased(KeyEvent e) { }
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getY() <= 150+60 && e.getY() >= 150 && e.getX() <= 62+60 && e.getX() >= 62) {
            num = '7';
            onButton = 'z';
        }
        if(e.getY() <= 150+60 && e.getY() >= 150 && e.getX() <= 142+60 && e.getX() >= 142) {
            num = '8';
            onButton = 'z';
        }
        if(e.getY() <= 150+60 && e.getY() >= 150 && e.getX() <= 222+60 && e.getX() >= 222) {
            num = '9';
            onButton = 'z';
        }
        if(e.getY() <= 150+60 && e.getY() >= 150 && e.getX() <= 302+60 && e.getX() >= 302) {
            num = '÷';
            onButton = 'z';
        }
        if(e.getY() <= 150+60 && e.getY() >= 150 && e.getX() <= 382+60 && e.getX() >= 382) {
            num = 'a';
            onButton = 'z';
        }
        if(e.getY() <= 250+60 && e.getY() >= 250 && e.getX() <= 62+60 && e.getX() >= 62) {
            num = '4';
            onButton = 'z';
        }
        if(e.getY() <= 250+60 && e.getY() >= 250 && e.getX() <= 142+60 && e.getX() >= 142) {
            num = '5';
            onButton = 'z';
        }
        if(e.getY() <= 250+60 && e.getY() >= 250 && e.getX() <= 222+60 && e.getX() >= 222) {
            num = '6';
            onButton = 'z';
        }
        if(e.getY() <= 250+60 && e.getY() >= 250 && e.getX() <= 302+60 && e.getX() >= 302) {
            num = 'x';
            onButton = 'z';
        }
        if(e.getY() <= 250+60 && e.getY() >= 250 && e.getX() <= 382+60 && e.getX() >= 382) {
            num = '^';
            onButton = 'z';
        }
        if(e.getY() <= 350+60 && e.getY() >= 350 && e.getX() <= 62+60 && e.getX() >= 62) {
            num = '1';
            onButton = 'z';
        }
        if(e.getY() <= 350+60 && e.getY() >= 350 && e.getX() <= 142+60 && e.getX() >= 142) {
            num = '2';
            onButton = 'z';
        }
        if(e.getY() <= 350+60 && e.getY() >= 350 && e.getX() <= 222+60 && e.getX() >= 222) {
            num = '3';
            onButton = 'z';
        }
        if(e.getY() <= 350+60 && e.getY() >= 350 && e.getX() <= 302+60 && e.getX() >= 302) {
            num = '-';
            onButton = 'z';
        }
        if(e.getY() <= 450+60 && e.getY() >= 450 && e.getX() <= 62+60 && e.getX() >= 62) {
            num = '.';
            onButton = 'z';
        }
        if(e.getY() <= 450+60 && e.getY() >= 450 && e.getX() <= 142+60 && e.getX() >= 142) {
            num = '0';
            onButton = 'z';
        }
        if(e.getY() <= 450+60 && e.getY() >= 450 && e.getX() <= 222+60 && e.getX() >= 222) {
            num = 'c';
            onButton = 'z';
        }
        if(e.getY() <= 450+60 && e.getY() >= 450 && e.getX() <= 302+60 && e.getX() >= 302) {
            num = '+';
            onButton = 'z';
        }
        if(e.getY() <= 350+160 && e.getY() >= 350 && e.getX() <= 382+60 && e.getX() >= 382) {
            num = '=';
            onButton = 'z';
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getY() <= 150+60 && e.getY() >= 150 && e.getX() <= 62+60 && e.getX() >= 62) {
            onButton = '7';
        }
        if(e.getY() <= 150+60 && e.getY() >= 150 && e.getX() <= 142+60 && e.getX() >= 142) {
            onButton = '8';
        }
        if(e.getY() <= 150+60 && e.getY() >= 150 && e.getX() <= 222+60 && e.getX() >= 222) {
            onButton = '9';
        }
        if(e.getY() <= 150+60 && e.getY() >= 150 && e.getX() <= 302+60 && e.getX() >= 302) {
            onButton = '÷';
        }
        if(e.getY() <= 150+60 && e.getY() >= 150 && e.getX() <= 382+60 && e.getX() >= 382) {
            onButton = 'a';
        }
        if(e.getY() <= 250+60 && e.getY() >= 250 && e.getX() <= 62+60 && e.getX() >= 62) {
            onButton = '4';
        }
        if(e.getY() <= 250+60 && e.getY() >= 250 && e.getX() <= 142+60 && e.getX() >= 142) {
            onButton = '5';
        }
        if(e.getY() <= 250+60 && e.getY() >= 250 && e.getX() <= 222+60 && e.getX() >= 222) {
            onButton = '6';
        }
        if(e.getY() <= 250+60 && e.getY() >= 250 && e.getX() <= 302+60 && e.getX() >= 302) {
            onButton = 'x';
        }
        if(e.getY() <= 250+60 && e.getY() >= 250 && e.getX() <= 382+60 && e.getX() >= 382) {
            onButton = '^';
        }
        if(e.getY() <= 350+60 && e.getY() >= 350 && e.getX() <= 62+60 && e.getX() >= 62) {
            onButton = '1';
        }
        if(e.getY() <= 350+60 && e.getY() >= 350 && e.getX() <= 142+60 && e.getX() >= 142) {
            onButton = '2';
        }
        if(e.getY() <= 350+60 && e.getY() >= 350 && e.getX() <= 222+60 && e.getX() >= 222) {
            onButton = '3';
        }
        if(e.getY() <= 350+60 && e.getY() >= 350 && e.getX() <= 302+60 && e.getX() >= 302) {
            onButton = '-';
        }
        if(e.getY() <= 450+60 && e.getY() >= 450 && e.getX() <= 62+60 && e.getX() >= 62) {
            onButton = '.';
        }
        if(e.getY() <= 450+60 && e.getY() >= 450 && e.getX() <= 142+60 && e.getX() >= 142) {
            onButton = '0';
        }
        if(e.getY() <= 450+60 && e.getY() >= 450 && e.getX() <= 222+60 && e.getX() >= 222) {
            onButton = 'c';
        }
        if(e.getY() <= 450+60 && e.getY() >= 450 && e.getX() <= 302+60 && e.getX() >= 302) {
            onButton = '+';
        }
        if(e.getY() <= 350+160 && e.getY() >= 350 && e.getX() <= 382+60 && e.getX() >= 382) {
            onButton = '=';
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //first time entered in frame!
    }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseDragged(MouseEvent e) { }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(e.getY() <= 150+60 && e.getY() >= 150 && e.getX() <= 62+60 && e.getX() >= 62) {
            onButton = '7';
        }
        else if(e.getY() <= 150+60 && e.getY() >= 150 && e.getX() <= 142+60 && e.getX() >= 142) {
            onButton = '8';
        }
        else if(e.getY() <= 150+60 && e.getY() >= 150 && e.getX() <= 222+60 && e.getX() >= 222) {
            onButton = '9';
        }
        else if(e.getY() <= 150+60 && e.getY() >= 150 && e.getX() <= 302+60 && e.getX() >= 302) {
            onButton = '÷';
        }
        else if(e.getY() <= 150+60 && e.getY() >= 150 && e.getX() <= 382+60 && e.getX() >= 382) {
            onButton = 'a';
        }
        else if(e.getY() <= 250+60 && e.getY() >= 250 && e.getX() <= 62+60 && e.getX() >= 62) {
            onButton = '4';
        }
        else if(e.getY() <= 250+60 && e.getY() >= 250 && e.getX() <= 142+60 && e.getX() >= 142) {
            onButton = '5';
        }
        else if(e.getY() <= 250+60 && e.getY() >= 250 && e.getX() <= 222+60 && e.getX() >= 222) {
            onButton = '6';
        }
        else if(e.getY() <= 250+60 && e.getY() >= 250 && e.getX() <= 302+60 && e.getX() >= 302) {
            onButton = 'x';
        }
        else if(e.getY() <= 250+60 && e.getY() >= 250 && e.getX() <= 382+60 && e.getX() >= 382) {
            onButton = '^';
        }
        else if(e.getY() <= 350+60 && e.getY() >= 350 && e.getX() <= 62+60 && e.getX() >= 62) {
            onButton = '1';
        }
        else if(e.getY() <= 350+60 && e.getY() >= 350 && e.getX() <= 142+60 && e.getX() >= 142) {
            onButton = '2';
        }
        else if(e.getY() <= 350+60 && e.getY() >= 350 && e.getX() <= 222+60 && e.getX() >= 222) {
            onButton = '3';
        }
        else if(e.getY() <= 350+60 && e.getY() >= 350 && e.getX() <= 302+60 && e.getX() >= 302) {
            onButton = '-';
        }
        else if(e.getY() <= 450+60 && e.getY() >= 450 && e.getX() <= 62+60 && e.getX() >= 62) {
            onButton = '.';
        }
        else if(e.getY() <= 450+60 && e.getY() >= 450 && e.getX() <= 142+60 && e.getX() >= 142) {
            onButton = '0';
        }
        else if(e.getY() <= 450+60 && e.getY() >= 450 && e.getX() <= 222+60 && e.getX() >= 222) {
            onButton = 'c';
        }
        else if(e.getY() <= 450+60 && e.getY() >= 450 && e.getX() <= 302+60 && e.getX() >= 302) {
            onButton = '+';
        }
        else if(e.getY() <= 350+160 && e.getY() >= 350 && e.getX() <= 382+60 && e.getX() >= 382) {
            onButton = '=';
        }
        else {
            onButton = 'z';
        }
    }
}
 