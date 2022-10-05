package com.baidu.translate;

import com.baidu.translate.data.Config;
import com.baidu.translate.doc.DocTranslate;
import com.baidu.translate.http.HttpStringCallback;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//按钮监听器的父类ActionListener里面有函数可以直接检测按钮是否被点击
public class ButListener implements ActionListener {
    //定义JTextFieldb变量jt,用来保存传递过来的文本框对象
    private JTextField jtp;

    private JTextField jt;
    private JTextField jt2;

    //定义set方法，初始化jt
    public void setJt(JTextField jtp,JTextField jt,JTextField jt2){
        this.jtp= jtp;
        this.jt = jt;
        this.jt2=jt2;
    }

    public void actionPerformed(ActionEvent e) {
        Const.FILE_PATH = jtp.getText();

        Const.SOURCE_LANGUAGE = jt.getText();
        Const.TARGET_LANGUAGE = jt2.getText();

        Config config = new Config(Const.APPID, Const.SECRET_KEY);
        config.lang(Const.SOURCE_LANGUAGE, Const.TARGET_LANGUAGE);
        config.file(Const.FILE_PATH);

        DocTranslate docTranslate = new DocTranslate();
        docTranslate.setConfig(config);

        docTranslate.docTrans(new HttpStringCallback() {
            @Override
            protected void onSuccess(String response) {
                super.onSuccess(response);
                String res=response.substring(15,20);
                Internet gourl = new Internet();
                gourl.gotourl();
                if("2000,".equals(res)) {
                    JOptionPane.showMessageDialog(null, "结果：" + "翻译成功，请前往“http://api.fanyi.baidu.com/api/trans/product/desktop”查看翻译结果", "提示：", JOptionPane.PLAIN_MESSAGE);
                }
                else if("52001".equals(res)){
                    JOptionPane.showMessageDialog(null, "结果：" + "请求超时，请检查网络连接", "提示：", JOptionPane.PLAIN_MESSAGE);
                }
                else if("52002".equals(res)){
                    JOptionPane.showMessageDialog(null, "结果：" + "服务器错误", "提示：", JOptionPane.PLAIN_MESSAGE);
                }
                else if("52003".equals(res)){
                    JOptionPane.showMessageDialog(null, "结果：" + "未授权的APPID，请前往“http://api.fanyi.baidu.com/api/trans/product/desktop”查看并开通文档翻译服务", "提示：", JOptionPane.PLAIN_MESSAGE);
                }
                else if("54003".equals(res)){
                    JOptionPane.showMessageDialog(null, "结果：" + "服务器忙，请稍后再试", "提示：", JOptionPane.PLAIN_MESSAGE);
                }
                else if("54004".equals(res)){
                    JOptionPane.showMessageDialog(null, "结果：" + "账户余额不足", "提示：", JOptionPane.PLAIN_MESSAGE);
                }
                else if("54010".equals(res)){
                    JOptionPane.showMessageDialog(null, "结果：" + "预扣余额不足", "提示：", JOptionPane.PLAIN_MESSAGE);
                }
                else if("58000".equals(res)){
                    JOptionPane.showMessageDialog(null, "结果：" + "非法的APPID，请前往“http://api.fanyi.baidu.com/api/trans/product/desktop”核对您的APPID和密钥", "提示：", JOptionPane.PLAIN_MESSAGE);
                }
                else if("70201".equals(res)){
                    JOptionPane.showMessageDialog(null, "结果：" + "找不到文件信息", "提示：", JOptionPane.PLAIN_MESSAGE);
                }
                else if("70203".equals(res)){
                    JOptionPane.showMessageDialog(null, "结果：" + "上传文件大小受限", "提示：", JOptionPane.PLAIN_MESSAGE);
                }
                else if("70206".equals(res)){
                    JOptionPane.showMessageDialog(null, "结果：" + "文件类型不支持", "提示：", JOptionPane.PLAIN_MESSAGE);
                }
                else if("70207".equals(res)){
                    JOptionPane.showMessageDialog(null, "结果：" + "文件内容无法翻译", "提示：", JOptionPane.PLAIN_MESSAGE);
                }
                else if("54009".equals(res)){
                    JOptionPane.showMessageDialog(null, "结果：" + "只支持中文（zh）、英文（en）、日语（jp）、韩语（kor）的翻译，请检查您的语言设置是否正确", "提示：", JOptionPane.PLAIN_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "结果：" + "未知错误，错误代码："+res, "提示：", JOptionPane.PLAIN_MESSAGE);
                }

            }

            @Override
            protected void onFailure(Throwable e) {
                super.onFailure(e);
            }
        });
    }
}