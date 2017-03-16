package kata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.fest.assertions.api.Assertions;
import org.junit.runner.RunWith;

/**
 * Created by johan on 16/03/17.
 */
@RunWith(JUnitQuickcheck.class)
public class LcdPropertyTest {
    @Property
    public void testStatisticalDeath(@From(Filled.class) Integer arg) {
        Assertions.assertThat(arg).isEqualTo(0);
    }


}
