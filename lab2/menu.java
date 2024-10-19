import RSA.main;
import java.util.Scanner;
import Theory1.main1;
import Theory2.main2;
import Theory3.main3;

public class menu {
    private static Scanner sc;
    public static void init() {
        sc = new Scanner(System.in);
    }

    public static void printMENU() {
        System.out.println("******************************************************************************");
        System.out.println("\t\tLAB2");
        System.out.println("0\tThoát");
        System.out.println("1\tC1.1.1. Tạo một số nguyên tố ngẫu nhiên");
        System.out.println(" \t        Xác định 10 số nguyên tố lớn nhất dưới 10 Mersenn đầu tiên số nguyên tố");
        System.out.println(" \t        Kiểm tra một số nguyên tố nhỏ hơn 2^89 - 1 có phải là số nguyên tố không");
        System.out.println("2\tC1.1.2. Xác định ước chung lớn nhất của 2 lớn nguyên tố tùy ý");
        System.out.println("3\tC1.1.3. Tính toán (a^x) mod p với (x > 40))");
        System.out.println("4\tC2.2.   RSA");
        System.out.println("******************************************************************************");
        System.out.println("Chọn số mà bạn muốn thực hiện nhiệm vụ (Nhập số): ");
    }

    public static void Start() {
        String choice;
        do {
            printMENU();
            choice = sc.nextLine();
            switch (choice) {
                case "0":
                    System.out.println("Exiting...");
                    return;
                case "1":
                    main1.main();
                    break;
                case "2":
                    main2.main();
                    break;
                case "3":
                    main3.main();
                    break;
                case "4":
                    try {
                        main.main(); // Call the SimpleRSA main method
                    } catch (Exception e) {
                        System.out.println("An error occurred: " + e.getMessage());
                        e.printStackTrace(); // Optional: Print the stack trace for debugging
                    }
            }
        }
        while(sc.hasNextLine());
    }
    public static void main(String[] args) {
        init();

        Start();

        sc.close();
    }
}
