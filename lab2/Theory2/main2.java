package Theory2;

import java.math.BigInteger;
import java.util.Scanner;

public class main2 {
    public static void main() {
        Scanner scan = new Scanner(System.in);

        // Nhập số nguyên lớn đầu tiên
        System.out.print("Nhap so nguyen lon đau tien: ");
        BigInteger num1 = new BigInteger(scan.nextLine());

        // Nhập số nguyên lớn thứ hai
        System.out.print("Nhap so nguyen lon thu hai: ");
        BigInteger num2 = new BigInteger(scan.nextLine());

        // Tính GCD(ước chung lớn nhất)
        BigInteger gcd = num1.gcd(num2);

        // Kết quả
        System.out.println("GCD(uoc chung lon nhat) cua  " + num1 + " va " + num2 + " la: " + gcd);

        scan.close();
    }
}
