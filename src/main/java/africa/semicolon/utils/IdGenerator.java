package africa.semicolon.utils;

public class IdGenerator {
    private static long currentId ;

    public static String generateId(){
        currentId ++;
        return String.valueOf(currentId);
    }
}
