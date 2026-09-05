public class P4_WarehouseInventoryBalancer {
    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0, totalB = 0;
        for (int qty : sectionA) totalA += qty;
        for (int qty : sectionB) totalB += qty;
        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";
        int highestQty = Integer.MIN_VALUE;
        String highestSection = "";
        int highestIndex = -1;
        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > highestQty) {
                highestQty = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }
    }
for (int i = 0; i < sectionB.length; i++) {
    if (sectionB[i] > highestQty) {
        highestQty = sectionB[i];
        highestSection = "Section B";
        highestIndex = i;
    }
}
System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB +
" | Status: " + status + " | Highest Quantity: " + highestQty +
" (" + highestSection + ", Item " + (highestIndex + 1) + ")");
}
public static void main(String[] args) {
    int[] sectionA = {20, 15, 30};
    int[] sectionB = {25, 10, 30};
    analyzeInventory(sectionA, sectionB);
    System.out.println("Expected: Section A Total: 65 | Section B Total: 65 | Status: Balanced | Highest Quantity: 30 (Section A, Item 3)");
}
}
