import hudson.plugins.gradle.GradleInstallation;
import hudson.tools.InstallSourceProperty;
import hudson.tools.ToolProperty;
import hudson.tools.ToolPropertyDescriptor;
import hudson.util.DescribableList;


def gradleDesc = jenkins.model.Jenkins.instance.getExtensionList(hudson.plugins.gradle.GradleInstallation.DescriptorImpl)[0]

def isp = new InstallSourceProperty()
def autoInstaller = new hudson.plugins.gradle.GradleInstaller("3.3")
isp.installers.add(autoInstaller)

def proplist = new DescribableList<ToolProperty<?>, ToolPropertyDescriptor>()
proplist.add(isp)

def installation = new hudson.plugins.gradle.GradleInstallation("G33", "", proplist)

gradleDesc.setInstallations(installation)
gradleDesc.save()
