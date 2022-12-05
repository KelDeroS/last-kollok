package org.kelderos.file.commands;

import org.kelderos.file.manager.FileManager;

import java.io.File;
import java.io.IOException;

public class CreateFile extends Command
{
    File file;
    public CreateFile(File file)
    {
        this.file = file;
    }

    @Override
    public boolean execute()
    {
        try {
            file.createNewFile();
            fileManager.setLastFile(file);
            fileManager.setExists(true);
            return true;

        } catch (IOException e) {
            return false;
        }
    }
}
