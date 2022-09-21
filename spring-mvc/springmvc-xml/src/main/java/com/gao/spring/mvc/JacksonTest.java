package com.gao.spring.mvc;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class JacksonTest {

    /**
     * 下面代码是截取的spring源码中把对象转换成json字符串的核心代码
     */
    public static void main(String[] args) throws Exception{
        OutputStream bos = System.out;

        ObjectMapper mapper = new ObjectMapper();

//        JavaTimeModule javaTimeModule = new JavaTimeModule();
//        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//        mapper.registerModule(javaTimeModule);

        JsonGenerator generator = mapper.getFactory().createGenerator(bos, JsonEncoding.UTF8);

        //设置json字符串前缀
        generator.writeRaw("json返回值:(");

        ObjectWriter objectWriter = mapper.writer();
        objectWriter.writeValue(generator, new User("gsd","28", LocalDateTime.now()));

        //设置json字符串后缀
        generator.writeRaw(")");
        generator.flush();
    }

}
