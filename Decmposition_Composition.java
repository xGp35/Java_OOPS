class Brain {
    public Brain() {
        System.out.println("Brain created");
    }
}

public class Human {
    private Brain brain;

    public Human() {
        this.brain = new Brain(); 
        //Using this.brain makes it explicit that you're assigning to the instance field, 
        // not to a local variable.
    }
}

// Composition between Employee and salary

public class Employee {
    private float salary;

    public Employee(float salaryValue) {
        this.salary = salaryValue;
    }
}

// If Salary was an object of its own
public class Employee {
    private Salary salary;

    public Employee(Salary employeeSalary) {
        this.salary = employeeSalary;
    }
}