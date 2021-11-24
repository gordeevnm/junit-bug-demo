package ext;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.util.List;

@RequiredArgsConstructor
public class ListParameterResolver implements ParameterResolver {
    private final List<?> arguments;

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return true;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return arguments.get(parameterContext.getIndex());
    }
}
