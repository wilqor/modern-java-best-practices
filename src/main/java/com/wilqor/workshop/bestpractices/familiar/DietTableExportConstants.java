package com.wilqor.workshop.bestpractices.familiar;

/**
 * @author wilqor
 */
public final class DietTableExportConstants {
    private DietTableExportConstants() {
        throw new AssertionError();
    }

    public static final int COLUMNS_PER_ROW = 10;

    public static final int ROWS_PER_PAGE = 20;

    public static final int PAGES_PER_EXPORT = 10_000;
}
