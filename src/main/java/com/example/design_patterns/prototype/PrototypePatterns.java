package com.example.design_patterns.prototype;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrototypePatterns {

    //浅拷贝
    @Test
    public void shallowCopyTest() throws CloneNotSupportedException {
        List<String> phone = new ArrayList<>(Arrays.asList("123", "456", "789"));
        Person1 p1 = new Person1(1L, "张三", phone);
        Person1 p2 = (Person1) p1.clone();
        System.err.println(p1 == p2);
        p1.getPhone().add("popo");
        System.err.println(p1.getPhone().equals(p2.getPhone()));
        System.err.println(p1.getPhone());
        System.err.println(p2.getPhone());

    }

    //深拷贝
    @Test
    public void deepCopyTest() throws CloneNotSupportedException {
        List<String> phone = new ArrayList<>(Arrays.asList("123", "456", "789"));

        Person2 p1 = new Person2(1L, "张三", phone);
        Person2 p2 = (Person2) p1.clone();
        System.err.println("p2: " + p2);
        System.err.println(p1 == p2);
        p1.getPhone().add("popo");
        System.err.println(p1.getPhone().equals(p2.getPhone()));
        System.err.println(p1.getPhone());
        System.err.println(p2.getPhone());


    }


}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Person1 implements Cloneable, Serializable {
    private Long id;
    private String name;
    private List<String> phone;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Person2 implements Cloneable, Serializable {
    private Long id;
    private String name;
    private List<String> phone;

    @Override
    public Object clone() throws CloneNotSupportedException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(mapper.writeValueAsString(this), this.getClass());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}