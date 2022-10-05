package com.baidu.translate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    private JButton Start;
    private JButton Link;

    private JTextField jtid;
    private JTextField jtpw;

    public void setJt(JTextField jtid,JTextField jtpw){
        this.jtid=jtid;
        this.jtpw=jtpw;
    }

    public Main(){
        setLayout(new FlowLayout());
        this.setTitle("欢迎使用文档翻译器");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(300,200);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);

        javax.swing.JLabel LID = new JLabel("APP ID：");
        this.add(LID);
        javax.swing.JTextField jtfid=new javax.swing.JTextField();
        java.awt.Dimension dmid=new java.awt.Dimension(280,30);
        jtfid.setPreferredSize(dmid);
        this.add(jtfid);

        javax.swing.JLabel LPW = new JLabel("密钥：");
        this.add(LPW);
        javax.swing.JTextField jtfpw=new javax.swing.JTextField();
        java.awt.Dimension dmpw=new java.awt.Dimension(280,30);
        jtfpw.setPreferredSize(dmpw);
        this.add(jtfpw);

        Start = new JButton("登录");
        Link = new JButton("注册");

        this.add(Start);
        java.awt.Dimension dm3=new java.awt.Dimension(80,30);
        Start.setPreferredSize(dm3);

        this.add(Link);
        Link.setPreferredSize(dm3);

        Start.addActionListener(this);
        Link.addActionListener(this);
        this.setJt(jtfid,jtfpw);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        Main menu = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Start) {
            Const.APPID = jtid.getText();
            Const.SECRET_KEY = jtpw.getText();
            this.dispose();
            new Mpage();
        }
        else{
            //进入百度翻译API主页
            Internet gourl = new Internet();
            gourl.gotourl();
        }
    }
}
