
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class SubscriptionPlan {
    protected final String name;
    protected final LocalDate startDate;

    public SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    protected abstract int getValidityDays();

    public LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }

    public String getName() {
        return name;
    }
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    protected int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    protected int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    protected int getValidityDays() {
        return 365;
    }
}

public class Problem5_StreamingPlanRenewalReminder {

    static SubscriptionPlan createPlan(String type, String name, LocalDate startDate) {
        switch (type) {
            case "BASIC":
                return new BasicPlan(name, startDate);
            case "STANDARD":
                return new StandardPlan(name, startDate);
            case "PREMIUM":
                return new PremiumPlan(name, startDate);
            default:
                throw new IllegalArgumentException("Unknown plan type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<SubscriptionPlan> subscribers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            LocalDate startDate = LocalDate.parse(tokens[2]);
            subscribers.add(createPlan(type, name, startDate));
        }

        for (SubscriptionPlan plan : subscribers) {
            System.out.println(plan.getName() + ": " + plan.getRenewalDate());
        }
    }
}
