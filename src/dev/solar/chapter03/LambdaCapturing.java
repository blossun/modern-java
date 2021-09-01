package dev.solar.chapter03;

public class LambdaCapturing {
    private int a = 12;

    public void test() {
        final int b = 123;
        int c = 123;
        int d = 123;

        final Runnable r = () -> {
            // 인스턴스 변수 a는 final로 선언돼있을 필요도, final처럼 재할당하면 안된다는 제약조건도 적용되지 않는다.
            a = 123;
            System.out.println(a);
        };

        // 지역변수 b는 final로 선언돼있기 때문에 OK
        final Runnable r2 = () -> System.out.println(b);

        // 지역변수 c는 final로 선언돼있지 않지만 final을 선언한 것과 같이 변수에 값을 재할당하지 않았으므로 OK
        final Runnable r3 = () -> System.out.println(c);

        // 지역변수 d는 final로 선언돼있지도 않고, 값의 재할당이 일어났으므로 final처럼 동작하지 않기 때문에 X
        d = 12;
//        final Runnable r4 = () -> System.out.println(d); //컴파일 에러
    }
}
