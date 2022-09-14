import java.util.Arrays;
import java.util.Scanner;

// merge sort lab5 by @x1oto

class Main {


  void merge(int array[], int p, int q, int r) {

    int n1 = q - p + 1;
    int n2 = r - q;

    int L[] = new int[n1];
    int M[] = new int[n2];

    for (int i = 0; i < n1; i++)
      L[i] = array[p + i];
    for (int j = 0; j < n2; j++)
      M[j] = array[q + 1 + j];

    int i, j, k;
    i = 0;
    j = 0;
    k = p;

    while (i < n1 && j < n2) {
      if (L[i] <= M[j]) {
        array[k] = L[i];
        i++;
      } else {
        array[k] = M[j];
        j++;
      }
      k++;
    }

    while (i < n1) {
      array[k] = L[i];
      i++;
      k++;
    }

    while (j < n2) {
      array[k] = M[j];
      j++;
      k++;
    }
  }

  void mergeSort(int array[], int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      mergeSort(array, left, mid);
      mergeSort(array, mid + 1, right);
      merge(array, left, mid, right);
    }
  }

  public static void main(String args[]) {
  
    System.out.print("Enter array lenght: ");
    Scanner scan = new Scanner(System.in);
    int lenghtArray = scan.nextInt();
    int[] array = new int[lenghtArray];
    for(int i = 0; i < lenghtArray; i++) {
      System.out.print("Enter number: ");
      int number = scan.nextInt();
      array[i] = number;
    }
    System.out.println("Unsorted Array: " + Arrays.toString(array));
    Main ob = new Main();
    ob.mergeSort(array, 0, array.length - 1);
    System.out.println("Sorted Array: " + Arrays.toString(array));
}
}