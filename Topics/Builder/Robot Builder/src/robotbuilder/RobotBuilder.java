package robotbuilder;

public class RobotBuilder implements RobotBuilderPlan{
    private int head;
    private int torso;
    private int legs;
    private int arms;



    @Override
    public RobotBuilder buildHead(int head) {
        this.head=head;
        return this;
    }

    @Override
    public RobotBuilder buildArms(int arm) {
        this.arms=arm;
        return this;
    }

    @Override
    public RobotBuilder buildTorso(int torso) {
        this.torso=torso;
        return this;
    }

    @Override
    public RobotBuilder buildLegs(int legs) {
        this.legs=legs;
        return this;
    }
    public Robot build(){
        return new Robot(head,torso,legs,arms);
    }
}
