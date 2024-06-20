
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("""
                Welcome to the Encryption Centre
                Following are the Encryption types:
                1.hash code
                2.Ascii value multiply with number of elements in the list
                3.hash code added with number of elements in the list
                4.hashcode added with some random number
                Enter your option here:""");
        String filePath  = "src/resources/Names.txt";
        try {
            String Contents = new String(Files.readAllBytes(Paths.get(filePath)));
//            System.out.println(Contents);
            List<String> namesList = new ArrayList<>();
            String[] arrayNames = Contents.split(",");
            for(String name: arrayNames){
                namesList.add(name.trim());
            }
//            System.out.println(namesList);
            int choice = scan.nextInt();
            EncryptData encrypt = new EncryptData();
            List<String> encryptedNames = new ArrayList<>();
            for(String name: namesList){
                encryptedNames.add(encrypt.EncryptNames(name, choice, namesList.size()));
            }
            String encryptedContent = String.join(",", encryptedNames);
            Files.write(Paths.get("src/resources/EncryptedNames.txt"), encryptedContent.getBytes());
            System.out.println("The given File is successfully Encrypted into EncryptedNames.txt file");
        } catch (IOException e) {
            System.err.println("Error while reading the File"+ e.getMessage());
        }




    }
}