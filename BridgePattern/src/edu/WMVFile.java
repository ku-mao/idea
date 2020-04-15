package edu;

public class WMVFile implements VideoFile {
    @Override
    public void decode(String osType, String fileName) {
        System.out.println(osType + ":" + fileName + ".wmv视频播放...");
    }
}
