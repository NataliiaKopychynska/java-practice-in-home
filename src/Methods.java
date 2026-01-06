public class Methods {

    public static void main(String[] args) {
//        sayHallo();
//        drawS(10);
    }

    public static void sayHallo(){
        System.out.println("Hallo");
    }

    public static int add(int a, int b){
        return a+b;
    }

    public static boolean isEven(int number){
        return number % 2 == 0;
    }

    public static void drawS(int size){
        for(int i = 0; i<size; i++){
            for (int j = 0; j<size; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
