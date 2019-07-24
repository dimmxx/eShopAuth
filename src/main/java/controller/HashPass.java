package controller;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class HashPass {

    public static String hashPass (String string){
        return Hashing.sha256().hashString(string, StandardCharsets.UTF_8).toString();
    }
}
