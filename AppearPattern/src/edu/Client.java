package edu;

public class Client {
    public static void main(String args[]) {
        EncryptFacade encryptFacade = new EncryptFacade(
                new FileReader("aaa.txt"),
                new FileWriter("file","aaa_加密.txt"),
                new CipherMachine());
        encryptFacade.fileEncrypt("aaa.txt", "aaa_加密.txt");
    }
}
