package robotbuilder;

public class TestDrive {
    public static void main(String[] args) {

        Robot bo1 = new RobotBuilder().buildArms(3).buildHead(2).build();
        System.out.println(bo1);
        Robot bo2 = new RobotBuilder().buildTorso(123).buildArms(123123).buildLegs(123123).buildHead(23423423).build();
        System.out.println(bo2);
    }
}
