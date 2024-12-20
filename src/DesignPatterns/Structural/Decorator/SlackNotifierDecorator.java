package DesignPatterns.Structural.Decorator;

public class SlackNotifierDecorator extends NotifierDecorator {
    private String slackUsername;

    public SlackNotifierDecorator(Notifier wrappedNotifier, String slackUsername) {
        super(wrappedNotifier);
        this.slackUsername = slackUsername;
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack message to @" + slackUsername + ": " + message);
    }
}

