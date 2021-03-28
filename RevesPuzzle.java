public class RevesPuzzle {

    private static void reves(int n, String from, String temp, String temp2, String to) {
        int k = (int) Math.round(n + 1 - (Math.sqrt(n * 2 + 1)));

        if (n == 0) return;
        if (n == 1) {
            StdOut.println("Move disc " + (k + 1) + " from " + from + " to " + temp);
            return;
        }
        if (k == 1) {
            StdOut.println("Move disc " + k + " from " + temp + " to " + to);
            return;
        }

        reves(k - 2, from, temp, temp2, to);
        StdOut.println("Move disc " + (k - 1) + " from " + from + " to " + temp2);
        StdOut.println("Move disc " + (k) + " from " + from + " to " + to);
        StdOut.println("Move disc " + (k - 1) + " from " + temp2 + " to " + to);
        reves(k - 2, temp, temp2, from, to);
    }

    // move n smallest discs from one pole to another, using the temp pole
    private static void hanoi(int n, int k, String from, String temp, String to) {
        if (n == k) return;
        hanoi(n - 1, k, from, to, temp);
        StdOut.println("Move disc " + n + " from " + from + " to " + to);
        hanoi(n - 1, k, temp, from, to);
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = (int) Math.round(n + 1 - Math.sqrt(n * 2 + 1));

        if (n == 0) return;
        if (n == 1)
            StdOut.println("Move disc 1 from A to D");

        else {
            reves(n, "A", "D", "C", "B");
            hanoi(n, k, "A", "C", "D");
            reves(n, "B", "C", "A", "D");
        }
    }
}
