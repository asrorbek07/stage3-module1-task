package com.mjc.school.service.util.validator;

import com.mjc.school.service.exception.ExceptionMessage;
import com.mjc.school.service.exception.NotValidException;
import com.mjc.school.service.model.dto.NewsCdo;

public class NewsValidator {
    private static final String NEWS_ID = "NewsModel id";
    private static final String NEWS_CONTENT = "NewsModel content";
    private static final String AUTHOR_ID = "AuthorModel id";
    private static final String NEWS_TITLE = "NewsModel title";
    private static final Integer NEWS_CONTENT_MIN_LENGTH = 5;
    private static final Integer NEWS_CONTENT_MAX_LENGTH = 255;
    private static final Integer NEWS_TITLE_MIN_LENGTH = 5;
    private static final Integer NEWS_TITLE_MAX_LENGTH = 30;

    private NewsValidator() {
    }

    public static NewsValidator getInstance() {
        //
        return LazyNewsValidator.NEWS_VALIDATOR_INSTANCE;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public void validateNewsId(Long newsId) {
        this.validateNumber(newsId, NEWS_ID);
    }

    public void validateNewsDto(NewsCdo newsCdo) {
        this.validateString(newsCdo.getTitle(), NEWS_TITLE, NEWS_TITLE_MIN_LENGTH, NEWS_TITLE_MAX_LENGTH);
        this.validateString(newsCdo.getContent(), NEWS_CONTENT, NEWS_CONTENT_MIN_LENGTH, NEWS_CONTENT_MAX_LENGTH);
        this.validateNumber(newsCdo.getAuthorId(), AUTHOR_ID);
    }

    private void validateNumber(Long id, String parameter) {
        if (id == null || id < 1L) {
            throw new NotValidException(String.format(ExceptionMessage.VALIDATE_NEGATIVE_OR_NULL_NUMBER.getMessage(), parameter, parameter, id));
        }
    }

    private void validateString(String value, String parameter, int minLength, int maxLength) {

        if (isEmpty(value)) {
            throw new NotValidException(String.format(ExceptionMessage.VALIDATE_NULL_STRING.getMessage(), parameter, parameter));
        } else if (value.trim().length() < minLength || value.trim().length() > maxLength) {
            throw new NotValidException(String.format(ExceptionMessage.VALIDATE_STRING_LENGTH.getMessage(), parameter, minLength, maxLength, parameter, value));
        }
    }

    private static class LazyNewsValidator {
        //
        static final NewsValidator NEWS_VALIDATOR_INSTANCE = new NewsValidator();
    }

}
