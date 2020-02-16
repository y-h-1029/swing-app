package jp.co.win.app.convert.logic.writer;

import javax.xml.bind.JAXB;

import jp.co.win.app.convert.bean.Configuration;

public class XmlWriter {

	public static void writeToXml(Object obj, String outPath) throws Exception {

	    try {
    		if (obj instanceof Configuration) {
    			Configuration tmp = (Configuration) obj;
    			JAXB.marshal(tmp, outPath);
    		}
	    } catch (Exception e) {
	        throw new Exception("XMLファイルの書き込みに失敗しました。");
	    }
	}

}
