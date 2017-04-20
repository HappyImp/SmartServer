import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Kyluzoi
 * on 2017/4/20.
 * Email:kyluzoi@gmail.com
 * main 方法
 */
public class Application {
    public static void main(String[] args) {
        final ExecutorService pool;
        final ServerSocket serverSocket;
        final int port = 27027;

        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            System.out.println("Server running @ " + ip + ":" + port);
        } catch (UnknownHostException e) {
            System.err.println("Unknown Host :-(");
        }

        // Wachsender Threadpool
        pool = Executors.newCachedThreadPool();

        try {
            // Server erstellen und RoutService starten
            serverSocket = new ServerSocket(port);
            Thread t1 = new Thread(new RoutService(pool, serverSocket));
            t1.start();
        } catch (IOException ex) {
        }
    }
}
