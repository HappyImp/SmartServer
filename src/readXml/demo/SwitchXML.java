package readXml.demo;

import com.thoughtworks.xstream.XStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import readXml.entity.DataPackage;

/**
 * Created by Kyluzoi
 * on 2017/4/24.
 * Email:kyluzoi@gmail.com
 */
public class SwitchXML
{
    /*
         * XStream 不关心序列化/逆序列化的类的字段的可见性。
         *
         * 序列化/逆序列化类的字段不需要 getter 和 setter 方法。
         *
         * 序列化/逆序列化的类不需要有默认构造函数。
         */
    private static XStream xStream = new XStream();

    private static String  xmlPath = "D:/userdata.xml";

    // 1. obj -> xml(object类型转换为xml类型)
    public String printXML(Object user) {
        System.out.println("obj -> xml");
        String xml = xStream.toXML(user);
        System.out.println(xml);
        return xml;
    }

    // 2. xml->obj(xml类型转换为object类型，并打印)
    public void printObj(String xml) {
        System.out.println("xml -> obj");
        DataPackage u = (DataPackage) xStream.fromXML(xml);
//        System.out.println(u.getUserName() + " " + u.getPassWord() + " " + u.getRegisteredTime());
    }

    // 3. 将object类型转换为xml类型，并写入XML文件(其他格式也可以，比如txt文件)
    public void writerXML(Object user) {
        try {
            FileOutputStream fs = new FileOutputStream(xmlPath);
            xStream.toXML(user, fs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 4. 读取XML文件，加载进相应Object类型
    public void readerXML() {
        DataPackage user = new DataPackage();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(xmlPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        xStream.fromXML(fis, user);
        // 打印对象信息
        System.out.println(user.toString());
        // 打印对象的属性值
//        System.out.println(user.getUserName() + "-" + user.getPassWord() + "-"
//                + user.getRegisteredTime());
    }

    public static void main(String[] args) {
        // 注册时间
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String registeredtime = format.format(now);

        DataPackage data=new DataPackage();
        SwitchXML switchXML = new SwitchXML();
        xStream.autodetectAnnotations(true);//使注解生效

        // 1. object类型转换为xml类型，在控制台打印
        String xml = switchXML.printXML(data);
        System.out.println("---------------------");
        // 2. xml类型转换为object类型，在控制台打印
//        switchXML.printObj(xml);
        System.out.println("---------------------");
        // 3. 将object类型转换为xml类型，并写入XML文件
        switchXML.writerXML(data);
        System.out.println("---------------------");
        // 4. 读取XML文件，加载进相应Object类型
//        switchXML.readerXML();

    }

}


