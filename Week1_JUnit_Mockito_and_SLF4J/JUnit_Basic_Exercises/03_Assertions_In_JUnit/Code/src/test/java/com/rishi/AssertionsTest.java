package com.rishi;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

// Core verification module evaluating multiple validation criteria
public class AssertionsTest {

    @Test
    public void testInventoryAssertions() {
        InventoryItem activeProduct = new InventoryItem("Vadilal Icecream", 80.0, 45);
        InventoryItem missingProduct = null;

        assertEquals("Vadilal Icecream", activeProduct.getItemName());

        assertTrue(activeProduct.isAvailableInStock());

        assertFalse(activeProduct.getStockQuantity() < 0);

        assertNull(missingProduct);

        assertNotNull(activeProduct);
    }
}