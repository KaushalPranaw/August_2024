package DesignPatterns.Structural.Decorator;

public class TestDecorator {
    public static void main(String[] args) {
        // Basic email notification
        Notifier notifier = new EmailNotifier("user@example.com");

        // Add SMS notification
        notifier = new SMSNotifierDecorator(notifier, "+1234567890");

        // Add Slack notification
        notifier = new SlackNotifierDecorator(notifier, "john_doe");

        // Send the message
        notifier.send("Your order has been shipped!");
    }
}
