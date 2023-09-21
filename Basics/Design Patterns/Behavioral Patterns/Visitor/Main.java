public class Main {
    public static void main(String[] args) {
        // Creating employees
        Employee rev = new FullTime("Rev", 60000, 2000, 3000);
        Employee RevPav = new Intern("Revanth Pavuluri", 30000);

        // Calculate salaries using the SalaryCalculator visitor
        Calculator salaryCalculator = new Calculator();
        rev.accept(salaryCalculator);
        RevPav.accept(salaryCalculator);

        // Get the total salary
        int totalSalary = salaryCalculator.getTotalSalary();
        System.out.println("\nTotal company need to be paid as Salary: Rs." + totalSalary);
    }
}
