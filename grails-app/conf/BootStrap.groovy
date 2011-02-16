import uk.co.assetmap.AssetGroup


class BootStrap {

    def init = { servletContext ->
      new AssetGroup(name:"bootstrapAssGrp", description:"a desc",created:new Date()).save()
    }
    def destroy = {
    }
}
