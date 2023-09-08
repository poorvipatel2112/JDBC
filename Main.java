import com.student.manage.Student;
import com.student.manage.StudentDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("JDBC");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("Press 1 to add student");
            System.out.println("Press 2 to delete student");
            System.out.println("Press 3 to display student");
//            System.out.println("Press 4 to update student");
//            System.out.println("Press 5 to exit");
            int c = Integer.parseInt(br.readLine());
            
            if(c==1){
                System.out.println("Enter student name: ");
                String name = br.readLine();
                System.out.println("Enter student phone: ");
                String phone = br.readLine();
                System.out.println("Enter student city: ");
                String city = br.readLine();

                Student st = new Student(name,phone,city);
                boolean answer =StudentDao.insertStudentToDB(st);
                if(answer){
                    System.out.println("Successfully added");
                }else{
                    System.out.println("Something went wrong..");
                }
                System.out.println(st);
            } else if (c==2) {
                System.out.println("enter student 1 to delete: ");
                int userId = Integer.parseInt(br.readLine());
                boolean f =StudentDao.deleteStudent(userId);
                if(f){
                    System.out.println("Delete");
                }else{
                    System.out.println("Something went wrong....");
                }
                
            } else if (c==3) {
                StudentDao.showAllStudent();
                
//            } else if (c==4) {

            }else{
                System.out.println("Invalid number.");
            }
        }
    }
}
