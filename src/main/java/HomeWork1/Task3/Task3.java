package HomeWork1.Task3;

public class Task3 {
    public static void main(String[] args) {

        // В моем решении коробка может использоваться для любых фруктов
//        Box box1 = new Box();
//        Box box2 = new Box();
//        Box box3 = new Box();
//        Box box4 = new Box();

        // В решении преподавателя тип коробки задается изначально и неизменяется в процессе

        Box <Apple> box1 = new Box<>();
        Box <Fruit> box2 = new Box<>();
        Box <Apple> box3 = new Box<>();
        Box <Apple> box4 = new Box();

        putApplesToBox(box1, 6);
        putOrangesToBox(box2, 4);
        putApplesToBox(box3, 5);

        System.out.println(box1.getWeight() + " equals " + box2.getWeight() + ": " + box1.compare(box2));
        System.out.println(box1.getWeight() + " equals " + box3.getWeight() + ": " + box1.compare(box3));

        System.out.println("box1 was poured to box2:" + box1.pourTo(box2));
        System.out.println("box1 was poured to box3:" + box1.pourTo(box3));
        System.out.println("box3 was poured to box4:" + box3.pourTo(box4));
    }

    public static void putApplesToBox(Box box, int count) {
        for (int i = 0; i < count; i++) {
            box.add(new Apple());
        }
    }

    public static void putOrangesToBox(Box box, int count) {
        for (int i = 0; i < count; i++) {
            box.add(new Orange());
        }
    }
}
