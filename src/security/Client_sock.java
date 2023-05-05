/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package security;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
 
class Client_sock {
public static void main(String args[]){

try{
    keys a = new keys();
    Des cipher = new Des();
//localhost because server is running on local machine, otherwise use ip of server
Socket s = new Socket("localhost", 5000);
 DataInputStream dis=new DataInputStream(s.getInputStream());
    int msg=dis.readInt();
 System.out.println("Encypted Key 1 :" +msg);
  DataInputStream dis1=new DataInputStream(s.getInputStream());
    int msg1=dis1.readInt();
 System.out.println("Encypted Key 2 :" +msg1);
  DataInputStream dis2=new DataInputStream(s.getInputStream());
    int msg2=dis2.readInt();
 System.out.println("Encypted Key 3 :" +msg2);
   DataInputStream dis3=new DataInputStream(s.getInputStream());
    int fy=dis3.readInt();
   DataInputStream dis4=new DataInputStream(s.getInputStream());
    int e=dis4.readInt();
   DataInputStream dis5=new DataInputStream(s.getInputStream());
    int p=dis5.readInt();
    DataInputStream dis6=new DataInputStream(s.getInputStream());
    int q=dis6.readInt();
    //message
    DataInputStream message=new DataInputStream(s.getInputStream());
    String cphText=message.readUTF();
    
    int d1,d2,d3;
    String hex1,hex2,hex3,text1,text2,text3;
           d1 = a.dencryption(msg, p, q, a.GFG(fy, e));
           hex1=Integer.toHexString(d1);
           System.out.println("Decrepted Key 1 :000000000000000"+hex1);
           String key1 = "000000000000000"+hex1;
           d2 = a.dencryption(msg1, p, q, a.GFG(fy, e));
           hex2=Integer.toHexString(d2);
           System.out.println("Decrepted Key 2 :000000000000000"+hex2);
           String key2 = "000000000000000"+hex2;
           d3 = a.dencryption(msg2, p, q, a.GFG(fy, e));
           hex3=Integer.toHexString(d3);
           String key3 = "00000000000000"+hex3;
           System.out.println("Decrepted Key 3 :00000000000000"+hex3);
           //message
           System.out.println("message encrepted :" +cphText);
           //decrypt message
           text1 =cipher.decrypt(cphText, key3);
           System.out.println("text1 :" +text1);
           text2 =cipher.encrypt(text1,key2);
           System.out.println("text2 :" +text2);
           text3 =cipher.decrypt(text2,key1);
           System.out.println("text3 :" +text3);
           System.out.println("Decrypt Message:"+text3);
             

//String text2 = cipher.encrypt(cipher.decrypt(cipher.encrypt(text, Okey1), Okey2),Okey3);
          
//close connection

  
}catch(Exception e){

}
}
}