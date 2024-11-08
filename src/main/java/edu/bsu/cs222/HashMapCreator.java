package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class HashMapCreator {
    RatesGetter ratesGetter = new RatesGetter();
    APIConnector APIConnector = new APIConnector();

    public HashMap<String, Float> createHashMap() throws IOException {

        ArrayList<CurrencyBuilder> dataList = new ArrayList<>();
        HashMap<String, Float> hashMap = new HashMap<>();
        HttpsURLConnection API_connection = APIConnector.connectNoDate();
        String allRates = createAllRatesForHashMap();

        try(Scanner scanner = new Scanner(allRates)) {
            ArrayList<String> lines = new ArrayList<>();

            while(scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                line = line.replace(",", "");
                String [] data = line.split(":");
                float valueID = Float.parseFloat(data[1]);
                String currencyAbb = data[0];


                //instantiation
                CurrencyBuilder currencyBuilder = new CurrencyBuilder(currencyAbb, valueID);
                dataList.add(currencyBuilder);
                hashMap.put(currencyAbb, valueID);
            }
        }
        System.out.println(hashMap);
        return hashMap;
    }
    public String createAllRatesForHashMap() throws IOException {
        StringBuilder hashMapToString = new StringBuilder();

        HttpsURLConnection API_connection = APIConnector.connectNoDate();
        String allCurrentRates = ratesGetter.getRates(API_connection);


        JSONArray abbreviationsAndRates = JsonPath.read(allCurrentRates, "$..rates" );

        return abbreviationsAndRates.toJSONString();
    }
}
