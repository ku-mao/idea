package edu;

public class FileLog implements Log {
    @Override
    public void writeLog() {
        System.out.println("以文件方式记录日志中...");
    }
}
