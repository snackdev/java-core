package annotation;


import java.util.logging.Logger;

public class Executor {
    private static final Logger logger = Logger.getLogger(Executor.class.getSimpleName());

    @TimeStamp
    public static void someAction() {
        logger.info("someAction started....");
        for (int i=0; i< 10e8; i++) { }
        logger.info("someAction ended....");
    }

    public static void main(String[] args) {
        someAction();
    }
}
