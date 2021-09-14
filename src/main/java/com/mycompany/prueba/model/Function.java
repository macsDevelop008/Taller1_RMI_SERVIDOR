package com.mycompany.prueba.model;
import java.util.Objects;
@FunctionalInterface
public interface Function<T,R> {
   R apply(T t);
    //ThrowingFunction
}