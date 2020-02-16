package jp.co.win.app.disp;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import jp.co.win.app.disp.form.MainForm;

public class LunchApp {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainForm frame = new MainForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "アプリケーション実行時にエラーが発生しました。",
                            "エラー", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}
