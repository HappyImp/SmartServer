import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Kyluzoi
 * on 2017/4/20.
 * Email:kyluzoi@gmail.com
 * 消息协定
 */
public class MessageService implements Runnable {

    private final Socket client;
    private final ServerSocket serverSocket;

    MessageService(ServerSocket serverSocket, Socket client) {
        this.client = client;
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        PrintWriter out = null;
        BufferedReader in = null;
        String clientName = client.getInetAddress().toString();
        try {

            OutputStream outputStream;
            InputStream inputStream;

            //获取输入输出流
            outputStream = client.getOutputStream();
            inputStream=client.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter bufferedWriter=new PrintWriter(outputStream,true);
            //读取发来服务器信息
            while (true)
            {
                String line=null;
//                bufferedWriter.println(",Hello,I'm Server!");//向客户端输出数据
                line=bufferedReader.readLine();//读取客户端传来的数据
                if(line==null)
                    break;
                System.out.println("客户端说："+line);//打印客户端传来的数据
                bufferedWriter.println(line);
            }



        } catch (IOException e) {
            System.out.println("Server/MessageService: IOException");
        } finally {
            if (!client.isClosed()) {
                System.out.println("Server: Client disconnected");
                try {
                    client.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
