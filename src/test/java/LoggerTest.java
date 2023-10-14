import dev.xatuos.chatrobo.api.logging.ILogger;

import java.util.List;

public class LoggerTest {
    public static final ILogger LOGGER = ILogger.getLogger();

    public static void main(String[] args) {
        LOGGER.info("123");
        LOGGER.debug("456");
        LOGGER.warn("789");
        LOGGER.error("233");
        try {
            List<Integer> list = List.of(1, 2, 3, 4, 5);
            list.get(100);
        } catch (Exception exception) {
            LOGGER.printStackTrace(exception);
        }
    }
}
