package org.kelderos.file.commands;

import java.io.File;

public class RenameFile extends Command{

    File newFile;
    public RenameFile(File newFile)
    {
        this.newFile = newFile;
    }

    @Override
    public boolean execute()
    {
        if (fileManager.getExists()) {
            if (fileManager.getLastFile().renameTo(newFile)) {
                fileManager.getLastFile().delete();
                fileManager.setLastFile(newFile);
                return true;
            }
            else {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}
