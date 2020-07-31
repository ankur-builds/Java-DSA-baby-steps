package basics;

public class TryLambda {
    interface IntegerMath {
        int operation(int a, int b);
    }

    interface CustomI{
        int print(int a, int b);
    }
    public int printHello(int a, int b, CustomI ci){
        return ci.print(a,b);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    public static void main(String... args) {

        TryLambda myApp = new TryLambda();
        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;
        CustomI ci_var = (a, b) -> {
            System.out.println(a);
            System.out.println(b);
            return 1;
        };
        System.out.println("40 + 2 = " +
                myApp.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " +
                myApp.operateBinary(20, 10, subtraction));
        System.out.println("CustomI" + myApp.printHello(50,100,ci_var));
    }
}
