package com.ksc.schedule.utils;

import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReadUtils {

    public static List<String[]> readCsv(String fileName, String separator) {
        String line;
        List<String[]> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ResourceUtils.getFile("classpath:" + fileName)))) {
            while ((line = br.readLine()) != null) {
                result.add(line.split(separator));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
