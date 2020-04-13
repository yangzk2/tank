package com.yangzk.tank.v3.strategy;


import java.util.Arrays;

/**
 * 策略模式测试案例
 */
public class Main {
    public static void main(String[] args) {
        //int [] a = {9,3,2,5,7,1,4};
        Cat[] cats = {new Cat(3,5),new Cat(1,2),new Cat(5,6)};
        Dog[] dogs = {new Dog(3),new Dog(1),new Dog(5)};

        //jdk中的比较器
        Sorter<Dog> sorter = new Sorter();
        sorter.sort(dogs, (o1,o2)->{
            if(o1.food < o2.food) return -1;
            else if(o1.food > o2.food) return 1;
            return 0;
        });
        //对狗进行排序
        sorter = new Sorter();
        sorter.sort(dogs,new DogComparator());
        System.out.println(Arrays.toString(dogs));
        //对猫按照宽度进行排序
        Sorter<Cat> catSorter = new Sorter();
        catSorter.sort(cats,new CatWidthComparator());
        System.out.println(Arrays.toString(cats));
        //对猫按照高度进行排序
        catSorter.sort(cats,new CatHeightComparator());
        System.out.println(Arrays.toString(cats));

    }

}
