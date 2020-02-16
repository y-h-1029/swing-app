package jp.co.win.app.convert.logic.writer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.gh.mygreen.xlsmapper.XlsMapper;

import jp.co.win.app.convert.bean.Configuration;

public class ExelWriter {

	public static void writeXlsx(String tmpFilePath, String dstFilePath, Configuration config) throws Exception {

		try (FileInputStream fis = new FileInputStream(new File(tmpFilePath));
				FileOutputStream fos = new FileOutputStream(new File(dstFilePath))) {

			XlsMapper mapper = new XlsMapper();
			mapper.save(fis, fos, config);
		} catch (Exception e) {
		    throw new Exception("Excelファイルの書き込みに失敗しました。");
		}
	}
}
