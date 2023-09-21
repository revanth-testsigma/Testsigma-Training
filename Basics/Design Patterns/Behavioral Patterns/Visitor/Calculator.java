public class Calculator implements Visitor {
    private int totalSalary;

    @Override
    public void visit(FullTime employee) {
        int salary = employee.getMonthlySalary() - employee.getPf() - employee.getTax();
        System.out.println("\nSalary details for "+ employee.getName() + " : \n----------------------");
        System.out.println("\tMonthly Salary : "+ employee.getMonthlySalary());
        System.out.println("\tTax : "+ employee.getTax());
        System.out.println("\tPF : "+ employee.getPf());
        System.out.println("\tNet Salary : "+ salary);


        totalSalary += salary;
        
    }

    @Override
    public void visit(Intern employee) {
        totalSalary += employee.getStipend();
        System.out.println("\nStipend details for "+ employee.getName() + " : \n----------------------");
        System.out.println("\tMonthly Stipend : "+ employee.getStipend());
    }

    public int getTotalSalary() {
        return totalSalary;
    }
}
