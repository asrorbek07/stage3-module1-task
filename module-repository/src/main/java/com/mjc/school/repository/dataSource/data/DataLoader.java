package com.mjc.school.repository.dataSource.data;

import com.mjc.school.repository.domain.AuthorModel;
import com.mjc.school.repository.domain.NewsModel;
import com.mjc.school.repository.FailedToLoadFileException;
import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataLoader {
    //
    private static final String AUTHOR_FILE = "/author.txt";
    private static final String NEWS_FILE = "/news.txt";
    private static final String CONTENT_FILE = "/content.txt";
    private static final int NEWS_COUNT = 20;

    @Getter
    private final ArrayList<AuthorModel> authorModelList;
    @Getter
    private final ArrayList<NewsModel> newsModelList;

    private DataLoader() {
        //
        this.authorModelList = generateAuthors();
        this.newsModelList = generateNews();
    }

    public static synchronized DataLoader getInstance() {
        //
        return LazyDataLoader.DATA_LOADER_INSTANCE;
    }

    private ArrayList<AuthorModel> generateAuthors() {
        //
        List<String> authorLines = readResourceFile(AUTHOR_FILE);
        ArrayList<AuthorModel> authorModels = new ArrayList<>();
        long id = 1;
        for (String name : authorLines) {
            authorModels.add(AuthorModel.builder().id(id++).name(name.trim()).build());
        }
        return authorModels;
    }

    private ArrayList<NewsModel> generateNews() {
        //
        List<String> newsTitles = readResourceFile(NEWS_FILE);
        List<String> contentLines = readResourceFile(CONTENT_FILE);
        ArrayList<NewsModel> newsModelList = new ArrayList<>();
        Random random = new Random();

        for (long id = 1; id <= NEWS_COUNT; id++) {
            String title = newsTitles.get(random.nextInt(newsTitles.size())).trim();
            String content = contentLines.get(random.nextInt(contentLines.size())).trim();
            Long authorId = authorModelList.isEmpty() ? null : authorModelList.get(random.nextInt(authorModelList.size())).getId();

            newsModelList.add(NewsModel.builder()
                    .id(id)
                    .title(title)
                    .content(content)
                    .createdDate(LocalDateTime.now())
                    .lastUpdatedDate(LocalDateTime.now())
                    .authorId(authorId)
                    .build());
        }
        return newsModelList;
    }

    private List<String> readResourceFile(String fileName) {
        //
        List<String> lines = new ArrayList<>();
        try (InputStream inputStream = getClass().getResourceAsStream(fileName)) {
            assert inputStream != null;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }
        } catch (IOException | NullPointerException e) {
            throw new FailedToLoadFileException("Failed to load resource file: " + fileName);
        }
        return lines;
    }

    private static class LazyDataLoader {
        //
        static final DataLoader DATA_LOADER_INSTANCE = new DataLoader();
    }

}
