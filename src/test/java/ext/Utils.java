package ext;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    @SneakyThrows
    public static List<Path> listFiles(final String dir) {
        return listFiles(
                getPath(dir)
        );
    }

    @SneakyThrows
    public static List<Path> listFiles(final Path dir) {
        return Files.list(dir)
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public static String read(final String filename) {
        return Files.readString(
                getPath(filename)
        );
    }

    @SneakyThrows
    public static String readPath(final Path path) {
        return Files.readString(path);
    }

    private static Path getPath(String filename) {
        try {
            //noinspection ConstantConditions
            return Path.of(
                    Utils.class
                            .getClassLoader()
                            .getResource(filename)
                            .getFile()
            );
        } catch (NullPointerException e) {
            throw new IllegalStateException(
                    String.format("File '%s' not exists", filename),
                    e
            );
        }
    }
}
