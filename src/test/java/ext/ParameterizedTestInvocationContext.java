package ext;

import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;

import java.util.List;

class ParameterizedTestInvocationContext implements TestTemplateInvocationContext {
	private final List<?> arguments;

	ParameterizedTestInvocationContext(List<?> arguments) {
		this.arguments = arguments;
	}

	@Override
	public String getDisplayName(int invocationIndex) {
		return "test " + invocationIndex;
	}

	@Override
	public List<Extension> getAdditionalExtensions() {
		return List.of(new ListParameterResolver(arguments));
	}

}
