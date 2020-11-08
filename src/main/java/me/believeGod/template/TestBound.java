package me.believeGod.template;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestBound
 * @Description TODO
 * @Author Tim
 * @Date 2020/6/2 18:53
 * @Version 1.0
 */
public class TestBound {
    public void upperBound(List<? extends Animal> list) {
        Animal animal = new Animal();
        Fish fish = new Fish();
        Shark shark = new Shark();

//      取值测试
        animal = list.get(0);
//        fish=list.get(0);        wrong
//        shark=list.get(0);       wrong

//        存值测试
//        list.add(Animal);        Wrong
//        list.add(fish);         Wrong
//        list.add(shark);         Wrong

//        容器赋值测试
        List<Object>objectList=new ArrayList();
        List<Animal> animalList=new ArrayList();
        List<Fish> fishList=new ArrayList();
        List<Shark> sharkList=new ArrayList();

//        list=objectList;    Wrong
        list=animalList;
        list=fishList;
        list=sharkList;

//        animalList=list;  Wrong
//        fishList=list;    Wrong
//        sharkList=list;    Wrong


//       泛型数组测试
        List<Animal>[] ls = new ArrayList[10];


//        List<Animal>[] ls2 = new ArrayList<String>[10];
       Animal[] animals=new Fish[10];
       Fish[] fishs=(Fish[])new Animal[10];

    }

    public void lowBound(List<? super Fish> list) {
        Animal animal = new Animal();
        Fish fish = new Fish();
        Shark shark = new Shark();

        Object object = list.get(0);
//        animal = list.get(0);
//        fish=list.get(0);        wrong
//        shark=list.get(0);       wrong

//        list.add(animal);        Wrong
        list.add(fish);
        list.add(shark);
    }
}
