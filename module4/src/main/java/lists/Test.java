package lists;

public class Test {
    public static void main(String[] args) {
        SamsungList<Integer> list = new SamsungLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
        for (int i = 10; i < 20; i++) {
            list.add(0, i + 1);
        }
        list.add(5, 22);
        System.out.println(list);
        list.add(21, 25);
        System.out.println(list);
        list.add(21, 25);
        System.out.println(list);
        list.set(3, 1);
        System.out.println(list);
//        list.delete(16);
//        System.out.println(list);
//        list.remove(1);
//        System.out.println(list);
//        list.remove(4, 8);
//        System.out.println(list);
    }
}
