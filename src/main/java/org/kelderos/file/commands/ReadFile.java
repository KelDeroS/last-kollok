package org.kelderos.file.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile extends Command{
    @Override
    public boolean execute()
    {
        if (fileManager.getExists()) {
            Scanner scanner = null;
            try {
                scanner = new Scanner(fileManager.getLastFile());
            } catch (FileNotFoundException e) {
                return false;
            }
            while (scanner.hasNextLine())
            {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
            return true;
        }
        else
        {
            return false;
        }
    }
}
