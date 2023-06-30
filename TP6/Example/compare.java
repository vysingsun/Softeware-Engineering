public class compare {
    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public String max(String a, String b) {
        // if (a.compareTo(b)>0)
        // return a;
        // return b;
        return a.compareTo(b) > 0 ? a : b;

    }

    public int max(int a, int b, int c) {
        return max(max(a, b), c);
    }

    // double...: syntaxic sugar
    public double max(double... ds) {
        if (ds.length == 0)
            return 0;
        double m = ds[0];
        for (int i = 1; i < ds.length; i++) {
            if (m < ds[i])
                m = ds[i];
        }
        return m;
    }
}