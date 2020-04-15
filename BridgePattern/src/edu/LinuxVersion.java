package edu;

public class LinuxVersion extends OperatingSystemVersion {
    public LinuxVersion(VideoFile form) {
        super(form);
    }

    @Override
    public void play(String FileName) {
        super.form.decode("Linux",FileName);
    }
}