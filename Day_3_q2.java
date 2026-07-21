public class RockPaperScissors {
    public static String winningMoveForB(String m) {
        if (m.equalsIgnoreCase("rock")) {
            return "paper";      // paper beats rock
        } else if (m.equalsIgnoreCase("paper")) {
            return "scissors";   // scissors beats paper
        } else if (m.equalsIgnoreCase("scissors")) {
            return "rock";       // rock beats scissors
        } else {
            return "invalid move"; // handle wrong input
        }
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(winningMoveForB("rock"));     // prints "paper"
        System.out.println(winningMoveForB("paper"));    // prints "scissors"
        System.out.println(winningMoveForB("scissors")); // prints "rock"
    }
}
