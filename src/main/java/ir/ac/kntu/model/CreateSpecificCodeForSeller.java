package ir.ac.kntu.model;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class CreateSpecificCodeForSeller {
    private static final String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int codeLength = 6;
    private static final SecureRandom random = new SecureRandom();
    private Set<String> existingCode = new HashSet<>();

    public String createCode() {
        StringBuilder strB = new StringBuilder();
        for (int i = 0; i < codeLength; i++) {
            int index = random.nextInt(character.length());
            strB.append(character.charAt(index));
        }
        return strB.toString();
    }

    public String createUniqueCode() {
        String code;
        do {
            code = createCode();
        } while (existingCode.contains(code));
        return code;
    }

}
