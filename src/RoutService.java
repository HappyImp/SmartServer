import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kyluzoi
 * on 2017/4/20.
 * Email:kyluzoi@gmail.com
 * socket轮询服务
 */

public class RoutService implements Runnable {

    private final ServerSocket serverSocket;
    private final ExecutorService pool;

    public RoutService(ExecutorService pool, ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket client = serverSocket.accept();
                pool.execute(new MessageService(serverSocket, client));
                System.out.println("Server: Client " + client.getInetAddress().toString() + " connected");
            }
        }
        catch (IOException e) {
            System.out.println("Server: IOException");
        }
        finally {
            System.out.println("Server: Shutting down RoutService");
            pool.shutdown();
            try {
                pool.awaitTermination((long)4, TimeUnit.SECONDS);
                if(!serverSocket.isClosed()) {
                    System.out.println("Server: Shutting down ServerSocket");
                    serverSocket.close();
                }
            }
            catch (IOException e) {}
            catch (InterruptedException e) {}
        }
    }
}
