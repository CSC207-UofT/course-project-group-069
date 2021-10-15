package ui;

import controller.MealsSystem;

public class MealsMain {

    public static void main(String[] args) {

        MealsSystem ms = new MealsSystem();
        SystemInOut inOut = new SystemInOut();
        ms.run(inOut);
    }


}
