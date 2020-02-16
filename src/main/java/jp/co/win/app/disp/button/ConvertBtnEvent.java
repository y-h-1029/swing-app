package jp.co.win.app.disp.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.commons.lang.StringUtils;

import jp.co.win.app.convert.logic.ConvertExecute;
import jp.co.win.app.disp.define.ResultType;

public class ConvertBtnEvent implements ActionListener {

    /** ボタンインスタンス */
    private JButton btnNewButton;

    /** ボタンとセットの場合テキストフィールド */
    private JTextField textNewField;

    /** 処理結果 */
    private ResultType resultType;

    @SuppressWarnings("unused")
    private ConvertBtnEvent() {}

    /**
     * コンストラクタ（ボタンのみ）
     * @param btnInstance
     */
    public ConvertBtnEvent(JButton btnInstance) {
        this.btnNewButton = btnInstance;
    }

    /**
     * コンストラクタ（ボタンとテキストフィールド）
     * @param btnInstance
     * @param textField
     */
    public ConvertBtnEvent(JButton btnInstance, JTextField textField) {
        this.btnNewButton = btnInstance;
        this.textNewField = textField;
    }

    /**
     * イベントメイン部品
     */
    public void callConvert() {
        this.btnNewButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // テキストフィールドの入力チェック
        if (StringUtils.isEmpty(this.textNewField.getText())) {
            JOptionPane.showMessageDialog(null, "変換対象のファイルを選択して下さい。",
                    "警告", JOptionPane.WARNING_MESSAGE);
        } else {
            resultType = ConvertExecute.execute(this.textNewField.getText());
        }

        if (ResultType.FAILD.equals(resultType)) {
            // 変換時エラーダイアログ
            JOptionPane.showMessageDialog(null, "変換処理に失敗しました。",
                    "エラー", JOptionPane.ERROR_MESSAGE);
        }
    }

}
