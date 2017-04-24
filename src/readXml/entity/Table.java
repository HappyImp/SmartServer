package readXml.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kyluzoi
 * on 2017/4/24.
 * Email:kyluzoi@gmail.com
 */
public class Table {

    @XStreamAlias("TableFields")
    List<TableField> tableFields=new ArrayList<>();
    @XStreamAlias("TableRows")
    TableRows tableRows=new TableRows();

    // FIXME: 2017/4/24 测试构造
    public Table()
    {
        tableFields.add(new TableField());
        tableFields.add(new TableField());
    }

    public List<TableField> getTableFields() {
        return tableFields;
    }

    public void setTableFields(List<TableField> tableFields) {
        this.tableFields = tableFields;
    }

    public TableRows getTableRows() {
        return tableRows;
    }

    public void setTableRows(TableRows tableRows) {
        this.tableRows = tableRows;
    }
}
