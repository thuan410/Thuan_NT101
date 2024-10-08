import java.io.Console;
import java.util.*;

/**
 * caeser_cipher
 */
public class caeser_cipher {

    public static List<Character> chars_list = new ArrayList<Character>();
    public static Scanner sc;
    public static Console c;
    public static void init()
    {
        c = System.console();   
        sc = new Scanner(System.in);
        Collections.addAll(chars_list, 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
    }

    public static String Caesar_Cipher(String input)
    {
        int length = input.length();
        input = input.toLowerCase();
        String result = "";
        System.out.print("Please Choose : (1) - encrypt with key, (2) - decrypt with key, 3 - brute force: ");
        String option = sc.nextLine();
        if (option.equals("3"))
        {
            for(int key = 1; key < 27; key++)
            {
                result = "";
                for(int i = 0; i < length; i++)
                {
                    char character = input.charAt(i);
                    if (!chars_list.contains(character))
                    {
                        result += character;
                        continue;
                    }
                    
                    character = chars_list.get((chars_list.indexOf(character) + key) % 26);
                    result += character;
                }
                System.out.print(result + "\n");
                System.out.print("****************************************");
                c.readLine();
            }
        }
        System.out.print("Enter the key: ");
        int key = sc.nextInt();
        sc.nextLine();
        if (option.equals("1")) {
            //Encrypt
            result = "";
            for(int i = 0; i < length; i++)
            {
                char character = input.charAt(i);
                if (!chars_list.contains(character))
                {
                    result += character;
                    continue;
                }
                
                character = chars_list.get((chars_list.indexOf(character) + key) % 26);
                result += character;
            }
            System.out.print(result + "\n");
            System.out.print("****************************************");
            c.readLine();
        }
        else if (option.equals("2")) {
            //Decrypt
            result = "";
            for(int i = 0; i < length; i++)
            {
                char character = input.charAt(i);
                if (!chars_list.contains(character))
                {
                    result += character;
                    continue;
                }
                int delta = chars_list.indexOf(character) - key;
                if (delta < 0) {
                    delta +=26;
                }
                character = chars_list.get(delta);
                result += character;
            }
            System.out.print(result + "\n");
            System.out.print("****************************************");
            c.readLine();
        }
        return result;
    }



    public static void Print_Menu()
    {
        System.out.println("****************************************");
        System.out.println("Select the algorithm you want to use");
        System.out.println("1. Caesar_Cipher");
    //  System.out.println("2. Playfair_Cipher");
     // System.out.println("3. Vigenere_Cipher");
        System.out.println("0. Exit");
        System.out.println("****************************************");
    }



    public static void Start() {
        String input = "";
        while (true) {
            Print_Menu();
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                sc.nextLine(); //Clear "/n" character
                System.out.println("Enter text:");
                switch (choice) {
                    case 1:
                        input = sc.nextLine();
                        Caesar_Cipher(input);
                        break;
                   
                   
                    case 0:
                        return;
                    default:
                        break;
                }
            } else {
                System.out.println("Invalid input");
                sc.next();
            }
        }
    }

    public static void main(String[] args)
    {
        init();
        Start();   
        
        sc.close();
    }

}