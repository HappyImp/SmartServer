package readXml.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Kyluzoi
 * on 2017/4/24.
 * Email:kyluzoi@gmail.com
 */
public class Update {
    @XStreamAlias("TableRow")
    TableRow tableRow=new TableRow();

    public TableRow getTableRow() {
        return tableRow;
    }

    public void setTableRow(TableRow tableRow) {
        this.tableRow = tableRow;
    }
}
