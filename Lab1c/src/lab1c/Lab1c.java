
package lab1c;

public class Lab1c {

    public static void main(String[] args) {
        int sum = 0, max, min;
        int arr[]=new int[]{61,35,45,83,37};
        max = arr[0];
        min= arr[0];
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
            if(arr[i]>max){
                max = arr[i];
            }
            if(arr[i]<min){
                min = arr[i];
            }
        }
        System.out.println("The sum of the array elements is: "+ sum);
        System.out.println("The maximum of the array elements is: "+ max);
        System.out.println("The minimum of the array elements is: "+ min);
        
    }
}