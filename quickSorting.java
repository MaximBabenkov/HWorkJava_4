// Реализовать алгоритм быстрой сортировки

import java.util.Random;
import java.util.Scanner;

public class quickSorting {

    static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int mid = left + (right - left) / 2;
        int pivot = arr[mid];
        int i = left;
        int j = right;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j) {
            quickSort(arr, left, j);
        }
        if (right > i) {
            quickSort(arr, i, right);
        }
    }

    static void randArr(int[] array) {
        Random random = new Random();
                 
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(-50, 50);
        }
    }
    
    static void printArr(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Enter your array size: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.close();

        int[] arr = new int[size];
        randArr(arr);
        System.out.println("Your array: ");
        printArr(arr);

        quickSort(arr, 0, arr.length-1);
        System.out.println("Your sorted array: ");
        printArr(arr);
    }
}