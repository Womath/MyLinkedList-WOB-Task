import org.junit.jupiter.api.Test;

import java.util.Objects;

class MyLinkedListHandlerTest {

    private final int length = 30;
    private final int[] values = new int[]{3, 4, 5, 6, 7, 9};
    private MyLinkedList list;

    /**
     * Tests removeRepeatedItems method. After method finished, test checks
     * all elements if they have different value from next element's value.
     * It also prints before-after lists.
     */
    @Test
    void removeRepeatedItems() {
        System.out.println("Removing repeated values");
        list = MyLinkedItemFactory.createListWithValues(length, values);
        TestUtil.printList(list);
        MyLinkedListHandler.removeRepeatedItems(list);
        TestUtil.printList(list);
        while (list.getNext() != null) {
            assert !Objects.equals(list.getValue(), list.getNext().getValue()) : "Repeated items remained in list";
            list = list.getNext();
        }
    }

    /**
     * Tests removeNonUniqueItems method. After method finished, test checks
     * if all the elements have unique value.
     * It also prints before-after lists.
     */
    @Test
    void removeNonUniqueItems() {
        System.out.println("Removing non-unique values");
        list = MyLinkedItemFactory.createListWithValues(length, values);
        TestUtil.printList(list);
        MyLinkedListHandler.removeNonUniqueItems(list);
        TestUtil.printList(list);
        MyLinkedList firstElement = list;
        int counter = 0;
        while (list != null) {
            while (list.getNext() != null) {
                assert !Objects.equals(list.getValue(), list.getNext().getValue()) : "There are none-unique items in the list";
                list = list.getNext();
            }
            ++counter;
            list = firstElement;

            for (int i = 0; i < counter; i++) {
                list = list.getNext();
            }
        }
    }

    /**
     * Tests removeValueFromList method. After method finished, test checks
     * all elements if they have different value from removed value.
     * It also prints before-after lists.
     */
    @Test
    void removeValueFromList() {
        System.out.println("Removing desired values");
        list = MyLinkedItemFactory.createListWithValues(length, values);
        int number = values[(int) (Math.random() * values.length)];
        TestUtil.printList(list);
        System.out.println("Number: " + number);
        list = MyLinkedListHandler.removeValueFromList(list, number);
        TestUtil.printList(list);
        while (list != null) {
            assert list.getValue() != number : "At least one desired element was not removed from list. Number: " + number + ", list value: " + list.getValue();
            list = list.getNext();
        }
    }




}