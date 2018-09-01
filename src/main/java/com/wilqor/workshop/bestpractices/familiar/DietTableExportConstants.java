package com.wilqor.workshop.bestpractices.familiar;

/**
 * @author wilqor
 */
final class DietTableExportConstants {
    private DietTableExportConstants() {
        throw new AssertionError();
    }

    static final int COLUMNS_PER_ROW = 10;

    static final int ROWS_PER_PAGE = 20;

    static final int PAGES_PER_EXPORT = 10_000;
}
