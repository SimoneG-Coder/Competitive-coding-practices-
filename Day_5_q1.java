//The door that remains open will be toggles odd number of times.
//Door number withh off number of factors will get toggled odd times to stay opem
//Numbers that are perfect squares will have odd factors as they have a factor repeating while other numbers have even number of factors as they come in pairs
public class ToggleSwitch {
    public static void main(String[] args) {
        int n = 100;
        int openDoors = (int) Math.sqrt(n);
        System.out.println("Open doors = " + openDoors);
    }
}
