package vigenereCipher;
import java.io.Console;
import java.util.*;


public class vigenere_cipher {
    public static List<Character> chars_list = new ArrayList<Character>();
    public static Scanner sc;
    public static Console c;
    public static void init()
    {
        c = System.console();   
        sc = new Scanner(System.in);
        Collections.addAll(chars_list, 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
    }

    public static String Vigenere_Cipher(String input)
    {
        int length = input.length();
        int current_key_pos = 0;
        String result = "";
        System.out.print("Enter key : ");

        String key = sc.nextLine();
        char[] key_elements = key.toCharArray();
        List<Integer> new_key = new ArrayList<Integer>() ;
        for(char character:key_elements)
        {
            int number_of_this_key = chars_list.indexOf(character);
            new_key.add(number_of_this_key);
        }
        int key_length = new_key.size();

        System.out.print("Enter option(1 - encrypt , 2 - decrypt) : ");
        String option = sc.nextLine();
        if (option.equals("1"))
        {
            for(int i = 0; i<length; i++)
            {
                char character = input.charAt(i);
                if (!chars_list.contains(character))
                {
                    result += character;
                    continue;
                }
                character = chars_list.get((chars_list.indexOf(character) + new_key.get(current_key_pos)) % 26);
                current_key_pos++;
                if(current_key_pos == key_length)
                {
                    current_key_pos = 0;
                }
                result+= character;
            }   
        }
        else if (option.equals("2"))
        {
            for(int i = 0; i<length; i++)
            {
                char character = input.charAt(i);
                if (!chars_list.contains(character))
                {
                    result += character;
                    continue;
                }
                int delta = chars_list.indexOf(character) - new_key.get(current_key_pos);
                if (delta < 0) {
                    delta += 26;
                }
                character = chars_list.get(delta);
                current_key_pos++;
                if(current_key_pos == key_length)
                {
                    current_key_pos = 0;
                }
                result+= character;
            }   
        }
        return result;
    }

    public static void Print_Menu()
    {
        System.out.println("****************************************");
        System.out.println("Select the algorithm you want to use");
        //System.out.println("1. Caesar_Cipher");
        //System.out.println("2. Playfair_Cipher");
        System.out.println("1. Vigenere_Cipher");
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
                System.out.println("Enter text : ");




                switch (choice) {
                    case 1:
                        input = sc.nextLine();
                        String output = Vigenere_Cipher(input);
                        System.out.println(output);
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
