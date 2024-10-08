package PlayFair;
import java.awt.Point;
import java.util.Scanner;

public class playfair {
    public int length = 0;
   public String[][] table;
   public String choice;

   public playfair() {
    Scanner var1 = new Scanner(System.in);

    do {
        System.out.println("Select : 'e' to encode or 'd' to decode a message.");
        this.choice = var1.nextLine();
     } while(!this.choice.equals("e") && !this.choice.equals("d"));

     System.out.println("Please input the keyword for the Playfair cipher.");

     String var2;
     for(var2 = this.parseString(var1); var2.equals(""); var2 = this.parseString(var1)) {
     }

     System.out.println();
     this.table = this.cipherTable(var2);
     System.out.println("Please input the message you would like to " + (this.choice.equals("e") ? "encode." : "decode."));

     String var3;
     for(var3 = this.parseString(var1); var3.equals(""); var3 = this.parseString(var1)) {
     }

     System.out.println();
     String var4 = "";
     switch (this.choice) {
        case "e":
           var4 = this.cipher(var3);
           break;
        case "d":
           var4 = this.decode(var3);
     }

     this.printTable(this.table);
     this.printResults(var4);
   }

   private String parseString(Scanner var1) {
    StringBuilder var2 = new StringBuilder();

    while(var1.hasNextLine()) {
       String var3 = var1.nextLine();
       if (var3.isEmpty()) {
          break;
       }

       var3 = var3.toUpperCase();
       var3 = var3.replaceAll("[^A-Z]", "");
       var3 = var3.replace("J", "I");
       var2.append(var3);
    }

    return var2.toString();
 }

 private String[][] cipherTable(String var1) {
    String[][] var2 = new String[5][5];
    String var3 = var1 + "ABCDEFGHIKLMNOPQRSTUVWXYZ";

    int var4;
    for(var4 = 0; var4 < 5; ++var4) {
       for(int var5 = 0; var5 < 5; ++var5) {
          var2[var4][var5] = "";
       }
    }

    for(var4 = 0; var4 < var3.length(); ++var4) {
       boolean var9 = false;
       boolean var6 = false;

       for(int var7 = 0; var7 < 5; ++var7) {
          for(int var8 = 0; var8 < 5; ++var8) {
             String var10000 = var2[var7][var8];
             char var10001 = var3.charAt(var4);
             if (var10000.equals("" + var10001)) {
                var9 = true;
             } else if (var2[var7][var8].equals("") && !var9 && !var6) {
                String[] var10 = var2[var7];
                char var10002 = var3.charAt(var4);
                var10[var8] = "" + var10002;
                var6 = true;
             }
          }
       }
    }

    return var2;
 }
 private String cipher(String var1) {
    this.length = var1.length() / 2 + var1.length() % 2;

    for(int var2 = 0; var2 < this.length - 1; ++var2) {
       if (var1.charAt(2 * var2) == var1.charAt(2 * var2 + 1)) {
          var1 = (new StringBuffer(var1)).insert(2 * var2 + 1, 'X').toString();
          this.length = var1.length() / 2 + var1.length() % 2;
       }
    }

    String[] var6 = new String[this.length];

    for(int var3 = 0; var3 < this.length; ++var3) {
       if (var3 == this.length - 1 && var1.length() / 2 == this.length - 1) {
          var1 = var1 + "X";
       }

       char var10002 = var1.charAt(2 * var3);
       var6[var3] = "" + var10002 + var1.charAt(2 * var3 + 1);
    }

    StringBuilder var7 = new StringBuilder();
    String[] var4 = new String[this.length];
    var4 = this.encodeDigraph(var6);

    for(int var5 = 0; var5 < this.length; ++var5) {
       var7.append(var4[var5]);
    }

    return var7.toString();
 }
 private String[] encodeDigraph(String[] var1) {
    String[] var2 = new String[this.length];

    for(int var3 = 0; var3 < this.length; ++var3) {
       char var4 = var1[var3].charAt(0);
       char var5 = var1[var3].charAt(1);
       int var6 = (int)this.getPoint(var4).getX();
       int var7 = (int)this.getPoint(var5).getX();
       int var8 = (int)this.getPoint(var4).getY();
       int var9 = (int)this.getPoint(var5).getY();
       if (var6 == var7) {
          var8 = (var8 + 1) % 5;
          var9 = (var9 + 1) % 5;
       } else if (var8 == var9) {
          var6 = (var6 + 1) % 5;
          var7 = (var7 + 1) % 5;
       } else {
          int var10 = var8;
          var8 = var9;
          var9 = var10;
       }

       var2[var3] = this.table[var6][var8] + this.table[var7][var9];
    }

    return var2;
 }

 private String decode(String var1) {
    String var2 = "";

    for(int var3 = 0; var3 < var1.length() / 2; ++var3) {
       char var4 = var1.charAt(2 * var3);
       char var5 = var1.charAt(2 * var3 + 1);
       int var6 = (int)this.getPoint(var4).getX();
       int var7 = (int)this.getPoint(var5).getX();
       int var8 = (int)this.getPoint(var4).getY();
       int var9 = (int)this.getPoint(var5).getY();
       if (var6 == var7) {
          var8 = (var8 + 4) % 5;
          var9 = (var9 + 4) % 5;
       } else if (var8 == var9) {
          var6 = (var6 + 4) % 5;
          var7 = (var7 + 4) % 5;
       } else {
          int var10 = var8;
          var8 = var9;
          var9 = var10;
       }

       var2 = var2 + this.table[var6][var8] + this.table[var7][var9];
    }

    return var2;
 }

 private Point getPoint(char var1) {
    Point var2 = new Point(0, 0);

    for(int var3 = 0; var3 < 5; ++var3) {
       for(int var4 = 0; var4 < 5; ++var4) {
          if (var1 == this.table[var3][var4].charAt(0)) {
             var2 = new Point(var3, var4);
          }
       }
    }

    return var2;
 } 
   
 private void printTable(String[][] var1) {
    System.out.println("This is the cipher table from the given keyword.");
    System.out.println();

    for(int var2 = 0; var2 < 5; ++var2) {
       for(int var3 = 0; var3 < 5; ++var3) {
          System.out.print(var1[var2][var3] + " ");
       }

       System.out.println();
    }

    System.out.println();
 }
    
 private void printResults(String var1) {
    switch (this.choice) {
       case "e":
          System.out.println("This is the encoded message:");
          break;
       case "d":
          System.out.println("This is the decoded message:");
    }

    System.out.println(var1);
 }
}
