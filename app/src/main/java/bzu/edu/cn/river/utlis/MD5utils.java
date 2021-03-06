package bzu.edu.cn.river.utlis;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.os.Message;
/**
 * Created by LG on 2017/10/17.
 */

public class MD5utils {
    /**
     * md5加密的工具类
     *
     * @param password
     * @return
     */
    public static String encode(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] results = digest.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for(byte b : results){
                int number = b&0xff;
                String hex = Integer.toHexString(number);
                if(hex.length()==1){
                    sb.append("0");
                }
                sb.append(hex);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
