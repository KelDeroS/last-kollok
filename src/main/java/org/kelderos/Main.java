package org.kelderos;

import org.kelderos.file.commands.*;
import org.kelderos.file.manager.FileManager;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        FileManager fileManager = new FileManager();
        fileManager.executeCommand(new CreateFile(new File("test.txt")));
        fileManager.executeCommand(new CreateFile(new File("test1.txt")));
        fileManager.executeCommand(new RenameFile(new File("grabli.txt")));
        fileManager.executeCommand(new WriteToFile("unit test"));
        fileManager.executeCommand(new ClearFile());
        fileManager.executeCommand(new DeleteFile());
        fileManager.executeCommand(new OpenFile(new File("test.txt")));
        fileManager.executeCommand(new WriteToFile("random stuff"));
        fileManager.executeCommand(new ReadFile());

        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }
}