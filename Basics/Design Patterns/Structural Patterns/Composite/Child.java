public class Child implements Person {
    private String name;
    public Child(String name){
        this.name = name;
    }
    @Override
    public void display(){
        System.out.println("    Child :" + name);
    }
}
