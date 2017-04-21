import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by Kyluzoi
 * on 2017/4/20.
 * Email:kyluzoi@gmail.com
 */
public class SocketApplication {
    public static void main(String[] args) {
        BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入一个字符串：");
        try {
            String str = strin.readLine();
            new MyThread(str).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static String buffer;

    public static class MyThread extends Thread {
        String text = "";

        public MyThread(String message) {
            text = message;
        }

        @Override
        public void run() {
            super.run();
            //连接服务器 并设置连接超时为5秒
            InputStream inputStream;
            OutputStream outputStream;
            Socket socket = new Socket();
            try {
                socket.connect(new InetSocketAddress("47.93.63.29", 27027), 5000);

                //获取输入输出流
                outputStream = socket.getOutputStream();
                inputStream = socket.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                PrintWriter bufferedWriter = new PrintWriter(outputStream, true);
                //读取发来服务器信息
                buffer = "";

                //向服务器发送信息

                while (true) {
                    String line = null;
                    BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
                    System.out.print("请输入一个字符串：");
                    String str = strin.readLine();
//                    if (!str.equals("") && str != null)
                    bufferedWriter.println(str);//向客户端输出数据
                    line = bufferedReader.readLine();//读取客户端传来的数据
                    if (line == null)
                        break;
                    System.out.println("服务器回执" + line);//打印客户端传来的数据
                }
//                inputStream.close();
//                outputStream.close();
//                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("连接超时");
                //关闭各种输入输出流

            }
        }
    }
}
