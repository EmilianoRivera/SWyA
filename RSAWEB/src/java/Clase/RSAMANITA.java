package Clase;


import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Diego
 */
public class RSAMANITA {
    
    
    //variables
    

    
    

    
    //un metodo para generar los numeros primos
    public BigInteger[] generarPrimos(int tamprimo){
        BigInteger p = new BigInteger(tamprimo, 10,
                new Random());
        BigInteger q;
        //p != q
        do q = new BigInteger(tamprimo, 10,
                new Random());
        while(q.compareTo(p) == 0);
        
        BigInteger[] pq = new BigInteger[2];
        
        pq[0]=p;
        pq[1]=q;
        
        
        return pq;
    }
    
    //generar las claves
    
    public BigInteger[] generarClaves(BigInteger p, BigInteger q, int tamprimo){
        
        BigInteger[] claves = new BigInteger[4];
        // n = p*q
        // fi = (p-1) * (q-1)
        BigInteger n = p.multiply(q);
        
        //calcular p-1
        BigInteger fi = p.subtract(BigInteger.valueOf(1));
        
        fi = fi.multiply(
                q.subtract(BigInteger.valueOf(1)));
        BigInteger e;
        
        //calculamos e
        //e debe de ser un coprimo de n tal que 1<e<fi(n)
        
        do e = new BigInteger(2*tamprimo, new Random());
            while( (e.compareTo(fi) != -1) || 
                ( e.gcd(fi).compareTo(
                        BigInteger.valueOf(1)) != 0 ));
        
        //d se calcula de fomra tal que
        // d = e^1 mod fi   osea es el inverso multiplicativo de e
        BigInteger d = e.modInverse(fi);
        
        claves[0]=n;
        claves[1]=fi;
        claves[2]=e;
        claves[3]=d;
        
        return claves;
    }
    
    //cifrar
    public BigInteger[] cifrar(String mensaje, BigInteger e, BigInteger n){
        int i;
        byte[] temp = new byte[1];
        byte[] digitos = mensaje.getBytes();
        
        BigInteger[] bigdigitos = new BigInteger[digitos.length];
        
        //iterar con el mensaje para cifrarlo
        for(i = 0; i < bigdigitos.length; i++){
            temp[0] = digitos[i];
            bigdigitos[i] = new BigInteger(temp);
        }
        
        BigInteger[] cifrado = new BigInteger[bigdigitos.length];
        
        for(i = 0; i < bigdigitos.length; i++){
            //aplico la formula  C = M^e modn
            cifrado[i] = bigdigitos[i].modPow(e, n);
        }
        return cifrado;
    }
    
    //descifrar
    public String descifrar(BigInteger[] cifrado, BigInteger d, BigInteger n){
        int i;
        
        BigInteger[] descifrado = new BigInteger[cifrado.length];
        
        //aplico la formula  Md = C^d modn
        
       
        
        //iterar con el mensaje para cifrarlo
        for(i = 0; i < descifrado.length; i++){
            descifrado[i] = cifrado[i].modPow(d, n);
        }
        
        char[] charArray = new char[descifrado.length];
        
        for(i = 0; i < charArray.length; i++){
            //vamos a unir todos los caracteres
            charArray[i] = (char)(descifrado[i].intValue());
        }
        return (new String(charArray));
    }

    
  
    

}
       
