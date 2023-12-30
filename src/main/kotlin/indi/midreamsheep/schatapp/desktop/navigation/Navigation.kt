package indi.midreamsheep.schatapp.desktop.navigation

class Navigation {
    private val uiPage:Map<String,Unit> = mapOf()
    /**
     * 注册page
     * */
    fun registerPage(pageName:String,page:Unit){
        uiPage.plus(Pair(pageName,page))
    }
    /**
     * 获取page
     * */
    fun getPage(pageName:String):Unit {
        return uiPage[pageName]!!
    }

}