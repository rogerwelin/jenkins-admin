import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.*
import com.dabsquared.gitlabjenkins.connection.*
import hudson.util.Secret
import jenkins.model.Jenkins

String id = "user"
String description = "gitlab auth"
String token = "secret-gitlab-api-token"
global_domain = Domain.global()

Secret secret = hudson.util.Secret.fromString(token)

credentials_store = Jenkins.instance.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].getStore()
  
credentials = new GitLabApiTokenImpl(
CredentialsScope.GLOBAL,
id,
description,
secret)

credentials_store.addCredentials(global_domain, credentials)

