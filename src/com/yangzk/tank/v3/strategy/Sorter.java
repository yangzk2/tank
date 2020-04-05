package com.yangzk.tank.v3.strategy;

/**
 * 排序方法
 */
public class Sorter<T> {

    public void sort(T[] arr,Comparator<T> comparator) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;

            for (int j = i + 1; j < arr.length; j++) {
                minPos = comparator.compare(arr[j],arr[minPos]) == -1 ? j :minPos;
            }
            //调用排序规则
            this.swap(arr,i,minPos);
        }
    }
    /*public void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;

            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j].compareTo(arr[minPos]) == -1 ? j :minPos;
            }
            //调用排序规则
            swap(arr,i,minPos);
        }
    }*/
    /**
     * 排序规则
     * @param arr
     * @param i
     * @param j
     */
    /*private static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }*/
    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
