interface BasicSecurity {
    void login(String username, String password);
    void logout(String username);
}

interface AdvancedSecurity extends BasicSecurity {
    void fingerprintAuthentication(String username);
    void faceRecognitionAuthentication(String username);
}

class BankingApplication implements AdvancedSecurity {

    @Override
    public void login(String username, String password) {
        System.out.println(username + " logged in successfully with username/password.");
    }

    @Override
    public void logout(String username) {
        System.out.println(username + " logged out successfully.");
    }

    @Override
    public void fingerprintAuthentication(String username) {
        System.out.println(username + " authenticated successfully using fingerprint scan.");
    }

    @Override
    public void faceRecognitionAuthentication(String username) {
        System.out.println(username + " authenticated successfully using face recognition.");
    }
}

public class T3 {
    public static void main(String[] args) {
        AdvancedSecurity app = new BankingApplication();

        System.out.println("=== Mobile Banking Security Demo ===\n");

        app.login("ananya_v", "P@ssw0rd123");
        app.fingerprintAuthentication("ananya_v");
        app.faceRecognitionAuthentication("ananya_v");
        app.logout("ananya_v");
    }
}
