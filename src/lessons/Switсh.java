package lessons;

import java.util.Scanner;

public class Switсh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day = Integer.parseInt(scanner.nextLine());

        String dayType = switch(day){
            case 1,2,3,4,5 -> "work day";
            case 6,7 -> "weekend";
            default -> "error";

        };
//        System.out.println(dayType);

        String result = switch (day){
            case 1,2,3,4,5 -> {
                    String type = "work day";
                    yield "this is " + type;
            }
            case 6,7 -> {
                String type = "weekend";
                yield "this is " + type;
            }
            default -> "error";
        };
        System.out.println(result);
    }
}
