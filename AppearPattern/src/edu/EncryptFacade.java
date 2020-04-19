package edu;

public class EncryptFacade {
     FileReader reader;
     FileWriter writer;
     CipherMachine cipher;

    // 构造方法
    public EncryptFacade(FileReader reader, FileWriter writer, CipherMachine cipher) {
        this.reader = reader;
        this.writer = writer;
        this.cipher = cipher;
    }

    public void fileEncrypt(String fileNameSrc, String fileNameDes)  {
        System.out.println("读取文件:" + fileNameSrc);
        System.out.println(cipher.encrypt(fileNameSrc));
        System.out.println("保存文件:" + fileNameDes);

    }

}
