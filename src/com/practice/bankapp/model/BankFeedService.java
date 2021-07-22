package com.practice.bankapp.model;

import java.io.File;
import java.io.FileReader;
import java.util.*;

public class BankFeedService {

    public List<Map<String, String>> loadFeed(File file) throws Exception {

        try (FileReader fileRead = new FileReader(file);) {
            Scanner scan = new Scanner(fileRead);
            List<Map<String, String>> maps = new ArrayList<>();

            while (scan.hasNextLine()) {
                String str = scan.nextLine();
                String[] pairs = str.split(";");
                Map<String, String> map = new HashMap<>();

                for (String pair : pairs) {
                    String[] keyValue = pair.split("=");
                    map.put(keyValue[0], keyValue[1]);
                }
                maps.add(map);
            }
            return maps;
        }
    }
}
