package kata;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class OnlyTwosGenerator extends Generator<Integer> {

    public OnlyTwosGenerator() {
        super(Integer.class);
    }

    @Override
    public Integer generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
        int[] twos = {2, 22, 222, 2222, 22222, 222222, 2222222, 22222222};
        int index = sourceOfRandomness.nextInt(0, twos.length - 1);
        return twos[index];
    }
}
