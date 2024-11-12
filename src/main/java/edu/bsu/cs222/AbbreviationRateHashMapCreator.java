package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AbbreviationRateHashMapCreator {

    RatesGetter ratesGetter = new RatesGetter();
    APIConnector APIConnector = new APIConnector();
    JSONToFloat jsonToFloat = new JSONToFloat();

    public HashMap<String, Float> abbreviationRateHashMapCreation(List<Float> rateList) throws IOException {

        HttpsURLConnection API_connection = APIConnector.connectNoDate();
        String allCurrentRates = ratesGetter.getRates(API_connection);
        List<String> abbreviationList = abbreviationListCreation();
        HashMap<String, Float> abbreviationsWithRates = new HashMap<>();
        for (int i = 0; i < abbreviationList.size(); i++) {
            JSONArray exchangeRateValue = JsonPath.read(allCurrentRates, "$.." + abbreviationList.get(i));
            if (!exchangeRateValue.isEmpty()) {
                float rateFromAbbreviation = jsonToFloat.jsonArrayToFloat(exchangeRateValue);
                for (int j = 0; j < rateList.size(); j++) {
                    if (rateFromAbbreviation == rateList.get(j)) {
                        abbreviationsWithRates.put(abbreviationList.get(i), rateList.get(j));
                    }
                }
            }
        }
        return abbreviationsWithRates;
    }

    private List<String> abbreviationListCreation() {
        List<String> abbreviationList = new ArrayList<>();
        abbreviationList.add("AED");
        abbreviationList.add("AFN");
        abbreviationList.add("ALL");
        abbreviationList.add("AMD");
        abbreviationList.add("ANG");
        abbreviationList.add("AOA");
        abbreviationList.add("ARS");
        abbreviationList.add("AUD");
        abbreviationList.add("AWG");
        abbreviationList.add("AZN");
        abbreviationList.add("BAM");
        abbreviationList.add("BBD");
        abbreviationList.add("BDT");
        abbreviationList.add("BGN");
        abbreviationList.add("BHD");
        abbreviationList.add("BIF");
        abbreviationList.add("BMD");
        abbreviationList.add("BND");
        abbreviationList.add("BOB");
        abbreviationList.add("BRL");
        abbreviationList.add("BSD");
        abbreviationList.add("BTC");
        abbreviationList.add("BTN");
        abbreviationList.add("BWP");
        abbreviationList.add("BYN");
        abbreviationList.add("BYR");
        abbreviationList.add("BZD");
        abbreviationList.add("CAD");
        abbreviationList.add("CDF");
        abbreviationList.add("CHF");
        abbreviationList.add("CLF");
        abbreviationList.add("CLP");
        abbreviationList.add("CNH");
        abbreviationList.add("CNY");
        abbreviationList.add("COP");
        abbreviationList.add("CRC");
        abbreviationList.add("CUC");
        abbreviationList.add("CUP");
        abbreviationList.add("CVE");
        abbreviationList.add("CZK");
        abbreviationList.add("DJF");
        abbreviationList.add("DKK");
        abbreviationList.add("DOP");
        abbreviationList.add("DZD");
        abbreviationList.add("EGP");
        abbreviationList.add("ERN");
        abbreviationList.add("ETB");
        abbreviationList.add("EUR");
        abbreviationList.add("FJD");
        abbreviationList.add("FKP");
        abbreviationList.add("GBP");
        abbreviationList.add("GEL");
        abbreviationList.add("GGP");
        abbreviationList.add("GHS");
        abbreviationList.add("GIP");
        abbreviationList.add("GMD");
        abbreviationList.add("GNF");
        abbreviationList.add("GTQ");
        abbreviationList.add("GYD");
        abbreviationList.add("HKD");
        abbreviationList.add("HNL");
        abbreviationList.add("HRK");
        abbreviationList.add("HTG");
        abbreviationList.add("HUF");
        abbreviationList.add("IDR");
        abbreviationList.add("ILS");
        abbreviationList.add("IMP");
        abbreviationList.add("INR");
        abbreviationList.add("IQD");
        abbreviationList.add("IRR");
        abbreviationList.add("ISK");
        abbreviationList.add("JEP");
        abbreviationList.add("JMD");
        abbreviationList.add("JOD");
        abbreviationList.add("JPY");
        abbreviationList.add("KES");
        abbreviationList.add("KGS");
        abbreviationList.add("KHR");
        abbreviationList.add("KMF");
        abbreviationList.add("KPW");
        abbreviationList.add("KRW");
        abbreviationList.add("KWD");
        abbreviationList.add("KYD");
        abbreviationList.add("KZT");
        abbreviationList.add("LAK");
        abbreviationList.add("LBP");
        abbreviationList.add("LKR");
        abbreviationList.add("LRD");
        abbreviationList.add("LSL");
        abbreviationList.add("LTL");
        abbreviationList.add("LVL");
        abbreviationList.add("LYD");
        abbreviationList.add("MAD");
        abbreviationList.add("MDL");
        abbreviationList.add("MGA");
        abbreviationList.add("MKD");
        abbreviationList.add("MMK");
        abbreviationList.add("MNT");
        abbreviationList.add("MOP");
        abbreviationList.add("MRU");
        abbreviationList.add("MUR");
        abbreviationList.add("MVR");
        abbreviationList.add("MWK");
        abbreviationList.add("MXN");
        abbreviationList.add("MYR");
        abbreviationList.add("MZN");
        abbreviationList.add("NAD");
        abbreviationList.add("NGN");
        abbreviationList.add("NIO");
        abbreviationList.add("NOK");
        abbreviationList.add("NPR");
        abbreviationList.add("NZD");
        abbreviationList.add("OMR");
        abbreviationList.add("PAB");
        abbreviationList.add("PEN");
        abbreviationList.add("PGK");
        abbreviationList.add("PHP");
        abbreviationList.add("PKR");
        abbreviationList.add("PLN");
        abbreviationList.add("PYG");
        abbreviationList.add("QAR");
        abbreviationList.add("RON");
        abbreviationList.add("RSD");
        abbreviationList.add("RUB");
        abbreviationList.add("RWF");
        abbreviationList.add("SAR");
        abbreviationList.add("SBD");
        abbreviationList.add("SCR");
        abbreviationList.add("SDG");
        abbreviationList.add("SEK");
        abbreviationList.add("SGD");
        abbreviationList.add("SHP");
        abbreviationList.add("SLE");
        abbreviationList.add("SLL");
        abbreviationList.add("SOS");
        abbreviationList.add("SRD");
        abbreviationList.add("STD");
        abbreviationList.add("SVC");
        abbreviationList.add("SYP");
        abbreviationList.add("SZL");
        abbreviationList.add("THB");
        abbreviationList.add("TJS");
        abbreviationList.add("TMT");
        abbreviationList.add("TND");
        abbreviationList.add("TOP");
        abbreviationList.add("TRY");
        abbreviationList.add("TTD");
        abbreviationList.add("TWD");
        abbreviationList.add("TZS");
        abbreviationList.add("UAH");
        abbreviationList.add("UGX");
        abbreviationList.add("USD");
        abbreviationList.add("UYU");
        abbreviationList.add("UZS");
        abbreviationList.add("VEF");
        abbreviationList.add("VES");
        abbreviationList.add("VND");
        abbreviationList.add("VUV");
        abbreviationList.add("WST");
        abbreviationList.add("XAF");
        abbreviationList.add("XAG");
        abbreviationList.add("XAU");
        abbreviationList.add("XCD");
        abbreviationList.add("XDR");
        abbreviationList.add("XOF");
        abbreviationList.add("XPF");
        abbreviationList.add("YER");
        abbreviationList.add("ZAR");
        abbreviationList.add("ZMK");
        abbreviationList.add("ZMW");
        abbreviationList.add("ZWL");
        return abbreviationList;
    }
}
