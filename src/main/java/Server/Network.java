//File named GreetingServer.java

/**
 * java.net.Socket provides a mechanism for the server
 * program to listen for clients and establish connections
 * with them
 */

 import java.net.*;

 /**
  * java.io.*; provides a mechanism to work withfile input and output
  */

 import java.io.*;

 //Creating a class to handle my serversocket

 public class Network extends Thread
 {
     //Creating a server socket object
     private ServerSocket serverSocket;

     /**
      * Attempts to create a server socket bound to the specidied
      * port.  if an exception occurs The port is already bound 
      * by another application. 
      */

      public GreetingServer(int port) throws IOException
      {
          serverSocket = new ServerSocket(port);

          /**
           * Sets the time-out valuse for how long the server socket 
           * waits for a client during the accept().
           */

           serverSocket.setTimeout(10000);
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
                   //displaying a waiting message
                   System.out.println("Waiting for client on port " +
                    serverScoket.getLocalPort() + "...");
                   
                   //Creates an unconnected socket to connect to the server
                   Socket server = serverSocket.accept();
                   
                   System.out.println("Just connect to " + server.getRemoteSocketAddress());
                   DataInputStream in = new DataInputStream(server.getInputStream());

                   System.out.println(in.readUTF());
                   DataOutputStream out =new DataOutputStream(server.getOutputStream());
                   out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() +
                   + "n/Goodbye!");
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
                   e.printStacktrace();
                   break;
               }
           }
       }
 }
