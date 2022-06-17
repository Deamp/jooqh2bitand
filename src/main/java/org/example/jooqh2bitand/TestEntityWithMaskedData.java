package org.example.jooqh2bitand;

import lombok.Data;

@Data
public class TestEntityWithMaskData {

    private Long   id;
    private byte[] data;
    private byte[] maskedData;

}
