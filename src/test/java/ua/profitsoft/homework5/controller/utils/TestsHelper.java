package ua.profitsoft.hw5.controller.utils;

public class TestsHelper {
    public static final String NORMAL_JSON =
            """
                       {
                           "title":"New Book",
                           "author":"New Author",
                           "genre":"Fantasy",
                           "yearWritten":2022
                        }
                    """;

    public static final String EMPTY_GENRE_JSON =
            """
                       {
                           "title":"New Book",
                           "author":"New Author",
                           "genre":"",
                           "yearWritten":2022
                        }
                    """;

    public static final String INVALID_GENRE_JSON =
            """
                       {
                           "title":"New Book",
                           "author":"New Author",
                           "genre":"THRILL",
                           "yearWritten":2022
                        }
                    """;


    public static final String YEAR_NEGATIVE_JSON =
            """
                       {
                           "title":"New Book",
                           "author":"New Author",
                           "genre":"THRILL",
                           "yearWritten":-200
                        }
                    """;


    public static final String YEAR_TOO_BIG_JSON =
            """
                       {
                           "title":"New Book",
                           "author":"New Author",
                           "genre":"THRILL",
                           "yearWritten":2024
                        }
                    """;
    public static final String EMPTY_AUTHOR_JSON =
            """
                       {
                           "title":"New Book",
                           "author":"",
                           "genre":"THRILL",
                           "yearWritten":2022
                        }
                    """;
    public static final String EMPTY_TITLE_JSON =
            """
                       {
                           "title":"",
                           "author":"New Author",
                           "genre":"THRILL",
                           "yearWritten":2022
                        }
                    """;

    public static final String ZERO_PAGE_SIZE_JSON =
            """
                       {
                           "author":"New Author",
                           "genre":"THRILL",
                           "pageSize":0,
                           "pageNumber":0
                        }
                    """;

    public static final String NEGATIVE_PAGE_NUMBER_JSON =
            """
                       {
                           "author":"New Author",
                           "genre":"THRILL",
                           "pageSize":3,
                           "pageNumber":-2
                        }
                    """;
    public static final String SEARCH_1_JSON =
            """
                       {
                           "author":"Jack London",
                           "genre":"Poetry",
                           "pageSize":3,
                           "pageNumber":1
                        }
                    """;
    public static final String SEARCH_2_JSON =
            """
                       {
                           "author":"John Steinbeck",
                           "genre":"Western",
                           "pageSize":2,
                           "pageNumber":0
                        }
                    """;
}
