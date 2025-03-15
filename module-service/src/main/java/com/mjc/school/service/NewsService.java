package com.mjc.school.service;

import java.util.List;

public interface NewsService<K,T, R> {
    //
    R register(T t);
    List<R> findAll();
    R findById(K k);
    R modify(K k, T t);
    boolean remove(K k);
}
