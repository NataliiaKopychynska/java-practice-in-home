package List;

import java.util.ArrayList;

public class Collections {
    public static void main(String[] args) {
        String[] arr = new String[3];

        ArrayList<String> toys = new ArrayList<>();
        toys.add("Toy1");
        toys.add("Toy2");
        System.out.println( toys.size());
        System.out.println(toys.get(1));
        System.out.println(toys);

        toys.add("Toy3");
        toys.add("Toy4");

        toys.remove("Toy1");
        System.out.println(toys);

        if(toys.contains("Toy3")){
            System.out.println("Toy3 contains Toy3");
        }

        System.out.println("\nToys:");
        for(String toy : toys){
            System.out.println(toy);
        }
    }
}
