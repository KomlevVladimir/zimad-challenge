package com.vladimirkomlev.zimadchallenge.data;

import com.github.javafaker.Faker;
import com.vladimirkomlev.zimadchallenge.models.CreateTaskRequest;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static java.util.Collections.emptyList;

public class DataGenerator {
    private static Faker faker = new Faker();
    private static final int INBOX_PROJECT = 0;
    private static final int NO_SECTION = 0;
    private static final int NO_PARENT = 0;
    private static final int CONTENT_MAX_SYMBOLS = 2048;
    private static final int CONTENT_MIN_SYMBOLS = 1;
    private static final int MIN_PRIORITY = 1;
    private static final int MAX_PRIORITY = 4;

    public static CreateTaskRequest randomValidTaskRequest() {
        return new CreateTaskRequest()
                .withContent(randomString(randomInt(CONTENT_MIN_SYMBOLS, CONTENT_MAX_SYMBOLS)))
                .withProjectId(INBOX_PROJECT)
                .withSectionId(NO_SECTION)
                .withOrder(randomInt(MIN_VALUE, MAX_VALUE))
                .withLabelIds(emptyList())
                .withParent(NO_PARENT)
                .withPriority(randomInt(MIN_PRIORITY, MAX_PRIORITY));
    }

    private static int randomInt(int min, int max) {
        return faker.number().numberBetween(min, max);
    }

    private static String randomString(int length) {
        return faker.regexify("[A-Za-z0-9]{" + length + "}");
    }
}
