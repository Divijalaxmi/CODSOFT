import java.util.*;

public class StudentGradeCalculator {
   public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Student name");
        String name = sc.nextLine();
        
        System.out.println("Enter no.of subjects: ");
        int n = sc.nextInt();
        
        int[] marks = new int[n];
        
        int totalMarks = 0;
        
        for(int i=0; i<n; i++){
            
            System.out.print("Enter marks for " + (i+1) + " subject: ");
            marks[i] = sc.nextInt();
            
            while(marks[i] < 0 || marks[i] > 100){
                System.out.println("Marks should be in the range of 0 to 100. Enter correct marks");
                marks[i] = sc.nextInt();
            }
            
            totalMarks += marks[i];
        }
        
        float averagePercentage = (float)totalMarks/n;

        String grade;

        if(averagePercentage >= 90){
            grade = "A+";
        }
        else if(averagePercentage >= 80){
            grade = "A";
        }
        else if(averagePercentage >= 70){
            grade = "B";
        }
        else if(averagePercentage >= 60) {
            grade = "C";
        }
        else if(averagePercentage >= 50){
            grade = "D";
        }
        else if(averagePercentage >= 40){
            grade = "E";
        }
        else{
            grade = "F";
        }

        System.out.println("Results of " + name +":");
        System.out.println("Total marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage +"%");
        System.out.println("Grade: " + grade);

        sc.close();

   }
}
