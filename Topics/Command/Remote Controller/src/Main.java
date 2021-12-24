import java.util.Scanner;

class Client {

    public static void main(String[] args) {

        Controller controller = new Controller();
        TV tv = new TV();
        final int SIZE_OF_THE_ARRAY = 3;
        int[] channelList = new int[SIZE_OF_THE_ARRAY];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < SIZE_OF_THE_ARRAY; i++) {
            channelList[i] = scanner.nextInt();
        }

        Command turnOnTV = new TurnOnCommand(tv);
        controller.setCommand(turnOnTV);
        controller.executeCommand();

        
        for (int i = 0; i < SIZE_OF_THE_ARRAY; i++) {
            Command ch = new ChangeChannelCommand(new Channel(tv, channelList[i]));
            controller.setCommand(ch);
            controller.executeCommand();
        }

        Command turnOffTV = new TurnOffCommand(tv);
        controller.setCommand(turnOffTV);
        controller.executeCommand();
    }
}

class TV {

    Channel channel;

    void turnOn() {
        System.out.println("Turning on the TV");
        setChannel(new Channel(this, 0));
    }

    void turnOff() {
        System.out.println("Turning off the TV");
    }

    void setChannel(Channel channel) {
        this.channel = channel;
    }
}

class Channel {
    private TV tv;
    private int channelNumber;

    Channel(TV tv, int channelNumber) {
        this.tv = tv;
        this.channelNumber = channelNumber;
    }

    void changeChannel() {
        tv.setChannel(this);
        System.out.println("Channel was changed to " + channelNumber);
    }
}

interface Command {
    public void execute();
}

class TurnOnCommand implements Command {
    
    TV tv;

    TurnOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        this.tv.turnOn();
    }
}

class TurnOffCommand implements Command {
    
    TV tv;

    TurnOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        this.tv.turnOff();
    }
}

class ChangeChannelCommand implements Command {

    private Channel channel;

    ChangeChannelCommand(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void execute() {
        this.channel.changeChannel();
    }
}

class Controller {
    private Command command;
    
    public void setCommand(Command command) {
        this.command = command;
    }
    
    void executeCommand() {
        this.command.execute();
    }
}
