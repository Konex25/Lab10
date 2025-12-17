public class Patient extends Person implements Treatable {
    private String condition;

    public Patient(String name, int age, String condition) {
        super(name, age);
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public void receiveTreatment() {
        // Simple demo treatment based on condition
        String cond = (condition == null) ? "" : condition;

        if (cond.equalsIgnoreCase("flu")) {
            System.out.println(getName() + " gets rest + fluids treatment.");
        } else if (cond.equalsIgnoreCase("injury")) {
            System.out.println(getName() + " gets wound care treatment.");
        } else {
            System.out.println(getName() + " gets general consultation.");
        }
    }
}