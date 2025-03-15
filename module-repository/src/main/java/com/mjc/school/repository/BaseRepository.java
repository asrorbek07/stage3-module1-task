package com.mjc.school.repository;

import java.util.List;

public interface BaseRepository<K,T> {
    //
    T create(T t);
    List<T> readAll();
    T readById(K k);
    T update(K id, T t);
    Boolean delete(K k);
    Boolean existsById(K k);
}
