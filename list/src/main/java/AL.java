public class AL {
    public static void main(String[] args) {
       ArrayList arrayList = new ArrayList();
       int i = 1;

        arrayList.add(i);
        arrayList.add("asf");
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add("ffddf", 2);
        arrayList.remove(2);
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.contains("asf"));
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(10);
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(14);
        arrayList.add(15);
        arrayList.add(16);
        System.out.println(arrayList.remove(0));
        System.out.println(arrayList.remove(0));
        System.out.println(arrayList.remove(0));
        System.out.println(arrayList.remove(0));
        System.out.println(arrayList.remove(0));
        System.out.println(arrayList.remove(0));
        System.out.println(arrayList.remove(0));
        System.out.println(arrayList.toString());

    }
}
