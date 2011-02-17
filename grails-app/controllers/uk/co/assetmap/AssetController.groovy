package uk.co.assetmap

import uk.co.assetmap.location.Postcode

class AssetController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [assetInstanceList: Asset.list(params), assetInstanceTotal: Asset.count()]
    }

    def create = {
        def assetInstance = new Asset()
        def postcodeInstance = new Postcode()
        assetInstance.properties = params
        return [assetInstance: assetInstance, postcodeInstance:postcodeInstance]
    }

    def save = {
     
       params.each() {
         System.out.println("param:" + it)
         // Do something with 'it' -- each item in the collection will be 'it' one time.
         // In your case you need to figure out which it's you want to process.
         }  
       
        def postcodeInstance = new Postcode(outward:params.outward, inward:params.inward)
        def assetInstance = new Asset(params)
        
        System.out.println("Asset1:" + assetInstance)
        assetInstance.setPostcode(postcodeInstance)
        
        System.out.println("Postcode:" + postcodeInstance)
        System.out.println("Asset2:" + assetInstance)
        
        if (assetInstance.save(flush: true)) {
            System.out.println("SAVE worked")
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'asset.label', default: 'Asset'), assetInstance.id])}"
            redirect(action: "show", id: assetInstance.id)
        }
        else {
            System.out.println("SAVE failed")
            render(view: "create", model: [assetInstance: assetInstance, postcodeInstance:postcodeInstance])
        }
    }

    def show = {
        def assetInstance = Asset.get(params.id)
        def postcodeInstance = assetInstance.getPostcode()
        
        System.out.println("show-Postcode:" + postcodeInstance)
        System.out.println("show-Asset:" + assetInstance)
        
        if (!assetInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'asset.label', default: 'Asset'), params.id])}"
            redirect(action: "list")
        }
        else {
            [assetInstance: assetInstance, postcodeInstance:postcodeInstance]
        }
    }

    def edit = {
        def assetInstance = Asset.get(params.id)
        if (!assetInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'asset.label', default: 'Asset'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [assetInstance: assetInstance]
        }
    }

    def update = {
        def assetInstance = Asset.get(params.id)
        if (assetInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (assetInstance.version > version) {
                    
                    assetInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'asset.label', default: 'Asset')] as Object[], "Another user has updated this Asset while you were editing")
                    render(view: "edit", model: [assetInstance: assetInstance])
                    return
                }
            }
            assetInstance.properties = params
            if (!assetInstance.hasErrors() && assetInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'asset.label', default: 'Asset'), assetInstance.id])}"
                redirect(action: "show", id: assetInstance.id)
            }
            else {
                render(view: "edit", model: [assetInstance: assetInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'asset.label', default: 'Asset'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def assetInstance = Asset.get(params.id)
        if (assetInstance) {
            try {
                assetInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'asset.label', default: 'Asset'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'asset.label', default: 'Asset'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'asset.label', default: 'Asset'), params.id])}"
            redirect(action: "list")
        }
    }
}
