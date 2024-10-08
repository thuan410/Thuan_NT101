package Caeser;
import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class caeser {
   public static List<Character> chars_list = new ArrayList();
   public static Scanner sc;
   public static Console c;

   public static void init() {
    c = System.console();
    sc = new Scanner(System.in);
    Collections.addAll(chars_list, new Character[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'});
 }

 public static String Caesar_Cipher(String var0) {
    int var1 = var0.length();
    var0 = var0.toLowerCase();
    String var2 = "";
    System.out.print("Please select : 1 - encrypt with key, 2 - decrypt with key, 3- brute force : ");
    String var3 = sc.nextLine();
    int var4;
    int var5;
    char var6;
    if (var3.equals("3")) {
       for(var4 = 1; var4 < 27; ++var4) {
          var2 = "";

          for(var5 = 0; var5 < var1; ++var5) {
             var6 = var0.charAt(var5);
             if (!chars_list.contains(var6)) {
                var2 = var2 + var6;
             } else {
                var6 = (Character)chars_list.get((chars_list.indexOf(var6) + var4) % 26);
                var2 = var2 + var6;
             }
          }

          System.out.print(var2 + "\n");
          System.out.print("****************************************");
          c.readLine();
       }
    }

    System.out.print("Enter the key: ");
    var4 = sc.nextInt();
    sc.nextLine();
    if (var3.equals("1")) {
       var2 = "";

       for(var5 = 0; var5 < var1; ++var5) {
          var6 = var0.charAt(var5);
          if (!chars_list.contains(var6)) {
             var2 = var2 + var6;
          } else {
             var6 = (Character)chars_list.get((chars_list.indexOf(var6) + var4) % 26);
             var2 = var2 + var6;
          }
       }

       System.out.print(var2 + "\n");
       System.out.print("****************************************");
       c.readLine();
    } else if (var3.equals("2")) {
       var2 = "";

       for(var5 = 0; var5 < var1; ++var5) {
          var6 = var0.charAt(var5);
          if (!chars_list.contains(var6)) {
             var2 = var2 + var6;
          } else {
             int var7 = chars_list.indexOf(var6) - var4;
             if (var7 < 0) {
                var7 += 26;
             }

             var6 = (Character)chars_list.get(var7);
             var2 = var2 + var6;
          }
       }

       System.out.print(var2 + "\n");
       System.out.print("****************************************");
       c.readLine();
    }

    return var2;
 }

 public static void Print_Menu() {
    System.out.println("****************************************");
    System.out.println("Select the algorithm you want to use");
    System.out.println("1. Caesar_Cipher");
    //System.out.println("2. Playfair_Cipher");
    //System.out.println("3. Vigenere_Cipher");
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
                   var0 = sc.nextLine();
                   Caesar_Cipher(var0);
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
