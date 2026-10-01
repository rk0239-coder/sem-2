class Document {

    protected String title;

    public Document(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

interface Confidential {}

class Memo extends Document {
    public Memo(String title) {
        super(title);
    }
}

class SalarySlip extends Document implements Confidential {
    public SalarySlip(String title) {
        super(title);
    }
}

class ContractAgreement extends Document implements Confidential {
    public ContractAgreement(String title) {
        super(title);
    }
}

public class T4 {
    public static void main(String[] args) {
        Document[] documents = {
                new Memo("Office Holiday Notice"),
                new SalarySlip("Employee Salary Slip - August 2026"),
                new ContractAgreement("Vendor Contract Agreement"),
                new Memo("Team Outing Announcement")
        };

        System.out.println("=== Document Confidentiality Check ===\n");

        for (Document doc : documents) {
            if (doc instanceof Confidential) {
                System.out.println("\"" + doc.getTitle() + "\" -> CONFIDENTIAL");
            } else {
                System.out.println("\"" + doc.getTitle() + "\" -> Not Confidential");
            }
        }
    }
}
