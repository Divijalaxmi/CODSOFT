import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

class Student implements Serializable {
    int rollno;
    String name;
    String grade;
    public Student(int rollno, String name, String grade) {
        this.rollno = rollno;
        this.name = name;
        this.grade = grade;
    }
    public int getRollno() {
        return rollno;
    }
    public String getName() {
        return name;
    }
    public String getGrade() {
        return grade;
    }

    public String toString(){
        return "Name: " + name +", rollno: " + rollno + ", grade: " + grade;
    }

    
}


public class StudentManagementSystem {
    private static final String FILENAME = "Students.dat";
    private Map<Integer, Student> students;

    public StudentManagementSystem(){
        students = new HashMap<>();
        loadFromFile();
    }

    public void addStudent(Student student){
        students.put(student.getRollno(), student);
        saveToFile();
    }

    public void removeStudent(int rollno){
        students.remove(rollno);
        saveToFile();
    }

    public Student findStudent(int rollno){
        return students.get(rollno);
    }

    public List<Student> listAllStudents(){
        return new ArrayList<>(students.values());
    }

    public void saveToFile(){
        try(ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(FILENAME))){
            oos.writeObject(students);
        }
        catch(IOException io){
            io.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))){
            students = (Map<Integer, Student>) ois.readObject();
        }
        catch(IOException | ClassNotFoundException e){
            students = new HashMap<>();
        }
    }
    public static void main(String args[]){
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner sc = new Scanner(System.in);
        int choice;
        while(true){
            System.out.println("Student Management choice");
            System.out.println("1. Add Student ");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");

            System.out.println("Enter your choice");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                       System.out.println("Enter name");
                       String name;
                       sc.nextLine();
                       name = sc.nextLine();
                       System.out.println("Enter roll number");
                       int rollno = sc.nextInt();
                       sc.nextLine();
                       System.out.println("Enter grade");
                       String grade = sc.nextLine();
                       Student student = new Student(rollno, name, grade);
                       sms.addStudent(student);
                       break;
                case 2:
                       System.out.println("Enter roll number to remove");
                       rollno = sc.nextInt();
                       sms.removeStudent(rollno);
                       break;
                case 3:
                       System.out.println("Enter roll number to search");
                       rollno = sc.nextInt();
                       Student st = sms.findStudent(rollno);
                       if(st != null){
                           System.out.println("Student found.2\n" + st);
                       } else{
                        System.out.println("Student not found");
                       }
                       break;
                case 4:
                       List<Student> lst = sms.listAllStudents();
                       if(lst.isEmpty()){
                        System.out.println("No students in the system");
                       } 
                       else{
                        for(Student s:lst){
                            System.out.println(s);
                        }
                       }
                       break;
                case 5:
                       System.out.println("Exiting application");
                       sc.close();
                       System.exit(0);
                       break;
                default:
                       System.out.println("Invalid option. Please try again.");

            }
        }

    }
}
