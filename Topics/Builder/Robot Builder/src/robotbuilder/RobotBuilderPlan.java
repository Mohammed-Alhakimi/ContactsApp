package robotbuilder;

public interface RobotBuilderPlan {

    RobotBuilder buildHead(int head);
    RobotBuilder buildArms(int arm);
    RobotBuilder buildTorso(int torso);
    RobotBuilder buildLegs(int legs);

}
