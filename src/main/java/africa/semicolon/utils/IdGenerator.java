package africa.semicolon.utils;

import java.math.BigInteger;
import java.util.UUID;

public class IdGenerator {
    private static final int ZERO = BigInteger.ZERO.intValue();
    private static final int NINE = BigInteger.valueOf(9).intValue();
    public static String generateVoterIdentificationNumber(){
        String uuid = generateUUID();
        String validUUID = stripInvalidValuesFrom(uuid);
        return buildVoterIdentificationNumberFrom(validUUID);
    }

    private static String buildVoterIdentificationNumberFrom(String validUUID) {
        String result = "";

        for (int index = 0; index < validUUID.length(); index++) {
            if (index % 5 == 0) result += " ";
            else result += validUUID.charAt(index);
        }
        return result.substring(0, 25).strip();
    }

    private static String stripInvalidValuesFrom(String randomUUId) {
        String validUUID = "";
        for (int index = ZERO; index < randomUUId.length(); index++) {
            if (randomUUId.charAt(index) != '-') validUUID += randomUUId.charAt(index);
        }

        return validUUID;
    }

    private static String generateUUID() {
//        String res = "";
//        int unicodePointForA = BigInteger.valueOf(97).intValue();
//        int codePointForZ = BigInteger.valueOf(122).intValue();
//
//        for(int index = unicodePointForA ; index< codePointForZ; index++) res += index;
//
//        for(int index = ZERO ; index< NINE ; index++) res += index;
//
//        UUID UUIDWthHyphen = UUID.nameUUIDFromBytes(res.getBytes());
//        return UUIDWthHyphen.toString();
        UUID uuid = UUID.randomUUID();
        return uuid.toString().toUpperCase();
    }


    public static void main(String[] args) {
        System.out.println(generateVoterIdentificationNumber());
    }
}
