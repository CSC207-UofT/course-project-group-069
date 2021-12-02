package com.example.phase2.ui;

import com.example.phase2.controller.MealsSystem;

public class MealsMain {

    public static void main(String[] args) {

        MealsSystem ms = new MealsSystem();
        SystemInOut inOut = new SystemInOut();
        ms.run(inOut);
    }


}
