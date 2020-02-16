package jp.co.win.app.convert.logic;

import jp.co.win.app.convert.bean.Configuration;
import jp.co.win.app.disp.define.ResultType;

public class ConvertExecute {

    public static ResultType execute(String path) {

        // 処理結果
        ResultType result = ResultType.SUCCESS;
        Configuration config = null;
        try {
        } catch (Exception e) {
            result = ResultType.FAILD;
        }

        return result;
    }
}
