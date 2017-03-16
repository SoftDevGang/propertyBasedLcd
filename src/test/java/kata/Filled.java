
package kata;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import com.pholser.junit.quickcheck.generator.Generator;

public class Filled extends Generator<Integer> {

    public Filled() {
        super(Integer.class);
    }

    @Override
    public Integer generate(SourceOfRandomness random, GenerationStatus status) {
        return 0;
    }

}