package main.java;

import main.java.ui.Authentication;
import main.java.ui.Homepage;

public class Starter {
    /**
     * Description: Main method
     * @param args
     */
    public static void main(String[] args) {
        ObjCache.ReadAllObjects();
        Authentication.authentificate();
        Homepage.showPage();
    }
}
