package readXml.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Created by Kyluzoi
 * on 2017/4/24.
 * Email:kyluzoi@gmail.com
 */
@XStreamAlias("DataPackage")
public class DataPackage {
    @XStreamOmitField
    String mElementsName="DataPackage";

    @XStreamAlias("Head")
    Head head=new Head();

    @XStreamAlias("TablePackage")
    TablePackage tablePackage=new TablePackage();

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public TablePackage getTablePackage() {
        return tablePackage;
    }

    public void setTablePackage(TablePackage tablePackage) {
        this.tablePackage = tablePackage;
    }
}
