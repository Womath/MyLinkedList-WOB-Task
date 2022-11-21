import org.junit.jupiter.api.Test;

class MyLinkedItemFactoryTest {
    /**
     * Creates a MyLinkedList with specified length, min and max values
     * then tests if all the values are between min and max (inclusive)
     */
    @Test
    void createListWithRange() {
        int length = 30;
        int min = 10;
        int max = 100;
        MyLinkedList list = MyLinkedItemFactory.createListWithRange(length, min, max);
        System.out.println("Creating list from random numbers between a range!");
        TestUtil.printList(list);

        int counter = 0;
        while(list != null) {
            ++counter;
            assert list.getValue() <= max && list.getValue() >= min : "Number is not between " + min + " and " + max;
            list = list.getNext();
        }
        assert counter == length : "List length is not equal with intended length";
    }

    /**
     * Creates a MyLinkedList with specified length and an array of values
     * then tests if all the numbers can be found in the provided array
     */
    @Test
    void createListWithValues() {
        System.out.println("Creating list with specified values!");

        int length = 30;
        int[] values = new int[]{3, 4, 5, 6, 7, 9};
        MyLinkedList list = MyLinkedItemFactory.createListWithValues(length, values);
        TestUtil.printList(list);

        int counter = 0;
        while(list != null) {
            ++counter;
            boolean match = false;
            for (int value : values) {
                if (value == list.getValue()) {
                    match = true;
                }
            }
            assert match : "Value is different from allowed numbers";
            list = list.getNext();
        }
        assert length == counter : "List length is not equal with intended length";
    }
}