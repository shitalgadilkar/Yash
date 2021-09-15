public class SortArray{
    public static void main(String[] args) 
    {
        int arrayElements[] = {20,12,54,67,43,88,53,23,56,66};
        System.out.println("Array before sorting:-");
        for (int i : arrayElements) {
            System.out.print(i+" , ");
        }
        new SortArray().sort(arrayElements);
        System.out.println("\nArray after sorting:-");
        for (int i : arrayElements) {
            System.out.print(i+" , ");
        }
    }

    public void sort(int []arr)
    {
        int temp;
        for (int i = 0; i < arr.length; i++) 
        {
            for(int j=i+1 ; j<arr.length ; j++)
            {
                if(arr[i]<arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}