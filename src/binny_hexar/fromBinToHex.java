package binny_hexar;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
Двоично-шестнадцатеричный конвертер
*/

public class fromBinToHex {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Write binary number: ");
        String binaryNumber = scanner.nextLine();
        System.out.println("Binary number " + binaryNumber + " equals hexadecimal number " + toHex(binaryNumber));

        System.out.print("\nWrite a hexadecimal number:");
        String hexNumber = scanner.nextLine();
        System.out.println("Hexadecimal number " + hexNumber + " equals binary number " + toBinary(hexNumber));
    }

    public static <keyWord, Value> keyWord getKey(Map <keyWord, Value> map, Value value) {
        for (Map.Entry<keyWord, Value> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        } return null;
    }

    public static String representNotation(String valueToRepresent, int toNotation) {
        Map <String, String> map = new HashMap();
        map.put("0000", "0");
        map.put("0001", "1");
        map.put("0010", "2");
        map.put("0011", "3");
        map.put("0100", "4");
        map.put("0101", "5");
        map.put("0110", "6");
        map.put("0111", "7");
        map.put("1000", "8");
        map.put("1001", "9");
        map.put("1010", "a");
        map.put("1011", "b");
        map.put("1100", "c");
        map.put("1101", "d");
        map.put("1110", "e");
        map.put("1111", "f");
        if (toNotation == 16) return map.get(valueToRepresent);
        else return getKey(map, valueToRepresent);

    }

    public static String toHex(String binaryNumber) {
        String hexNumber = "";
        if (binaryNumber == "" || binaryNumber == null || !Pattern.matches("[0-1]+", binaryNumber)) {
            return hexNumber;
        }
        if (binaryNumber.length() % 4 != 0) {
            int howToAdd = binaryNumber.length() % 4;
            if (howToAdd == 3) binaryNumber = "0" + binaryNumber;
            else if (howToAdd == 2) binaryNumber = "00" + binaryNumber;
            else binaryNumber = "000" + binaryNumber;
        }
        while (binaryNumber.length() != 0) {
            String temp = binaryNumber.substring(0, 4);
            hexNumber += representNotation(temp, 16);
            binaryNumber = binaryNumber.substring(4, binaryNumber.length());
        }
        return hexNumber;

    }

    public static String toBinary(String hexNumber) {
        String binaryNumber = "";
        if (hexNumber == "" || hexNumber == null || !Pattern.matches("[0-9a-f]+", hexNumber)) {
            return binaryNumber;
        }
        while (hexNumber.length() != 0) {
            String temp = String.valueOf(hexNumber.charAt(0));
            binaryNumber += representNotation(temp, 2);
            hexNumber = hexNumber.substring(1, hexNumber.length());
        }
        return binaryNumber;
    }
}

