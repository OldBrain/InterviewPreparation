package ru.avbugorov.interviewpreparation.hw2.test.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.avbugorov.interviewpreparation.hw2.list.MyArrayList;
import ru.avbugorov.interviewpreparation.hw2.list.MyList;


public class ArrayListTests {
    private MyList<Integer> myArrayList = new MyArrayList();

    private void init(int n) {
        n = 9;
        for (int i = 0; i < n; i++) {
            myArrayList.add(i * 10);
        }
    }

    @Test
    public void myListTest() {
        init(9);
        myArrayList.add(13);
        Assertions.assertEquals(myArrayList.size(), 10);
        Assertions.assertEquals(myArrayList.removeFromItem(13), true);
        Assertions.assertEquals(myArrayList.size(), 9);
        Assertions.assertEquals(myArrayList.remove(8), 80);
        Assertions.assertEquals(myArrayList.size(), 8);
        Assertions.assertEquals(myArrayList.isEmpty(), false);
        Assertions.assertEquals(myArrayList.get(1), 10);
        Assertions.assertEquals(myArrayList.get(7), 70);
        myArrayList.add(100);
        myArrayList.add(110);
        myArrayList.add(120);
        myArrayList.add(130);
        myArrayList.add(140);
        Assertions.assertEquals(myArrayList.size(), 13);
        Assertions.assertEquals(myArrayList.removeFromItem(40), true);
        Assertions.assertEquals(myArrayList.removeFromItem(4000000), false);

        for (int i = 0; i < myArrayList.size(); i++) {
            Assertions.assertNotEquals(myArrayList.get(i), null);
        }

        // Интересная ситуация с размером и индексом списка
        // после удаления меняется размер и сдвигается индекс
        // и тест проходит только если запомнить размер и удалять
        // все время 0 элемент. Причина понятна, но разбираться нет
        // времени. Надеюсь, что для учебного проекта этого достаточно
        int size = myArrayList.size();
        for (int i = 0; i < size; i++) {
            myArrayList.remove(0);
        }

        Assertions.assertEquals(myArrayList.isEmpty(), true);
    }

}
