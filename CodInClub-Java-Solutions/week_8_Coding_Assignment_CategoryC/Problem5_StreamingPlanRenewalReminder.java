/*
 * ASSIGNMENT PROBLEM 5: The Streaming Plan Renewal Reminder
 *
 * Task:
 * A video streaming service offers Basic, Standard, and Premium plans,
 * each valid for a different number of days from its start date.
 * Calculate the renewal date for every subscriber.
 *
 * Input:
 *   Line 1: integer N (number of subscribers)
 *   Next N lines: PlanType Name StartDate   (StartDate in YYYY-MM-DD)
 *     BASIC Name StartDate
 *     STANDARD Name StartDate
 *     PREMIUM Name StartDate
 *
 * Output:
 *   For each subscriber: "Name: RenewalDate" (RenewalDate as YYYY-MM-DD)
 *
 * Business Rules:
 *   - BASIC:    valid for 30 days.
 *   - STANDARD: valid for 90 days.
 *   - PREMIUM:  valid for 365 days.
 *   - RenewalDate = StartDate + plan's validity, in days.
 *
 * NOTE ON THIS FILE:
 * The original problem sheet was cut off before it listed a Sample
 * Input/Expected Output for this problem, so the sample below in main()
 * was constructed by us (following the stated Business Rules exactly) so
 * the program can still be demonstrated and verified end to end.
 *
 * Self-constructed sample input:
 *   3
 *   BASIC Amit 2023-01-01
 *   STANDARD Priya 2023-05-15
 *   PREMIUM Karan 2023-01-01
 *
 * Resulting output (verified against java.time.LocalDate):
 *   Amit: 2023-01-31
 *   Priya: 2023-08-13
 *   Karan: 2024-01-01
 *
 * Design note:
 * Each plan type is its own class extending an abstract SubscriptionPlan
 * that stores the subscriber's name and start date, and exposes
 * getRenewalDate(). Each subclass only supplies its own validity period;
 * the main loop calls getRenewalDate() polymorphically with no explicit
 * type checks.
 */

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
