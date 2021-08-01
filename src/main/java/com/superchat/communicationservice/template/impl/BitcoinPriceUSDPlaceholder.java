package com.superchat.communicationservice.template.impl;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.superchat.communicationservice.template.TemplatePlaceholder;

public class BitcoinPriceUSDPlaceholder extends TemplatePlaceholder {
    public BitcoinPriceUSDPlaceholder() {
        super("{btc_price_usd}");
    }

    @Override
    public String loadReplacement() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.coindesk.com/v1/bpi/currentprice/USD.json")).GET().build();
            HttpResponse<String> response = HttpClient.newBuilder().build().send(request, BodyHandlers.ofString());

            JsonNode parent = new ObjectMapper().readTree(response.body());

            return String.format("US$%s", parent.path("bpi").path("USD").path("rate").asText());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
