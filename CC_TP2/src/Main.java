import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static Logger logger = Logger.getLogger("FFS");

    public static void main(String[] args) {
        FileHandler fh;
        try {
            fh = new FileHandler("../logs/log.txt");
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }

        SocketTCP socketTCP = new SocketTCP();
        socketTCP.start();

        File folder = new File(args[0]);
        if(!folder.isDirectory()){
            Main.logger.severe("Erro, não é uma pasta.");
            return;
        }
        try {

            InetAddress client = InetAddress.getByName(args[1]);
            SocketUDP socketUDP = new SocketUDP(folder, client);
            socketUDP.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}