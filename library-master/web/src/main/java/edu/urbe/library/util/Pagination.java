package edu.urbe.library.util;

import java.util.Collections;
import java.util.List;

public class Pagination {

    public static <T> List<T> getPages(List<T> list, int page, int pageSize) {
        if (page <= 0 || pageSize <= 0)
            throw new IllegalArgumentException("Invalid Page or PageSize");
        int from = (page - 1) * pageSize;
        if (list == null || list.size() < from) {
            return Collections.emptyList();
        }
        return list.subList(from, Math.min(from + pageSize, list.size()));
    }

}
