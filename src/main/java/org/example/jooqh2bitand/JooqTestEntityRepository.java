package org.example.jooqh2bitand;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static com.example.jooqh2bitand.Tables.TESTENTITY;

@Repository
@RequiredArgsConstructor
public class JooqTestEntityRepository {

    private final DSLContext dsl;

    @Transactional(readOnly = true)
    public TestEntityWithBitMask findOne(long id, byte[] bitMask) {
        return dsl.select(TESTENTITY.asterisk(),
                          TESTENTITY.DATA.bitAnd(bitMask).as("maskedData"))
                  .from(TESTENTITY)
                  .where(TESTENTITY.ID.eq(id))
                  .fetchOneInto(TestEntityWithBitMask.class);
    }
}
