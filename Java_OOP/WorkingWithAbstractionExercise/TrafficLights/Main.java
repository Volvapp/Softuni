package WorkingWithAbstractionExercise.TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] trafficLights = scanner.nextLine().split("\\s+");

        TrafficLight[] trafficLightsArr = new TrafficLight[trafficLights.length];

        for (int i = 0; i < trafficLights.length; i++) {
            String trafficLight = trafficLights[i];
            TrafficLight.Signal signal = TrafficLight.Signal.valueOf(trafficLight);
            trafficLightsArr[i] = new TrafficLight(signal);
        }
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            updateTrafficLights(trafficLightsArr);
            printTrafficLights(trafficLightsArr);
        }

    }

    private static void printTrafficLights(TrafficLight[] trafficLightsArr) {
        for (TrafficLight trafficLight : trafficLightsArr) {
            System.out.print(trafficLight.getSignal() + " ");
        }
        System.out.println();
    }

    private static void updateTrafficLights(TrafficLight[] trafficLightsArr) {
        for (TrafficLight trafficLight : trafficLightsArr) {
            trafficLight.update();
        }
    }
}
