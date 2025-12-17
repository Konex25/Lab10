public abstract class Staff extends Person {
    private String role;

    public Staff(String name, int age, String role) {
        super(name, age);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public void introduce() {
        System.out.println("Name: " + getName() + " | Age: " + getAge() + " | Role: " + role);
    }

    public abstract void performDuties();
}