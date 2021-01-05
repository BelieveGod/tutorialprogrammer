package me.believeGod.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName Example14
 * @Description GUI程序实力
 * @Author Tim
 * @Date 2020/6/8 10:41
 * @Version 1.0
 */
public class Example18 extends JFrame {
    private JButton sendBt;
    private JTextField inputFiled;
    private JTextArea chatContent;

    public Example18(){
        this.setLayout(new BorderLayout());
        chatContent=new JTextArea(12,34);
        // 创建一个滚动面板，将文本域作为显示组件
        JScrollPane showPanel=new JScrollPane(chatContent);
        chatContent.setEditable(false);
        JPanel inputPanel = new JPanel();
        inputFiled = new JTextField(20);
        sendBt = new JButton("发送");
        sendBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String content=inputFiled.getText();
                if(content !=null && !content.trim().equals("")){
                    chatContent.append("本人："+content+"\n");
                }
                else{
                    chatContent.append("聊天消息不能为空\n");
                }
                inputFiled.setText("");
            }
        });

        JLabel label=new JLabel("聊天消息");
        inputPanel.add(label);
        inputPanel.add(inputFiled);
        inputPanel.add(sendBt);

        this.add(showPanel,BorderLayout.CENTER);
        this.add(inputPanel, BorderLayout.SOUTH);
        this.setTitle("聊天窗口");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Example18();
    }
}
