/**
    This class opens the binary Storage.mp4 and saves data to that file. 
*/

import java.io.*;

public class WriteStream
{
    public WriteStream()
    {
        //Creating a FileOutputStream object to connect to Storage.java file
        FileOutputStream fstream = FileOutputStream("Storage.mp4");

        //Creating a DataOutputStream object to write data to Storage.java file
        DataOutputStream outputFile = new DataOutputStream(fstream);
    }

    public void saveStream(byte[] bytes)
    {
        for(i=0; i < 100; i++)
        {
            outputFile.write(this.bytes[i]);
        }
        saveStream(byte[] bytes);
    }
}