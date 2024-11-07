package edu.bsu.cs222;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapCreator {
    RatesGetter ratesGetter = new RatesGetter();
    APIConnector APIConnector = new APIConnector();

    public HashMap<String, Float> createHashMap(String jsonValue) throws IOException {

        ArrayList<CurrencyBuilder> dataList = new ArrayList<>();
        HashMap<String, Float> hashMap = new HashMap<>();
        HttpsURLConnection API_connection = APIConnector.connectNoDate();
        String allRatesOnSpecificDate = ratesGetter.getRates(API_connection);

        try(Scanner scanner = new Scanner(allRatesOnSpecificDate)) {
            ArrayList<String> lines = new ArrayList<>();

            while(scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                String [] data = line.split(":");
                float valueID = Float.parseFloat(data[1]);
                String currencyAbb = data[0];


                //instantiation
                CurrencyBuilder currencyBuilder = new CurrencyBuilder(currencyAbb, valueID);
                dataList.add(currencyBuilder);
                //hashMap.put(dataList.get(i));
            }
        }
        return null;
    }
}
