package com.mjc.school.repository.factory;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.impl.AuthorArrayRepository;
import com.mjc.school.repository.impl.NewsArrayRepository;
import com.mjc.school.repository.domain.Author;
import com.mjc.school.repository.domain.News;
import lombok.Getter;

@Getter
public class RepositoryFactory {
    //
    private final BaseRepository<Long, News> newsRepository;
    private final BaseRepository<Long, Author> authorRepository;

    private RepositoryFactory() {
        //
        this.authorRepository = new AuthorArrayRepository();
        this.newsRepository = new NewsArrayRepository();
    }

    public static RepositoryFactory getInstance() {
        //
        return LazyRepositoryFactory.REPOSITORY_FACTORY_INSTANCE;
    }

    private static class LazyRepositoryFactory {
        //
        static final RepositoryFactory REPOSITORY_FACTORY_INSTANCE = new RepositoryFactory();
    }

}
