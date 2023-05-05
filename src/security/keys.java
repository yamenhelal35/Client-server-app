/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package security;

/**
 *
 * @author admin
 */
public class keys {
    boolean isPrime(int num){
        if(num<=1)
        {
            return false;
        }
       for(int i=2;i<=num/2;i++)
       {
           if((num%i)==0)
               return  false;
       }
       return true;
    }
    boolean isNotFactor(int num, int x){

      // if number is divided by i
      // i is the factor
            if (num % x == 0) {
          //System.out.print(i + " ");
          return false;
      }
        return true; 
         }

    int encryption (int m, int p, int q, int e){
        int n = p*q;
        int c = (int) ((Math.pow(m, e))%n);
        return c;
    }
    
    int GFG(int fy,int e){
        int a1=fy;
       int a=fy;
       int b=e;
        int r = 72;
        int q=0;
        int x3=0;
        int x1=0;
        int x2=1;
        int d=0;
        while(r>=1){
            //System.out.println("r:"+r +","+ "q:"+q +","+ "x:"+x3);
            r = a%b;
            q = a/b;
            x3= x1-(x2*q);
            a=b;
            b=r;
            x1=x2;
            x2=x3;
        }
        //System.out.println(x1);
        if(x1>0){
           d=x1;  
        }
        else {d=x1+a1;}
        //System.out.println("d="+d);
        return d;
    }
    int dencryption (int c, int p, int q, int d){
        int n = p*q;
        int message = (int) ((Math.pow(c, d))%n);
        return message;
    }
}

