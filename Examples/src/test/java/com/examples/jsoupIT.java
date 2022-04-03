package com.examples;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class jsoupIT {

    @Test
    void testChocolatey() throws IOException {
        Document doc = Jsoup.connect("https://community.chocolatey.org/profiles/JohanJanssen").get();
        Elements elements = doc.select(".card-header").select("div.col-md.py-3.py-md-0");

        for (Element element : elements) {
            if (element.text().contains("Downloads of Packages")) {
                String result = element.select("h4").get(0).text();
                System.out.println("Number of downloads " + result);
            }
        }

    }
}
