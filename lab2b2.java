public class lab2b2 {

    public void battle(String word) {
        int leftScore = 0, rightScore = 0;

        for (char c : word.toCharArray()) {
            leftScore += getLeftStrength(c);
            rightScore += getRightStrength(c);
        }

        if (leftScore > rightScore) {
            System.out.println("Left side wins!");
        } else if (rightScore > leftScore) {
            System.out.println("Right side wins!");
        } else {
            System.out.println("Let's fight again!");
        }
    }

    public void battle(String leftWord, String rightWord) {
        int leftScore = 0, rightScore = 0;

        for (char c : leftWord.toCharArray()) leftScore += getLeftStrength(c);
        for (char c : rightWord.toCharArray()) rightScore += getRightStrength(c);

        if (leftScore > rightScore) {
            System.out.println("Left side wins!");
        } else if (rightScore > leftScore) {
            System.out.println("Right side wins!");
        } else {
            System.out.println("Let's fight again!");
        }
    }

    private int getLeftStrength(char c) {
        return switch (c) {
            case 'w' -> 4;
            case 'p' -> 3;
            case 'b' -> 2;
            case 's' -> 1;
            default -> 0;
        };
    }

    private int getRightStrength(char c) {
        return switch (c) {
            case 'm' -> 4;
            case 'q' -> 3;
            case 'd' -> 2;
            case 'z' -> 1;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        lab2b2 game = new lab2b2();
        System.out.println("Test 1 (Word: 'z'):");
        game.battle("z");

        System.out.println("Test 2 (Word: 'zdqmwpbs'):");
        game.battle("zdqmwpbs");

        System.out.println("Test 3 (Word: 'wwwwwwz'):");
        game.battle("wwwwwwz");

        System.out.println("Test 4 (Left Word: 'wbp', Right Word: 'mqdz'):");
        game.battle("wbp", "mqdz");
    }
}