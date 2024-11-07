package edu.bsu.cs222;

public class CurrencyBuilder {
    String currency;
    float jsonValue;

    public CurrencyBuilder(String currency, float jsonValue) {
        this.currency = currency;
        this.jsonValue = jsonValue;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getJsonValue() {
        return jsonValue;
    }

    public void setJsonValue(float jsonValue) {
        this.jsonValue = jsonValue;
    }
}
