package episen.si.ing1.pds.backend.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BackendService {
    private static final Logger serverLogger = LoggerFactory.getLogger(BackendService.class.getName());
    public static void main(String[] args) {
        serverLogger.info("BackendService is running");
        System.out.println("mvn install with cmd");
        System.out.println("");
    }
}
