package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.dataSource.DataSource;
import com.mjc.school.repository.domain.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorArrayRepository implements BaseRepository<Long, Author> {
    //
    private final List<Author> authorList;

    public AuthorArrayRepository() {
        //
        this.authorList = DataSource.getInstance().getAuthorList();
    }

    @Override
    public Author create(Author author) {
        //
        authorList.add(author);
        return author;
    }

    @Override
    public List<Author> getAll() {
        //
        return new ArrayList<>(authorList);
    }

    @Override
    public Optional<Author> getById(Long id) {
        //
        return authorList.stream()
                .filter(author -> author.getId().equals(id))
                .findFirst();
    }

    @Override
    public Author update(Long id, Author updatedAuthor) {
        //
        for (int i = 0; i < authorList.size(); i++) {
            if (authorList.get(i).getId().equals(id)) {
                authorList.set(i, updatedAuthor);
                return updatedAuthor;
            }
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        //
        return authorList.removeIf(author -> author.getId().equals(id));
    }

    @Override
    public boolean existsById(Long id) {
        //
        return authorList.stream()
                .anyMatch(news -> news.getId().equals(id));
    }

}
