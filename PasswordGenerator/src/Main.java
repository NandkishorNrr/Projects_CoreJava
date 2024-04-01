import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = upper.toLowerCase();
        String numbers = "0123456789";
        String special = "~`@#$%^&*()_-+={[]}\\|:;'<,>.?/*";
        String combination = upper + lower + numbers + special;

        int len = 8;
        char[] password = new char[len];
        Random random = new Random();

        for (int i = 0; i < len; i++)
            password[i] = combination.charAt(random.nextInt(combination.length()));

        System.out.println("Generated password: "  + new String(password));
    }
}