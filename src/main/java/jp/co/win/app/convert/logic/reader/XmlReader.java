package jp.co.win.app.convert.logic.reader;

import java.io.File;

import javax.xml.bind.JAXB;

import jp.co.win.app.convert.bean.Configuration;

public class XmlReader {

    /**
     * xmlファイル読み込み処理
     * @param path
     * @return
     * @throws Exception
     */
	public static Configuration readXml(String path) throws Exception {
		Configuration config = null;
		try {
			File xml = new File(path);
			config = JAXB.unmarshal(xml, Configuration.class);
		} catch (Exception e) {
		    throw new Exception("Xmlファイルの読込に失敗しました。");
		}

		return config;
	}
}
