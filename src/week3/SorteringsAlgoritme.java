package week3;

import hjelpeklasser.Tabell;

import java.util.Arrays;

public class SorteringsAlgoritme {
    public static void main(String[] args) {

    }

    public static int findMax(int[] values, int left, int right){
        Tabell.vhKontroll(values.length, left, right);
        int max_value = values[left];
        int max_index = left;
        for(int i = left + 1; i<=right; i++){
            if(values[i] > max_value){
                max_value = values[i];
                max_index = i;
            }
        }
        return max_index;
    }

    public static void selectionSort(int[] values){
        for(int i = 0; i<values.length-1; i++){
            int max_index = findMax(values, i, values.length - 1);
            System.out.println(i + " - " + (values.length-1));
            System.out.println(max_index);

            int temp = values[max_index];
            values[max_index] = values[i];
            values[i] = temp;

            System.out.println(Arrays.toString(values));
            System.out.println("-----------");
        }

    }

    public static int binarySearch(int[] values, int value){
        int left = 0;
        int right = values.length - 1;

        while (left < right){
            //NOTE: heltallsdivisjon
            int mid = (left + right) / 2;
            if (value < values[mid]) {
                right = mid - 1;
            }else if( value > values[mid]){
                left = mid + 1;
            }
            if(value == values[mid]){
                return mid;
            }
        }
    return left;
    }
}
