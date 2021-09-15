import java.util.Scanner;

public class ComputeAveragePercentage{
    int subjectScoresList[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ComputeAveragePercentage compute = new ComputeAveragePercentage();
        compute.subjectScoresList = new int[5];
        System.out.println("Enter Scores of 5 subjects :-");
        for (int i = 0; i < compute.subjectScoresList.length; i++) {
            System.out.print("Enter Subject "+(i+1)+" mark : ");
            compute.subjectScoresList[i]=sc.nextInt();
        }
        int sumOfMarks = ComputeAveragePercentage.getMarksCount(compute.subjectScoresList);
        System.out.println("\nAverage Marks : "+compute.computeAverage(sumOfMarks));
        System.out.println("Percentage : "+compute.computePercentage(sumOfMarks)+" %");
        sc.close();
    }

    public static int getMarksCount(int[] subjectScoresList){
        int sumOfMarks=0;
        for (int i = 0; i < subjectScoresList.length; i++) {
            sumOfMarks+=subjectScoresList[i];
        }
        return sumOfMarks;
    }

    public float computeAverage(int sumOfMarks)
    {
        return sumOfMarks/5;
    }

    public float computePercentage(int sumOfMarks){
        float factor = (float)sumOfMarks/500;
        return factor * 100;
    }

}