import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    public static void main(String[] args) {
        int length = 12; // Set the desired password length
        boolean useLowercase = true;
        boolean useUppercase = true;
        boolean useDigits = true;
        boolean useSpecialCharacters = true;

        String generatedPassword = generatePassword(length, useLowercase, useUppercase, useDigits, useSpecialCharacters);
        System.out.println("Generated Password: " + generatedPassword);
    }

    public static String generatePassword(int length, boolean useLowercase, boolean useUppercase, boolean useDigits, boolean useSpecialCharacters) {
        StringBuilder password = new StringBuilder();
        String characters = "";

        if (useLowercase) {
            characters += LOWERCASE;
        }
        if (useUppercase) {
            characters += UPPERCASE;
        }
        if (useDigits) {
            characters += DIGITS;
        }
        if (useSpecialCharacters) {
            characters += SPECIAL_CHARACTERS;
        }

        if (characters.isEmpty()) {
            throw new IllegalArgumentException("At least one character set must be selected.");
        }

        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}
