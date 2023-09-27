package com.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyWindow extends JFrame {

    private JLabel heading;
    private JLabel clockLabel;
    private Font font = new Font("", Font.BOLD, 35);

    MyWindow() {
        super.setTitle("MY CLOCK");
        super.setSize(400, 400);
        super.setLocation(300, 500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation
        this.createGUI();
        this.startclock();
        super.setVisible(true);
    }

    public void createGUI() {
        //gui
        heading = new JLabel("MY CLOCK");
        clockLabel = new JLabel("clock");
        heading.setFont(font);
        clockLabel.setFont(font);

        this.setLayout(new GridLayout(2, 1));
        this.add(heading);
        this.add(clockLabel);

    }

    public void startclock() {
        //   Timer timer=new Timer(1000, new ActionListener() {
        //      @Override
        //      public void actionPerformed(ActionEvent e) {
        // String dateTim=new Date().toString();

        //String dateTim=new Date().toLocaleString();
        //Date d=new Date();
        //SimpleDateFormat sfd=new SimpleDateFormat("hh:mm:ss a - y");

        // String dateTime=sfd.format(d);


        // clockLabel.setText(dateTime);
        //    }
        //  });

       // timer.start();

        Thread t = new Thread() {
            public void run() {
                try {
                    while (true) {
                        Date d = new Date();
                        SimpleDateFormat sfd = new SimpleDateFormat("hh:mm:ss a - y");

                        String dateTime = sfd.format(d);


                        clockLabel.setText(dateTime);
                        Thread.currentThread().sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();

    }
}