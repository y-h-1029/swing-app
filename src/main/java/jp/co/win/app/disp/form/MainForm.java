package jp.co.win.app.disp.form;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import jp.co.win.app.disp.button.ConvertBtnEvent;
import jp.co.win.app.disp.button.WinExpBtnEvent;

public class MainForm extends JFrame {

    private JPanel contentPane;

    private SpringLayout sl_contentPane;

    /**
     * Create the frame.
     */
    public MainForm() {

        // JFrame初期化
        initJFrame();

        // ヘッダ
        setHeader();

    }

    /**
     * メインフォーム→ヘッダ設定メソッド
     * @param sl_contentPane レイアウトが設定されたJPanel
     */
    private void setHeader() {

        // ラベル
        JLabel lblNewLabel = new JLabel("変換種別");
        sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 5, SpringLayout.WEST, contentPane);
        contentPane.add(lblNewLabel);

        // ラジオボタン（Excel→XML）
        JRadioButton rdbtnExcelToXml = new JRadioButton("Excel To Xml", true);
        sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 4, SpringLayout.NORTH, rdbtnExcelToXml);
        sl_contentPane.putConstraint(SpringLayout.NORTH, rdbtnExcelToXml, 5, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnExcelToXml, 88, SpringLayout.WEST, contentPane);
        contentPane.add(rdbtnExcelToXml);
        // ラジオボタン（XML→Excel）
        JRadioButton rdbtnXmlToExcel = new JRadioButton("Xml To Excel");
        sl_contentPane.putConstraint(SpringLayout.NORTH, rdbtnXmlToExcel, 5, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnXmlToExcel, 216, SpringLayout.WEST, contentPane);
        contentPane.add(rdbtnXmlToExcel);

        // ボタングループ生成
        ButtonGroup btnGrp = new ButtonGroup();
        btnGrp.add(rdbtnExcelToXml);
        btnGrp.add(rdbtnXmlToExcel);

        // テキストフィールド（ファイルパス入力）
        JTextField textField = new JTextField();
        textField.setToolTipText("");
        sl_contentPane.putConstraint(SpringLayout.WEST, textField, 5, SpringLayout.WEST, contentPane);
        contentPane.add(textField);
        textField.setColumns(10);

        // Windowsエクスプローラ呼び出しボタン
        JButton btnNewButton = new JButton("参照");
        sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 1, SpringLayout.NORTH, btnNewButton);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, textField, 22, SpringLayout.NORTH, btnNewButton);
        sl_contentPane.putConstraint(SpringLayout.EAST, textField, -11, SpringLayout.WEST, btnNewButton);
        sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 57, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, contentPane);

        // Windowsエクスプローラ呼び出しイベント
        WinExpBtnEvent winExpBtnEvt = new WinExpBtnEvent(btnNewButton, textField);
        winExpBtnEvt.callWinExp();
        contentPane.add(btnNewButton);

        // 変換ボタン
        JButton chgBtn = new JButton("変換実行");
        sl_contentPane.putConstraint(SpringLayout.NORTH, chgBtn, 41, SpringLayout.SOUTH, textField);
        sl_contentPane.putConstraint(SpringLayout.WEST, chgBtn, 147, SpringLayout.WEST, contentPane);

        // 変換ボタン呼び出しイベント
        ConvertBtnEvent convEvt = new ConvertBtnEvent(chgBtn, textField);
        convEvt.callConvert();
        contentPane.add(chgBtn);
    }

    /**
     * メインフォーム→フレーム及びレイアウト設定メソッド
     */
    private void initJFrame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        sl_contentPane = new SpringLayout();
        contentPane.setLayout(sl_contentPane);
    }
}
