public class MyLinkedItemFactory {


    /**
     * creates a MyLinkedList with 'length' number of elements
     * every element will have a random value between 'min' and 'max'
     * sets the next element to the created element by calling the same method again
     * @param length int - how many items the list holds
     * @param min int - minimum acceptable value
     * @param max int - maximum acceptable value
     * @return MyLinkedList - returns first element of the list, or null
     */
    public static MyLinkedList createListWithRange(int length, int min, int max) {
        if (length > 0) {
            MyLinkedItem item = new MyLinkedItem();
            item.setValue((int) (Math.random() * (max - min)) + min);
            item.setNext(createListWithRange(length - 1, min, max));
            return item;
        } else {
            return null;
        }
    }

    /**
     * creates a MyLinkedList with 'length' number of elements
     * every element will have a random value from the provided array, and only elements from that array
     * sets the next element to the created element by calling the same method again
     * @param length int - how many items the list holds
     * @param values int[] - array of available numbers
     * @return MyLinkedList - returns first element of the list, or null
     */
    public static MyLinkedList createListWithValues(int length, int[] values) {
        if (length > 0) {
            MyLinkedItem item = new MyLinkedItem();
            item.setValue(values[(int) (Math.random() * values.length)]);
            item.setNext(createListWithValues(length - 1, values));
            return item;
        } else {
            return null;
        }
    }
}
