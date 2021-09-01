package dev.solar.chapter03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LambdaApplication {
    public static void main(String[] args) throws IOException {
        String oneLine = processFile((BufferedReader br) -> br.readLine());
        System.out.println("oneLine : " + oneLine);

        String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        System.out.println("oneLine : " + twoLine);
    }

    public static String processFile(BufferedReaderProcessor brp) throws IOException {
        String path = LambdaApplication.class.getResource("").getPath(); //현재 클래스의 절대 경로
        try (BufferedReader br = new BufferedReader(new FileReader(path + "data.txt"))) {
            return brp.process(br);
        }
    }
}
