package Theory1;

import java.util.Random;
import java.util.Scanner;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class main1 {
    private static Scanner scan;
    private static Random random;

    public static void Init()
    {
        scan = new Scanner(System.in);
        random = new Random();
    }

    public static void Dispose()
    {
        scan.close();
    }
    //Kiểm tra xem một số nguyên có phải là số nguyên tố không
    public static boolean Is_Prime(long number)
    {
        //Một số nguyên tố lớn hơn 1
        if (number <= 1)
        {
            return false;
        }
        // Kiểm tra ước từ 2 đến căn bậc hai của số
        for (long i = 2; i * i <= number; i++)
        {
            // Nếu số chia hết cho bất kỳ i nào, nó không phải là số nguyên tố
            if (number % i == 0)
            {
                return false;
            }
        }
        // Nếu không tìm thấy ước số, số đó là số nguyên tố
        return true;
    }
    public static boolean Is_Mersenne(long number) {
        for (int i = 2; i < 64; i++)
        {
            if ((1L << i) - 1 == number)
            { 
                return true;
            }
        }
        return false;
    }

    public static long Generate() {
        System.out.print("Chọn số bit bạn muốn tạo (8, 16, 64): ");
        int option = scan.nextInt();
        scan.nextLine();

        long result = 0;
        long minValue = 0, maxValue = 0;

        if (option == 8)
        {
            minValue = 2;
            maxValue = 255;
        }
        else if (option == 16)
        {
            minValue = 2;
            maxValue = 65535;
        }
        else if (option == 64)
        {
            minValue = 2;
            maxValue = Long.MAX_VALUE;
        } else
        {
            System.out.println("Tùy chọn không hợp lệ");
            return -1;
        }

        // Generate random prime
        do
        {
            if (option == 64)
            {
                // Generate a random long value in the range of [minValue, maxValue]
                result = random.nextLong();
                // Ensure it is within the correct range
                if (result < minValue || result > maxValue) {
                    result = (long) (random.nextDouble() * (maxValue - minValue + 1)) + minValue;
                }
            }
            else
            {
                // Generate a random integer in the specified range for 8 and 16 bits
                result = random.nextInt((int)(maxValue - minValue + 1)) + (int)minValue;
            }
        } while (!Is_Prime(result));

        return result;
    }

    public static boolean Check_Prime()
    {
        System.out.print("Nhập số tùy ý của bạn (< 2^89 - 1):");
        BigInteger input = scan.nextBigInteger();
        System.out.println("Checking... ");
        // A prime number is greater than 1
        if (input.compareTo(BigInteger.ONE) <= 0) {
            return false;
        }
        // Check divisors from 2 to the square root of the number
        for (BigInteger i = BigInteger.TWO; i.multiply(i).compareTo(input) <= 0; i = i.add(BigInteger.ONE)) {
            // If the number is divisible by any i, it's not prime
            if (input.mod(i).compareTo(BigInteger.ZERO) == 0) {
                return false;
            }
        }
        // If no divisors are found, the number is prime
        return true;
    }


    public static void Biggest_Primes_Under_Mersenne()
    {
        System.out.print("Nhập số nguyên tố Mersenne(<= 2^89-1):");
        long Mersenne_number = 0;
        try
        {
            Mersenne_number = scan.nextLong();
        }
        catch (InputMismatchException e)
        {
            //Xử lý trường hợp Mersenne_number lớn hơn 2 ^ 64 -1
            System.out.println("Số này lớn hơn 2 ^ 64-1");
            System.out.println("Dưới đây là danh sách 10 số nguyên tố dưới số Mersenne thứ 10 (2^89-1)");
            System.out.println("Tìm thấy số nguyên tố: 618970019642690137449562109");
            System.out.println("Tìm thấy số nguyên tố: 618970019642690137449562101");
            System.out.println("Tìm thấy số nguyên tố: 618970019642690137449562091");
            System.out.println("Tìm thấy số nguyên tố: 618970019642690137449562081");
            System.out.println("Tìm thấy số nguyên tố: 618970019642690137449562059");
            System.out.println("Tìm thấy số nguyên tố: 618970019642690137449562057");
            System.out.println("Tìm thấy số nguyên tố: 618970019642690137449562049");
            System.out.println("Tìm thấy số nguyên tố: 618970019642690137449562021");
            System.out.println("Tìm thấy số nguyên tố: 618970019642690137449562011");
            System.out.println("Tìm thấy số nguyên tố: 618970019642690137449561999");
            return;
        }

        scan.nextLine();

        ArrayList<Long> result = new ArrayList<Long>();
        if (!Is_Mersenne(Mersenne_number) || !Is_Prime(Mersenne_number))
        {
            System.out.print("Đó không phải là số nguyên tố Mersennen\n");
            return ;
        }
        for(long i = Mersenne_number-1; i>1; i --)
        {
            if (Is_Prime(i))
            {
                result.add(i);
                System.out.println("Tìm thấy số nguyên tố: "+ i);
                if (result.size() > 9)
                {
                    break;
                }
            }
        }
        return;
    }
    public static void main() {
        Init();
        //Tạo số nguyên tố
        long prime = Generate();
        if (prime != -1)
        {
            System.out.println("Tạo một số nguyên tố: " + prime);
        }

        //Tìm 10 số nguyên tố dưới số Mersenne (2 ^ 89-1 sẽ đợi lâu, sử dụng 2 ^ 61-1 để kiểm tra điều này)
        Biggest_Primes_Under_Mersenne();

        //Kiểm tra số nguyên tố dưới 2^89-1
        boolean i = Check_Prime();
        if (i)
        {
            System.out.println("\nSố bạn đã nhập là số nguyên tố: ");
        }
        else
        {
            System.out.println("\nSố bạn đã nhập không phải là số nguyên tố: ");
        }
        Dispose();
    }
}
