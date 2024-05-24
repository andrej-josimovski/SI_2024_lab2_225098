import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void everyBranchMethod() {

        //test case - allItems Null
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class,
                () -> SILab2.checkCart(null, 100));
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));

        //test case - empty item list
        List<Item> allItems = new ArrayList<>();
        assertTrue(SILab2.checkCart(allItems, 100));

        //test case - item name null
        allItems = new ArrayList<>();
        allItems.add(new Item(null, "123456", 100, 0));
        assertTrue(SILab2.checkCart(allItems, 100));

        //test case - item name empty
        allItems = new ArrayList<>();
        allItems.add(new Item("", "123456", 100, 0));
        assertTrue(SILab2.checkCart(allItems, 100));

        //test case - barcode null
        allItems = new ArrayList<>();
        allItems.add(new Item("item", null, 100, 0));
        List<Item> finalAllItems = allItems;
        ex = assertThrows(RuntimeException.class,
                () -> SILab2.checkCart(finalAllItems, 100));
        assertTrue(ex.getMessage().contains("No barcode!"));

        //test case - invalid barcode character
        allItems = new ArrayList<>();
        allItems.add(new Item("item", "12345A", 100, 0));
        List<Item> finalAllItems1 = allItems;
        ex = assertThrows(RuntimeException.class,
                () -> SILab2.checkCart(finalAllItems1, 100));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));

        //test case - item with discount
        allItems = new ArrayList<>();
        allItems.add(new Item("item", "123456", 100, 0.1f));
        assertTrue(SILab2.checkCart(allItems, 10));

        //test case - item without discount
        allItems = new ArrayList<>();
        allItems.add(new Item("item", "123456", 100, 0));
        assertTrue(SILab2.checkCart(allItems, 100));

        //test case - price>300 with discount and barcode starting with 0
        allItems = new ArrayList<>();
        allItems.add(new Item("item", "012345", 350, 0.1f));
        assertTrue(SILab2.checkCart(allItems, 300));

        //test case - sum less or equal to payment
        allItems = new ArrayList<>();
        allItems.add(new Item("item", "123456", 100, 0));
        assertTrue(SILab2.checkCart(allItems, 100));

        //test case - sum greater than payment
        allItems = new ArrayList<>();
        allItems.add(new Item("item", "123456", 150, 0));
        assertFalse(SILab2.checkCart(allItems, 100));
    }

    @Test
    void multipleConditionMethod() {

        //test case - T T T
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item("item", "123456", 350, 0.1f));
        assertTrue(SILab2.checkCart(allItems, 300));

        //test case - T T F
        allItems = new ArrayList<>();
        allItems.add(new Item("item", "112345", 350, 0.1f));
        assertTrue(SILab2.checkCart(allItems, 300));

        //test case - T F T
        allItems = new ArrayList<>();
        allItems.add(new Item("item", "012345", 350, 0));
        assertFalse(SILab2.checkCart(allItems, 300));

        //test case - F T T
        allItems = new ArrayList<>();
        allItems.add(new Item("item", "012345", 250, 0.1f));
        assertTrue(SILab2.checkCart(allItems, 300));

        //test case - T F F
        allItems = new ArrayList<>();
        allItems.add(new Item("item", "112345", 350, 0));
        assertFalse(SILab2.checkCart(allItems, 300));

        //test case - F T F
        allItems = new ArrayList<>();
        allItems.add(new Item("item", "112345", 250, 0.1f));
        assertTrue(SILab2.checkCart(allItems, 300));

        //test case - F F T
        allItems = new ArrayList<>();
        allItems.add(new Item("item", "012345", 250, 0));
        assertTrue(SILab2.checkCart(allItems, 300));

        //test case - F F F
        allItems=new ArrayList<>();
        allItems.add(new Item("item","112345",250,0));
        assertTrue(SILab2.checkCart(allItems,300));
    }
}

