package oncall;

import oncall.controller.OnCallController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OnCallController onCall = new OnCallController();
        onCall.run();
    }
}
