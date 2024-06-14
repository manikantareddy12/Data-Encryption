package main;

import java.util.Random;

public class EncryptData {

    String EncryptNames(String name, int choice, int size){

        return switch (choice) {
            case 1 -> String.valueOf(name.hashCode());
            case 2 -> asciiValueMultiplied(name, size);
            case 3 -> String.valueOf(name.hashCode() + size);
            case 4 -> String.valueOf(name.hashCode() + getRandomNumber());
            default -> " Invalid Encryption choice";
        };

    }

    String asciiValueMultiplied(String name,int size){
        StringBuilder encryptName = new StringBuilder();
        for(char ch: name.toCharArray()){
            encryptName.append((int) ch * size);//.append(" ");
        }
        return encryptName.toString().trim();
    }

    private static int getRandomNumber(){
        Random random =new Random();
        return random.nextInt(100);
    }


}
