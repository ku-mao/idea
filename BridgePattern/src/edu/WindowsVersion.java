package edu;

public class WindowsVersion extends OperatingSystemVersion {
    public WindowsVersion(VideoFile form) {
        super(form);
    }

    @Override
    public void play(String FileName) {
        super.form.decode("Windows",FileName);
    }
}
