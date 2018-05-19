package application;

import network.*;
import java.net.*;
import java.io.*;

public class Surveillance { 
   
   public static void main( String args[] ) throws {
    try {
        Thread t = new TCPServer(8080);
        t.start();
     } catch (IOException e) {
        e.printStackTrace();
     }
   }
   
}