package com.example.labjavaintrotojpa.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnumUtilsTest {

    private enum TestCustomerStatus {
        GOLD, SILVER, NONE
    }
    @Test
    void testIsValidEnumWithValidValue() {
        assertTrue(EnumUtils.isValidEnum(TestCustomerStatus.class, "GOLD"));
    }

    @Test
    void testIsValidEnumWithInvalidValue() {
        assertFalse(EnumUtils.isValidEnum(TestCustomerStatus.class, "PLATINUM"));
    }

    @Test
    void testIsValidEnumWithNullValue() {
        assertFalse(EnumUtils.isValidEnum(TestCustomerStatus.class, null));
    }

    @Test
    void testIsValidEnumWithEmptyValue() {
        assertFalse(EnumUtils.isValidEnum(TestCustomerStatus.class, ""));
    }
}