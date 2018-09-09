package com.wilqor.workshop.bestpractices.familiar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.UnaryOperator;

/**
 * @author wilqor
 */
public final class LineRewriter {
    private final UnaryOperator<String> lineConverter;

    public LineRewriter(UnaryOperator<String> lineConverter) {
        this.lineConverter = lineConverter;
    }

    public void rewriteLines(Path inputFilePath, Path outputFilePath)
            throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(inputFilePath);
             BufferedWriter writer = Files.newBufferedWriter(outputFilePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(lineConverter.apply(line));
                writer.newLine();
            }
        }
    }
}
