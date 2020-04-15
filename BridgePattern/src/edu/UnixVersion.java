package edu;

public class UnixVersion extends OperatingSystemVersion {
    public UnixVersion(VideoFile form) {
        super(form);
    }

    @Override
    public void play(String FileName) {
        super.form.decode("Unix", FileName);
    }
}