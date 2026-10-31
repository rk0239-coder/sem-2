import java.util.*;

public class TransactionDuplicateCheck {
    static boolean hasDuplicate(String[] transactionIds) {
        Set<String> seen = new HashSet<>();
        for (String id : transactionIds) {
            if (!seen.add(id)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] t1 = {"TXN1001", "TXN1002", "TXN1003", "TXN1002", "TXN1004"};
        String[] t2 = {"TXN2001", "TXN2002", "TXN2003"};
        System.out.println(hasDuplicate(t1));
        System.out.println(hasDuplicate(t2));
    }
}
