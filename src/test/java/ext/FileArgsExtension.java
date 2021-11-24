package ext;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;

import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileArgsExtension implements TestTemplateInvocationContextProvider {
    @Override
    public boolean supportsTestTemplate(ExtensionContext context) {
        return true;
    }

    @Override
    public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext context) {
        final Method method = context.getRequiredTestMethod();
        final FileArgsTemplate templateAnnotation = method.getAnnotation(FileArgsTemplate.class);
        final TestCase[] caseAnnotations = method.getAnnotationsByType(TestCase.class);

        if (caseAnnotations.length > 0) {
            return Stream.of(caseAnnotations)
                    .map(TestCase::value)
                    .map(Arrays::asList)
                    .map(files -> files.stream()
                            .map(Utils::read)
                            .collect(Collectors.toList()))
                    .map(ParameterizedTestInvocationContext::new);
        }
        if (templateAnnotation != null && templateAnnotation.directory().length > 0) {
            return Stream.of(templateAnnotation.directory())
                    .map(Utils::listFiles)
                    .map(paths -> paths.stream()
                            .sorted(Comparator.comparing(Path::getFileName))
                            .map(Utils::readPath)
                            .collect(Collectors.toList()))
                    .map(ParameterizedTestInvocationContext::new);
        }

        throw new IllegalArgumentException();
    }
}
