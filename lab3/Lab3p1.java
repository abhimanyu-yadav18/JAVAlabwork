package Lab3;

class Employ {
    static String collegeName = "Christ University";
    String Ename, Designation;
    int eid;

    // Constructor for Employee
    public Employ(int eid, String Ename, String Designation) {
        this.eid = eid;
        this.Ename = Ename;
        this.Designation = Designation;
    }

    // Method to print employee details
    public void getDetails() {
        System.out.println("The employee ID is " + this.eid);
        System.out.println("Employee Name: " + this.Ename);
        System.out.println("Designation: " + this.Designation);
    }

    // Private method, can only be accessed within the Employee class
    private void calculationBonus() {
        System.out.println("Bonus calculations");
    }
}

// Subclass HourlyEmploy inherits Employ
class HourlyEmploy extends Employ {
    double HourlyRate;
    int HourlyWorked;

    // Constructor for HourlyEmploy
    HourlyEmploy(int eid, String Ename, String Designation, double HourlyRate, int HourlyWorked) {
        super(eid, Ename, Designation); // Call the superclass constructor
        this.HourlyRate = HourlyRate;
        this.HourlyWorked = HourlyWorked;
    }

    // Method to calculate and print weekly salary
    public void weeklySalary() {
        double payrollWeekly = this.HourlyRate * this.HourlyWorked;
        System.out.println("Weekly Salary: " + payrollWeekly);
    }
}

// Derived SalariedEmploy inherits Employ
class SalariedEmploy extends Employ {
    double monthlySalary;

    // Constructor for SalariedEmploy
    SalariedEmploy(int eid, String Ename, String Designation, double monthlySalary) {
        super(eid, Ename, Designation); // Call the superclass constructor
        this.monthlySalary = monthlySalary;
    }

    // Method to calculate and print weekly salary
    public void weeklySalary() {
        double payrollWeekly = this.monthlySalary / 4;
        System.out.println("Weekly Salary: " + payrollWeekly);
    }
}

// Derived ExecutiveEmploy inherits from SalariedEmploy
class ExecutiveEmploy extends SalariedEmploy {
    int age;
    float experience, bonusPre; // in years

    ExecutiveEmploy(int eid, String Ename, String Designation, double monthlySalary, int age, float experience, float bonusPre) {
        super(eid, Ename, Designation, monthlySalary);
        this.age = age;
        this.experience = experience;
        this.bonusPre = bonusPre;
    }

    public void bonusPercentage() {
        double totalPayroll = (monthlySalary * this.bonusPre * 12) / 100;
        System.out.println("Total Payroll is: " + totalPayroll);
    }
}

// Main class to test the program
public class Lab3p1 {
    public static void main(String[] args) {
        System.out.println("Lab-3 p1");

        // Creating HourlyEmploy object
        HourlyEmploy hEmp = new HourlyEmploy(101, "Alice", "Part-time Worker", 15.5, 40);
        hEmp.getDetails();
        hEmp.weeklySalary();

        // Creating SalariedEmploy object
        SalariedEmploy sEmp = new SalariedEmploy(102, "Bob", "Manager", 4000);
        sEmp.getDetails();
        sEmp.weeklySalary();

        // Creating ExecutiveEmploy object
        ExecutiveEmploy eEmp = new ExecutiveEmploy(103, "Charlie", "Executive", 6000, 45, 20, 10);
        eEmp.getDetails();
        eEmp.weeklySalary();
        eEmp.bonusPercentage();
    }
}
