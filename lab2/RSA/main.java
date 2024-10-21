package RSA;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;
import java.util.Base64;
import java.util.Scanner;
import java.security.SecureRandom;

public class main {

    public static void main() throws Exception {
        System.out.println("Ma hoa RSA");
        System.out.println("*********************");
        System.out.println("Khoa cong khai đuoc tao ngau nhien hoac ban co the tu nhap chung.");
        System.out.println("*********************");
        Scanner scanner = new Scanner(System.in);
        String choose;
        do {
            System.out.print("Vay ban muon gi? Tu nhap hay Ngau nhien? (nhap 'i' cho đau vao, 'r' cho ngau nhien)");
            choose = scanner.nextLine();
        }
        while(!choose.equals("i") && !choose.equals("r"));

        BigInteger p, q, e;
        if (choose.equals("i")) {
            do {
                System.out.print("Nhap so nguyen to p (phải la số nguyen to & co it nhat 128 chu so):");
                p = new BigInteger(scanner.nextLine());
                if (!p.isProbablePrime(10) || p.compareTo(new BigInteger("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")) <= 0) {
                    System.out.println("p khong phai la mot so nguyen to, hoac no khong đu lon. Vui long nhap lai p.");
                }
            } while (!p.isProbablePrime(10) || p.compareTo(new BigInteger("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")) <= 0);

            do {
                System.out.print("Nhap so nguyen to q (phai la so nguyen to & co it nhat 128 chu so): ");
                q = new BigInteger(scanner.nextLine());
                if (!q.isProbablePrime(10) || p.compareTo(new BigInteger("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")) <= 0) {
                    System.out.println("q khong phai la mot so nguyen to, hoac no khong đu lon. Vui long nhap lai q.");
                }
            } while (!q.isProbablePrime(10) || p.compareTo(new BigInteger("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")) <= 0);
            do {
                System.out.print("Nhap so mu cong khai e (phai la so nguyen to & co it nhat 6 chu so):");
                e = new BigInteger(scanner.nextLine());
                if (!e.isProbablePrime(10) || p.compareTo(new BigInteger("100000")) <= 0) {
                    System.out.println("e khong phai la mot so nguyen to, hoac no khong đu lon. Vui long nhap lai e.");
                }
            } while (!e.isProbablePrime(10) || p.compareTo(new BigInteger("100000")) <= 0);
        }
        else {
            p = generateRandomPrime();
            q = generateRandomPrime();
            e = generateRandomPrimeExponent();
        }
    }

    public static KeyPair generateKeyPair(BigInteger p, BigInteger q, BigInteger e) throws Exception {
        BigInteger n = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        BigInteger d = e.modInverse(phi);

        RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(n, e);
        RSAPrivateKeySpec privateKeySpec = new RSAPrivateKeySpec(n, d);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
        PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

        return new KeyPair(publicKey, privateKey);
    }

    public static byte[] encrypt(String message, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(message.getBytes());
    }

    public static String decrypt(byte[] encryptedMessage, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedMessage);
        return new String(decryptedBytes);
    }

    public static BigInteger generateRandomPrime() {
        SecureRandom random = new SecureRandom();
        BigInteger prime;
        do {
            prime = new BigInteger(1024, random);
        } while (!prime.isProbablePrime(10) || prime.compareTo(new BigInteger("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")) <= 0);
        return prime;
    }

    public static BigInteger generateRandomPrimeExponent() {
        SecureRandom random = new SecureRandom();
        BigInteger exponent;
        do {
            exponent = new BigInteger(128, random);
        } while (!exponent.isProbablePrime(10) || exponent.compareTo(new BigInteger("100000")) <= 0);
        return exponent;
    }
    
}
