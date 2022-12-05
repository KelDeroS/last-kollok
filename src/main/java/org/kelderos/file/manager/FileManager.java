package org.kelderos.file.manager;

import org.kelderos.file.commands.Command;

import java.io.File;

public class FileManager {
    File lastFile;
    boolean exists = false;

    public void executeCommand(Command command)
    {
        command.setFileManager(this);
        command.execute();
    }

    public File getLastFile() {
        return lastFile;
    }

    public void setLastFile(File existingFile) {
        this.lastFile = existingFile;
        lastFile.deleteOnExit();
    }

    public boolean getExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }
}
