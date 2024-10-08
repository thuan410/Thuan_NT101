package vigenere;
import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class vigenere {
   public static List<Character> chars_list = new ArrayList();
   public static Scanner sc;
   public static Console c;
    

   public static void init() {
    c = System.console();
    sc = new Scanner(System.in);
    Collections.addAll(chars_list, new Character[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'});
 }

 public static String Vigenere_Cipher(String var0) {
    int var1 = var0.length();
    int var2 = 0;
    String var3 = "";
    System.out.print("Enter key: ");
    String var4 = sc.nextLine();
    char[] var5 = var4.toCharArray();
    ArrayList var6 = new ArrayList();
    char[] var7 = var5;
    int var8 = var5.length;

    int var9;
    char var10;
    int var11;
    for(var9 = 0; var9 < var8; ++var9) {
       var10 = var7[var9];
       var11 = chars_list.indexOf(var10);
       var6.add(var11);
    }

    int var12 = var6.size();
    System.out.print("Please select (1 - encrypt with key, 2 - decrypt with key): ");
    String var13 = sc.nextLine();
    if (var13.equals("1")) {
       for(var9 = 0; var9 < var1; ++var9) {
          var10 = var0.charAt(var9);
          if (!chars_list.contains(var10)) {
             var3 = var3 + var10;
          } else {
             var10 = (Character)chars_list.get((chars_list.indexOf(var10) + (Integer)var6.get(var2)) % 26);
             ++var2;
             if (var2 == var12) {
                var2 = 0;
             }

             var3 = var3 + var10;
          }
       }
    } else if (var13.equals("2")) {
       for(var9 = 0; var9 < var1; ++var9) {
          var10 = var0.charAt(var9);
          if (!chars_list.contains(var10)) {
             var3 = var3 + var10;
          } else {
             var11 = chars_list.indexOf(var10) - (Integer)var6.get(var2);
             if (var11 < 0) {
                var11 += 26;
             }

             var10 = (Character)chars_list.get(var11);
             ++var2;
             if (var2 == var12) {
                var2 = 0;
             }

             var3 = var3 + var10;
          }
       }
    }

    return var3;
 }

 public static void Print_Menu() {
    System.out.println("****************************************");
    System.out.println("Select the algorithm you want to use");
    System.out.println("1. Vigenere_Cipher");
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
                   String var3 = Vigenere_Cipher(var0);
                   System.out.println(var3);
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
