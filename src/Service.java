public class Service {
    public static String insertCharacter(String str, char targetChar, char insertChar) {
        StringBuilder result = new StringBuilder();

        for (char currentChar : str.toCharArray()) {
            if (currentChar == targetChar) {
                result.append(insertChar);
            }
            else {
                result.append(currentChar);
            }
        }

        return result.toString();
    }
}
