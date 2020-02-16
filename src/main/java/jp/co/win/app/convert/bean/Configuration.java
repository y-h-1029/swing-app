package jp.co.win.app.convert.bean;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.gh.mygreen.xlsmapper.annotation.LabelledCellType;
import com.gh.mygreen.xlsmapper.annotation.RecordTerminal;
import com.gh.mygreen.xlsmapper.annotation.XlsCell;
import com.gh.mygreen.xlsmapper.annotation.XlsColumn;
import com.gh.mygreen.xlsmapper.annotation.XlsHorizontalRecords;
import com.gh.mygreen.xlsmapper.annotation.XlsIgnorable;
import com.gh.mygreen.xlsmapper.annotation.XlsLabelledCell;
import com.gh.mygreen.xlsmapper.annotation.XlsRecordOption;
import com.gh.mygreen.xlsmapper.annotation.XlsRecordOption.OverOperation;
import com.gh.mygreen.xlsmapper.annotation.XlsSheet;
import com.gh.mygreen.xlsmapper.annotation.XlsSheetName;
import com.gh.mygreen.xlsmapper.util.IsEmptyBuilder;

import lombok.Data;

@Data
@XlsSheet(name="Configuration")
@XmlRootElement(name="configuration")
@XmlType(propOrder={"sheetName", "title", "createDate", "author", "configName", "remarks", "itemInfo"})
public class Configuration {

	@XlsSheetName
	private String sheetName;

	/** title */
	@XlsCell(column=0, row=0)
	private String title;

	@XlsLabelledCell(label="作成日", type=LabelledCellType.Bottom)
	private String createDate;

	@XlsLabelledCell(label="作成者", type=LabelledCellType.Bottom)
	private String author;

	@XlsLabelledCell(label="定義名", type=LabelledCellType.Right)
	private String configName;

	@XlsLabelledCell(label="備考", type=LabelledCellType.Right)
	private String remarks;

	@XlsHorizontalRecords(headerAddress = "A9", terminal=RecordTerminal.Border)
	@XlsRecordOption(overOperation = OverOperation.Copy)
	private List<DataRecord> itemInfo;

	@Data
	public static class DataRecord implements Serializable {

		@XlsColumn(columnName="ＮＯ．")
		private String no;

		@XlsColumn(columnName="項目和名")
		private String itemNameJa;

		@XlsColumn(columnName="項目英名")
		private String itemNameEn;

		@XlsColumn(columnName="データ型")
		private String javaType;

		@XlsColumn(columnName="説明")
		private String dataRemarks;

		// 空レコードを読み飛ばす処理
		@XlsIgnorable
		public boolean isEmpty() {
			return IsEmptyBuilder.reflectionIsEmpty(no, "itemNameJa", "itemNameEn", "javaType", "dataRemarks");
		}
	}
}
