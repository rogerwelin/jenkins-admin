import hudson.model.UpdateSite
import hudson.PluginWrapper

Boolean dynamicLoad = false
updateSite = Jenkins.getInstance().getUpdateCenter().getById('default')

def install(String c, Boolean dynamicLoad, UpdateSite updateSite) {
        println "Installing ${c} plugin."
        UpdateSite.Plugin plugin = updateSite.getPlugin(c)
        Throwable error = plugin.deploy(dynamicLoad).get().getError()
        if(error != null) {
            println "ERROR installing ${it}, ${error}"
    }
}


install("gradle", dynamicLoad, updateSite)
