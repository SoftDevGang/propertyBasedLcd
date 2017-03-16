package kata;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.generator.java.lang.IntegerGenerator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class AnyPositiveIntegerWithoutOneAndFour extends Generator<Integer> {

    protected AnyPositiveIntegerWithoutOneAndFour() {
        super(Integer.class);
    }

    @Override
    public Integer generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
        return sourceOfRandomness.nextInt(0, Integer.MAX_VALUE);
    }
}
