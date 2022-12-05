package org.kelderos.file.commands;

import org.kelderos.file.manager.FileManager;

public abstract class Command {
    FileManager fileManager;

    public void setFileManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public boolean execute()
    {
        return true;
    }
}
