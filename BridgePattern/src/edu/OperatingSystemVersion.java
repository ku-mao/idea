package edu;

public abstract class OperatingSystemVersion {

    // 聚合视频文件格式
    VideoFile form;

    public OperatingSystemVersion(VideoFile form) {
        this.form = form;
    }
    public abstract void play(String FileName);

}
