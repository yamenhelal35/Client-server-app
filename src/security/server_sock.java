/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package security;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class Security {

    public static void main(String args[]) {
        try {
//create socket, 5000 is port number
//create 3 keysss
            keys a = new keys();
            String Okey1 = "0000000000000002";
            String Okey2 = "000000000000000B";
            String Okey3 = "000000000000001C";
            int key1 = Integer.parseInt("0000000000000002", 16);
            System.out.println("key1 before encryption:" + key1);
            int key2 = Integer.parseInt("000000000000000B", 16);
            System.out.println("key2 before encryption:" + key2);
            int key3 = Integer.parseInt("000000000000001C", 16);
            System.out.println("key3 before encryption:" + key3);
            int p = 3;
            int q = 11;
            int e = 7;
            int n = p * q;
            int fy = (p - 1) * (q - 1);
            int c1 = a.encryption(key1, p, q, e);
            System.out.println("key1 after encryption:" + c1);
            int c2 = a.encryption(key2, p, q, e);
            System.out.println("key2 after encryption:" + c2);
            int c3 = a.encryption(key3, p, q, e);
            System.out.println("key3 after encryption:" + c3);

            ServerSocket server = new ServerSocket(5000);
            Socket s = server.accept();
            System.out.println("Connected !!");

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeInt(c1);
            DataOutputStream dos1 = new DataOutputStream(s.getOutputStream());
            dos1.writeInt(c2);
            DataOutputStream dos2 = new DataOutputStream(s.getOutputStream());
            dos2.writeInt(c3);
            DataOutputStream dos3 = new DataOutputStream(s.getOutputStream());
            dos3.writeInt(fy);
            DataOutputStream dos4 = new DataOutputStream(s.getOutputStream());
            dos4.writeInt(e);
            DataOutputStream dos5 = new DataOutputStream(s.getOutputStream());
            dos5.writeInt(p);
            DataOutputStream dos6 = new DataOutputStream(s.getOutputStream());
            dos6.writeInt(q);

//create message
            String text = "123456ABCD132536";
            Des cipher = new Des();
            System.out.println("Encryption:\n");
            String text1 = cipher.encrypt(text, Okey1);
            System.out.println("text1 :" + text1);
            String text2 = cipher.decrypt(text1, Okey2);
            System.out.println("text2 :" + text2);
            String text3 = cipher.encrypt(text2, Okey3);
            System.out.println("text3 :" + text3);
            DataOutputStream message = new DataOutputStream(s.getOutputStream());
            message.writeUTF(text3);
            System.out.println("message encrepted :" + text3);
        } catch (Exception e) {

        }
    }
}
