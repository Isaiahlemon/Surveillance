package network;    //Package I created to extend to other classes.

/**
 * java.net.Socket provides a mechanism for the server
 * program to listen for clients and establish connections
 * with them
 */

 import java.net.*;
 import video.*;    // import statement to connect to my video files

 /**
  * java.io.*; provides a mechanism to work withfile input and output
  */

 import java.io.*;

 //Creating a class to handle my serversocket

 public class TCPServer extends Thread
 {
     //Creating a server socket object
     private ServerSocket serverSocket;

     /**
      * Attempts to create a server socket bound to the specidied
      * port.  if an exception occurs The port is already bound 
      * by another application. 
      */

      public TCPServer(int port) throws IOException
      {
          serverSocket = new ServerSocket(port);

          /**
           * Sets the time-out valuse for how long the server socket 
           * waits for a client during the accept().
           */

           serverSocket.setSoTimeout(10000);
      }

      /**
       * Creating a run method to be ran in a thread.
       */

       public void run()
       {
           // creating a constant loop to keep my server running
           while(true)
           {
               //Creating exceptions
               try
               {
                    Socket server = serverSocket.accept();

                   //displaying a waiting message
                   System.out.println("Waiting for client on port " + server.getLocalPort() + "...");
                   
                   //Creates an unconnected socket to connect to the server
                   
                   System.out.println("Just connect to " + server.getRemoteSocketAddress());
                   DataInputStream in = new DataInputStream(server.getInputStream());
                   DataOutputStream out = new DataOutputStream(server.getOutputStream());
                   System.out.println(in.readUTF());
                   out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "n/Goodbye!");
                   
                //    Video myVideo = new Video("test.text");
                //    myVideo.write.("Thank you for connecting to " + server.getLocalSocketAddress() +
                //    + "n/Goodbye!".bytes());
                   //Close the server
                   server.close();
               }
               catch(SocketTimeoutException s)
               {
                   System.out.println("Socket timed out!");
                   break;
               }
               catch(IOException e)
               {
                   e.printStackTrace();
                   break;
               }
           }
       }
 }
