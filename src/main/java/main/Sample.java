package main;

import java.util.ArrayList;
import java.util.List;

public class Sample {
    public static void main(final String[] args) {

        final var originList = List.of(3, 1, 2);

        System.out.println(doubleByForLoop(originList));
        System.out.println(doubleByStream(originList));
        // System.out.println(sortByStream(originList));
    }

    private static List<Integer> doubleByForLoop(final List<Integer> originList) {
        var doubledList = new ArrayList<Integer>();
        for (final var item : originList) {
            doubledList.add(item * 2);
        }
        return doubledList;
    }

    private static List<Integer> doubleByStream(final List<Integer> originList) {
        return originList.stream()
                .map(num -> num * 2)
                .toList();
    }

}
