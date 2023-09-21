public class Intern implements Employee {
    private String name;
    private int Stipend;
   

    public Intern (String name, int Stipend) {
        this.name = name;
        this.Stipend = Stipend;
    }


    public String getName() {
        return name;
    }

    public int getStipend() {
        return Stipend;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
