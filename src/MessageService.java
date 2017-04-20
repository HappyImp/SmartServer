import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
            OutputStream ops = client.getOutputStream();
            OutputStreamWriter opsw = new OutputStreamWriter(ops);
            BufferedWriter bw = new BufferedWriter(opsw);

            String line;
            System.out.println("Waiting for "+clientName);
            //循环发送信息
            while (true)
            {
                ops.write("服务器回执".getBytes("utf-8"));
            }
//            while((line = in.readLine()) != null) {
//                System.out.println(clientName + ": " + line);
//
//                out.println(line);
//                out.flush();
//            }
        }
        catch (IOException e) {
            System.out.println("Server/MessageService: IOException");
        }
        finally {
            if(!client.isClosed()) {
                System.out.println("Server: Client disconnected");
                try {
                    client.close();
                }
                catch (IOException e) {}
            }
        }
    }
}
