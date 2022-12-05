package org.kelderos.file.commands;

import java.io.File;

public class OpenFile extends Command{

    File file;
    public OpenFile(File file)
    {
        this.file = file;
    }

    @Override
    public boolean execute()
    {
        if (file.exists())
        {
            fileManager.setLastFile(file);
            fileManager.setExists(true);
            return true;
        }
        else
        {
            return false;
        }
    }
}
