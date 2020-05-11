package table;

import collection.KolekceException;
import table.TypProhlidky;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * TODO The previous test contained incorrect deep traversal. Instead of in-order
 * it was using post-order.
 * @author Tomas Marny & Co.
 */
/**
 * created by TreeBuild software 0.9.9 beta © from Michael Vodák
 * modified by Tomáš Marný
 * P.S.: The mention software was not stolen from this due.
 * @author Tomas Marny & Co.
 */
public class AbstrTableImplementedAsAbstrSearchBinaryTreeStreamUnsupportedTest_Correction {
    
    private static int counter = 1;
    
    private String methodName() {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[2];
        return e.getMethodName();
    }
    
    private void printTestMethodName(String testMethodName) {
        System.out.println("test" +
                (counter < 10 ? 
                        "000" : 
                        (counter < 100 ? 
                                "00" : 
                                counter < 1000 ? "0" : "")) +
                counter++ + "_" + testMethodName
        );
    }
    private final String STRING01 = "01";
    private final String STRING02 = "02";
    private final String STRING03 = "03";
    private final String STRING04 = "04";
    private final String STRING05 = "05";
    private final String STRING06 = "06";
    private final String STRING07 = "07";
    private final String STRING08 = "08";
    private final String STRING09 = "09";
    private final String STRING10 = "10";
    private final String STRING11 = "11";
    private final String STRING12 = "12";
    private final String STRING13 = "13";
    private final String STRING14 = "14";
    private final String STRING15 = "15";
    private final String STRING16 = "16";
    private final String STRING17 = "17";
    private final String STRING18 = "18";
    private final String STRING_NULL = null;
    
    private static Table<String, String> table;
    
    
    public AbstrTableImplementedAsAbstrSearchBinaryTreeStreamUnsupportedTest_Correction() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        table = new AbstrTable();
    }
    
    @AfterClass
    public static void tearDownClass() {
        table = null;
    }
    
    @Before
    public void setUp() {
        System.out.println("");
    }
    
    @After
    public void tearDown() {
        System.out.println("tear down");
        printDataByIterator(TypProhlidky.LEVEL_ORDER);
        printDataByIterator(TypProhlidky.IN_ORDER);
        System.out.println(
                "--------------------------------------------------------------"
                + "------------------------------------------------------------"
        );
        table.zrus();
    }

    //================== Testy jednotlivých metod ==============================
    
    @Test
    public void testUnitJePrazdny() {
        printTestMethodName(methodName());
        assertTrue(table.jePrazdny());
    }
    
    @Test
    public void testUnitNeniPrazdny() {
        printTestMethodName(methodName());
        table.vloz(STRING01, STRING01);
        assertFalse(table.jePrazdny());
    }
    
    @Test
    public void testUnitZrus() {
        printTestMethodName(methodName());
        table.vloz(STRING09, STRING09);
        table.zrus();
        assertTrue(table.jePrazdny());
    }
    
    @Test(expected = NullPointerException.class)
    public void tesUnittNajdi01() {
        printTestMethodName(methodName());
        table.najdi(STRING_NULL);
        fail();
    }
    
    @Test
    public void testUnitNajdi02() {
        printTestMethodName(methodName());
        assertEquals(STRING_NULL, table.najdi(STRING05));
        
    }
    
    @Test
    public void testUnitNajdi03() {
        printTestMethodName(methodName());
        table.vloz(STRING03, STRING03);
        assertEquals(STRING03, table.najdi(STRING03));
        
    }
    
    /**
     *       "08"
     *      /    \
     *  "03"      "10"
     */
    @Test
    public void testUnitNajdi04() {
        printTestMethodName(methodName());
        table.vloz(STRING08, STRING08);
        table.vloz(STRING03, STRING03);
        table.vloz(STRING10, STRING10);
        assertEquals(STRING03, table.najdi(STRING03));
    }
    
    /**
     *       "08"
     *      /    \
     *  "03"      "10"
     */
    @Test
    public void testUnitNajdi05() {
        printTestMethodName(methodName());
        table.vloz(STRING08, STRING08);
        table.vloz(STRING03, STRING03);
        table.vloz(STRING10, STRING10);
        assertEquals(STRING10, table.najdi(STRING10));
    }
    
    @Test(expected = NullPointerException.class)
    public void testUnitVloz01() {
        printTestMethodName(methodName());
        table.vloz(STRING_NULL, STRING04);
        fail();
    }
    
    @Test(expected = NullPointerException.class)
    public void testUnitVloz02() {
        printTestMethodName(methodName());
        table.vloz(STRING04, STRING_NULL);
        fail();
    }
    
    /**
     *      "04"
     */
    @Test
    public void testUnitVloz03() {
        printTestMethodName(methodName());
        table.vloz(STRING04, STRING04);
    }
    
    @Test(expected = KolekceException.class)
    public void testUnitVloz04() {
        printTestMethodName(methodName());
        table.vloz(STRING04, STRING04);
        table.vloz(STRING04, STRING05);
        fail();
    }
    
    /**
     *      "04"
     *          \
     *           "05"
     */
    @Test
    public void testUnitVloz05() {
        printTestMethodName(methodName());
        table.vloz(STRING04, STRING04);
        table.vloz(STRING05, STRING05);
    }
    
    /**
     *       "04"
     *      /    \
     *  "03"      "05"
     */
    @Test
    public void testUnitVloz06() {
        printTestMethodName(methodName());
        table.vloz(STRING04, STRING04);
        table.vloz(STRING03, STRING03);
        table.vloz(STRING05, STRING05);
    }
    
    @Test(expected = NullPointerException.class)
    public void testUnitOdeber01() throws IllegalAccessException {
        printTestMethodName(methodName());
        table.odeber(STRING_NULL);
        fail();
    }
    
    @Test(expected = KolekceException.class)
    public void testUnitOdeber02() throws IllegalAccessException {
        printTestMethodName(methodName());
        table.odeber(STRING08);
        fail();
    }
    
    /**
     *           removing
     *  "07"        =>
     *           "07"
     */
    @Test
    public void testUnitOdeber03() throws IllegalAccessException {
        printTestMethodName(methodName());
        table.vloz(STRING07, STRING07);
        assertEquals(STRING07, table.odeber(STRING07));
        assertTrue(table.jePrazdny());
    }
    
    /**
     *       "07"        removing       "07"
     *      /    \         =>               \
     *  "06"      "08"   "06"                "08"
     */
    @Test
    public void testUnitOdeber04() throws IllegalAccessException {
        printTestMethodName(methodName());
        table.vloz(STRING07, STRING07);
        table.vloz(STRING08, STRING08);
        table.vloz(STRING06, STRING06);
        assertEquals(STRING06, table.odeber(STRING06));
        String[] expectedsWide = {STRING07, STRING08};
        String[] expectedsDepth = {STRING07, STRING08};
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /**
     *       "07"        removing       "07"
     *      /    \         =>          /
     *  "06"      "08"   "08"      "06"
     */
    @Test
    public void testUnitOdeber05() throws IllegalAccessException {
        printTestMethodName(methodName());
        table.vloz(STRING07, STRING07);
        table.vloz(STRING08, STRING08);
        table.vloz(STRING06, STRING06);
        assertEquals(STRING08, table.odeber(STRING08));
        String[] expectedsWide = {STRING07, STRING06};
        String[] expectedsDepth = {STRING06, STRING07};
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /**
     *       "07"        removing       "08"
     *      /    \         =>          /
     *  "06"      "08"   "07"      "06"
     */
    @Test
    public void testUnitOdeber06() throws IllegalAccessException {
        printTestMethodName(methodName());
        table.vloz(STRING07, STRING07);
        table.vloz(STRING08, STRING08);
        table.vloz(STRING06, STRING06);
        String res = table.odeber(STRING07);
        assertEquals(STRING07, res);
        String[] expectedsWide = {STRING08, STRING06};
        String[] expectedsDepth = {STRING06, STRING08};
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    //================== Testy sequencí ========================================
    
    /** Tree as LinkedList #1
     *  "02"
     *      \
     *       "05"
     *           \
     *            "07"
     *               \
     *                "08"
     *                    \
     *                     "11"
     *                         \
     *                          "14"
     *                              \
     *                               "16"
     */
    @Test
    public void testSequenceVlozAsLinkedList01() {
        printTestMethodName(methodName());
        createTreeAsLinkedList01();
        String[] expectedsWide = {
            STRING02, STRING05, STRING07, STRING08, STRING11, STRING14, STRING16
        };
        String[] expectedsDepth = {
            STRING02, STRING05, STRING07, STRING08, STRING11, STRING14, STRING16
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree as LinkedList #1
     *  "02"                                            "02"
     *      \                                               \
     *       "05"                                            "05"
     *           \                                               \
     *            "07"                                            "07"
     *                \                       removing                 \
     *                 "08"                      =>                     "08"
     *                     \                  "16"                          \
     *                      "11"                                             "11"
     *                          \                                                \
     *                           "14"                                             "14"
     *                               \
     *                                "16"
     */
    @Test
    public void testSequenceVlozOdeber01AsLinkedList01() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTreeAsLinkedList01();
        assertEquals(STRING16, table.odeber(STRING16));
        String[] expectedsWide = {
            STRING02, STRING05, STRING07, STRING08, STRING11, STRING14
        };
        String[] expectedsDepth = {
            STRING02, STRING05, STRING07, STRING08, STRING11, STRING14
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree as LinkedList #1
     *  "02"                                            "02"
     *      \                                               \
     *       "05"                                            "05"
     *           \                                               \
     *            "07"                                            "07"
     *                \                       removing                 \
     *                 "08"                      =>                     "11"
     *                     \                  "08"                          \
     *                      "11"                                             "14"
     *                          \                                                \
     *                           "14"                                             "16"
     *                               \
     *                                "16"
     */
    @Test
    public void testSequenceVlozOdeber02AsLinkedList01() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTreeAsLinkedList01();
        assertEquals(STRING08, table.odeber(STRING08));
        String[] expectedsWide = {
            STRING02, STRING05, STRING07, STRING11, STRING14, STRING16
        };
        String[] expectedsDepth = {
            STRING02, STRING05, STRING07, STRING11, STRING14, STRING16
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree as LinkedList #1
     *  "02"                                            "05"
     *      \                                               \
     *       "05"                                            "07"
     *           \                                               \
     *            "07"                                            "08"
     *                \                       removing                 \
     *                 "08"                      =>                     "11"
     *                     \                  "02"                          \
     *                      "11"                                             "14"
     *                          \                                                \
     *                           "14"                                             "16"
     *                               \
     *                                "16"
     */
    @Test
    public void testSequenceVlozOdeber03AsLinkedList01() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTreeAsLinkedList01();
        assertEquals(STRING02, table.odeber(STRING02));
        String[] expectedsWide = {
            STRING05, STRING07, STRING08, STRING11, STRING14, STRING16
        };
        String[] expectedsDepth = {
            STRING05, STRING07, STRING08, STRING11, STRING14, STRING16
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree as LinkedList #2
     *                                   "17"
     *                                  /
     *                              "15"
     *                             /
     *                          "14"
     *                         /
     *                      "13"
     *                     /
     *                 "09"
     *                /
     *            "08"
     *           /
     *       "06"
     *      /
     *  "01"
     */
    @Test
    public void testSequenceVlozAsLinkedList02() {
        printTestMethodName(methodName());
        createTreeAsLinkedList02();
        String[] expectedsWide = {
            STRING17, STRING15, STRING14, STRING13, STRING09, STRING08,
            STRING06, STRING01
        };
        String[] expectedsDepth = {
            STRING01, STRING06, STRING08, STRING09, STRING13, STRING14,
            STRING15, STRING17
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree as LinkedList #2
     *                                     "17"                                               "17"
     *                                    /                                                  /
     *                                "15"                                               "15"
     *                               /                                                  /
     *                           "14"                                               "14"
     *                          /                                                  /
     *                      "13"                                               "13"
     *                     /                     removing                     /
     *                 "09"                         =>                    "09"
     *                /                          "01"                    /
     *            "08"                                               "08"
     *           /                                                  /
     *       "06"                                               "06"
     *      /
     *  "01"
     */
    @Test
    public void testSequenceVlozOdeber01AsLinkedList02() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTreeAsLinkedList02();
        assertEquals(STRING01, table.odeber(STRING01));
        String[] expectedsWide = {
            STRING17, STRING15, STRING14, STRING13, STRING09, STRING08, STRING06
        };
        String[] expectedsDepth = {
            STRING06, STRING08, STRING09, STRING13, STRING14, STRING15, STRING17
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree as LinkedList #2
     *                                     "17"                                               "17"
     *                                    /                                                  /
     *                                "15"                                               "15"
     *                               /                                                  /
     *                           "14"                                               "14"
     *                          /                                                  /
     *                      "13"                                               "13"
     *                     /                     removing                     /
     *                 "09"                         =>                    "09"
     *                /                          "09"                    /
     *            "08"                                               "06"
     *           /                                                  /
     *       "06"                                               "01"
     *      /
     *  "01"
     */
    @Test
    public void testSequenceVlozOdeber02AsLinkedList02() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTreeAsLinkedList02();
        assertEquals(STRING09, table.odeber(STRING09));
        String[] expectedsWide = {
            STRING17, STRING15, STRING14, STRING13, STRING08, STRING06, STRING01
        };
        String[] expectedsDepth = {
            STRING01, STRING06, STRING08, STRING13, STRING14, STRING15, STRING17
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree as LinkedList #2
     *                                     "17"                                               "15"
     *                                    /                                                  /
     *                                "15"                                               "14"
     *                               /                                                  /
     *                           "14"                                               "13"
     *                          /                                                  /
     *                      "13"                                               "09"
     *                     /                     removing                     /
     *                 "09"                         =>                    "08"
     *                /                          "17"                    /
     *            "08"                                               "06"
     *           /                                                  /
     *       "06"                                               "01"
     *      /
     *  "01"
     */
    @Test
    public void testSequenceVlozOdeber03AsLinkedList02() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTreeAsLinkedList02();
        assertEquals(STRING17, table.odeber(STRING17));
        String[] expectedsWide = {
            STRING15, STRING14, STRING13, STRING09, STRING08, STRING06, STRING01
        };
        String[] expectedsDepth = {
            STRING01, STRING06, STRING08, STRING09, STRING13, STRING14, STRING15
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #01
     *                  "07"
     *              /          \
     *          "05"            "10"
     *         /    \          /    \
     *     "04"      "06"  "09"      "13"
     *                              /
     *                          "11"
     *                              \
     *                               "12"
     */
    @Test
    public void testSequenceVlozAsTree01() {
        printTestMethodName(methodName());
        createTree01();
        String[] expectedsWide = {
            STRING07, STRING05, STRING10, STRING04, STRING06, STRING09,
            STRING13, STRING11, STRING12
        };
        String[] expectedsDepth = {
            STRING04, STRING05, STRING06, STRING07, STRING09, STRING10,
            STRING11, STRING12, STRING13
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #01
     *                  "07"                                             "07"
     *              /          \                                     /          \
     *          "05"            "10"                             "05"            "10"
     *         /    \          /    \        removing                \          /    \
     *     "04"      "06"  "09"      "13"       =>                    "06"  "09"      "13"
     *                              /        "04"                                    /
     *                          "11"                                             "11"
     *                              \                                                \
     *                               "12"                                             "12"
     */
    @Test
    public void testSequenceVlozOdeber01AsTree01() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree01();
        assertEquals(STRING04, table.odeber(STRING04));
        String[] expectedsWide = {
            STRING07, STRING05, STRING10, STRING06, STRING09, STRING13,
            STRING11, STRING12
        };
        String[] expectedsDepth = {
            STRING05, STRING06, STRING07, STRING09, STRING10, STRING11,
            STRING12, STRING13
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #01
     *                  "07"                                             "07"
     *              /          \                                     /          \
     *          "05"            "10"                             "05"            "10"
     *         /    \          /    \        removing           /    \          /    \
     *     "04"      "06"  "09"      "13"       =>          "04"      "06"  "09"      "13"
     *                              /        "12"                                    /
     *                          "11"                                             "11"
     *                              \
     *                               "12"
     */
    @Test
    public void testSequenceVlozOdeber02AsTree01() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree01();
        assertEquals(STRING12, table.odeber(STRING12));
        String[] expectedsWide = {
            STRING07, STRING05, STRING10, STRING04, STRING06, STRING09,
            STRING13, STRING11
        };
        String[] expectedsDepth = {
            STRING04, STRING05, STRING06, STRING07, STRING09, STRING10,
            STRING11, STRING13
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #01
     *                  "07"                                             "07"
     *              /          \                                     /          \
     *          "05"            "10"                             "05"            "10"
     *         /    \          /    \        removing           /    \          /    \
     *     "04"      "06"  "09"      "13"       =>          "04"      "06"  "09"      "13"
     *                              /        "11"                                    /
     *                          "11"                                             "12"
     *                              \
     *                               "12"
     */
    @Test
    public void testSequenceVlozOdeber03AsTree01() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree01();
        assertEquals(STRING11, table.odeber(STRING11));
        String[] expectedsWide = {
            STRING07, STRING05, STRING10, STRING04, STRING06, STRING09,
            STRING13, STRING12
        };
        String[] expectedsDepth = {
            STRING04, STRING05, STRING06, STRING07, STRING09, STRING10,
            STRING12, STRING13
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #01
     *                  "07"                                             "07"
     *              /          \                                     /          \
     *          "05"            "10"                             "05"            "10"
     *         /    \          /    \        removing           /    \          /    \
     *     "04"      "06"  "09"      "13"       =>          "04"      "06"  "09"      "11"
     *                              /        "13"                                         \
     *                          "11"                                                       "12"
     *                              \
     *                               "12"
     */
    @Test
    public void testSequenceVlozOdeber04AsTree01() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree01();
        assertEquals(STRING13, table.odeber(STRING13));
        String[] expectedsWide = {
            STRING07, STRING05, STRING10, STRING04, STRING06, STRING09,
            STRING11, STRING12
        };
        String[] expectedsDepth = {
            STRING04, STRING05, STRING06, STRING07, STRING09, STRING10,
            STRING11, STRING12
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #01
     *                  "07"                                             "07"
     *              /          \                                     /          \
     *          "05"            "10"                             "06"            "10"
     *         /    \          /    \        removing           /               /    \
     *     "04"      "06"  "09"      "13"       =>          "04"            "09"      "13"
     *                              /        "05"                                    /
     *                          "11"                                             "11"
     *                              \                                                \
     *                               "12"                                             "12"
     */
    @Test
    public void testSequenceVlozOdeber05AsTree01() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree01();
        assertEquals(STRING05, table.odeber(STRING05));
        String[] expectedsWide = {
            STRING07, STRING06, STRING10, STRING04, STRING09, STRING13,
            STRING11, STRING12
        };
        String[] expectedsDepth = {
            STRING04, STRING06, STRING07, STRING09, STRING10, STRING11,
            STRING12, STRING13
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #01
     *                  "07"                                             "07"
     *              /          \                                     /          \
     *          "05"            "10"                             "05"            "11"
     *         /    \          /    \        removing           /    \          /    \
     *     "04"      "06"  "09"      "13"       =>          "04"      "06"  "09"      "13"
     *                              /        "10"                                    /
     *                          "11"                                             "12"
     *                              \
     *                               "12"
     */
    @Test
    public void testSequenceVlozOdeber06AsTree01() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree01();
        assertEquals(STRING10, table.odeber(STRING10));
        String[] expectedsWide = {
            STRING07, STRING05, STRING11, STRING04, STRING06, STRING09,
            STRING13, STRING12
        };
        String[] expectedsDepth = {
            STRING04, STRING05, STRING06, STRING07, STRING09, STRING11,
            STRING12, STRING13
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #01
     *                  "07"                                             "09"
     *              /          \                                     /          \
     *          "05"            "10"                             "05"            "10"
     *         /    \          /    \        removing           /    \               \
     *     "04"      "06"  "09"      "13"       =>          "04"      "06"            "13"
     *                              /        "07"                                    /
     *                          "11"                                             "11"
     *                              \                                                \
     *                               "12"                                             "12"
     */
    @Test
    public void testSequenceVlozOdeber07AsTree01() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree01();
        assertEquals(STRING07, table.odeber(STRING07));
        String[] expectedsWide = {
            STRING09, STRING05, STRING10, STRING04, STRING06, STRING13,
            STRING11, STRING12
        };
        String[] expectedsDepth = {
            STRING04, STRING05, STRING06, STRING09, STRING10, STRING11,
            STRING12, STRING13
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #02
     *                  "04"
     *                 /    \
     *             "03"      "08"
     *            /         /    \
     *        "02"      "07"      "12"
     *                           /
     *                       "10"
     */
    @Test
    public void testSequenceVlozAsTree02() {
        printTestMethodName(methodName());
        createTree02();
        String[] expectedsWide = {
            STRING04, STRING03, STRING08, STRING02, STRING07, STRING12, STRING10
        };
        String[] expectedsDepth = {
            STRING02, STRING03, STRING04, STRING07, STRING08, STRING10, STRING12
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #02
     *                  "04"                                           "04"
     *                 /    \                                         /    \
     *             "03"      "08"             removing            "03"      "08"
     *            /         /    \               =>                        /    \
     *        "02"      "07"      "12"        "02"                     "07"      "12"
     *                           /                                              /
     *                       "10"                                           "10"
     */
    @Test
    public void testSequenceVlozOdeber01AsTree02() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree02();
        assertEquals(STRING02, table.odeber(STRING02));
        String[] expectedsWide = {
            STRING04, STRING03, STRING08, STRING07, STRING12, STRING10
        };
        String[] expectedsDepth = {
            STRING03, STRING04, STRING07, STRING08, STRING10, STRING12
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #02
     *                  "04"                                           "04"
     *                 /    \                                         /    \
     *             "03"      "08"             removing            "03"      "08"
     *            /         /    \               =>              /         /    \
     *        "02"      "07"      "12"        "12"           "02"      "07"      "10"
     *                           /
     *                       "10"
     */
    @Test
    public void testSequenceVlozOdeber02AsTree02() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree02();
        assertEquals(STRING12, table.odeber(STRING12));
        String[] expectedsWide = {
            STRING04, STRING03, STRING08, STRING02, STRING07, STRING10
        };
        String[] expectedsDepth = {
            STRING02, STRING03, STRING04, STRING07, STRING08, STRING10
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #02
     *                  "04"                                           "04"
     *                 /    \                                         /    \
     *             "03"      "08"             removing            "02"      "08"
     *            /         /    \               =>                        /    \
     *        "02"      "07"      "12"        "03"                     "07"      "12"
     *                           /                                              /
     *                       "10"                                           "10"
     */
    @Test
    public void testSequenceVlozOdeber03AsTree02() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree02();
        assertEquals(STRING03, table.odeber(STRING03));
        String[] expectedsWide = {
            STRING04, STRING02, STRING08, STRING07, STRING12, STRING10
        };
        String[] expectedsDepth = {
            STRING02, STRING04, STRING07, STRING08, STRING10, STRING12
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #02
     *                  "04"                                           "04"
     *                 /    \                                         /    \
     *             "03"      "08"             removing            "03"      "10"
     *            /         /    \               =>              /         /    \
     *        "02"      "07"      "12"        "08"           "02"      "07"      "12"
     *                           /
     *                       "10"
     */
    @Test
    public void testSequenceVlozOdeber04AsTree02() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree02();
        assertEquals(STRING08, table.odeber(STRING08));
        String[] expectedsWide = {
            STRING04, STRING03, STRING10, STRING02, STRING07, STRING12
        };
        String[] expectedsDepth = {
            STRING02, STRING03, STRING04, STRING07, STRING10, STRING12
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #02
     *                  "04"                                           "07"
     *                 /    \                                         /    \
     *             "03"      "08"             removing            "03"      "08"
     *            /         /    \               =>              /              \
     *        "02"      "07"      "12"        "04"           "02"                "12"
     *                           /                                              /
     *                       "10"                                           "10"
     */
    @Test
    public void testSequenceVlozOdeber05AsTree02() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree02();
        assertEquals(STRING04, table.odeber(STRING04));
        String[] expectedsWide = {
            STRING07, STRING03, STRING08, STRING02, STRING12, STRING10
        };
        String[] expectedsDepth = {
            STRING02, STRING03, STRING07, STRING08, STRING10, STRING12
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #03
     *                   "06"
     *               /          \
     *           "03"            "11"
     *          /    \          /    \
     *      "02"      "05"  "10"     "14"
     *     /               /        /
     * "01"            "08"     "13"
     *                /    \
     *            "07"      "09"
     */
    @Test
    public void testSequenceVlozAsTree03() {
        printTestMethodName(methodName());
        createTree03();
        String[] expectedsWide = {
            STRING06, STRING03, STRING11, STRING02, STRING05, STRING10,
            STRING14, STRING01, STRING08, STRING13, STRING07, STRING09
        };
        String[] expectedsDepth = {
            STRING01, STRING02, STRING03, STRING05, STRING06, STRING07,
            STRING08, STRING09, STRING10, STRING11, STRING13, STRING14
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #03
     *                   "06"                                                "06"
     *               /          \                                        /          \
     *           "03"            "11"                                "03"            "11"
     *          /    \          /    \           removing           /    \          /    \
     *      "02"      "05"  "10"     "14"           =>          "02"      "05"  "10"      "14"
     *     /               /        /            "01"                          /         /
     * "01"            "08"     "13"                                       "08"      "13"
     *                /    \                                             /     \
     *            "07"      "09"                                     "07"       "09"
     */
    @Test
    public void testSequenceVlozOdeber01AsTree03() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree03();
        assertEquals(STRING01, table.odeber(STRING01));
        String[] expectedsWide = {
            STRING06, STRING03, STRING11, STRING02, STRING05, STRING10,
            STRING14, STRING08, STRING13, STRING07, STRING09
        };
        String[] expectedsDepth = {
            STRING02, STRING03, STRING05, STRING06, STRING07, STRING08,
            STRING09, STRING10, STRING11, STRING13, STRING14
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #03
     *                   "06"                                                "06"
     *               /          \                                        /          \
     *           "03"            "11"                                "03"            "11"
     *          /    \          /    \           removing           /    \          /    \
     *      "02"      "05"  "10"     "14"           =>          "01"      "05"  "10"      "14"
     *     /               /        /            "02"                          /         /
     * "01"            "08"     "13"                                       "08"      "13"
     *                /    \                                             /     \
     *            "07"      "09"                                     "07"       "09"
     */
    @Test
    public void testSequenceVlozOdeber02AsTree03() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree03();
        assertEquals(STRING02, table.odeber(STRING02));
        String[] expectedsWide = {
            STRING06, STRING03, STRING11, STRING01, STRING05, STRING10,
            STRING14, STRING08, STRING13, STRING07, STRING09
        };
        String[] expectedsDepth = {
            STRING01, STRING03, STRING05, STRING06, STRING07, STRING08,
            STRING09, STRING10, STRING11, STRING13, STRING14
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #03
     *                   "06"                                                "06"
     *               /          \                                        /          \
     *           "03"            "11"                                "05"            "11"
     *          /    \          /    \           removing           /               /    \
     *      "02"      "05"  "10"     "14"           =>          "02"            "10"      "14"
     *     /               /        /            "03"         /                /         /
     * "01"            "08"     "13"                     "01"              "08"      "13"
     *                /    \                                             /     \
     *            "07"      "09"                                     "07"       "09"
     */
    @Test
    public void testSequenceVlozOdeber03AsTree03() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree03();
        assertEquals(STRING03, table.odeber(STRING03));
        String[] expectedsWide = {
            STRING06, STRING05, STRING11, STRING02, STRING10, STRING14,
            STRING01, STRING08, STRING13, STRING07, STRING09
        };
        String[] expectedsDepth = {
            STRING01, STRING02, STRING05, STRING06, STRING07, STRING08,
            STRING09, STRING10, STRING11, STRING13, STRING14
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #03
     *                   "06"                                                "06"
     *               /          \                                        /          \
     *           "03"            "11"                                "03"            "11"
     *          /    \          /    \           removing           /    \          /    \
     *      "02"      "05"  "10"     "14"           =>          "02"      "05"  "10"      "14"
     *     /               /        /            "13"         /                /
     * "01"            "08"     "13"                     "01"              "08"
     *                /    \                                             /     \
     *            "07"      "09"                                     "07"       "09"
     */
    @Test
    public void testSequenceVlozOdeber04AsTree03() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree03();
        assertEquals(STRING13, table.odeber(STRING13));
        String[] expectedsWide = {
            STRING06, STRING03, STRING11, STRING02, STRING05, STRING10,
            STRING14, STRING01, STRING08, STRING07, STRING09
        };
        String[] expectedsDepth = {
            STRING01, STRING02, STRING03, STRING05, STRING06, STRING07,
            STRING08, STRING09, STRING10, STRING11, STRING14
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #03
     *                   "06"                                                "06"
     *               /          \                                        /          \
     *           "03"            "11"                                "03"            "11"
     *          /    \          /    \           removing           /   \           /    \
     *      "02"      "05"  "10"     "14"           =>          "02"     "05"   "10"      "13"
     *     /               /        /            "14"         /                /
     * "01"            "08"     "13"                     "01"              "08"
     *                /    \                                             /     \
     *            "07"      "09"                                     "07"       "09"
     */
    @Test
    public void testSequenceVlozOdeber05AsTree03() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree03();
        assertEquals(STRING14, table.odeber(STRING14));
        String[] expectedsWide = {
            STRING06, STRING03, STRING11, STRING02, STRING05, STRING10,
            STRING13, STRING01, STRING08, STRING07, STRING09
        };
        String[] expectedsDepth = {
            STRING01, STRING02, STRING03, STRING05, STRING06, STRING07,
            STRING08, STRING09, STRING10, STRING11, STRING13
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #03
     *                   "06"                                                "06"
     *               /          \                                        /          \
     *           "03"            "11"                                "03"            "13"
     *          /    \          /    \           removing           /    \          /    \
     *      "02"      "05"  "10"     "14"           =>          "02"      "05"  "10"      "14"
     *     /               /        /            "11"         /                /
     * "01"            "08"     "13"                     "01"              "08"
     *                /    \                                             /     \
     *            "07"      "09"                                     "07"       "09"
     */
    @Test
    public void testSequenceVlozOdeber06AsTree03() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree03();
        assertEquals(STRING11, table.odeber(STRING11));
        String[] expectedsWide = {
            STRING06, STRING03, STRING13, STRING02, STRING05, STRING10,
            STRING14, STRING01, STRING08, STRING07, STRING09
        };
        String[] expectedsDepth = {
            STRING01, STRING02, STRING03, STRING05, STRING06, STRING07,
            STRING08, STRING09, STRING10, STRING13, STRING14
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #03
     *                   "06"                                                "07"
     *               /          \                                        /          \
     *           "03"            "11"                                "03"            "11"
     *          /    \          /    \           removing           /    \          /    \
     *      "02"      "05"  "10"     "14"           =>          "02"      "05"  "10"      "14"
     *     /               /        /            "06"         /                /         /
     * "01"            "08"     "13"                     "01"              "08"      "13"
     *                /    \                                                   \
     *            "07"      "09"                                                "09"
     */
    @Test
    public void testSequenceVlozOdeber07AsTree03() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree03();
        assertEquals(STRING06, table.odeber(STRING06));
        String[] expectedsWide = {
            STRING07, STRING03, STRING11, STRING02, STRING05, STRING10,
            STRING14, STRING01, STRING08, STRING13, STRING09
        };
        String[] expectedsDepth = {
            STRING01, STRING02, STRING03, STRING05, STRING07, STRING08,
            STRING09, STRING10, STRING11, STRING13, STRING14
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #04
     *                              "10"
     *                       /                \
     *                "05"                        "11"
     *            /          \                         \
     *        "03"            "07"                      "15"
     *       /    \          /    \                    /    \
     *   "01"      "04"  "06"      "09"            "14"      "17"
     *       \                    /               /         /    \
     *        "02"            "08"            "13"      "16"      "18"
     *                                       /
     *                                   "12"
     */
    @Test
    public void testSequenceVlozAsTreeType04() {
        printTestMethodName(methodName());
        createTree04();
        String[] expectedsWide = {
            STRING10, STRING05, STRING11, STRING03, STRING07, STRING15,
            STRING01, STRING04, STRING06, STRING09, STRING14, STRING17,
            STRING02, STRING08, STRING13, STRING16, STRING18, STRING12
        };
        String[] expectedsDepth = {
            STRING01, STRING02, STRING03, STRING04, STRING05, STRING06,
            STRING07, STRING08, STRING09, STRING10, STRING11, STRING12,
            STRING13, STRING14, STRING15, STRING16, STRING17, STRING18
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #04
     *                              "10"
     *                       /                \
     *                "05"                        "11"
     *            /          \                         \
     *        "03"            "07"                      "15"
     *       /    \          /    \                    /    \
     *   "01"      "04"  "06"      "09"            "14"      "17"
     *       \                    /               /         /    \
     *        "02"            "08"            "13"      "16"      "18"
     *                                       /
     *                                   "12"
     * 
     *                      removing ‖ "12"
     *                               ˅
     * 
     *                              "10"
     *                       /                \
     *                "05"                        "11"
     *            /          \                         \
     *        "03"            "07"                      "15"
     *       /    \          /    \                    /    \
     *   "01"      "04"  "06"      "09"            "14"      "17"
     *       \                    /               /         /    \
     *        "02"            "08"            "13"      "16"      "18"
     */
    @Test
    public void testSequenceVlozOdeber01AsTreeType04() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree04();
        assertEquals(STRING12, table.odeber(STRING12));
        String[] expectedsWide = {
            STRING10, STRING05, STRING11, STRING03, STRING07, STRING15,
            STRING01, STRING04, STRING06, STRING09, STRING14, STRING17,
            STRING02, STRING08, STRING13, STRING16, STRING18
        };
        String[] expectedsDepth = {
            STRING01, STRING02, STRING03, STRING04, STRING05, STRING06,
            STRING07, STRING08, STRING09, STRING10, STRING11, STRING13,
            STRING14, STRING15, STRING16, STRING17, STRING18
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #04
     *                              "10"
     *                       /                \
     *                "05"                        "11"
     *            /          \                         \
     *        "03"            "07"                      "15"
     *       /    \          /    \                    /    \
     *   "01"      "04"  "06"      "09"            "14"      "17"
     *       \                    /               /         /    \
     *        "02"            "08"            "13"      "16"      "18"
     *                                       /
     *                                   "12"
     * 
     *                      removing ‖ "13"
     *                               ˅
     * 
     *                              "10"
     *                       /                \
     *                "05"                        "11"
     *            /          \                         \
     *        "03"            "07"                      "15"
     *       /    \          /    \                    /    \
     *   "01"      "04"  "06"      "09"            "14"      "17"
     *       \                    /               /         /    \
     *        "02"            "08"            "12"      "16"      "18"
     */
    @Test
    public void testSequenceVlozOdeber02AsTreeType04() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree04();
        assertEquals(STRING13, table.odeber(STRING13));
        String[] expectedsWide = {
            STRING10, STRING05, STRING11, STRING03, STRING07, STRING15,
            STRING01, STRING04, STRING06, STRING09, STRING14, STRING17,
            STRING02, STRING08, STRING12, STRING16, STRING18
        };
        String[] expectedsDepth = {
            STRING01, STRING02, STRING03, STRING04, STRING05, STRING06,
            STRING07, STRING08, STRING09, STRING10, STRING11, STRING12,
            STRING14, STRING15, STRING16, STRING17, STRING18
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #04
     *                              "10"
     *                       /                \
     *                "05"                        "11"
     *            /          \                         \
     *        "03"            "07"                      "15"
     *       /    \          /    \                    /    \
     *   "01"      "04"  "06"      "09"            "14"      "17"
     *       \                    /               /         /    \
     *        "02"            "08"            "13"      "16"      "18"
     *                                       /
     *                                   "12"
     * 
     *                      removing ‖ "16"
     *                               ˅
     * 
     *                              "10"
     *                       /                \
     *                "05"                        "11"
     *            /          \                         \
     *        "03"            "07"                      "15"
     *       /    \          /    \                    /    \
     *   "01"      "04"  "06"      "09"            "14"      "17"
     *       \                    /               /              \
     *        "02"            "08"            "13"                "18"
     *                                       /
     *                                   "12"
     */
    @Test
    public void testSequenceVlozOdeber03AsTreeType04() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree04();
        assertEquals(STRING16, table.odeber(STRING16));
        String[] expectedsWide = {
            STRING10, STRING05, STRING11, STRING03, STRING07, STRING15,
            STRING01, STRING04, STRING06, STRING09, STRING14, STRING17,
            STRING02, STRING08, STRING13, STRING18, STRING12
        };
        String[] expectedsDepth = {
            STRING01, STRING02, STRING03, STRING04, STRING05, STRING06,
            STRING07, STRING08, STRING09, STRING10, STRING11, STRING12,
            STRING13, STRING14, STRING15, STRING17, STRING18
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #04
     *                              "10"
     *                       /                \
     *                "05"                        "11"
     *            /          \                         \
     *        "03"            "07"                      "15"
     *       /    \          /    \                    /    \
     *   "01"      "04"  "06"      "09"            "14"      "17"
     *       \                    /               /         /    \
     *        "02"            "08"            "13"      "16"      "18"
     *                                       /
     *                                   "12"
     * 
     *                      removing ‖ "18"
     *                               ˅
     * 
     *                              "10"
     *                       /                \
     *                "05"                        "11"
     *            /          \                         \
     *        "03"            "07"                      "15"
     *       /    \          /    \                    /    \
     *   "01"      "04"  "06"      "09"            "14"      "17"
     *       \                    /               /         /
     *        "02"            "08"            "13"      "16"
     *                                       /
     *                                   "12"
     */
    @Test
    public void testSequenceVlozOdeber04AsTreeType04() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree04();
        assertEquals(STRING18, table.odeber(STRING18));
        String[] expectedsWide = {
            STRING10, STRING05, STRING11, STRING03, STRING07, STRING15,
            STRING01, STRING04, STRING06, STRING09, STRING14, STRING17,
            STRING02, STRING08, STRING13, STRING16, STRING12
        };
        String[] expectedsDepth = {
            STRING01, STRING02, STRING03, STRING04, STRING05, STRING06,
            STRING07, STRING08, STRING09, STRING10, STRING11, STRING12,
            STRING13, STRING14, STRING15, STRING16, STRING17
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #04
     *                              "10"
     *                       /                \
     *                "05"                        "11"
     *            /          \                         \
     *        "03"            "07"                      "15"
     *       /    \          /    \                    /    \
     *   "01"      "04"  "06"      "09"            "14"      "17"
     *       \                    /               /         /    \
     *        "02"            "08"            "13"      "16"      "18"
     *                                       /
     *                                   "12"
     * 
     *                      removing ‖ "17"
     *                               ˅
     * 
     *                              "10"
     *                       /                \
     *                "05"                        "11"
     *            /          \                         \
     *        "03"            "07"                      "15"
     *       /    \          /    \                    /    \
     *   "01"      "04"  "06"      "09"            "14"      "18"
     *       \                    /               /         /
     *        "02"            "08"            "13"      "16"
     *                                       /
     *                                   "12"
     */
    @Test
    public void testSequenceVlozOdeber05AsTreeType04() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree04();
        assertEquals(STRING17, table.odeber(STRING17));
        String[] expectedsWide = {
            STRING10, STRING05, STRING11, STRING03, STRING07, STRING15,
            STRING01, STRING04, STRING06, STRING09, STRING14, STRING18,
            STRING02, STRING08, STRING13, STRING16, STRING12
        };
        String[] expectedsDepth = {
            STRING01, STRING02, STRING03, STRING04, STRING05, STRING06,
            STRING07, STRING08, STRING09, STRING10, STRING11, STRING12,
            STRING13, STRING14, STRING15, STRING16, STRING18
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #04
     *                              "10"
     *                       /                \
     *                "05"                        "11"
     *            /          \                         \
     *        "03"            "07"                      "15"
     *       /    \          /    \                    /    \
     *   "01"      "04"  "06"      "09"            "14"      "17"
     *       \                    /               /         /    \
     *        "02"            "08"            "13"      "16"      "18"
     *                                       /
     *                                   "12"
     * 
     *                      removing ‖ "15"
     *                               ˅
     * 
     *                              "10"
     *                       /                \
     *                "05"                        "11"
     *            /          \                         \
     *        "03"            "07"                      "16"
     *       /    \          /    \                    /    \
     *   "01"      "04"  "06"      "09"            "14"      "17"
     *       \                    /               /              \
     *        "02"            "08"            "13"                "18"
     *                                       /
     *                                   "12"
     */
    @Test
    public void testSequenceVlozOdeber06AsTreeType04() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree04();
        assertEquals(STRING15, table.odeber(STRING15));
        String[] expectedsWide = {
            STRING10, STRING05, STRING11, STRING03, STRING07, STRING16,
            STRING01, STRING04, STRING06, STRING09, STRING14, STRING17,
            STRING02, STRING08, STRING13, STRING18, STRING12
        };
        String[] expectedsDepth = {
            STRING01, STRING02, STRING03, STRING04, STRING05, STRING06,
            STRING07, STRING08, STRING09, STRING10, STRING11, STRING12,
            STRING13, STRING14, STRING16, STRING17, STRING18
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #04
     *                                "10"
     *                       /                  \
     *                "05"                          "11"
     *            /          \                           \
     *        "03"            "07"                        "15"
     *       /    \          /    \                      /    \
     *   "01"      "04"  "06"      "09"              "14"      "17"
     *       \                    /                 /         /    \
     *        "02"            "08"              "13"      "16"      "18"
     *                                         /
     *                                     "12"
     * 
     *                        removing ‖ "11"
     *                                 ˅
     * 
     *                                "10"
     *                       /                  \
     *                "05"                          "15"
     *            /          \                     /    \
     *        "03"            "07"             "14"      "17"
     *       /    \          /    \           /         /    \
     *   "01"      "04"  "06"      "09"   "13"      "16"      "18"
     *       \                    /      /
     *        "02"            "08"   "12"
     */
    @Test
    public void testSequenceVlozOdeber07AsTreeType04() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree04();
        String res = table.odeber(STRING11);
        assertEquals(STRING11, res);
        String[] expectedsWide = {
            STRING10, STRING05, STRING15, STRING03, STRING07, STRING14,
            STRING17, STRING01, STRING04, STRING06, STRING09, STRING13,
            STRING16, STRING18, STRING02, STRING08, STRING12
        };
        String[] expectedsDepth = {
            STRING01, STRING02, STRING03, STRING04, STRING05, STRING06,
            STRING07, STRING08, STRING09, STRING10, STRING12, STRING13,
            STRING14, STRING15, STRING16, STRING17, STRING18
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #04
     *                                "10"
     *                       /                  \
     *                "05"                          "11"
     *            /          \                           \
     *        "03"            "07"                        "15"
     *       /    \          /    \                      /    \
     *   "01"      "04"  "06"      "09"              "14"      "17"
     *       \                    /                 /         /    \
     *        "02"            "08"              "13"      "16"      "18"
     *                                         /
     *                                     "12"
     * 
     *                        removing ‖ "09"
     *                                 ˅
     * 
     *                                "10"
     *                       /                  \
     *                "05"                          "11"
     *            /          \                          \
     *        "03"            "07"                       "15"
     *       /    \          /    \                     /    \
     *   "01"      "04"  "06"      "08"             "14"      "17"
     *       \                                     /         /    \
     *        "02"                             "13"      "16"      "18"
     *                                        /
     *                                    "12"
     */
    @Test
    public void testSequenceVlozOdeber08AsTreeType04() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree04();
        assertEquals(STRING09, table.odeber(STRING09));
        String[] expectedsWide = {
            STRING10, STRING05, STRING11, STRING03, STRING07, STRING15,
            STRING01, STRING04, STRING06, STRING08, STRING14, STRING17,
            STRING02, STRING13, STRING16, STRING18, STRING12
        };
        String[] expectedsDepth = {
            STRING01, STRING02, STRING03, STRING04, STRING05, STRING06,
            STRING07, STRING08, STRING10, STRING11, STRING12, STRING13,
            STRING14, STRING15, STRING16, STRING17, STRING18
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #04
     *                                "10"
     *                       /                  \
     *                "05"                          "11"
     *            /          \                           \
     *        "03"            "07"                        "15"
     *       /    \          /    \                      /    \
     *   "01"      "04"  "06"      "09"              "14"      "17"
     *       \                    /                 /         /    \
     *        "02"            "08"              "13"      "16"      "18"
     *                                         /
     *                                     "12"
     * 
     *                        removing ‖ "07"
     *                                 ˅
     * 
     *                                "10"
     *                       /                  \
     *                "05"                          "11"
     *            /          \                          \
     *        "03"            "08"                       "15"
     *       /    \          /    \                     /    \
     *   "01"      "04"  "06"      "09"             "14"      "17"
     *       \                                     /         /    \
     *        "02"                             "13"      "16"      "18"
     *                                        /
     *                                    "12"
     */
    @Test
    public void testSequenceVlozOdeber09AsTreeType04() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree04();
        assertEquals(STRING07, table.odeber(STRING07));
        String[] expectedsWide = {
            STRING10, STRING05, STRING11, STRING03, STRING08, STRING15,
            STRING01, STRING04, STRING06, STRING09, STRING14, STRING17,
            STRING02, STRING13, STRING16, STRING18, STRING12
        };
        String[] expectedsDepth = {
            STRING01, STRING02, STRING03, STRING04, STRING05, STRING06,
            STRING08, STRING09, STRING10, STRING11, STRING12, STRING13,
            STRING14, STRING15, STRING16, STRING17, STRING18
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #04
     *                                "10"
     *                       /                  \
     *                "05"                          "11"
     *            /          \                           \
     *        "03"            "07"                        "15"
     *       /    \          /    \                      /    \
     *   "01"      "04"  "06"      "09"              "14"      "17"
     *       \                    /                 /         /    \
     *        "02"            "08"              "13"      "16"      "18"
     *                                         /
     *                                     "12"
     * 
     *                        removing ‖ "01"
     *                                 ˅
     * 
     *                                "10"
     *                       /                  \
     *                "05"                          "11"
     *            /          \                          \
     *        "03"            "07"                       "15"
     *       /    \          /    \                     /    \
     *   "02"      "04"  "06"      "09"             "14"      "17"
     *                            /                /         /    \
     *                        "08"             "13"      "16"      "18"
     *                                        /
     *                                    "12"
     */
    @Test
    public void testSequenceVlozOdeber10AsTreeType04() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree04();
        assertEquals(STRING01, table.odeber(STRING01));
        String[] expectedsWide = {
            STRING10, STRING05, STRING11, STRING03, STRING07, STRING15,
            STRING02, STRING04, STRING06, STRING09, STRING14, STRING17,
            STRING08, STRING13, STRING16, STRING18, STRING12
        };
        String[] expectedsDepth = {
            STRING02, STRING03, STRING04, STRING05, STRING06, STRING07,
            STRING08, STRING09, STRING10, STRING11, STRING12, STRING13,
            STRING14, STRING15, STRING16, STRING17, STRING18
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #04
     *                                "10"
     *                       /                  \
     *                "05"                          "11"
     *            /          \                           \
     *        "03"            "07"                        "15"
     *       /    \          /    \                      /    \
     *   "01"      "04"  "06"      "09"              "14"      "17"
     *       \                    /                 /         /    \
     *        "02"            "08"              "13"      "16"      "18"
     *                                         /
     *                                     "12"
     * 
     *                        removing ‖ "03"
     *                                 ˅
     * 
     *                                "10"
     *                       /                  \
     *                "05"                          "11"
     *            /          \                          \
     *        "04"            "07"                       "15"
     *       /               /    \                     /    \
     *   "01"            "06"      "09"             "14"      "17"
     *       \                    /                /         /    \
     *        "02"            "08"            "13"       "16"      "18"
     *                                       /
     *                                   "12"
     */
    @Test
    public void testSequenceVlozOdeber11AsTreeType04() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree04();
        assertEquals(STRING03, table.odeber(STRING03));
        String[] expectedsWide = {
            STRING10, STRING05, STRING11, STRING04, STRING07, STRING15,
            STRING01, STRING06, STRING09, STRING14, STRING17, STRING02,
            STRING08, STRING13, STRING16, STRING18, STRING12
        };
        String[] expectedsDepth = {
            STRING01, STRING02, STRING04, STRING05, STRING06, STRING07,
            STRING08, STRING09, STRING10, STRING11, STRING12, STRING13,
            STRING14, STRING15, STRING16, STRING17, STRING18
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #04
     *                                "10"
     *                       /                  \
     *                "05"                          "11"
     *            /          \                           \
     *        "03"            "07"                        "15"
     *       /    \          /    \                      /    \
     *   "01"      "04"  "06"      "09"              "14"      "17"
     *       \                    /                 /         /    \
     *        "02"            "08"              "13"      "16"      "18"
     *                                         /
     *                                     "12"
     * 
     *                        removing ‖ "05"
     *                                 ˅
     * 
     *                                "10"
     *                       /                  \
     *                "06"                          "11"
     *            /          \                          \
     *        "03"            "07"                       "15"
     *       /    \               \                     /    \
     *   "01"      "04"            "09"             "14"      "17"
     *       \                    /                /         /    \
     *        "02"            "08"             "13"      "16"      "18"
     *                                        /
     *                                    "12"
     */
    @Test
    public void testSequenceVlozOdeber12AsTreeType04() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree04();
        assertEquals(STRING05, table.odeber(STRING05));
        String[] expectedsWide = {
            STRING10, STRING06, STRING11, STRING03, STRING07, STRING15,
            STRING01, STRING04, STRING09, STRING14, STRING17, STRING02,
            STRING08, STRING13, STRING16, STRING18, STRING12
        };
        String[] expectedsDepth = {
            STRING01, STRING02, STRING03, STRING04, STRING06, STRING07,
            STRING08, STRING09, STRING10, STRING11, STRING12, STRING13,
            STRING14, STRING15, STRING16, STRING17, STRING18
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    /** Tree #04
     *                                "10"
     *                       /                  \
     *                "05"                          "11"
     *            /          \                           \
     *        "03"            "07"                        "15"
     *       /    \          /    \                      /    \
     *   "01"      "04"  "06"      "09"              "14"      "17"
     *       \                    /                 /         /    \
     *        "02"            "08"              "13"      "16"      "18"
     *                                         /
     *                                     "12"
     * 
     *                        removing ‖ "10"
     *                                 ˅
     * 
     *                                "11"
     *                       /                  \
     *                "05"                          "15"
     *            /          \                     /    \
     *        "03"            "07"             "14"      "17"
     *       /    \          /    \           /         /    \
     *   "01"      "04"  "06"      "09"   "13"      "16"      "18"
     *       \                    /      /  
     *        "02"            "08"   "12"
     */
    @Test
    public void testSequenceVlozOdeber13AsTreeType04() throws IllegalAccessException {
        printTestMethodName(methodName());
        createTree04();
        assertEquals(STRING10, table.odeber(STRING10));
        String[] expectedsWide = {
            STRING11, STRING05, STRING15, STRING03, STRING07, STRING14,
            STRING17, STRING01, STRING04, STRING06, STRING09, STRING13,
            STRING16, STRING18, STRING02, STRING08, STRING12
        };
        String[] expectedsDepth = {
            STRING01, STRING02, STRING03, STRING04, STRING05, STRING06,
            STRING07, STRING08, STRING09, STRING11, STRING12, STRING13,
            STRING14, STRING15, STRING16, STRING17, STRING18
        };
        checkDataByIterator(expectedsWide, expectedsDepth);
    }
    
    //================== Metody pro vytváření stromů ===========================
    
    /** Tree as LinkedList #1
     *  "02"
     *      \
     *       "05"
     *           \
     *            "07"
     *               \
     *                "08"
     *                    \
     *                     "11"
     *                         \
     *                          "14"
     *                              \
     *                               "16"
     */
    private void createTreeAsLinkedList01() {
        table.vloz(STRING02, STRING02);
        table.vloz(STRING05, STRING05);
        table.vloz(STRING07, STRING07);
        table.vloz(STRING08, STRING08);
        table.vloz(STRING11, STRING11);
        table.vloz(STRING14, STRING14);
        table.vloz(STRING16, STRING16);
    }

    /** Tree as LinkedList #2
     *                                   "17"
     *                                  /
     *                              "15"
     *                             /
     *                          "14"
     *                         /
     *                      "13"
     *                     /
     *                 "09"
     *                /
     *            "08"
     *           /
     *       "06"
     *      /
     *  "01"
     */
    private void createTreeAsLinkedList02() {
        table.vloz(STRING17, STRING17);
        table.vloz(STRING15, STRING15);
        table.vloz(STRING14, STRING14);
        table.vloz(STRING13, STRING13);
        table.vloz(STRING09, STRING09);
        table.vloz(STRING08, STRING08);
        table.vloz(STRING06, STRING06);
        table.vloz(STRING01, STRING01);
    }

    /** Tree #01
     *                  "07"
     *              /          \
     *          "05"            "10"
     *         /    \          /    \
     *     "04"      "06"  "09"      "13"
     *                              /
     *                          "11"
     *                              \
     *                               "12"
     */
    private void createTree01() {
        table.vloz(STRING07, STRING07);
        table.vloz(STRING10, STRING10);
        table.vloz(STRING13, STRING13);
        table.vloz(STRING11, STRING11);
        table.vloz(STRING12, STRING12);
        table.vloz(STRING09, STRING09);
        table.vloz(STRING05, STRING05);
        table.vloz(STRING04, STRING04);
        table.vloz(STRING06, STRING06);
    }

    /** Tree #02
     *                  "04"
     *                 /    \
     *             "03"      "08"
     *            /         /    \
     *        "02"      "07"      "12"
     *                           /
     *                       "10"
     */
    private void createTree02() {
        table.vloz(STRING04, STRING04);
        table.vloz(STRING03, STRING03);
        table.vloz(STRING02, STRING02);
        table.vloz(STRING08, STRING08);
        table.vloz(STRING12, STRING12);
        table.vloz(STRING10, STRING10);
        table.vloz(STRING07, STRING07);
    }

    /** Tree #03
     *                   "06"
     *               /          \
     *           "03"            "11"
     *          /    \          /    \
     *      "02"      "05"  "10"     "14"
     *     /               /        /
     * "01"            "08"     "13"
     *                /    \
     *            "07"      "09"
     */
    private void createTree03() {
        table.vloz(STRING06, STRING06);
        table.vloz(STRING11, STRING11);
        table.vloz(STRING14, STRING14);
        table.vloz(STRING10, STRING10);
        table.vloz(STRING03, STRING03);
        table.vloz(STRING05, STRING05);
        table.vloz(STRING02, STRING02);
        table.vloz(STRING13, STRING13);
        table.vloz(STRING01, STRING01);
        table.vloz(STRING08, STRING08);
        table.vloz(STRING07, STRING07);
        table.vloz(STRING09, STRING09);
    }

    /** Tree #04
     *                              "10"
     *                       /                \
     *                "05"                        "11"
     *            /          \                         \
     *        "03"            "07"                      "15"
     *       /    \          /    \                    /    \
     *   "01"      "04"  "06"      "09"            "14"      "17"
     *       \                    /               /         /    \
     *        "02"            "08"            "13"      "16"      "18"
     *                                       /
     *                                   "12"
     */
    private void createTree04() {
        table.vloz(STRING10, STRING10);
        table.vloz(STRING05, STRING05);
        table.vloz(STRING11, STRING11);
        table.vloz(STRING03, STRING03);
        table.vloz(STRING07, STRING07);
        table.vloz(STRING15, STRING15);
        table.vloz(STRING01, STRING01);
        table.vloz(STRING04, STRING04);
        table.vloz(STRING06, STRING06);
        table.vloz(STRING09, STRING09);
        table.vloz(STRING14, STRING14);
        table.vloz(STRING17, STRING17);
        table.vloz(STRING02, STRING02);
        table.vloz(STRING08, STRING08);
        table.vloz(STRING13, STRING13);
        table.vloz(STRING16, STRING16);
        table.vloz(STRING18, STRING18);
        table.vloz(STRING12, STRING12);
    }
    
    private void checkDataByIterator(String[] expectedsWide, String[] expectedsDepth) {
        assertEquals(
                arrayConvertToString(expectedsWide),
                iteratorConvertToString(
                        table.vytvorIterator(
                                TypProhlidky.LEVEL_ORDER
                        )
                )
        );
        assertEquals(
                arrayConvertToString(expectedsDepth),
                iteratorConvertToString(
                        table.vytvorIterator(
                                TypProhlidky.IN_ORDER
                        )
                )
        );
        assertEquals(expectedsWide.length, table.mohutnost());
    }
    
    private String iteratorConvertToString(Iterator<String> iterator) {
        StringBuilder stringBuilder = new StringBuilder();
        while(iterator.hasNext()) {
            stringBuilder.append(iterator.next());
        }
        return stringBuilder.toString();
    }
    
    private String arrayConvertToString(String[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String array1 : array) {
            stringBuilder.append(array1);
        }
        return stringBuilder.toString();
    }
    
    private void printDataByIterator(TypProhlidky traversalType) {
        System.out.println("");
        System.out.println("Prohlídka: " + traversalType);
        Iterator<String> iterator = table.vytvorIterator(traversalType);
        StringBuilder stringBuilder = new StringBuilder();
        while(iterator.hasNext()) {
            stringBuilder.append(iterator.next()).append(" ");
        }
        System.out.println(stringBuilder.toString());
    }
    
}

//created by TreeBuild software 0.9.9 beta © from Michael Vodák
//modified by Tomáš Marný
//P.S.: The mention software was not stolen from this due.