package edu;

public class AVIFile implements VideoFile {
    @Override
    public void decode(String osType, String fileName) {
        System.out.println(osType + ":" + fileName + ".avi视频播放...");
    }
}
