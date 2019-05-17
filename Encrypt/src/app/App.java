package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Encrypt: " + encrypt("oqygwlkmwjnmrksasgjqcgqtgrosrmt", 331));
    }

    public static String encrypt(String text, int rule) {
        String result = "";
        if (text == "") return "";
        char [] array = new char [text.length()];

        for(int j = 0; j < text.length(); j++){
            array[j] = text.charAt(j);
        }

        for(int i = 0; i < array.length; i++){
            Character aux = array[i];
            int valueOfCharacter = aux;
            int newCharacterValue = valueOfCharacter + rule;

            while(newCharacterValue > 255){
                newCharacterValue -= 255;
            }

            char newCharacter = (char)newCharacterValue;
            array[i] = newCharacter;
            result += array[i];
        }
        return result;
    }
}