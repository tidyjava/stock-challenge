import java.math.BigDecimal;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

final class StockHelper {
    private static final int SKIP_CLOSEST_OFFSET = 2;

    private StockHelper() {
    }

    static Deal bestDeal(List<BigDecimal> stockPrices) {
        return allPossibleDeals(stockPrices).stream().max(byGain()).get();
    }

    private static List<Deal> allPossibleDeals(List<BigDecimal> stockPrices) {
        List<Deal> possibleDeals = new LinkedList<>();
        for (int i = 0; i < (stockPrices.size() - SKIP_CLOSEST_OFFSET); ++i) {
            for (int j = i + SKIP_CLOSEST_OFFSET; j < stockPrices.size(); ++j) {
                possibleDeals.add(new Deal(stockPrices.get(i), stockPrices.get(j)));
            }
        }
        return possibleDeals;
    }

    private static Comparator<Deal> byGain() {
        return (d1, d2) -> d1.gain().compareTo(d2.gain());
    }
}
