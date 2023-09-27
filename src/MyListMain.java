import java.util.Comparator;

public class MyListMain {
    public static void main(String[] args) {
        MyList<String> list1 = new MyArrayList<>();
        list1.add("abc");
        list1.add("def");
        list1.remove(0);
        list1.add(0, "ghi");

        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }

        String valueToFind = "def";
        boolean containsValue = list1.contain(valueToFind);
        if (containsValue) {
            System.out.println("The list contains: " + valueToFind);
        } else {
            System.out.println("The list does not contain: " + valueToFind);
        }


        MyList<Integer> list2 = new MyArrayList<>();
        list2.add(123);
        list2.add(456);
        list2.remove(0);
        list2.add(0, 789);

        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }

        Integer valueTooFind = 123;
        boolean containssValue = list2.contain(valueTooFind);
        if (containssValue) {
            System.out.println("The list contains: " + valueTooFind);
        } else {
            System.out.println("The list does not contain: " + valueTooFind);
        }

        list1.sort(Comparator.naturalOrder());
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }

        list2.sort(Comparator.naturalOrder());
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }
    }
}
