package com.simple.testing.tool;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;

/**
 * 雪花算法生成器
 *
 * @author chenkangkang
 * @date 2023/3/30 5:36 PM
 **/
public class SnowflakeIdGenerator {

    private static final TimeBasedGenerator GENERATOR = Generators.timeBasedGenerator(EthernetAddress.fromInterface());

    public static long generateId() {
        return GENERATOR.generate().timestamp();
    }

}
