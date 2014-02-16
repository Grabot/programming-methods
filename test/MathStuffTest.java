
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite for MathStuff.
 *
 * @author Tom Verhoeff (TU/e)
 */
@RunWith(Suite.class)
@SuiteClasses({MathStuffTestTopLevel.class, MathStuffTestAuxiliary.class})
public class MathStuffTest {

}
