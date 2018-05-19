package video;
/**
    This class opens the binary Storage.mp4 and saves data to that file. 
*/

import java.io.*;
import java.util.Scanner;

public class Video
{
    private String filename;
    private DataOutputStream outputStream;
    
    public Video(String filename)
    {
        this.filename = filename;
        try {
            outputStream = new DataOutputStream(new FileOutputStream(this.filename, true));

        } catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    //saveStream method that takes an array of bytes as a parameter to save to Storage.mp4

    public void write(byte[] bytes)
    {   
        try {
            outputStream.write(bytes);

        } catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void finish()
    {   
        try {
            outputStream.close();

        } catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}