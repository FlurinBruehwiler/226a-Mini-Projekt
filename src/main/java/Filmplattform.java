package main.java;

import main.java.ui.Authentication;
import main.java.ui.Homepage;

public class Filmplattform {
    /**
     * Description: Main method
     * @param args
     */
    public static void main(String[] args) {
        ObjCache.readAllObjects();
        Authentication.authentificate();
        Homepage.showPage();
    }
}
