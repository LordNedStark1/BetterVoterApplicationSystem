package africa.semicolon.utils;

import java.util.HashMap;
import java.util.Map;

public class AppUtils {
    private static long currentId ;
    private static final Map<String, String> userInformationJoinTable = new HashMap<String, String>();

    public static String generateId(){
        currentId ++;
        return String.valueOf(currentId);
    }
    public static void linkUserTUserInformation(String userId, String userInformationId){
        userInformationJoinTable.put(userId, userInformationId);
    }
    public static String getUserInformationId(String userId){
        return userInformationJoinTable.get(userId);
    }
}
