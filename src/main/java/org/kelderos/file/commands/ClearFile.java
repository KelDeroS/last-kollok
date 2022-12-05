package org.kelderos.file.commands;

import java.io.FileOutputStream;
import java.io.IOException;

public class ClearFile extends Command{

    @Override
    public boolean execute()
    {
        if (fileManager.getExists())
        {
            try {
                new FileOutputStream(fileManager.getLastFile()).close();
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
