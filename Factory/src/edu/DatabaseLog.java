package edu;

public class DatabaseLog implements Log {
    @Override
    public void writeLog() {
        System.out.println("以数据库方式记录日志中...");
    }
}
