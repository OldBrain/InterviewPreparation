package ru.avbugorov.interviewpreparation.list_impl.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.avbugorov.interviewpreparation.list.MyList;
import ru.avbugorov.interviewpreparation.list_impl.MyLinkedList;

public class LinkedListTests {
    private MyList<Integer> myLinkedList = new MyLinkedList<>();

    private void init(int n) {
        n = 9;
        for (int i = 0; i < n; i++) {
            myLinkedList.add(i * 10);
        }
    }

    @Test
    public void myListTest() {
        init(9);
        myLinkedList.add(13);
        System.out.println(myLinkedList);
        Assertions.assertEquals(myLinkedList.size(), 10);
        Assertions.assertEquals(myLinkedList.removeFromItem(13), true);
        Assertions.assertEquals(myLinkedList.size(), 9);
        Assertions.assertEquals(myLinkedList.remove(8), 80);
        Assertions.assertEquals(myLinkedList.size(), 8);
        Assertions.assertEquals(myLinkedList.isEmpty(), false);
        Assertions.assertEquals(myLinkedList.get(1), 10);
        Assertions.assertEquals(myLinkedList.get(7), 70);
        myLinkedList.add(100);
        myLinkedList.add(110);
        myLinkedList.add(120);
        myLinkedList.add(130);
        myLinkedList.add(140);
        Assertions.assertEquals(myLinkedList.size(), 13);
        Assertions.assertEquals(myLinkedList.removeFromItem(40), true);
        Assertions.assertEquals(myLinkedList.removeFromItem(4000000), false);

        for (int i = 0; i < myLinkedList.size(); i++) {
            Assertions.assertNotEquals(myLinkedList.get(i), null);
        }

        System.out.println(myLinkedList);

        // Интересная ситуация с размером и индексом списка
        // после удаления меняется размер и сдвигается индекс
        // и тест проходит только если запомнить размер и удалять
        // все время 0 элемент. Причина понятна, но разбираться нет
        // времени. Надеюсь, что для учебного проекта этого достаточно
        int size = myLinkedList.size();
        for (int i = 0; i < size; i++) {
            myLinkedList.remove(0);
        }

        Assertions.assertEquals(myLinkedList.isEmpty(), true);
    }

}
