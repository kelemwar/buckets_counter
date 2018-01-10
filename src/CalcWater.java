import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * Created by Banner on 08.12.2017.
 */

public class CalcWater {

    List<Integer> buckets = Arrays.asList(1, 2, 5,10);

    public List<List<Integer>> allWays(int amountWater) {

        Collections.sort(buckets);
        List<List<Integer>> result = new ArrayList<>();

        class Wrapper<T> {
            private T function;
        }
        Wrapper<Function<Integer, BiConsumer<Integer, List<Integer>>>> recursion = new Wrapper<>();
        recursion.function = bucket -> (numberOfBucket, buffer) -> {
            if (bucket < 0 || numberOfBucket < 0)
                return;

            if (bucket == 0) {
                result.add(buffer);
                return;
            }

            recursion.function.apply(bucket).accept(numberOfBucket - 1, new ArrayList<>(buffer));
            int count = buckets.get(numberOfBucket);
            buffer = new ArrayList<>(buffer);
            buffer.add(count);
            recursion.function.apply(bucket - count).accept(numberOfBucket, buffer);
        };

        recursion.function.apply(amountWater).accept(buckets.size() - 1, new ArrayList<>());

        return result;
    }

}

