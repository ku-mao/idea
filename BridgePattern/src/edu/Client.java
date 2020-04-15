package edu;

public class Client {
    public static void main(String args[]) {
        new WindowsVersion(new AVIFile()).play("Test1");
        new WindowsVersion(new MPEGFile()).play("Test2");
        new WindowsVersion(new WMVFile()).play("Test3");
        new WindowsVersion(new RMVBFile()).play("Test4");
        System.out.println("********************");
        new LinuxVersion(new AVIFile()).play("Test1");
        new LinuxVersion(new MPEGFile()).play("Test2");
        new LinuxVersion(new WMVFile()).play("Test3");
        new LinuxVersion(new RMVBFile()).play("Test4");
        System.out.println("********************");
        new UnixVersion(new AVIFile()).play("Test1");
        new UnixVersion(new MPEGFile()).play("Test2");
        new UnixVersion(new WMVFile()).play("Test3");
        new UnixVersion(new RMVBFile()).play("Test4");
    }
}
