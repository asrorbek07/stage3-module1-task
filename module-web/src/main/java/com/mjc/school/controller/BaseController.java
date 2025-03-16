package com.mjc.school.controller;

import java.util.List;

public interface BaseController< T> {
    T create(T t);
    List<T> readAll();
    T readById(Long id);
    T update(T t);
    Boolean delete(Long id);
}
