import ext.FileArgsTemplate;
import ext.TestCase;

public class ExampleTest {
    /**
     * Working case
     */
    @TestCase({"input_0/arg0.txt", "input_0/arg1.txt"})
    @TestCase({"input_1/arg0.txt", "input_1/arg1.txt"})
    void test_0(String h, String w) {
        System.out.println(h + " " + w);
    }

    /**
     * Still working case
     */
    @FileArgsTemplate({
            @TestCase({"input_0/arg0.txt", "input_0/arg1.txt"}),
            @TestCase({"input_1/arg0.txt", "input_1/arg1.txt"})
    })
    void test_1(String h, String w) {
        System.out.println(h + " " + w);
    }

    /**
     * Crash :(
     * <p>
     * <p>
     * org.junit.platform.commons.PreconditionViolationException: You must register at least one TestTemplateInvocationContextProvider that supports @TestTemplate method [void ExampleTest.test_2(java.lang.String,java.lang.String)]
     * <p>
     * at org.junit.platform.commons.util.Preconditions.condition(Preconditions.java:296)
     * at org.junit.platform.commons.util.Preconditions.notEmpty(Preconditions.java:146)
     * at org.junit.jupiter.engine.descriptor.TestTemplateTestDescriptor.validateProviders(TestTemplateTestDescriptor.java:122)
     * at org.junit.jupiter.engine.descriptor.TestTemplateTestDescriptor.execute(TestTemplateTestDescriptor.java:98)
     * at org.junit.jupiter.engine.descriptor.TestTemplateTestDescriptor.execute(TestTemplateTestDescriptor.java:42)
     * at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:139)
     * at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
     * at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:129)
     * at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137)
     * at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:127)
     * at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
     * at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:126)
     * at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:84)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
     * at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38)
     * at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:143)
     * at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
     * at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:129)
     * at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137)
     * at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:127)
     * at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
     * at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:126)
     * at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:84)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
     * at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38)
     * at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:143)
     * at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
     * at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:129)
     * at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137)
     * at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:127)
     * at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
     * at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:126)
     * at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:84)
     * at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:32)
     * at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:57)
     * at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:51)
     * at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:108)
     * at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:88)
     * at org.junit.platform.launcher.core.EngineExecutionOrchestrator.lambda$execute$0(EngineExecutionOrchestrator.java:54)
     * at org.junit.platform.launcher.core.EngineExecutionOrchestrator.withInterceptedStreams(EngineExecutionOrchestrator.java:67)
     * at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:52)
     * at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:96)
     * at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:75)
     * at com.intellij.junit5.JUnit5IdeaTestRunner.startRunnerWithArgs(JUnit5IdeaTestRunner.java:71)
     * at com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:33)
     * at com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:235)
     * at com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:54)
     */
    @FileArgsTemplate(directory = {"input_0", "input_1"})
    void test_2(String h, String w) {
        System.out.println(h + " " + w);
    }
}
