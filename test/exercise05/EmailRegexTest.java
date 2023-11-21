package exercise05;

import org.junit.Assert;
import org.junit.Test;

import static exercise05.EmailRegex.EMAIL_REGEX;

public class EmailRegexTest {

    @Test
    public void validAdresses() {
        Assert.assertTrue("johannes.schneider@htwg-konstanz.de".matches(EMAIL_REGEX));
        // TODO: 9 weitere Positiv-Tests
        Assert.assertTrue("johannes.schneider@htwg-konstanz.de".matches(EMAIL_REGEX));
        Assert.assertTrue("anny-2mueller@example.com".matches(EMAIL_REGEX));
        Assert.assertTrue("maxmustermann@gmail.com".matches(EMAIL_REGEX));
        Assert.assertTrue("tom_schmidt2@yahoo.co.uk".matches(EMAIL_REGEX));
        Assert.assertTrue("marie.schneider@mydomain.org".matches(EMAIL_REGEX));
        Assert.assertTrue("12lukas.weber@website.info".matches(EMAIL_REGEX));
        Assert.assertTrue("leonie_becker@htwg-konstanz.de".matches(EMAIL_REGEX));
        Assert.assertTrue("anne-marie@htwg-konstanz.de".matches(EMAIL_REGEX));
        Assert.assertTrue("tom123@htwg-konstanz.de".matches(EMAIL_REGEX));
        Assert.assertTrue("HaLloL@htwg-konstanz.de".matches(EMAIL_REGEX));
    }

    @Test
    public void withSpace_invalid() {
        Assert.assertFalse("johannes @schneider.de".matches(EMAIL_REGEX));
    }

    @Test
    public void withTab_invalid() {
        Assert.assertFalse("johannes@sc\thneider.de".matches(EMAIL_REGEX));
    }

    @Test
    public void domainTooShort_invalid() {
        Assert.assertFalse("johannes@schneider.d".matches(EMAIL_REGEX));
    }

    @Test
    public void moreInvalidAdresses() {
        Assert.assertFalse("a".matches(EMAIL_REGEX));
        // TODO: 9 weitere Negativ-Fälle
        Assert.assertFalse("a".matches(EMAIL_REGEX));
        Assert.assertFalse("b@htwg-konstanz".matches(EMAIL_REGEX));
        Assert.assertFalse("anna.meier.de".matches(EMAIL_REGEX));
        Assert.assertFalse("leonie becker @ htwg - konstanz . de".matches(EMAIL_REGEX));
        Assert.assertFalse("marie.schneider@htwg. de".matches(EMAIL_REGEX));
        Assert.assertFalse("@tom@.de".matches(EMAIL_REGEX));
        Assert.assertFalse("hallo@htwg".matches(EMAIL_REGEX));
        Assert.assertFalse(".de".matches(EMAIL_REGEX));
        Assert.assertFalse("@lukas.de".matches(EMAIL_REGEX));
    }
}
