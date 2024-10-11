package com.Pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;


    public class App {
        public static void main(String[] args) {


            try {
                FileReader fileReader = new FileReader("src/main/resources/products.csv");
                // create a BufferedReader to manage input stream
                BufferedReader bufReader = new BufferedReader(fileReader);
                String input;
                Product[] products = new Product[12];

                int count = 0;

                while ((input = bufReader.readLine()) != null) {
                    if (input.startsWith("sku")) {
                        continue;
                    }

                    String[] lineSplit = input.split(Pattern.quote("|"));
                    products[count++] = new Product(lineSplit[0], lineSplit[1], Double.parseDouble(lineSplit[2]), lineSplit[3]);

                    bufReader.close();
                }
            }
                catch (IOException e) {
                    System.out.println("ERROR:  An unexpected error occurred");
                    e.getStackTrace();
                }
            }
}
