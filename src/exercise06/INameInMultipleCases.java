package exercise06;

/**
 * Classes implementing this interface indicate that they have a name that can be returned in upper and lower case.
 * Returning lower case is optional. If you do not implement this method, throw an {@link UnsupportedOperationException}.
 */
public interface INameInMultipleCases {

    String getNameInUpperCase();

    String getNameInLowerCase();
}
