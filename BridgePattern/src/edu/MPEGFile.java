package edu;

public class MPEGFile implements VideoFile {
    @Override
    public void decode(String osType, String fileName) {
        System.out.println(osType + ":" + fileName + ".mpeg视频播放...");
    }
}
