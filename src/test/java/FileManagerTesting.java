import org.junit.Assert;
import org.kelderos.file.commands.*;
import org.kelderos.file.manager.FileManager;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManagerTesting {

    @Test
    public void fileManagerTesting()
    {
        FileManager fileManager = new FileManager();

        File file = new File("test.txt");
        fileManager.executeCommand(new CreateFile(file));
        Assert.assertTrue(file.exists());

        File file1 = new File("test1.txt");
        fileManager.executeCommand(new CreateFile(file1));
        Assert.assertTrue(file1.exists());

        File file2 = new File("grabli.txt");
        fileManager.executeCommand(new RenameFile(new File("grabli.txt")));
        Assert.assertFalse(file1.exists());
        Assert.assertTrue(file2.exists());

        fileManager.executeCommand(new WriteToFile("unit test"));
        try {
            Scanner scanner = new Scanner(file2);
            Assert.assertEquals("unit test", scanner.nextLine());
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        fileManager.executeCommand(new ClearFile());
        try {
            Scanner scanner = new Scanner(file2);
            Assert.assertFalse(scanner.hasNext());
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        fileManager.executeCommand(new DeleteFile());
        Assert.assertFalse(file2.exists());

        fileManager.executeCommand(new OpenFile(new File("test.txt")));
        fileManager.executeCommand(new WriteToFile("random stuff"));
        try {
            Scanner scanner = new Scanner(file);
            Assert.assertEquals("random stuff", scanner.nextLine());
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        fileManager.executeCommand(new ReadFile());
        Assert.assertEquals("random stuff\r\n", outputStream.toString());
    }
}
