package com.mjc.school;


import com.mjc.school.controller.impl.NewsController;
import com.mjc.school.util.ConsoleUtil;
import com.mjc.school.util.MenuHelper;
import com.mjc.school.util.Narrator;
import com.mjc.school.util.TalkingAt;

public class Main {
    public static void main(String[] args) {
        Narrator narrator = new Narrator(Main.class, TalkingAt.Left);
        ConsoleUtil consoleUtil = new ConsoleUtil(narrator);
        MenuHelper helper = new MenuHelper(narrator,new NewsController());

        while (true) {
            try {
                helper.printMainMenu();
                String command = consoleUtil.getValueOf("Enter your choice");
                switch (command) {
                    case "1":
                        helper.getNews();
                        break;
                    case "2":
                        helper.getNewsById();
                        break;
                    case "3":
                        helper.createNews();
                        break;
                    case "4":
                        helper.updateNews();
                        break;
                    case "5":
                        helper.deleteNews();
                        break;
                    case "0":
                        narrator.sayln("Exiting application...");
                        System.exit(0);
                        break;
                    default:
                        narrator.sayln("Command not found.");
                }
            } catch (RuntimeException ex) {
                narrator.sayln("Error: " + ex.getMessage());
            }
        }
    }
}
