import hudson.plugins.git.GitTool;
import hudson.tools.InstallSourceProperty;
import hudson.tools.ToolProperty;
import hudson.tools.ToolPropertyDescriptor;
import hudson.util.DescribableList;


def gitDesc = jenkins.model.Jenkins.instance.getExtensionList(hudson.plugins.git.GitTool.DescriptorImpl)[0]
def installation = new hudson.plugins.git.GitTool("default", "/usr/bin/git", [])
gitDesc.setInstallations(installation)
gitDesc.save()
