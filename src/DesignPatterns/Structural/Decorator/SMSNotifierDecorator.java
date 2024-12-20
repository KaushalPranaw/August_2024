package DesignPatterns.Structural.Decorator;

public class SMSNotifierDecorator extends NotifierDecorator {
    private String phoneNumber;

    public SMSNotifierDecorator(Notifier wrappedNotifier, String phoneNumber) {
        super(wrappedNotifier);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }
}

