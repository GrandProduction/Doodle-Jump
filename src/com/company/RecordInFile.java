package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Дмитрий on 20.12.2016.
 */
public class RecordInFile {
    private static final String nameFile = "Record.dat";
    private static final String newLine = "\n";

    public RecordInFile(String text){
        try {
            Files.write(Paths.get(nameFile), text.getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(nameFile), newLine.getBytes(), StandardOpenOption.APPEND);

        }
        catch (IOException e) {}
    }
}
