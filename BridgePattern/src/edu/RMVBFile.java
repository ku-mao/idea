package edu;

public class RMVBFile implements VideoFile {
    @Override
    public void decode(String osType, String fileName) {
        System.out.println(osType + ":" + fileName + ".rmvb视频播放...");
    }
}
