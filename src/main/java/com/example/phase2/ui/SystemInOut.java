package com.example.phase2.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInOut {
    BufferedReader reader;


    public SystemInOut() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    public String getInput() throws IOException {
        return reader.readLine();
    }

    public void sendOutput(Object s) {
        System.out.println(s);
    }
}
