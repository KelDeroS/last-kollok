package org.kelderos.file.commands;

import java.io.File;

public class DeleteFile extends Command{
    @Override
    public boolean execute()
    {
        if (fileManager.getExists())
        {
            if (fileManager.getLastFile().delete())
            {
                fileManager.setExists(false);
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}
