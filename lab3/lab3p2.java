package Lab3;

// main class to test the functionality
public class lab3p2 {
    public static void main(String[] args) {
        // Creating employee objects
        HourlyEmployee hourlyEmployee = new HourlyEmployee(1, "Neetu", "Teaching Assistant", 20.5, 40);
        SalariedEmployee salariedEmployee = new SalariedEmployee(2, "Riya", "Lecturer", 5000);
        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee(3, "Srinija", "Coordinator", 10000, 15);

        // Displaying employee details
        System.out.println("Hourly Employee Details:");
        hourlyEmployee.displayEmployeeDetails();


        System.out.println("Salaried Employee Details:");
        salariedEmployee.displayEmployeeDetails();


        System.out.println("Executive Employee Details:");
        executiveEmployee.displayEmployeeDetails();
    }
}



// Base class: Employee
class Employee {
    // Attributes
    private int employeeId;
    private String employeeName;
    private String designation;

    // Constructor
    public Employee(int employeeId, String employeeName, String designation) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
    }

    // Getter and Setter methods
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        if (employeeId > 0) {
            this.employeeId = employeeId;
        } else {
            throw new IllegalArgumentException("Employee ID must be positive.");
        }
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        if (employeeName != null && !employeeName.isEmpty()) {
            this.employeeName = employeeName;
        } else {
            throw new IllegalArgumentException("Employee name cannot be null or empty.");
        }
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        if (designation != null && !designation.isEmpty()) {
            this.designation = designation;
        } else {
            throw new IllegalArgumentException("Designation cannot be null or empty.");
        }
    }

    // Method to calculate bonus (base implementation)
    public double calculateBonus() {
        return 0; // Default bonus for a generic employee
    }

    // Method to display employee details
    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Designation: " + designation);
    }
}

// Derived class: HourlyEmployee
class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public HourlyEmployee(int employeeId, String employeeName, String designation, double hourlyRate, int hoursWorked) {
        super(employeeId, employeeName, designation);
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate > 0) {
            this.hourlyRate = hourlyRate;
        } else {
            throw new IllegalArgumentException("Hourly rate must be positive.");
        }
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        if (hoursWorked >= 0 && hoursWorked <= 168) { // Validating hours in a week
            this.hoursWorked = hoursWorked;
        } else {
            throw new IllegalArgumentException("Hours worked must be between 0 and 168.");
        }
    }

    public double calculateWeeklyPay() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public double calculateBonus() {
        return calculateWeeklyPay() * 0.05; // Example: 5% of weekly pay as a bonus
    }

    @Override
    public void displayEmployeeDetails() {
        super.displayEmployeeDetails();
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Weekly Pay: " + calculateWeeklyPay());
        System.out.println("Bonus: " + calculateBonus());
    }
}

// Derived class: SalariedEmployee
class SalariedEmployee extends Employee {
    private double monthlySalary;

    public SalariedEmployee(int employeeId, String employeeName, String designation, double monthlySalary) {
        super(employeeId, employeeName, designation);
        setMonthlySalary(monthlySalary);
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        if (monthlySalary > 0) {
            this.monthlySalary = monthlySalary;
        } else {
            throw new IllegalArgumentException("Monthly salary must be positive.");
        }
    }

    public double calculateWeeklyPay() {
        return monthlySalary / 4; // Assuming a 4-week month
    }

    @Override
    public double calculateBonus() {
        return calculateWeeklyPay() * 0.1; // Example: 10% of weekly pay as a bonus
    }

    @Override
    public void displayEmployeeDetails() {
        super.displayEmployeeDetails();
        System.out.println("Monthly Salary: " + monthlySalary);
        System.out.println("Weekly Pay: " + calculateWeeklyPay());
        System.out.println("Bonus: " + calculateBonus());
    }
}

// Further Derived Class: ExecutiveEmployee
class ExecutiveEmployee extends SalariedEmployee {
    private double bonusPercentage;

    public ExecutiveEmployee(int employeeId, String employeeName, String designation, double monthlySalary, double bonusPercentage) {
        super(employeeId, employeeName, designation, monthlySalary);
        setBonusPercentage(bonusPercentage);
    }

    public double getBonusPercentage() {
        return bonusPercentage;
    }

    public void setBonusPercentage(double bonusPercentage) {
        if (bonusPercentage >= 0 && bonusPercentage <= 100) {
            this.bonusPercentage = bonusPercentage;
        } else {
            throw new IllegalArgumentException("Bonus percentage must be between 0 and 100.");
        }
    }

    @Override
    public double calculateBonus() {
        double baseBonus = super.calculateBonus(); // Invoke the base class method
        double annualSalary = getMonthlySalary() * 12;
        return baseBonus + (annualSalary * (bonusPercentage / 100)); // Bonus based on percentage of annual salary
    }

    @Override
    public void displayEmployeeDetails() {
        super.displayEmployeeDetails();
        System.out.println("Bonus Percentage: " + bonusPercentage + "%");
        System.out.println("Total Bonus: " + calculateBonus());
    }
}
