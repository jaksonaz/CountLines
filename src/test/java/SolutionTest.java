import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


public class SolutionTest {

    private Solution solution;

    @Before
    public void init() {
        solution = new Solution();
    }

    @Test
    public void testOneLineCode() throws IOException {
        int result = solution.countLines("src/test/java/com/animals/Cat.java");
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testNoSuchFileExist() throws IOException {
        int result = solution.countLines("text.txt");
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testBlankPath() throws IOException {
        int result = solution.countLines("");
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testMultiLineCommentInsideCode() throws IOException {
        int result = solution.countLines("src/test/java/com/utils/Dave.java");
        Assert.assertEquals(result, 4);
    }

    @Test
    public void testCommentsInsideAndMultiLineComments() throws IOException {
        int result = solution.countLines("src/test/java/com/utils/Hello.java");
        Assert.assertEquals(result, 6);
    }

    @Test
    public void testRootPackage() throws IOException {
        int result = solution.countLines("src/test/java/com");
        Assert.assertEquals(result, 28);
    }
}
