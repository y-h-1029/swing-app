package jp.co.win.app.convert.logic.reader;

import java.io.File;
import java.io.FileInputStream;

import com.gh.mygreen.xlsmapper.XlsMapper;

import jp.co.win.app.convert.bean.Configuration;

/**
 * Excelファイルリーダクラス
 * 「.xlsx」ファイルを読み込む
 */
public class ExcelFileReader {

    /**
     * xlsxのファイル読み込み
     * @param path
     * @return
     * @throws Exception
     */
	public static Configuration readXlsx(String path) throws Exception {
		XlsMapper mapper = new XlsMapper();
		Configuration config = null;
		try(FileInputStream fis = new FileInputStream(new File(path))) {
			config = mapper.load(fis, Configuration.class);
		} catch (Exception e) {
		    throw new Exception("Excelファイルの読込に失敗しました。");
		}
		return config;
	}
}
