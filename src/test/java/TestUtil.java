public class TestUtil {

    public static void printList(MyLinkedList list) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        while(list != null) {
            if (list.getNext() != null) {
                sb.append(list.getValue()).append(", ");
            } else {
                sb.append(list.getValue());
            }
            list = list.getNext();
        }
        sb.append("}");
        System.out.println(sb);
    }
}
