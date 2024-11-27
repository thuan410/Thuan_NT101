import java.io.FileInputStream;
import java.io. IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;


public class task1 {

    public static String calculateHash(String input, String algorithm) 
    throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        byte[] hash = digest.digest(input.getBytes());
        return bytesToHex(hash);
    }

    public static String calculateHashFromFile(String filePath, String algorithm)
    throws NoSuchAlgorithmException, IOException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        FileInputStream fis = new FileInputStream(filePath);
        byte[] buffer = new byte[1024];
        int bytesRead = -1;
        while((bytesRead = fis.read(buffer)) != -1) {
            digest. update(buffer,0, bytesRead);
        }
        fis.close();
        byte[] hash = digest.digest();
        return bytesToHex(hash);
    }

    public static String calculateHashFromHexString(String hexString, String algorithm) 
    throws NoSuchAlgorithmException {
        byte[] bytes = hexStringToByteArray(hexString);
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        byte[] hash = digest.digest (bytes);
        return bytesToHex(hash);
}


    private static String bytesToHex(byte[] bytes) { 
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
        result.append(String.format("%02x", b));
        }
        return result.toString();
        }

    private static byte[] hexStringToByteArray(String hexString) { 
        int len = hexString. length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
        data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
            + Character.digit(hexString.charAt(i + 1), 16));
            }
        return data;    
            }

    private static void displayMenu() {
        System.out.println("\nHay chon du lieu de bam: ");
        System.out.println("1. Bam text string");
        System.out.println("2. Bam hex string");
        System.out.println("3. Bam noi dung tu file");
        System.out.println("4. Thoat khoi chuong trinh");
        System.out.print ("Lua chon cua ban: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        try {
            while (running) {
                displayMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Nhap chuoi van ban de bam: ");
                        String teString = scanner.nextLine();
                        System.out.println("\nBam chuoi van ban: ");
                        System.out.println("MD5 :" + calculateHash(teString, "MD5"));
                        System.out.println("SHA-1 " + calculateHash(teString, "SHA-1"));
                        System.out.println("SH5-256: " + calculateHash(teString, "SHA-256"));
                        break;
                

                        case 2:
                        System.out.println("Nhap chuoi van ban de bam: ");
                        String hexString = scanner.nextLine();
                        System.out.println("\nBam chuoi Hex: ");
                        System.out.println("MD5 :" + calculateHashFromHexString(hexString, "MD5"));
                        System.out.println("SHA-1 " + calculateHashFromHexString(hexString, "SHA-1"));
                        System.out.println("SH5-256: " + calculateHashFromHexString(hexString, "SHA-256"));
                        break;

                        case 3:
                        System.out.println("Nhap duong dan den file de bam: ");
                        String filePath = scanner.nextLine();
                        System.out.println("\nBam file: ");
                        System.out.println("MD5 :" + calculateHashFromFile(filePath, "MD5"));
                        System.out.println("SHA-1 " + calculateHashFromFile(filePath, "SHA-1"));
                        System.out.println("SH5-256: " + calculateHashFromFile(filePath, "SHA-256"));
                        break;

                        case 4:
                        running = false;
                        System.out.println("Thoat");
                    default:
                        break;
                }

            }
        }
        catch(Exception e)  {
            System.out.println("Da xay ra loi: " + e.getMessage());
        };

    }
}
