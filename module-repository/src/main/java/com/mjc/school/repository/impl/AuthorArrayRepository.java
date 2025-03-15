package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.dataSource.DataSource;
import com.mjc.school.repository.domain.AuthorModel;

import java.util.ArrayList;
import java.util.List;

public class AuthorArrayRepository implements BaseRepository<Long, AuthorModel> {
    //
    private final DataSource dataSource;

    public AuthorArrayRepository() {
        //
        this.dataSource = DataSource.getInstance();
    }

    @Override
    public AuthorModel create(AuthorModel authorModel) {
        //
        Long nextId = dataSource.getAuthorModelList().stream()
                .mapToLong(AuthorModel::getId)
                .max()
                .orElse(0L) + 1;
        authorModel.setId(nextId);
        dataSource.getAuthorModelList().add(authorModel);
        return authorModel;
    }

    @Override
    public List<AuthorModel> readAll() {
        //
        return new ArrayList<>(dataSource.getAuthorModelList());
    }

    @Override
    public AuthorModel readById(Long id) {
        //
        return dataSource.getAuthorModelList().stream()
                .filter(author -> author.getId().equals(id))
                .findFirst().get();
    }

    @Override
    public AuthorModel update(AuthorModel updatedAuthorModel) {
        //
        for (int i = 0; i < dataSource.getAuthorModelList().size(); i++) {
            if (dataSource.getAuthorModelList().get(i).getId().equals(updatedAuthorModel.getId())) {
                dataSource.getAuthorModelList().set(i, updatedAuthorModel);
                return updatedAuthorModel;
            }
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        //
        return dataSource.getAuthorModelList().removeIf(author -> author.getId().equals(id));
    }

    @Override
    public Boolean existsById(Long id) {
        //
        return dataSource.getAuthorModelList().stream()
                .anyMatch(news -> news.getId().equals(id));
    }

}
