package com.ksc.schedule.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReadUtils {

    public static List<String[]> readCsv(String fileName, String separator) {
        String line;
        List<String[]> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(CSVReadUtils.class.getResourceAsStream(fileName)))) {
            while ((line = br.readLine()) != null) {
                result.add(line.split(separator));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
