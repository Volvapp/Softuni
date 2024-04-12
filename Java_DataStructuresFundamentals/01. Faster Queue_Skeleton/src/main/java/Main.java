import implementations.Queue;

public class Main {
    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";

        System.out.println(extracted(s, t));
    }

    private static boolean extracted(String s, String t) {
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.toCharArray()[i] == t.toCharArray()[j]) {
                    counter++;
                    break;
                }
            }
            if (counter == s.toCharArray().length) {
                break;
            }
        }
        return counter == s.toCharArray().length;
    }

}


