import jenkins.model.*


def jobName = "myjob"
def configXml = new File('/tmp/myjob.xml').text
def xmlStream = new ByteArrayInputStream( configXml.getBytes() )
Jenkins.instance.createProjectFromXML(jobName, xmlStream)
