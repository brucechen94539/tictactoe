import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String shape = sc.next();
        final double pi = 3.14;
        double area = 0;

        switch (shape) {
            case "triangle":
                double s1 = sc.nextDouble();
                double s2 = sc.nextDouble();
                double s3 = sc.nextDouble();
                double p = (s1 + s2 + s3) / 2;
                area = Math.sqrt(p * (p - s1) * (p - s2) * (p - s3));
                break;
            case "rectangle":
                double l = sc.nextDouble();
                double w = sc.nextDouble();
                area = l * w;
                break;
            case "circle":
                double radius = sc.nextDouble();
                area = radius * radius * pi;
                break;
            case "default":
                System.out.println("Unknown form");
                break;
        }

        System.out.println(area);
    }
}
