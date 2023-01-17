package com.mycompany.mavenproject1;

/**
 * Class in which there is a method to sort a given real number list
 * @author Jaime Sanchez Mendieta
 */

public class QuickSort {
    int partition(double arr[], int low, int high) {
        double pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++) {
            if (arr[j] <= pivot) {
             i++;

             // swapping arr[i] and arr[j]
             double temp = arr[i];
             arr[i] = arr[j];
             arr[j] = temp;
            }
        }

        // swap arr[i+1] and pivot
        double temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    // method for sorting the arr taking as reference the pivot
    void sort(double arr[], int low, int high)
    {
     if (low < high)
     {
      int pi = partition(arr, low, high);

      // Sorting elements before and after partition
      sort(arr, low, pi-1);
      sort(arr, pi+1, high);
     }
    }

    static void printArray(double arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
            System.out.println();
            
    }

    // Driver program
    public static void main(String args[])
    {
     double arr[] = {10.5, 7.2, 8.5, 9, 1.5, 5};
     int n = arr.length;

     QuickSort ob = new QuickSort();
     ob.sort(arr, 0, n-1);

     System.out.println("sorted array");
     printArray(arr);
    }
}

