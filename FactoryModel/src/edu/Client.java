package edu;

public class Client {
    public static void main(String[] args) {
            Log log;
            LogFactory factory;
            factory = new FileLogFactory();
            log = factory.createLog();
            log.writeLog();
            System.out.println("************");
            factory = new DatabaseLogFactory();
            log = factory.createLog();
            log.writeLog();
    }
}
