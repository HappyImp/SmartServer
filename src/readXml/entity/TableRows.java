package readXml.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Kyluzoi
 * on 2017/4/24.
 * Email:kyluzoi@gmail.com
 */
@XStreamAlias("TableRows")
public class TableRows {
    @XStreamAlias("Update")
    Update updat=new Update();

    public Update getUpdat() {
        return updat;
    }

    public void setUpdat(Update updat) {
        this.updat = updat;
    }
}
