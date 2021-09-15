import java.util.Scanner;

public class CountWord
{
    public static void main(String[] args) 
    {
        String data="Java is Object oriented. Java is platform independent. Java is simple.";
        int count = countOccurrences(data, "Java")   ;
        System.out.println("No. of occurrences of word 'Java' is : "+count);
    }

    public static int countOccurrences(String str,String wordToCount){
        Scanner sc = new Scanner(str);
        int count=0;
        while(sc.hasNext())
        {
            if(sc.next().equalsIgnoreCase(wordToCount)){
                count++;
            }    
        }
        sc.close();
        return count;
    }
}