package com.wpp;

public class SortAl {
    public static void main(String[] args) {
        int[] ints = InsertSort.insertSort(new int[]{3, 2, 1, 4, 5, 7, 8, 0, 6});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    static class InsertSort {
        public static int[] insertSort(int[] arr) {
            if (arr == null || arr.length <= 1) {
                return arr;
            }

            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    j--;
                }
                arr[j + 1] = key;
            }

            return arr;
        }
    }


    static class MegerSort {
        public static int[] megerSort(int[] arr) {
            if (arr == null || arr.length <= 1) {
                return arr;
            }

            return arr;
        }
    }
}
