package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {

  public static String convertirSHA256(String password) {
    MessageDigest md = null;
    try {
      md = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
      return null;
    }

    byte[] hash = md.digest(password.getBytes());
    StringBuffer sb = new StringBuffer();

    for (byte b : hash) {
      sb.append(String.format("%02x", b));
    }

    return sb.toString();

  }

  public static void main(String[] args) {


    System.out.println(convertirSHA256("passAna"));
  }

}
