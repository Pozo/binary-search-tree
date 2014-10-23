package com.prezi.collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    private BinarySearchTree<String> testText;
    private BinarySearchTree<Integer> testInt;

    @Before
    public void setUp() throws Exception {
        testText = new BinarySearchTree<String>();
        testInt = new BinarySearchTree<Integer>();
    }

    @After
    public void tearDown() throws Exception {
        testText = new BinarySearchTree<String>();
    }
    @Test
    public void testAddNull() throws Exception {
        testText.add(null);
        assertEquals(0, testText.size());
    }
    @Test
    public void testAddText() throws Exception {
        testText.add("asdads");
        assertEquals(1, testText.size());
    }
    @Test
    public void testAddTextTwo() throws Exception {
        testText.add("asdads");
        testText.add("asda aqqds");
        assertEquals(2, testText.size());
    }
    @Test
    public void testAddTextRedundant() throws Exception {
        testText.add("asdads");
        testText.add("asdads");
        assertEquals(1, testText.size());
    }
    @Test
    public void testAddInt() throws Exception {
        testInt.add(12);
        assertEquals(1, testInt.size());
    }
    @Test
    public void testAddIntTwo() throws Exception {
        testInt.add(12);
        testInt.add(1);
        assertEquals(2, testInt.size());
    }
    @Test
    public void testAddIntRedundant() throws Exception {
        testInt.add(12);
        testInt.add(12);
        assertEquals(1, testInt.size());
    }
    @Test
    public void testLookupFalse() throws Exception {
        testText.add("asdads");
        testText.add("asd88ads");
        testText.add("8888");
        assertEquals(false, testText.lookup("88"));
    }
    @Test
    public void testLookupTrue() throws Exception {
        testText.add("asdads");
        testText.add("asd88ads");
        testText.add("8888");
        assertEquals(true, testText.lookup("asd88ads"));
    }
    @Test
    public void testRemoveSize() throws Exception {
        testText.add("asdads");
        testText.add("asd88ads");
        testText.add("8888");

        testText.remove("asd88ads");
        assertEquals(2, testText.size());
    }
    @Test
    public void testRemoveContentOne() throws Exception {
        testText.add("asdads");
        testText.add("asd88ads");
        testText.add("8888");

        testText.remove("aa");
        assertEquals(3, testText.size());
    }
    @Test
    public void testRemoveRootText() throws Exception {
        testText.add("a");
        testText.add("b");
        testText.add("c");

        testText.remove("a");
        assertEquals(2, testText.size());
    }
    @Test
    public void testRemoveRootInt() throws Exception {
        testInt.add(0);
        testInt.add(1);
        testInt.add(2);

        testInt.remove(0);
        assertEquals(2, testInt.size());
    }
    @Test
    public void testRemoveContentTwo() throws Exception {
        testText.add("asdads");
        testText.add("asd88ads");
        testText.add("8888");

        testText.remove("asd88ads");
        assertEquals(false, testText.lookup("asd88ads"));
    }
    @Test
    public void testRemoveContentAndAdd() throws Exception {
        testText.add("asdads");
        testText.add("asd88ads");
        testText.add("8888");

        testText.remove("asd88ads");
        testText.add("asd88ads");
        assertEquals(true, testText.lookup("asd88ads"));
    }
    @Test
    public void testRemoveContentAndAddTwo() throws Exception {
        testText.add("asdads");
        testText.add("ellen");
        testText.add("allhat");
        testText.add("daaaaaa");
        testText.add("nyekk");

        testText.remove("daaaaaa");
        testText.add("daaaaaa");
        assertEquals(5, testText.size());
    }
    @Test
    public void testSize() throws Exception {
        testText.add("asdads");
        testText.add("ellen");
        testText.add("allhat");
        testText.add("daaaaaa");
        testText.add("nyekk");

        testText.remove("daaaaaa");
        testText.add("daaaaaa");
        assertEquals(5, testText.size());
    }
    @Test
    public void testSizeTwo() throws Exception {
        testText.add(null);

        assertEquals(0, testText.size());
    }
    @Test
    public void testSizeThree() throws Exception {
        testText.add(null);
        testText.add("egy");

        assertEquals(1, testText.size());
    }
    @Test
    public void testMinDepthEmpty() throws Exception {
        assertEquals(0, testInt.minDepth());
    }
    @Test
    public void testMinDepth() throws Exception {
        testInt.add(12);
        testInt.add(11);
        assertEquals(1, testInt.minDepth());
    }
    @Test
    public void testMinDepthOne() throws Exception {
        testInt.add(0);
        testInt.add(1);
        testInt.add(2);
        testInt.add(3);
        assertEquals(1, testInt.minDepth());
    }
    @Test
    public void testMaxDepthEmpty() throws Exception {
        assertEquals(0, testInt.maxDepth());
    }
    @Test
    public void testMaxDepth() throws Exception {
        testInt.add(0);
        testInt.add(1);
        testInt.add(2);
        testInt.add(3);

        assertEquals(4, testInt.maxDepth());
    }
    @Test
    public void testMaxDepthOne() throws Exception {
        testInt.add(0);
        testInt.add(1);
        testInt.add(-1);
        testInt.add(3);

        assertEquals(3, testInt.maxDepth());
    }
    @Test
    public void testMaxDepthTwo() throws Exception {
        testInt.add(0);
        testInt.add(1);
        testInt.add(-1);
        testInt.add(-2);

        assertEquals(3, testInt.maxDepth());
    }
    public void testFindMinText() throws Exception {
        testText.add("a");
        testText.add("p");
        testText.add("e");
        testText.add("h");
        testText.add("b");
        testText.add("f");
        testText.add("é");
        testText.add("g");
        testText.add("c");
        testText.add("d");

        testText.remove("e");
        //testText.add("e");

        assertEquals(9, testText.size());
    }

    @Test
    public void testFindMin() throws Exception {
        testInt.add(0);
        testInt.add(1);
        testInt.add(-1);
        testInt.add(3);

        assertEquals("0,-1,1,3,", testInt.tree());
        testInt.remove(3);
        assertEquals("0,-1,1,", testInt.tree());
    }
    @Test
    public void testFindMinYay() throws Exception {
        testInt.add(5);
        testInt.add(2);
        testInt.add(18);
        testInt.add(-4);
        testInt.add(3);
        testInt.add(21);
        testInt.add(19);
        testInt.add(25);

        assertEquals("5,2,-4,3,18,21,19,25,", testInt.tree());
        testInt.remove(18);
        assertEquals("5,2,-4,3,21,19,25,", testInt.tree());
    }
    @Test
    public void testFindMinYayTwo() throws Exception {
        testInt.add(5);
        testInt.add(2);
        testInt.add(12);
        testInt.add(-4);
        testInt.add(3);
        testInt.add(9);
        testInt.add(21);
        testInt.add(19);
        testInt.add(25);

        assertEquals("5,2,-4,3,12,9,21,19,25,", testInt.tree());
        testInt.remove(12);
        assertEquals("5,2,-4,3,19,9,21,25,", testInt.tree());
    }
    @Test
    public void testFindMinYayThree() throws Exception {
        testInt.add(5);
        testInt.add(2);
        testInt.add(18);
        testInt.add(-4);
        testInt.add(3);

        assertEquals("5,2,-4,3,18,", testInt.tree());
        testInt.remove(-4);
        assertEquals("5,2,3,18,", testInt.tree());
    }
    @Test
    public void testPrintPostorder() throws Exception {

    }

    @Test
    public void testPrintPostorder1() throws Exception {

    }

    @Test
    public void testTree() throws Exception {
        testInt.add(5);
        testInt.add(2);
        testInt.add(33);
        testInt.add(-22);
        testInt.add(-2);
        testInt.add(4);

        assertEquals("5,2,-22,-2,4,33,",testInt.tree());
    }

    @Test
    public void testTree1() throws Exception {
        testInt.add(0);
        testInt.add(1);
        testInt.add(2);
        testInt.add(3);
        testInt.add(4);
        testInt.add(5);
        testInt.add(-1);

        assertEquals("0,-1,1,2,3,4,5,",testInt.tree());
    }

    @Test
    public void testSerialize() throws Exception {

    }
    @Test
    public void testDeserializeOne() throws Exception {
        String serializedValue = "[2,[1,[-5,null,[-3,null,null]],null],[7,[3,null,[5,null,null]],[9,null,[49,null,null]]]]";

        BinarySearchTree<String> bst = BinarySearchTree.<String>deserialize(serializedValue);
        assertEquals(true,bst.serialize().equals(serializedValue));
    }
    @Test
    public void testDeserializeTwo() throws Exception {
        String serializedValue = "[IFA,[BMW,[Audi,null,null],[Csepel,null,[GAS,[Ferrari,null,null],null]]],[Wartburg,[Opel,[Mercedes,[Lamborgini,null,null],null],null],null]]";

        BinarySearchTree<String> bst = BinarySearchTree.<String>deserialize(serializedValue);
        assertEquals(true,bst.serialize().equals(serializedValue));
    }
    @Test
    public void testDeserializeThree() throws Exception {
        String serializedValue = "[2,[1,[-5,null,[-3,null,null]],null],[7,[3,null,[5,null,null]],[9,null,[49,null,null]]]]";

        BinarySearchTree<String> bst = BinarySearchTree.<String>deserialize(serializedValue);
        assertEquals(true,bst.serialize().equals(serializedValue));
    }
    @Test
    public void testDeseriualizeFromGit() {
        String serializedValue = "[21,[17,null,null],[81,[62,[58,[31,null,[36,null,null]],null],[77,[68,null,null],null]],[82,null,[91,null,null]]]]";

        BinarySearchTree<String> bst = BinarySearchTree.<String>deserialize(serializedValue);
        assertEquals(true, bst.serialize().equals(serializedValue));
    }
}