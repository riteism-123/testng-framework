package com.example.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.testng.annotations.DataProvider;

import java.io.InputStream;
import java.util.List;

public class JsonDataProvider {

    @DataProvider(name = "jsonData")
    public Object[][] getDataFromJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        // Load JSON file
        InputStream is = getClass().getClassLoader().getResourceAsStream("testData.json");

        // Convert JSON array to List<LoginData>
        List<LoginData> dataList = mapper.readValue(is, new TypeReference<List<LoginData>>() {});

        // Convert to Object[][]
        Object[][] data = new Object[dataList.size()][2];
        for (int i = 0; i < dataList.size(); i++) {
            data[i][0] = dataList.get(i).username;
            data[i][1] = dataList.get(i).password;
        }
        return data;
    }
}
