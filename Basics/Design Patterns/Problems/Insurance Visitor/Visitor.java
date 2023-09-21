public interface Visitor {
    void visit(LifeInsurance insurance);
    void visit(HealthInsurance insurance);
    void visit(VehicleInsurance insurance);
}
