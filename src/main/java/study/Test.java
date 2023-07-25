package study;

public class Test {
    private static int classVar = 1;

    private static final int finalClassVar = 2;

    private int instanceVar = 3;

    private final int finalInstanceVar = 4;

    public static void main(String[] args) {
        int localVar = 5;

        Test test = new Test();

        test.setInstanceVar(5); // 상관없음!

        // test = new Test(); 지역 변수에 대해서만 발생!

        Runnable r = () -> {
            System.out.println(classVar);
            System.out.println(finalClassVar);
            System.out.println(test.instanceVar);
            System.out.println(test.finalInstanceVar);
            System.out.println(localVar);
        };

        r.run();

        // localVar = 7; 오류 발생..
    }

    public void setInstanceVar(int instanceVar) {
        this.instanceVar = instanceVar;
    }
}
