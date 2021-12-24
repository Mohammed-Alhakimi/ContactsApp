package robotbuilder;

public class Robot implements RobotPlan{
    private int head;
    private int torso;
    private int legs;
    private int arms;

    @Override
    public String toString() {
        return "Robot{" +
                "head=" + head +
                ", torso=" + torso +
                ", legs=" + legs +
                ", arms=" + arms +
                '}';
    }

    public Robot(int head, int torso, int legs, int arms) {
        this.head = head;
        this.torso = torso;
        this.legs = legs;
        this.arms = arms;
    }

    @Override
    public void setArms(int arms) {
        this.arms=arms;
    }

    @Override
    public void setLegs(int legs) {
        this.legs=legs;
    }

    @Override
    public void setHead(int head) {
        this.head=head;
    }

    @Override
    public void setTorso(int torso) {
        this.torso=torso;
    }
}
