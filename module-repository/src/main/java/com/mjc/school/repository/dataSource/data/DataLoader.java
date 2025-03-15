package com.mjc.school.repository.dataSource.data;

import com.mjc.school.repository.domain.Author;
import com.mjc.school.repository.domain.News;
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
    private final ArrayList<Author> authorList;
    @Getter
    private final ArrayList<News> newsList;

    private DataLoader() {
        //
        this.authorList = generateAuthors();
        this.newsList = generateNews();
    }

    public static synchronized DataLoader getInstance() {
        //
        return LazyDataLoader.DATA_LOADER_INSTANCE;
    }

    private ArrayList<Author> generateAuthors() {
        //
        List<String> authorLines = readResourceFile(AUTHOR_FILE);
        ArrayList<Author> authors = new ArrayList<>();
        long id = 1;
        for (String name : authorLines) {
            authors.add(Author.builder().id(id++).name(name.trim()).build());
        }
        return authors;
    }

    private ArrayList<News> generateNews() {
        //
        List<String> newsTitles = readResourceFile(NEWS_FILE);
        List<String> contentLines = readResourceFile(CONTENT_FILE);
        ArrayList<News> newsList = new ArrayList<>();
        Random random = new Random();

        for (long id = 1; id <= NEWS_COUNT; id++) {
            String title = newsTitles.get(random.nextInt(newsTitles.size())).trim();
            String content = contentLines.get(random.nextInt(contentLines.size())).trim();
            Long authorId = authorList.isEmpty() ? null : authorList.get(random.nextInt(authorList.size())).getId();

            newsList.add(News.builder()
                    .id(id)
                    .title(title)
                    .content(content)
                    .createdDate(LocalDateTime.now())
                    .lastUpdatedDate(LocalDateTime.now())
                    .authorId(authorId)
                    .build());
        }
        return newsList;
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
