import PlayFair.playfair;
import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class merger {
   public static List<Character> chars_list = new ArrayList();
   public static Scanner sc;
   public static Console c;

   public static void init() {
    c = System.console();
    sc = new Scanner(System.in);
    Collections.addAll(chars_list, new Character[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'});
 }

 public static void Print_Menu() {
    System.out.println("****************************************");
    System.out.println("Select the algorithm you want to use");
    System.out.println("1. Playfair_Cipher");
    System.out.println("0. Exit");
    System.out.println("****************************************");
 }

 public static void Start() {
    String var0 = "";

    while(true) {
       while(true) {
          Print_Menu();
          if (sc.hasNextInt()) {
             int var1 = sc.nextInt();
             sc.nextLine();
             System.out.println("Enter text:");
             switch (var1) {
                case 0:
                   return;
                case 1:
                   new playfair();
                   break;
                
             }
          } else {
             System.out.println("Invalid input");
             sc.next();
          }
       }
    }
 }

 public static void main(String[] var0) {
    init();
    Start();
    sc.close();
 }
}
