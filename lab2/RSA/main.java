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
        System.out.println("Mã hóa RSA");
        System.out.println("*********************");
        System.out.println("Đây là tin nhắn cần được mã hóa: Xin chào RSA!");
        System.out.println("*********************");
        System.out.println("Khóa công khai được tạo ngẫu nhiên hoặc bạn có thể tự nhập chúng.");
        System.out.println("*********************");
        Scanner scanner = new Scanner(System.in);
        String choose;
        do {
            System.out.print("Vậy bạn muốn gì? Tự nhập hay Ngẫu nhiên? (nhập 'i' cho đầu vào, 'r' cho ngẫu nhiên)");
            choose = scanner.nextLine();
        }
        while(!choose.equals("i") && !choose.equals("r"));

        BigInteger p, q, e;
        if (choose.equals("i")) {
            do {
                System.out.print("Nhập số nguyên tố p (phải là số nguyên tố & có ít nhất 128 chữ số):");
                p = new BigInteger(scanner.nextLine());
                if (!p.isProbablePrime(10) || p.compareTo(new BigInteger("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")) <= 0) {
                    System.out.println("p không phải là một số nguyên tố, hoặc nó không đủ lớn. Vui lòng nhập lại p.");
                }
            } while (!p.isProbablePrime(10) || p.compareTo(new BigInteger("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")) <= 0);

            do {
                System.out.print("Nhập số nguyên tố q (phải là số nguyên tố & có ít nhất 128 chữ số): ");
                q = new BigInteger(scanner.nextLine());
                if (!q.isProbablePrime(10) || p.compareTo(new BigInteger("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")) <= 0) {
                    System.out.println("q không phải là một số nguyên tố, hoặc nó không đủ lớn. Vui lòng nhập lại q.");
                }
            } while (!q.isProbablePrime(10) || p.compareTo(new BigInteger("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")) <= 0);
            do {
                System.out.print("Nhập số mũ công khai e (phải là số nguyên tố & có ít nhất 6 chữ số):");
                e = new BigInteger(scanner.nextLine());
                if (!e.isProbablePrime(10) || p.compareTo(new BigInteger("100000")) <= 0) {
                    System.out.println("e không phải là một số nguyên tố, hoặc nó không đủ lớn. Vui lòng nhập lại e.");
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
