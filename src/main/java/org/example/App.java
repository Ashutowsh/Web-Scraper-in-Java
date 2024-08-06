package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void getData(String country) throws IOException {

        String url = "https://www.worldometers.info/coronavirus/country/" + country +"/";
        Document document = Jsoup.connect(url).get();

//        System.out.println(document.title());
//        System.out.println(document.body());

        Elements lists = document.select("#maincounter-wrap");
//        System.out.println(lists);

        lists.forEach((e) -> {
//            System.out.println(e.html());
//            System.out.println();
//            System.out.println();

            String text = e.select("h1").text();
            String count = e.select(".maincounter-number>span").text();
            if(!Objects.equals(text, "")) System.out.println(text + " : " + count);
        });
    }

    public static void main( String[] args ) throws IOException {
        System.out.println( "--------- Web Scraper in Java----------" );
        System.out.println();


        Scanner sc = new Scanner(System.in);
        System.out.print("Country : ");
        String country = sc.next();
        System.out.println();

        // Note - Use Short-forms like USA - us, India - india, etc

        getData(country);
    }
}
