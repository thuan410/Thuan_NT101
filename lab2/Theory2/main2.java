package Theory2;

import java.math.BigInteger;
import java.util.Scanner;

public class main2 {
    public static void main() {
        Scanner scan = new Scanner(System.in);

        // Nhập số nguyên lớn đầu tiên
        System.out.print("Nhập số nguyên lớn đầu tiên: ");
        BigInteger num1 = new BigInteger(scan.nextLine());

        // Nhập số nguyên lớn thứ hai
        System.out.print("Nhập số nguyên lớn thứ hai: ");
        BigInteger num2 = new BigInteger(scan.nextLine());

        // Tính GCD(ước chung lớn nhất)
        BigInteger gcd = num1.gcd(num2);

        // Kết quả
        System.out.println("GCD(ước chung lớn nhất) của  " + num1 + " và " + num2 + " là: " + gcd);

        scan.close();
    }
}
