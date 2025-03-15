package com.mjc.school.repository.dataSource;

import com.mjc.school.repository.dataSource.data.DataLoader;
import com.mjc.school.repository.domain.AuthorModel;
import com.mjc.school.repository.domain.NewsModel;
import lombok.Getter;

import java.util.List;

@Getter
public class DataSource {
    //
    private List<NewsModel> newsModelList;
    private List<AuthorModel> authorModelList;

    private DataSource() {
        //
        this.newsModelList = DataLoader.getInstance().getNewsModelList();
        this.authorModelList = DataLoader.getInstance().getAuthorModelList();
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
