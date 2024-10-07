
import java.util.Scanner;
import javax.swing.JOptionPane;
//Sultana Altheab
//Mrooj Alqarni
public class Project3 {
    private Node head;
      private  class Node{
        private String EmpName,day,EmpPhone,EmpAddress;
        private long EmpID;
        private double WorkHours,EmpSalary;
        private Node next;
        public Node(long ID,String name,String day,String phone,String address,double hours,double salary){
            EmpPhone=phone;
            EmpAddress=address;
            WorkHours=hours;
            EmpID=ID;
            this.day=day;
            this.EmpName=name;
            EmpSalary=salary;
            next=null;
        }
    }
    
   public void insertEmployee(long ID,String name,String day,String phone,String address,double hours,double salary){
   
    Node newNode = new Node(ID, name, day, phone, address, hours, salary);
    Node temp=head;
    if (temp == null) {
        head = newNode;
        return;
    } else if (ID < temp.EmpID) {
        newNode.next = head;
        head = newNode;
        return;
    }
    
    Node current = head;
    while (current.next != null && current.next.EmpID < ID) {
        current = current.next;
    }
    
    newNode.next = current.next;
    current.next = newNode;
}
    
   public  int deleteEmployee(long ID){
         
         Node temp=head;
         Node prev=null;
         if (temp != null && temp.EmpID == ID) {
            head = temp.next; 
            return 1;
        }
         while (temp != null && temp.EmpID != ID) {
            prev = temp;
            temp = temp.next;
        }
        if(temp==null){
            return 0;
        }
        prev.next=temp.next;
        return 1;
   }
   public void updateEmployee(long ID){
         if(!checkRecord(ID)){
             System.out.println("Employee with ID number "+ID+" not found !");
         }
         else{
              Node temp=head;
                while(temp!=null){
                    if(temp.EmpID==ID){
                         break;
                    }
                    temp=temp.next;
                }
                         
             Scanner input=new Scanner(System.in);
             int choice;
             String updateChoice;
             String name,day,phone,address;
             double hours,salary;
             char upChoice;
             do{
             System.out.println("Select what you want to update : ");
             System.out.println("1. Employee name ");
             System.out.println("2. First day of work ");
             System.out.println("3. Phone number ");
             System.out.println("4. Address "); 
             System.out.println("5. Work hours ");
             System.out.println("6. Salary");
             choice=input.nextInt();
             input.nextLine();
             if(choice==1){
                     System.out.print("Enter new employee Name:");  
                     name=input.nextLine();
                     temp.EmpName=name;
             }
             else if(choice==2){
                     System.out.print("Enter new First day of work:");  
                     day=input.nextLine();
                     temp.day=day;
             }
             else if(choice==3){
                     do{
                        System.out.print("Enter new phone number, length should be 10 :");  
                        phone=input.nextLine();
                        }while(phone.length()!=10);
                      temp.EmpPhone=phone;
             }
             else if(choice==4){
                      System.out.print("Enter new Address:");  
                      address=input.nextLine();
                      temp.EmpAddress=address;
             }
             else if (choice==5){
                      
                       do{
                            System.out.print("Enter new work hours, at least 32 hours :");  
                            hours=input.nextDouble();
                        }while(hours<32);
                      temp.WorkHours=hours;
                      input.nextLine();
                      
             }
             else if(choice==6){
                       System.out.print("Enter new Salary:");  
                       salary=input.nextDouble();
                       input.nextLine();
                        temp.EmpSalary=salary;

             }
             else{
                   
                     System.out.println("Wrong choice !!");
                     
                     
                 }
                 System.out.println("Do you want to update something else ? (y/n)");
                 updateChoice=input.nextLine();
                 upChoice=updateChoice.charAt(0);
                 
             }while(upChoice=='y' || upChoice=='Y');
    
         }      
     }
   public void showEmployee(){
        Node temp=head;
        while(temp!=null){
              System.out.println("\nEmployee All Information :\n1. ID:"+temp.EmpID+"\n2. Name:"+temp.EmpName+"\n3. First day of work: "+
                        temp.day+"\n4. Phone number: "+temp.EmpPhone+"\n5. Address :"+temp.EmpAddress+"\n6. Work hours: "+temp.WorkHours
                +"\n7. Salary: "+temp.EmpSalary);
            temp=temp.next;
        }
    
     }
   public Node searchEmployee(long ID){
        Node temp=head;
        while (temp!= null) {
              if(temp.EmpID == ID){
              break;
            }else{
                temp=temp.next;
            }
        }
        return temp;
       
   }
   boolean checkRecord(long ID){
       Node temp=head;
       if(head==null)
           return false;
       
        while(temp!=null&&head!=null){
            if(temp.EmpID==ID)
                return true;
            temp=temp.next;
        }
       return false;
   }
 
   public void updateSalary(long ID){  
         Node temp= searchEmployee(ID);
         if(temp!=null){
            if(temp.WorkHours>32){
                       double extraHours=temp.WorkHours-32;
                       double bouns=extraHours*2;
                       temp.EmpSalary+=(temp.EmpSalary*bouns/100);
                       System.out.println("Salary updated for employee with ID number "+ID+" \n");
                       
               }
            else{
                System.out.println("No bonus for this employee ");
            }
         }
         else{
              System.out.println("Employee with ID "+ID+" not found !");
         }   
        
     }
      public static void main(String[] args) {
            JOptionPane.showMessageDialog(null,"Welcome to Employee record management system !\n\nThis program will allow you the following :\n1. Insert Employee\n"
                    +"2. Delete Employee\n3. Search Employee \n4.Update Employee\n5. Show Employee Information\n6. Update Salary");
            Scanner input=new Scanner(System.in);
            int choice;
            long EmpID;
            String EmpName,day,EmpPhone,EmpAddress;
            double WorkHours,EmpSalary;
            Project3 employees=new Project3();
           
           while(true){
                System.out.println("--------------------------\n1. Insert employee record\n" +
                               "2. Delete employee record\n" +
                               "3. Update employee record\n" +
                               "4. Show employees information\n" +
                               "5. Search employee\n" +
                               "6. Update salary\n"+
                               "7. Exit\n--------------------------");
                System.out.print("Please enter your choice: ");
                choice=input.nextInt();
                if (choice==1){
                        do{
                            System.out.print("Enter employee ID, length should be at least 10 :");  
                            EmpID=input.nextLong();
                        }while(String.valueOf(EmpID).length()<10);
                        input.nextLine();
                        if(employees.checkRecord(EmpID)){
                            System.out.println("Employee with ID number "+EmpID+ " is already exist !");
                        }else{
                        System.out.print("Enter employee Name:");  
                        EmpName=input.nextLine();
                        
                        System.out.print("Enter first day of work:");  
                        day=input.nextLine();
                        do{
                        System.out.print("Enter Phone number, length should be 10 :");  
                        EmpPhone=input.nextLine();
                        }while(EmpPhone.length()!=10);
                        System.out.print("Enter Address:");  
                        EmpAddress=input.nextLine();
                        do{
                            System.out.print("Enter Work hours, at least 32 hours :");  
                            WorkHours=input.nextDouble();
                        }while(WorkHours<32);
                        System.out.print("Enter Salary:");  
                        EmpSalary=input.nextDouble();
                        employees.insertEmployee(EmpID, EmpName, day, EmpPhone, EmpAddress, WorkHours, EmpSalary);
                        System.out.println("\n*Employee added successfully*\n");
                        }
                }
                     
                else if (choice==2){ 
                        System.out.println("Enter employee ID to delete :");
                        EmpID=input.nextLong();
                        if(employees.deleteEmployee(EmpID)==1){
                            System.out.println("Emplyee with ID number "+EmpID+" has been deleted ");
                            
                        }else{
                            System.out.println("Employee with "+EmpID+" not found !");
                        }
                }
                else if (choice==3){
                         System.out.println("Enter employee ID to Update :");
                         EmpID=input.nextLong();
                         employees.updateEmployee(EmpID);
                }
                else if(choice==4){
                        employees.showEmployee();
                }
                else if(choice==5){
                        System.out.println("Enter employee ID to Search :");
                        EmpID=input.nextLong();
                        Node temp=employees.searchEmployee(EmpID);
                        if(temp!=null){
                             System.out.println("\nEmployee All Information :\n1. ID:"+EmpID+"\n2. Name:"+temp.EmpName+"\n3. First day of work: "+
                        temp.day+"\n4. Phone number: "+temp.EmpPhone+"\n5. Address :"+temp.EmpAddress+"\n6. Work hours: "+temp.WorkHours
                +"\n7. Salary: "+temp.EmpSalary+"\n");
                        }else{
                             System.out.println("employee with ID "+EmpID+" not found !" );
                        }
                }
                else if (choice==6){
                        System.out.println("Enter employee ID to update :");
                        EmpID=input.nextLong();
                        employees.updateSalary(EmpID);
                        
                }
                else if(choice==7){
                      
                       JOptionPane.showMessageDialog(null,"Thank you for using this program !\n See You Soon");
                       System.exit(0);
                }
                else{
                        System.out.println("Wrong choice!! Try again\n");
                }     
                        
                }
           }     
    }
    

