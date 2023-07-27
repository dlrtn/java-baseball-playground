package study;

import java.util.stream.Stream;

public class StreamLazy {

    public static class Data {
        private final String data;

        public Data(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void functionA() {
            System.out.println(data + "functionA");
        }

        public void functionB() {
            System.out.println(data + "functionB");
        }

        public void functionC() {
            System.out.println(data + "functionC");
        }

        public void functionD() {
            System.out.println(data + "functionD");
        }
    }

    public static void main(String[] args) {
        Stream.of(new Data("data1"), new Data("data2"), new Data("data3"))
                .peek(Data::functionA)
                .peek(Data::functionB)
                .peek(Data::functionC)
                .forEach(Data::functionD);
    }
}
