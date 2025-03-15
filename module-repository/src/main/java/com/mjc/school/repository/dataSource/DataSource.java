package com.mjc.school.repository.dataSource;

import com.mjc.school.repository.dataSource.data.DataLoader;
import com.mjc.school.repository.domain.Author;
import com.mjc.school.repository.domain.News;
import lombok.Getter;

import java.util.List;

@Getter
public class DataSource {
    //
    private List<News> newsList;
    private List<Author> authorList;

    private DataSource() {
        //
        this.newsList = DataLoader.getInstance().getNewsList();
        this.authorList = DataLoader.getInstance().getAuthorList();
    }

    public static DataSource getInstance() {
        //
        return LazyDataSource.DATA_SOURCE_INSTANCE;
    }

    private static class LazyDataSource {
        //
        static final DataSource DATA_SOURCE_INSTANCE = new DataSource();
    }

}
