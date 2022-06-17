/*
 * This file is generated by jOOQ.
 */
package com.example.jooqh2bitand;


import com.example.jooqh2bitand.tables.Testentity;
import com.example.jooqh2bitand.tables.records.TestentityRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in the
 * default schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<TestentityRecord> PK_TESTENTITY = Internal.createUniqueKey(Testentity.TESTENTITY, DSL.name("PK_TESTENTITY"), new TableField[] { Testentity.TESTENTITY.ID }, true);
}