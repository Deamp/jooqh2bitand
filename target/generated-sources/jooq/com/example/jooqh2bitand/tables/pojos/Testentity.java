/*
 * This file is generated by jOOQ.
 */
package com.example.jooqh2bitand.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Testentity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long   id;
    private byte[] data;

    public Testentity() {}

    public Testentity(Testentity value) {
        this.id = value.id;
        this.data = value.data;
    }

    public Testentity(
        Long   id,
        byte[] data
    ) {
        this.id = id;
        this.data = data;
    }

    /**
     * Getter for <code>TESTENTITY.ID</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>TESTENTITY.ID</code>.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for <code>TESTENTITY.DATA</code>.
     */
    public byte[] getData() {
        return this.data;
    }

    /**
     * Setter for <code>TESTENTITY.DATA</code>.
     */
    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Testentity (");

        sb.append(id);
        sb.append(", ").append("[binary...]");

        sb.append(")");
        return sb.toString();
    }
}
