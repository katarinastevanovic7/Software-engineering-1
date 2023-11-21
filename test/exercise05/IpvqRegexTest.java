package exercise05;

import org.junit.Assert;
import org.junit.Test;

import static exercise05.IpvqRegex.IPVQ_REGEX;

public class IpvqRegexTest {

    @Test
    public void validAdresses() {
        // 3a
        //TODO: weitere Fälle
        Assert.assertTrue("509;0;380;339;468".matches(IPVQ_REGEX));
        Assert.assertTrue("0;0;0;0;0".matches(IPVQ_REGEX));
        Assert.assertTrue("1;0;1;0;0".matches(IPVQ_REGEX));
        Assert.assertTrue("57;1;2;3;4".matches(IPVQ_REGEX));
        Assert.assertTrue("99;99;99;99;42".matches(IPVQ_REGEX));
        Assert.assertTrue("123;456;111;112;1".matches(IPVQ_REGEX));
    }

    @Test
    public void invalidAdresses() {
        //TODO: weitere Fälle
        Assert.assertFalse("05;305;380;339;468".matches(IPVQ_REGEX));
        Assert.assertFalse("305;380;339;468".matches(IPVQ_REGEX));
        Assert.assertFalse("05 ;305;380;339;468".matches(IPVQ_REGEX));
        Assert.assertFalse("513;305;380;339;468".matches(IPVQ_REGEX));
    }
}
