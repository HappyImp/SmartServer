package readXml.entity;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Created by Kyluzoi
 * on 2017/4/24.
 * Email:kyluzoi@gmail.com
 */
public class Head {

    @XStreamOmitField
    String mElementsName = "Head";

    String FromID=""; //发送方ID
    String ToID="";  //接收方ID
    String Fsdw="";  //发送方单位1
    String Jsdw="";  //接收方单位1
    String MsgNum="";  //JDZBSJ
    String MsgType="";  //DYSY
    String MsgID="";  //消息名称1
    String MsgName="";  //更新机制1
    String MsgDesc="";  //消息描述1
    String SubmitTime="";  //2017.04.05 15:06:46
    String Bz="";  //xxxx

    public String getFromID() {
        return FromID;
    }

    public void setFromID(String fromID) {
        FromID = fromID;
    }

    public String getToID() {
        return ToID;
    }

    public void setToID(String toID) {
        ToID = toID;
    }

    public String getFsdw() {
        return Fsdw;
    }

    public void setFsdw(String fsdw) {
        Fsdw = fsdw;
    }

    public String getJsdw() {
        return Jsdw;
    }

    public void setJsdw(String jsdw) {
        Jsdw = jsdw;
    }

    public String getMsgNum() {
        return MsgNum;
    }

    public void setMsgNum(String msgNum) {
        MsgNum = msgNum;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getMsgID() {
        return MsgID;
    }

    public void setMsgID(String msgID) {
        MsgID = msgID;
    }

    public String getMsgName() {
        return MsgName;
    }

    public void setMsgName(String msgName) {
        MsgName = msgName;
    }

    public String getMsgDesc() {
        return MsgDesc;
    }

    public void setMsgDesc(String msgDesc) {
        MsgDesc = msgDesc;
    }

    public String getSubmitTime() {
        return SubmitTime;
    }

    public void setSubmitTime(String submitTime) {
        SubmitTime = submitTime;
    }

    public String getBz() {
        return Bz;
    }

    public void setBz(String bz) {
        Bz = bz;
    }
}