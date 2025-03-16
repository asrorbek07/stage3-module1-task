package com.mjc.school.controller;

import java.util.List;

public interface BaseController<K, T, R> {
    R create(T t);
    List<R> readAll();
    R readById(K k);
    R update(T t);
    Boolean delete(K k);
}
