package Mentoring;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.*;

public class Teams {

    public static void main(String[] args)  {

        // checked exceptions
        try {
            FileInputStream connection = new FileInputStream(String.valueOf(Path.of("://anypath.txt")));
        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);
        }




    }




}
