package org.example.jooqh2bitand;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JdbcTest
@ContextConfiguration(classes = {JooqConfig.class, JooqTestEntityRepository.class})
@Transactional
class JooqTestEntityRepositoryTest {

    @Autowired
    private JooqTestEntityRepository repository;

    @Test
    @Sql("/testdata.sql")
    void testTrueMask() {

        byte[] mask = new byte[]{(byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff};

        TestEntityWithBitMask testObject = repository.findOne(1, mask);

        assertEquals(1, testObject.getId());
        assertEquals((byte) 0x01, testObject.getData()[1]);
        assertEquals((byte) 0x01, testObject.getMaskedData()[1]);
    }

    @Test
    @Sql("/testdata.sql")
    void testFalseMask() {

        byte[] mask = new byte[]{(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00};

        TestEntityWithBitMask testObject = repository.findOne(1, mask);

        assertEquals(1, testObject.getId());
        assertEquals((byte) 0x01, testObject.getData()[1]);
        assertEquals((byte) 0x00, testObject.getMaskedData()[1]);
    }

    @Test
    @Sql("/testdata.sql")
    void testTrueMaskBiggerData() {

        byte[] mask = new byte[]{(byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff};

        TestEntityWithBitMask testObject = repository.findOne(2, mask);

        assertEquals(2, testObject.getId());
        assertEquals((byte) 0x01, testObject.getData()[1]);
        assertEquals((byte) 0x01, testObject.getMaskedData()[1]);
    }

    @Test
    @Sql("/testdata.sql")
    void testFalseMaskBiggerData() {

        byte[] mask = new byte[]{(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00};

        TestEntityWithBitMask testObject = repository.findOne(2, mask);

        assertEquals(2, testObject.getId());
        assertEquals((byte) 0x01, testObject.getData()[1]);
        assertEquals((byte) 0x00, testObject.getMaskedData()[1]);
    }
}
