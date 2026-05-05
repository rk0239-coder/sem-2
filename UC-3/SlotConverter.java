class SlotConverter {

    // Utility method to convert slot to row and column
    public static int[] convertSlotToPosition(int slot) {

        // Convert to zero-based index
        int index = slot - 1;

        // Mathematical mapping
        int row = index / 3;   // Division → row
        int col = index % 3;   // Modulo → column

        return new int[]{row, col};
    }

    public static void main(String[] args) {
        int slot = 5; // Example input

        int[] position = convertSlotToPosition(slot);

        System.out.println("Row: " + position[0]);
        System.out.println("Column: " + position[1]);
    }
}