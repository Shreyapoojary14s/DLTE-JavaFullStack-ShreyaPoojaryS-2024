package blocks.service.log;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogFileHandle {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("MyLog");
            FileHandler fh;

            try {
                fh = new FileHandler("mylog.txt",true);
                // adding the FileHandler to the logger
                logger.addHandler(fh);
                // Create a SimpleFormatter to format log messages
                SimpleFormatter formatter = new SimpleFormatter();
                // Set the formatter to the FileHandler
                fh.setFormatter(formatter);
                logger.info("Logging to a text file");
            } catch (SecurityException | IOException e) {
                e.printStackTrace();
            }
        }


}
