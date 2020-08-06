package opencart.Ultils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUltils {
    public static String encrytedPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "123";

        String encrytedPassword = encrytedPassword(password);

        System.out.println("Encrypted Password:" + encrytedPassword);
    }
}
