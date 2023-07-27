package modern;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TraderStream {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1
        System.out.println(transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList()));

        // 2
        System.out.println(transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList()));

        //3
        System.out.println(transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .map(Trader::getName)
                .distinct()
                .sorted(String::compareTo)
                .collect(Collectors.toList()));

        //4
        System.out.println(transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted(String::compareTo)
                .collect(Collectors.toList()));

        //5
        System.out.println(transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(trader -> trader.getCity().equals("Milan")));

        //6
        System.out.println(transactions.stream()
                .filter(trader -> trader.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .collect(Collectors.toList()));

        //7
        System.out.println(transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer::max)
                .get());

        //8
        System.out.println(transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min)
                .get());
    }

}
