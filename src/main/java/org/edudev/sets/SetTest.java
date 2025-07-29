package org.edudev.sets;

import java.util.HashSet;
import java.util.Set;

final class SetTest {

    void main() {
        HashSet<Integer> a = new HashSet<>(Set.of(1,2,3,4,5));
        HashSet<Integer> b = new HashSet<>(Set.of(4,5,6,7,8));

        System.out.println(STR."Conjunto A: \{a}");
        System.out.println(STR."Conjunto B: \{b}");

        a.add(9);
        System.out.println(STR."Conjunto A após adicionar 9: \{a}");

        a.remove(9);
        System.out.println(STR."Conjunto A após remover 9: \{a}");

        System.out.println(STR."Conjunto A contém 5? \{a.contains(5)}");

        System.out.println(STR."Conjunto está vazio? \{a.isEmpty()}");

        System.out.println(STR."Tamanho do Conjunto A: \{a.size()}");

        HashSet<Integer> union = new HashSet<>(a);
        union.addAll(b);
        System.out.println(STR."União de A e B: \{union}");

        HashSet<Integer> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        System.out.println(STR."Interseção de A e B: \{intersection}");

        HashSet<Integer> difference = new HashSet<>(a);
        difference.removeAll(b);
        System.out.println(STR."Diferença de A e B: \{difference}");
    }
}
