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
        System.out.println("0\tThoat");
        System.out.println("1\tC1.1.1. Tao mot so nguyen to ngau nhien");
        System.out.println(" \t        Xac dinh 10 so nguyen to lon nhat duoi 10 Mersenn đau tien so nguyen to");
        System.out.println(" \t        Kiem tra mot so nguyen to nho hon 2^89 - 1 có phai la so nguyen to khong");
        System.out.println("2\tC1.1.2. Xac dinh uoc chung lon nhat cua 2 lon nguyen to tuy y");
        System.out.println("3\tC1.1.3. Tinh toan (a^x) mod p voi (x > 40))");
        System.out.println("4\tC2.2.   RSA");
        System.out.println("******************************************************************************");
        System.out.println("Chon so ma ban muon thuc hien nhiem vu (Nhap so): ");
    }

    public static void Start() {
        String choice;
        do {
            printMENU();
            choice = sc.nextLine();
            switch (choice) {
                case "0":
                    System.out.println("Dang tai...");
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
                        System.out.println("1 loi : " + e.getMessage());
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
