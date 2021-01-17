import java.util.Scanner;

public class AngleClock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minute = sc.nextInt();
        hour %=12;
        double hourHandAngle = hour*30 + minute*0.5;
        double minuteHandAngle = minute*6;
        double angle = Math.min(Math.abs(hourHandAngle-minuteHandAngle),Math.abs(360-Math.abs(hourHandAngle-minuteHandAngle)));
        System.out.println(angle);
        sc.close();
    }
    
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                