package HomeWork1.Task3;

import java.util.ArrayList;
import java.util.Arrays;

//public class Box {
public class Box <T extends Fruit> {
    //    private ArrayList<Fruit> fruits = new ArrayList<>();
    private ArrayList<T> fruits = new ArrayList<>();

    public Box(T... arr){
        fruits = new ArrayList<T>(Arrays.asList(arr));
    }

    public float getWeight(){
        if (fruits.isEmpty()){
            return 0.0f;
        } else {
            return fruits.size()*(fruits.get(0).getWeight());
        }
    }

    public boolean compare(Box other){
//        return this.getWeight() == other.getWeight();
        return Math.abs(this.getWeight() - other.getWeight()) < 0.00001;
    }

//    public boolean add(Fruit fruit){
//        if (!fruits.isEmpty() && fruit.getClass() != fruits.get(0).getClass()){
//            return false;
//        }
//
//        fruits.add(fruit);
//        return true;
//    }

    public void add(T fruit){
        fruits.add(fruit);
    }

    public boolean isEmpty(){
        return fruits.isEmpty();
    }

    public Fruit takeFruit(){
        if(fruits.isEmpty()){
            return null;
        }
        return fruits.get(0);
    }

//    public boolean pourTo(Box other){
    public boolean pourTo(Box<? super T> another){
//        if (!other.isEmpty() && other.takeFruit().getClass() != fruits.get(0).getClass()){
//            return false;
//        }

//        for (Fruit fruit:fruits) {
//            if (!other.add(fruit)){
//                return false;
//            }
//        }

        try {
            another.fruits.addAll(fruits);
            this.fruits.clear();
        } catch (Exception e){
            return true;
        }
        return true;
    }
}
