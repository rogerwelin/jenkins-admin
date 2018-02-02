import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.*
import com.dabsquared.gitlabjenkins.connection.*
import hudson.util.Secret
import jenkins.model.Jenkins

String name = 'gitlab'
String url = 'http://gitlab.mycompany.com'
String apiTokenId = 'your-jenkins-credential-name'
boolean ignoreCertificateErrors = true
Integer connectionTimeout = 10
Integer readTimeout = 10


// will add configuration to global config
GitLabConnection glc = new GitLabConnection(name, url, apiTokenId, ignoreCertificateErrors, connectionTimeout, readTimeout)
//println Jenkins.instance.getExtensionList(GitLabConnectionConfig.class)[0].metaClass.methods*.name.sort().unique() 
def settings = Jenkins.instance.getExtensionList(GitLabConnectionConfig.class)[0]
settings.addConnection(glc)
settings.save()

