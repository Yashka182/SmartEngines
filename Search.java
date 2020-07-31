package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Search {

    public int[] generateRandomArray(int n){
        int[] array = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++){
            array[i] = random.nextInt(n);
        }
        return array;
    }

    public int sum(int[] array, int left, int right){
        int result = 0;
        for(int i = left; i <= right; i++){
            result += array[i];
        }
        return result;
    }

    public int[] brutSearch(int[] array){
        int size = array.length;
        int right = 0;
        int left = 0;
        int sum = 0;
        for(int i = 0; i < size-2; i++){
            for(int j = i+1; j < size-1; j++){
                sum = sum(array, i, j);
                if(sum % size == 0){
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {left, right};
    }

    public int[] smortSearch(int[] array){
        int size = array.length;
        int rem = 0;
        ArrayList<Integer> rems = new ArrayList<>(size);
        for(int i = 1; i < size-1; i++){
            rem = sum(array, 0, i) % size;
            if(rem == 0){
                return new int[] {0, i};
            }else if(rems.contains(rem)){
                return new int[] {rems.indexOf(rem) + 1, i};
            }
            rems.add(rem);
        }
        return new int[] {0,0};
    }

    public static void main(String[] args) {
        Search search = new Search();
        int[] arr = search.generateRandomArray(10);
        int[] result = search.smortSearch(arr);
        System.out.println("Left: " + result[0]);
        System.out.println("Right: " + result[1]);
        System.out.println("Sum: " + search.sum(arr, result[0], result[1]));
        System.out.println("Array: \n");
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
