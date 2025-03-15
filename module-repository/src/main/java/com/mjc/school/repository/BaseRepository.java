package com.mjc.school.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<K,T> {
    //
    T create(T t);
    List<T> getAll();
    Optional<T> getById(K k);
    T update(K id, T t);
    boolean delete(K k);
    boolean existsById(K k);
}
