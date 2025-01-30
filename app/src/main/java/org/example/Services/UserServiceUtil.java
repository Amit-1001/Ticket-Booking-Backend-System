package org.example.Services;

import org.mindrot.jbcrypt.BCrypt; // downloading jbcrypt dependency

public class UserServiceUtil {

    public static String hashPassword(String password){
        /** Encrypting password with BCrypt class **/
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }

    public static boolean checkPassword(String password, String hashPassword){
        return BCrypt.checkpw(password,hashPassword);
    }
}
