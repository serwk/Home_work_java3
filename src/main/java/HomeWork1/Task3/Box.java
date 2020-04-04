package HomeWork1.Task3;

import java.util.ArrayList;

public class Box {
    private ArrayList<Fruit> fruits = new ArrayList<>();

    public float getWeight(){
        if (fruits.isEmpty()){
            return 0;
        } else {
            return fruits.size()*(fruits.get(0).getWeight());
        }
    }

    public boolean compare(Box other){
        return this.getWeight() == other.getWeight();
    }

    public boolean add(Fruit fruit){
        if (!fruits.isEmpty() && fruit.getClass() != fruits.get(0).getClass()){
            return false;
        }

        fruits.add(fruit);
        return true;
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

    public boolean pourTo(Box other){
        if (!other.isEmpty() && other.takeFruit().getClass() != fruits.get(0).getClass()){
            return false;
        }

        for (Fruit fruit:fruits) {
            if (!other.add(fruit)){
                return false;
            }
        }
        return true;
    }
}
