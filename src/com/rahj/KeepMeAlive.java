/**
 * KeepMeAlive package to keep your computer awake and never idle
 *
 * September 23, 2020
 * by Reynaldo A. Hipolito
 */
package com.rahj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicBoolean;

public class KeepMeAlive implements ActionListener
{
    private Robot hal;
    private JFrame frame;
    private JPanel rootPanel;
    private JButton buttonEnableDisable;
    private JMenuBar menubar;
    private JMenu fileMenu;
    private JMenu aboutMenu;
    private JMenuItem menuItemClose;
    private JMenuItem menuItemAuthor;
    private Image icon;
    private AtomicBoolean atomicBoolean;
    private RobotThread robotThread = new RobotThread(20);

    public KeepMeAlive()
    {
        //set the root panel
        this.rootPanel = new JPanel();
        this.rootPanel.setLayout(null);

        //set the menubar
        this.menubar = new JMenuBar();

        //set the menus
        this.fileMenu = new JMenu("File");
        this.aboutMenu = new JMenu("About");
        this.menubar.add(this.fileMenu);
        this.menubar.add(this.aboutMenu);

        //set the menu items
        this.menuItemClose = new JMenuItem("Close");
        this.menuItemAuthor = new JMenuItem("Author");
        this.fileMenu.add(this.menuItemClose);
        this.aboutMenu.add(this.menuItemAuthor);

        //set the button enable disable
        this.buttonEnableDisable = new JButton("Enable");
        this.buttonEnableDisable.setBounds(100, 45, 200, 50);
        this.buttonEnableDisable.setFont(new Font("arial", Font.PLAIN, 20));
        this.rootPanel.add(this.buttonEnableDisable);

        //set image icon
        this.icon = Toolkit.getDefaultToolkit().getImage("c:\\java\\icons\\images\\heart_beating.png");

        //set the frame
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setTitle("RAHJ KeepMeAlive v.1");
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);
        this.frame.setContentPane(this.rootPanel);
        this.frame.setJMenuBar(this.menubar);
        this.frame.setIconImage(this.icon);
        this.frame.pack();
        this.frame.setSize(400, 200);
        this.frame.setVisible(true);

        //set the button boolean default to true
        this.atomicBoolean = new AtomicBoolean();
        this.atomicBoolean.set(true);

        //add button action listener
        this.buttonEnableDisable.addActionListener(this);

        //set the menu actions
        this.menuItemClose.addActionListener(this);
        this.menuItemAuthor.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String actionCommand = e.getActionCommand();

        switch (actionCommand) {
            case "Enable":
                this.buttonEnableDisable.setText("Disable");

                //run the background thread
                this.robotThread.start();
                break;
            case "Disable":
                this.buttonEnableDisable.setText("Enable");

                //stop the background thread
                this.robotThread.stop();
                break;
            case "Close":
                System.exit(0);
                break;
            case "Author":
                String author = "Reynaldo A. Hipolito \r\n" +
                        "Copyright © 2020 \r\n" +
                        "rahj.1986@gmail.com \r\n";
                JOptionPane.showMessageDialog(this.frame, author, "Author", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                break;
        }

    }

}
