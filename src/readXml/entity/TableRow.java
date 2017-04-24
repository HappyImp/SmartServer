package readXml.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kyluzoi
 * on 2017/4/24.
 * Email:kyluzoi@gmail.com
 */
@XStreamAlias("TableRow")
public class TableRow{
    @XStreamImplicit(itemFieldName="V")
    List<String> tableRow=new ArrayList<>();
    public TableRow()
    {
        tableRow.add("1");
        tableRow.add("1");
        tableRow.add("1");
        tableRow.add("1");
    }
}
