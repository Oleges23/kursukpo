import org.junit.Assert;
import org.junit.Test;

public class TreeTest {

    @Test
    public void testDefaultConstructor() {
        Tree t1 = new Tree();
        Assert.assertNull(t1.mRoot);
    }

    @Test
    public void testIntegerConstructor() {
        Tree t1 = new Tree(1);
        Assert.assertNotNull(t1.mRoot);
    }

    @Test
    public void testInsertToEmptyTree() {
        Tree t1 = new Tree();
        t1.insert(1);
        Assert.assertEquals(1, t1.mRoot.mValue);
    }

    @Test
    public void testNotEqualNotAvlInstance() {
        Tree t1 = new Tree();
        Object object = new Object();
        Assert.assertNotEquals(t1, object);
    }

    @Test
    public void testRootEmpty() {
        Tree t1 = new Tree();
        t1.insert();
        Assert.assertEquals(null, t1.mRoot);
    }

    @Test
    public void testRootsEqual() {
        Tree t1 = new Tree(1);
        Tree t2 = new Tree(1);
        Assert.assertEquals(t1, t2);
    }

    @Test
    public void testRootAndLeftEqual() {
        Tree t1 = new Tree(10);
        t1.insert(2);
        Assert.assertNotEquals(t1.mRoot.mLeft.mValue, t1.mRoot.mValue);
    }

    @Test
    public void testRootAndRightEqual() {
        Tree t1 = new Tree(2);
        t1.insert(2);
        Assert.assertEquals(t1.mRoot.mRight.mValue, t1.mRoot.mValue);
    }

    @Test
    public void testLeftEqRight(){
        Tree t1 = new Tree(3);
        t1.insert(4);
        t1.insert(2);
        Assert.assertNotEquals(t1.mRoot.mRight.mValue, t1.mRoot.mLeft.mValue);
    }

    @Test
    public void testRootsEqual_LeftsNotEqual() {
        Tree t1 = new Tree(10);
        t1.insert(2);
        Tree t2 = new Tree(10);
        t2.insert(1);
        Assert.assertNotEquals(t1, t2);
    }

    @Test
    public void testEqualsRightLeft(){
        Tree tree = new Tree(6);
        tree.insert(5,5);
        Assert.assertNotEquals(tree.mRoot.mRight.mValue,tree.mRoot.mLeft.mValue);
    }

    @Test
    public void testEqualTreesEqualHashCodes() {
        Tree t1 = new Tree(10);
        t1.insert(2, 12);
        Tree t2 = new Tree(10);
        t2.insert(2, 12);
        Assert.assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void testToStringEmpty() {
        Tree t1 = new Tree();
        Assert.assertEquals("[]", t1.toString());
    }

    @Test
    public void testToStringSingleNode() {
        Tree t1 = new Tree(1);
        Assert.assertEquals("[1]", t1.toString());
    }

    @Test
    public void testToStringManyNodes() {
        Tree t1 = new Tree(1);
        t1.insert(12, 56, 7, 2, 1);
        Assert.assertEquals("[1, 1, 2, 7, 12, 56]", t1.toString());
    }

    @Test
    public void testSingleRotateLeft() {
        Tree t1 = new Tree(10);
        t1.insert(14, 56);
        Assert.assertEquals(t1.mRoot.mValue, 14);
        Assert.assertEquals(t1.mRoot.mLeft.mValue, 10);
        Assert.assertEquals(t1.mRoot.mRight.mValue, 56);
    }

    @Test
    public void testSingleRotateRight() {
        Tree t1 = new Tree(10);
        t1.insert(2, 1);
        Assert.assertEquals(t1.mRoot.mValue, 2);
        Assert.assertEquals(t1.mRoot.mLeft.mValue, 1);
        Assert.assertEquals(t1.mRoot.mRight.mValue, 10);
    }
}