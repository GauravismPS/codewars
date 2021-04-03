/*
 * Copyright (c) 2021.
 */

package sapient.codewars.solution;

import java.util.*;
import java.util.stream.Collectors;

public class Johnann {
    static List<Long> seq_j = new ArrayList<>();
    static List<Long> seq_a = new ArrayList<>();
    static List<Long> sum_j = new ArrayList<>();
    static List<Long> sum_a = new ArrayList<>();

    public static void init() {
        seq_j.add(0L);
        seq_a.add(1L);
        sum_j.add(0L);
        sum_a.add(1L);
     }

    public static void update(long n) {
        for (int i = seq_j.size(); i < n; i++) {
            seq_j.add(i - seq_a.get(seq_j.get(i - 1).intValue()));
            sum_j.add(sum_j.get(sum_j.size() - 1) + seq_j.get(seq_j.size() - 1));
            seq_a.add(i - seq_j.get(seq_a.get(i - 1).intValue()));
            sum_a.add(sum_a.get(sum_a.size() - 1) + seq_a.get(seq_a.size() - 1));
        }
    }
    public static List<Long> john(long n) {
        if (seq_j.size() == 0) init();
        if (seq_j.size() >= n) return seq_j.stream().limit(n).collect(Collectors.toList());
        update(n);
        return seq_j;
    }

    public static List<Long> ann(long n) {
        if (seq_j.size() == 0) init();
        if (seq_a.size() >= n) return seq_a.stream().limit(n).collect(Collectors.toList());
        update(n);
        return seq_a;
    }

    public static long sumJohn(long n) {
        if (sum_j.size() < n) john(n);
        return sum_j.get((int) n - 1);
    }

    public static long sumAnn(long n) {
        if (sum_a.size() < n) ann(n);
        return sum_a.get((int) (n - 1));
    }

    public static void printer() {
        System.out.println("seq_a size : " + seq_a.size() + ",\n" + "seq_j size : " + seq_j.size()
                + ",\n" + "sum_a size : " + sum_a.size() + ",\n" + "sum_j size : " + sum_j.size()
                + ",\n");
    }
}
