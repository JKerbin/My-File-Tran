package com.baidu.translate;

import javax.swing.*;

public class Mpage extends JFrame {
    public Mpage(){
//      ZH = "zh";
//      EN = "en";
//      JP = "jp";
//      KOR = "kor";
        javax.swing.JFrame jf= new javax.swing.JFrame();
        jf.setTitle("文档翻译器 2.01");
        jf.setSize(300,260);
        jf.setDefaultCloseOperation(3);
        jf.setLocationRelativeTo(null);

        java.awt.FlowLayout flow=new java.awt.FlowLayout();
        jf.setLayout(flow);

        javax.swing.JLabel Lpath = new JLabel("文件路径：");
        jf.add(Lpath);
        javax.swing.JTextField jtfp=new javax.swing.JTextField();
        java.awt.Dimension dmp=new java.awt.Dimension(280,30);
        jtfp.setPreferredSize(dmp);
        jf.add(jtfp);

        javax.swing.JLabel jLabel = new JLabel("源语言：");
        jf.add(jLabel);
        javax.swing.JTextField jtf=new javax.swing.JTextField();
        java.awt.Dimension dm1=new java.awt.Dimension(280,30);
        jtf.setPreferredSize(dm1);
        jf.add(jtf);

        javax.swing.JLabel jLabel2 = new JLabel("目标语言：");
        jf.add(jLabel2);
        javax.swing.JTextField jtf2=new javax.swing.JTextField();
        java.awt.Dimension dm2=new java.awt.Dimension(280,30);
        jtf2.setPreferredSize(dm2);
        jf.add(jtf2);

        javax.swing.JButton jbu = new javax.swing.JButton("提交");
        java.awt.Dimension dm3=new java.awt.Dimension(80,30);
        jbu.setPreferredSize(dm3);
        jf.add(jbu);

        ButListener but = new ButListener();
        //创建一个监听器
        jbu.addActionListener(but);
        //把监听器加在“提交”按钮上
        but.setJt(jtfp,jtf,jtf2);

        jf.setVisible(true);
    }
}
