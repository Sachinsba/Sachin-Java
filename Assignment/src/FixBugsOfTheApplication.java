import java.util.Scanner;

public class FixBugsOfTheApplication {

    // Binary Search Method
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target is present at the middle
            if (array[mid] == target) {
                return mid;
            }

            // If the target is greater, ignore the left half
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                // If the target is smaller, ignore the right half
                right = mid - 1;
            }
        }

        // Target not present in the array
        return -1;
    }

    // Sorting Method
    public static void sortArray(int[] arr) {
        
        for (int i = 0; i < arr.length; i++) {     
            for (int j = i+1; j < arr.length; j++) {     
               if(arr[i] > arr[j]) {    
                   int temp = arr[i];    
                   arr[i] = arr[j];    
                   arr[j] = temp;    
               }     
            }     
        }    
    }

    public static void main(String[] args) {
        int[] myArray = {5, 2, 8, 1, 6, 3, 7, 4};

        Scanner scan = new Scanner(System.in);
        // Sorting the predefined array
        sortArray(myArray);

        // Searching for a target value in the sorted array
        System.out.println("Enter the target which is present in the given array");
        int targetValue = scan.nextInt();
        int result = binarySearch(myArray, targetValue);

        // Display the result
        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found in the array");
        }
    }
}