package DesignPatterns.Structural.Bridge;

public class TestBridgePattern {
    public static void main(String[] args) {
        Device tv = new TV();
        Device radio = new Radio();

        RemoteControl basicRemoteForTV = new BasicRemote(tv);
        RemoteControl basicRemoteForRadio = new BasicRemote(radio);

        basicRemoteForTV.powerOn();
        basicRemoteForTV.powerOff();

        basicRemoteForRadio.powerOn();
        basicRemoteForRadio.powerOff();

    }
}
