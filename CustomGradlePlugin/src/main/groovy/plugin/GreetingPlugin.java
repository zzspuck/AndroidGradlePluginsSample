package plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

class GreetingPlugin implements Plugin<Project> {
    public void apply(Project project) {
        project.task("hello") {
            doLast {
                println 'Hello from the GreetingPlugin'
            }
        }
    }
}
