package edu;

public class FileLogFactory implements LogFactory {
    @Override
    public Log createLog() {
        System.out.println("文件日志工厂产生文件日志记录方式");
        return new FileLog();
    }
}
