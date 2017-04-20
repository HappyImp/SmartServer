import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by Kyluzoi
 * on 2017/4/20.
 * Email:kyluzoi@gmail.com
 */
public class SocketApplication {
    public static void main(String[] args)
    {
        BufferedReader strin=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入一个字符串：");
        try {
            String str = strin.readLine();
            System.out.println(str);
            new MyThread(str).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static String buffer;
    public static class MyThread extends Thread
    {
        String text="";
        public MyThread(String message){
            text=message;
        }
        @Override
        public void run() {
            super.run();
            //连接服务器 并设置连接超时为5秒
            try {
                Socket socket=new Socket();
                socket.connect(new InetSocketAddress("169.254.204.30", 27027), 5000);

                //获取输入输出流
                OutputStream ou = socket.getOutputStream();

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //读取发来服务器信息
                String line = null;
                buffer="";
                while ((line = in.readLine()) != null) {
                    buffer = line + buffer;
                    System.out.println(buffer);
                }

                //向服务器发送信息
                ou.write("android 客户端".getBytes("utf-8"));
                ou.flush();
                //关闭各种输入输出流
                in.close();
                ou.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("连接超时");
            }
        }
    }
}
