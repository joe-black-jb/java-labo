package to.msn.wings.quickmaster.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ApplicationLogger {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationLogger.class);

    // ログを出力するメソッドを作成
    public void logInfo(String message) {
        logger.info(message);
    }

    public void logError(String message, Throwable throwable) {
        logger.error(message, throwable);
    }
}