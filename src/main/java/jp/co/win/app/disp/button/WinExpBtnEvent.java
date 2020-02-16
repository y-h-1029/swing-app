package jp.co.win.app.disp.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class WinExpBtnEvent implements ActionListener {

    /** ボタンインスタンス */
    private JButton btnNewButton;

    /** ボタンとセットの場合テキストフィールド */
    private JTextField textNewField;

    @SuppressWarnings("unused")
    private WinExpBtnEvent() {}

    /**
     * コンストラクタ（ボタンとテキストフィールド）
     * @param btnInstance
     * @param textField
     */
    public WinExpBtnEvent(JButton btnInstance, JTextField textField) {
        this.btnNewButton = btnInstance;
        this.textNewField = textField;
    }

    /**
     * コンストラクタ（ボタンのみ）
     * @param btnInstance
     */
    public WinExpBtnEvent(JButton btnInstance) {
        this.btnNewButton = btnInstance;
    }

    /**
     * イベントメイン部品
     */
    public void callWinExp() {
        this.btnNewButton.addActionListener(this);
    }

    /**
     * イベント内容
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChr = new JFileChooser();

        // ダイアログオープン
        int selected = fileChr.showOpenDialog(null);
        if (selected == JFileChooser.ERROR_OPTION) {
            // ファイル選択でエラーが起きた場合
            JOptionPane.showMessageDialog(null, "ファイル選択時にエラーが発生しました。",
                    "エラー", JOptionPane.ERROR_MESSAGE);
        } else if (selected == JFileChooser.APPROVE_OPTION) {
            // ファイルを取得
            File file = fileChr.getSelectedFile();
            this.textNewField.setText(file.getAbsolutePath());
        }
    }

}
