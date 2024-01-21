package A_Easy_Data_Structures.CamelCase;

import java.util.stream.Collectors;

public class CamelCase {

    public static void main(String[] args) {

        String word = "camelCasting";
        System.out.println(breakCamelCase(word));
        System.out.println(breakCamelCase2(word));
        System.out.println(breakCamelCase3(word));
    }

    public static String breakCamelCase(String str) {
        int index = 0;
        String result = "";
        if (str != null && !str.isEmpty()) {
            while (index <= (str.length() - 1)) {
                if (Character.isUpperCase(str.charAt(index))) {
                    result += " ";
                }
                result += str.charAt(index);
                index++;
            }
        } else {
            throw new RuntimeException("String can not be null or empty!");
        }
        return result;
    }

    public static String breakCamelCase2(String str) {
        int index = 0;
        StringBuilder result = new StringBuilder();
        if (str != null && !str.isEmpty()) {
            while (index <= (str.length() - 1)) {
                if (Character.isUpperCase(str.charAt(index))) {
                    result.append(" ");
                }
                result.append(str.charAt(index));
                index++;
            }
        } else {
            return new String(" ");
        }
        return result.toString();
    }

    public static String breakCamelCase3(String str) {
        StringBuffer result = new StringBuffer();
        if (str == null && str.isEmpty()) return result.toString();
        for (Character ch: str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append(" ");
            }
            result.append(ch);
        }
        return result.toString();
    }

    public static String breakCamelCase4(String str) {
        if (str == null || str.isEmpty()) return "";
        return str.chars()
                .mapToObj(ch -> Character.isUpperCase((char) ch) ? " " + (char) ch : String.valueOf((char) ch))
                .collect(Collectors.joining());
    }

}
