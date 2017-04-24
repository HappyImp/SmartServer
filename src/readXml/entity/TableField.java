package readXml.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Kyluzoi
 * on 2017/4/24.
 * Email:kyluzoi@gmail.com
 */
@XStreamAlias("TableField")
public class TableField {

    String Name="";//Name  zbbh
    String Desc=""; //Desc 装备编号
    String DataType=""; //DataType string
    String DataLen=""; //DataLen 20
    // TODO: 2017/4/24 boolean String 转换 0 1
    String IsRequired=""; //IsRequired 0


}
