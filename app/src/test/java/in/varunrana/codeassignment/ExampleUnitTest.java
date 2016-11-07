package in.varunrana.codeassignment;

import org.junit.Test;

import in.varunrana.codeassignment.Utils.Utils;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    @Test
    public void check_StringLength_isCorrect() throws Exception {
        assertEquals(Utils.getInstance().isStringLengthValid("Varun Rana"), true);
    }

    @Test
    public void validate_username_isValid() throws Exception {
        assertEquals(Utils.getInstance().isUserNameValid("Varun@in"), false);
    }

}