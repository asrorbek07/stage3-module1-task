package com.mjc.school.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<K,T> {
    //
    T create(T t);
    List<T> readAll();
    Optional<T> readById(K k);
    T update(K id, T t);
    Boolean delete(K k);
    Boolean existsById(K k);
}
