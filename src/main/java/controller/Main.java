package controller;

import com.google.common.hash.Hashing;
import model.Cart;
import model.Product;

import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String sha256hex =
                Hashing.sha256().hashString("qwerty", StandardCharsets.UTF_8).toString();

        System.out.println(sha256hex);


    }
}
