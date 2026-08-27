//Move Hyphen To The Beginning
public class MoveHyphen {
    public static void main(String[] args) {
        String input = "ab-cd-e-fg--h";
        String result = moveHyphensToFront(input);
        System.out.println("Original: " + input);
        System.out.println("Modified: " + result);
    }

    public static String moveHyphensToFront(String str) {
        StringBuilder hyphens = new StringBuilder();
        StringBuilder others = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (ch == '-') {
                hyphens.append(ch);
            } else {
                others.append(ch);
            }
        }

        return hyphens.append(others).toString();
    }
}
