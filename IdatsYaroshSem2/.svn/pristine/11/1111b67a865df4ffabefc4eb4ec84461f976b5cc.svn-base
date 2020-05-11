package table;

import collection.KolekceException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import queueNstack.AbstrFIFO;

/**
 * <h2>!!!!!Upozorneni!!!!!</h2>
 * <p>Implementaci datove struktury provedte pomoci necyklickeho zretezeneho
 * seznamu ze semestralni prace A. Taktez provedte volani prislusnych metod,
 * abyste nemuseli znovu implementovat iterator zamomoci metod zacinaji
 * slovem "zpristupni".</p>
 * @author Tomas Marny
 */
/**
 * <p>Dekuji za precteni upozorneni.</p>
 * <h2>!!!!!Upozorneni!!!!!</h2>
 * <p>Tento test obsahuje komentare typu <b>TODO</b>, proto nejdrive
 * provedte tyto instrukce, ktere zobrazite kliknutim na polozku menu
 * IDE Netbeans <b>Window</b> > <b>Action Items</b>. V tomto pripade se jedna
 * o provedeni implementace metody {@link Iterator#remove() }.</p>
 * @author Tomas Marny
 */
/**
 * <p>Dekuji za precteni upozorneni.</p>
 * <h2>!!!!!Upozorneni!!!!!</h2>
 * <p>Tento test neni oficialni od pane inzenyra Simerdy, protoze nemusi klast
 * duraz na poradi vystavenych vyjimek podle zmineneho cviciciho. Berte ho
 * jako inspiraci k vytvoreni vlastniho testu.</p>
 * <p>Dekuji za precteni upozorneni.</p>
 * @author Tomas Marny
 */
public class AbstrFifoStreamUnsupportedTest {
    
    private static int counter = 1;
    
    private String methodName() {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[2];
        return e.getMethodName();
    }
    
    private void printTestMethodName(String testMethodName) {
        System.out.println("test" + (counter < 10 ? "000" : (counter < 100 ? "00" : counter < 1000 ? "0" : "")) + counter++ + "_" + testMethodName);
    }
    
    public AbstrFifoStreamUnsupportedTest() {
    }
    
    private final TestClass<Integer> T1 = new TestClass(1);
    private final TestClass<Integer> T2 = new TestClass(2);
    private final TestClass<Integer> T3 = new TestClass(3);
    private final TestClass<Integer> T4 = new TestClass(4);
    private final TestClass<Integer> T5 = new TestClass(5);
    private final TestClass<Integer> T6 = new TestClass(6);
    private final TestClass<Integer> T7 = new TestClass(7);
    private final TestClass<Integer> T8 = new TestClass(8);
    private final TestClass<Integer> T_NULL = null;
    private static AbstrFIFO<TestClass> queue;
    
    @BeforeClass
    public static void setUpClass() {
        queue = new AbstrFIFO();
    }
    
    @AfterClass
    public static void tearDownClass() {
        queue = null;
    }
    
    @Before
    public void setUp() {
        queue = new AbstrFIFO();
    }
    
    @After
    public void tearDown() {
        queue = null;
    }

    //================== Testy jednotlivých metod ==============================
    
    @Test
    public void testUnitJePrazdny() {
        printTestMethodName(methodName());
        assertTrue(queue.jePrazdny());
    }
    
    @Test
    public void testUnitNeniPrazdny() {
        printTestMethodName(methodName());
        queue.vloz(T1);
        assertFalse(queue.jePrazdny());
    }
    
    @Test(expected = NullPointerException.class)
    public void testUnitVloz01() {
        printTestMethodName(methodName());
        queue.vloz(T_NULL);
        fail();
    }
    
    @Test
    public void testUnitVloz02() {
        printTestMethodName(methodName());
        queue.vloz(T1);
    }
    
    @Test(expected = KolekceException.class)
    public void testUnitOdeber01() throws KolekceException {
        printTestMethodName(methodName());
        queue.odeber();
        fail();
    }
    
    @Test
    public void testUnitOdeber02() throws KolekceException {
        printTestMethodName(methodName());
        queue.vloz(T1);
        TestClass result = queue.odeber();
        assertEquals(T1, result);
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testUnitIterator01() {
        printTestMethodName(methodName());
        Iterator<TestClass> iterator = queue.iterator();
        iterator.next();
        fail();
    }
    
    @Test
    public void testUnitIterator02() {
        printTestMethodName(methodName());
        queue.vloz(T1);
        TestClass[] results = {T1};
        checkDataByIterator(results);
    }
    
    @Test
    public void testUnitIterator03() {
        printTestMethodName(methodName());
        queue.vloz(T1);
        queue.vloz(T8);
        queue.vloz(T5);
        TestClass[] results = {T1, T8, T5};
        checkDataByIterator(results);
    }
    
    /* TODO zakomentuj nasledujici tri testovaci pripady, pokud iterator
    * tve datove struktury nema implementovanou metodu "remove()"
    */
    
//    @Test(expected = IllegalStateException.class)
//    public void testUnitIteratorRemove01() {
//        printTestMethodName(methodName());
//        Iterator<TestClass> iterator = queue.iterator();
//        iterator.remove();
//        fail();
//    }
//    
//    @Test(expected = IllegalStateException.class)
//    public void testUnitIteratorRemove02() {
//        printTestMethodName(methodName());
//        queue.vloz(T1);
//        Iterator<TestClass> iterator = queue.iterator();
//        iterator.next();
//        iterator.remove();
//        iterator.remove();
//        fail();
//    }
//    
//    @Test
//    public void testUnitIteratorRemove03() {
//        printTestMethodName(methodName());
//        queue.vloz(T1);
//        Iterator<TestClass> iterator = queue.iterator();
//        iterator.next();
//        iterator.remove();
//    }
    
    /* TODO odkomentuj nasledujici testovaci pripad, pokud iterator
    * tve datove struktury nema implementovanou metodu "remove()"
    */
//    @Test(expected = UnsupportedOperationException.class)
//    public void testUnitIteratorRemoveUnsupported() {
//        printTestMethodName(methodName());
//        Iterator<TestClass> iterator = queue.iterator();
//        iterator.remove();
//        fail();
//    }
    
    @Test
    public void testUnitZrus() {
        printTestMethodName(methodName());
        queue.vloz(T1);
        queue.zrus();
    }
    
    //================== Testy sequencí ========================================
    
    @Test
    public void testSequenceVloz() {
        printTestMethodName(methodName());
        queue.vloz(T5);
        queue.vloz(T3);
        queue.vloz(T8);
        queue.vloz(T6);
        TestClass[] results = {T5, T3, T8, T6};
        checkDataByIterator(results);
    }
    
    @Test
    public void testSequenceOdeber01() throws KolekceException {
        printTestMethodName(methodName());
        queue.vloz(T8);
        queue.vloz(T4);
        queue.vloz(T7);
        queue.odeber();
        queue.vloz(T5);
        TestClass[] results = {T4, T7, T5};
        checkDataByIterator(results);
    }
    
    @Test
    public void testSequenceOdeber02() throws KolekceException {
        printTestMethodName(methodName());
        queue.vloz(T3);
        queue.vloz(T8);
        queue.odeber();
        queue.vloz(T1);
        queue.vloz(T4);
        queue.vloz(T6);
        queue.odeber();
        queue.odeber();
        queue.vloz(T5);
        queue.vloz(T2);
        TestClass[] results = {T4, T6, T5, T2};
        checkDataByIterator(results);
    }
    
    @Test
    public void testSequenceIteratorRemove() {
        printTestMethodName(methodName());
        queue.vloz(T2);
        queue.vloz(T8);
        queue.vloz(T5);
        queue.vloz(T7);
        Iterator<TestClass> iterator = queue.iterator();
        iterator.next();
        iterator.next();
        iterator.remove();
        TestClass[] results = {T2, T5, T7};
        checkDataByIterator(results);
    }
    
    private void checkDataByIterator(TestClass[] results) {
        int i = 0;
        Iterator<TestClass> iterator = queue.iterator();
        while(iterator.hasNext()) {
            assertEquals(results[i++], iterator.next());
        }
    }
    
}