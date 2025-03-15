package com.mjc.school.service;

import java.util.List;

public interface NewsService<K,T, R> {
    //
    R create(T t);
    List<R> readAll();
    R readById(K k);
    R update(K k, T t);
    boolean delete(K k);
}
