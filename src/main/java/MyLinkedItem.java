public class MyLinkedItem implements MyLinkedList {
    private MyLinkedList next;
    private Integer value;

    public MyLinkedItem() {
        this.next = null;
        this.value = 0;
    }

    @Override
    public void setNext(MyLinkedList next) {
        this.next = next;
    }

    @Override
    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public MyLinkedList getNext() {
        return this.next;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}
