package sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    static int iter = 0;
    static int timeSplit = 0;
    static int timeMerge = 0;

    static class Pair {

        private List<Integer> left, right;

        public Pair(List<Integer> left, List<Integer> right) {
            this.left = left;
            this.right = right;
        }

        public List<Integer> getLeft() {
            return left;
        }

        public List<Integer> getRight() {
            return right;
        }
    }

    static List<Integer> mergeSort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        Pair pair = split(list);
        return merge(
                mergeSort(pair.getLeft()),
                mergeSort(pair.getRight())
        );
    }

    static Pair split(List<Integer> list) {
        int n = list.size();
        long start = System.currentTimeMillis();
        var left = list.subList(0, n / 2);
        var right = list.subList(n / 2, n);
        //System.out.print(left + " " + right);
        //System.out.println();
        long end = System.currentTimeMillis();
        timeSplit += (end - start);
        return new Pair(left, right);
    }

    static List<Integer> merge(List<Integer> left, List<Integer> right) {
        long start = System.currentTimeMillis();
        int n = left.size() + right.size();
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        for (int x = 0; x < n; x++) {
            if (left.get(i) < right.get(j)) {
                result.add(left.get(i));
                iter++;
                i++;
                if (i == left.size()) {
                    for (int k = j; k < right.size(); k++) {
                        result.add(right.get(k));
                        iter++;
                    }
                    long end = System.currentTimeMillis();
                    timeMerge += (end - start);
                    return result;
                }
            } else {
                result.add(right.get(j));
                iter++;
                j++;
                if (j == right.size()) {
                    for (int k = i; k < left.size(); k++) {
                        result.add(left.get(k));
                        iter++;
                    }
                    long end = System.currentTimeMillis();
                    timeMerge += (end - start);
                    return result;
                }
            }
        }
        long end = System.currentTimeMillis();
        timeMerge += (end - start);
        return result;
    }

}
