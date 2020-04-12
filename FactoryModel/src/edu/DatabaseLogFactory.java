package edu;

public class DatabaseLogFactory implements LogFactory {
    @Override
    public Log createLog() {
        System.out.println("数据库日志工厂产生数据库日志记录方式");
        return new DatabaseLog();
    }
}
