package jp.co.win.app.disp.define;

import lombok.Getter;

public enum ResultType {

    SUCCESS("成功", 0),
    FAILD("失敗", 1),
    WARNING("警告", 2);

    /** 名前 */
    @Getter
    private final String name;
    /** コード */
    @Getter
    private final int code;

    private ResultType(String name, int code) {
        this.name = name;
        this.code = code;
    }
}
