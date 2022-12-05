package org.kelderos.file.commands;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile extends Command{

    String str;
    public WriteToFile(String str)
    {
        this.str = str;
    }

    @Override
    public boolean execute()
    {
        if (fileManager.getExists())
        {
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(fileManager.getLastFile());
                fileWriter.write(str);
                fileWriter.close();
            } catch (IOException e) {
                return false;
            }
            return true;
        }
        else
        {
            return false;
        }
    }
}
