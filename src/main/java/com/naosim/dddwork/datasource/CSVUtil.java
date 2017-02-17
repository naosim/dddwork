package com.naosim.dddwork.datasource;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVUtil {
    public static void insert(File file, Object... columns) throws IOException {
        try(FileWriter filewriter = new FileWriter(file, true)) {
            filewriter.write(Stream.of(columns).map(Object::toString).collect(Collectors.joining(",")));
            filewriter.write("\n");
        }
    }

    public static List<List<String>> get(File file) throws IOException {
        try(
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
        ) {
            List<List<String>> result = new ArrayList<>();

            String line = br.readLine();
            while(line != null){
                result.add(Arrays.asList(line.split(",")));
                line = br.readLine();
            }

            return result;
        }
    }
}
