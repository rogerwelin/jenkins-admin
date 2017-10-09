import java.lang.System
import hudson.model.*
import jenkins.plugins.git.GitSCMSource
import org.jenkinsci.plugins.workflow.libs.*

//def home_dir = System.getenv("JENKINS_HOME")
//def properties = new ConfigSlurper().parse(new File("$home_dir/jenkins.properties").toURI().toURL())
// https://github.com/Praqma/JenkinsAsCodeReference/blob/master/dockerizeit/master/globalPipelineLibraries.groovy

GlobalLibraries gl = GlobalLibraries.get()
List<LibraryConfiguration> configs = new ArrayList<LibraryConfiguration>()

println "--> Configure Pipeline shared groovy library: del-library"
GitSCMSource gitSCM = new GitSCMSource("del-lib",
                                       "https://github.com/some/git/repo.git",
                                       "",
                                       null, null, false)

LibraryConfiguration globalConfig = new LibraryConfiguration("del-lib", new SCMSourceRetriever(gitSCM))
globalConfig.setDefaultVersion("master")
globalConfig.setImplicit(false)
globalConfig.setAllowVersionOverride(true)
configs.add(globalConfig)

gl.setLibraries(configs)
