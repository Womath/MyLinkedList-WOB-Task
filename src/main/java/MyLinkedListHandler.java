import java.util.Objects;

public class MyLinkedListHandler {
    /**
     * if two continuous items value is same, deletes the second element from list
     * @param list MyLinkedList - list that needs to be altered
     * @return MyLinkedList - returns first item of list (optional)
     */
    public static MyLinkedList removeRepeatedItems (MyLinkedList list) {
        MyLinkedList item = list;

        while (item.getNext() != null) {
            if (Objects.equals(item.getValue(), item.getNext().getValue())) {
                item.setNext(item.getNext().getNext());
            } else {
                item = item.getNext();
            }
        }
        return list;
    }

    /**
     * removes every element from list until only unique values remain
     * by using getItemAtPosition and removeMatching methods
     * @param list MyLinkedList - list that needs to be altered
     * @return MyLinkedList - returns first item of list (optional)
     */
    public static MyLinkedList removeNonUniqueItems (MyLinkedList list) {
        MyLinkedList item = list;

        int counter = 0;
        while (item.getNext() != null) {
            item = getItemAtPosition(list, counter++);
            removeMatching(item);
        }
        return list;
    }

    /**
     * removes all elements from list after the provided item where an element's value
     * is same as the provided item's value
     * @param item MyLinkedList - one element of the list, this element's value
     *             is the reference to remove other elements
     * @return MyLinedList - returns the provided element (optional)
     */
    private static MyLinkedList removeMatching(MyLinkedList item) {
        MyLinkedList firstItem = item;
        Integer value = item.getValue();

        while (item.getNext() != null) {
            if (item.getNext().getValue().equals(value)) {
                item.setNext(item.getNext().getNext());
            } else {
                item = item.getNext();
            }
        }
        return firstItem;
    }

    /**
     * Finds the 'position'th element from list and returns it
     * if position is higher than size of list, throws an exception
     * @param list MyLinkedList - first element of list
     * @param position int - desired element from list
     * @return MyLinkedList - returns list's 'position'th element
     */
    private static MyLinkedList getItemAtPosition(MyLinkedList list, int position) {
        for (int i = 0; i < position; ++i) {
            list = list.getNext();
            if (list == null) {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
        return list;
    }

    /**
     * removes all the desired values from list
     * if first element has to be deleted, method changes first element's reference
     * to the second element and returns that,
     * thus it must overwrite the original object or must be saved in a new object!
     * @param list MyLinkedList - first item of list
     * @param value int - value that needs to be deleted
     * @return MyLinkedList - returns first (or new first) element of list
     */
    public static MyLinkedList removeValueFromList(MyLinkedList list, int value) {
        MyLinkedList item = list;

        while (item.getNext() != null) {
            if (item.getValue() == value) {
                list = list.getNext();
                item = list;
            } else if (item.getNext().getValue() == value) {
                item.setNext(item.getNext().getNext());
            } else {
                item = item.getNext();
            }
        }

        return list;

    }


}
