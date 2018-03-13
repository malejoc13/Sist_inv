Ext.define('Admin.view.authentication.AuthenticationController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.authentication',
    
    
    onLoginButton: function () {
        var me = this;
        //creo un objeto de forma que sea interpretado por el front (json)
        var credentials = {
            user: me.getView().getReferences()['userNameField'].getValue(),
            password: me.getView().getReferences()['passwordField'].getValue()
        };

        Request.load({
            url: 'loginPage/security/login',
            method: 'POST',
            jsonData: credentials,
            ignoreError: true,
            success: function (response) { 
                if (response && response.status && response.status === 100 && response.data && response.data.token) {
                    Session.Principal = response.data;
                    
                    var navTree = Ext.getStore('NavigationTree');
                    navTree.custom();
                    Ext.ComponentQuery.query('#navigationTreeList')[0].setStore( navTree );
                   
                    var node = navTree.data.items[0],
                            firstItem = node.get('routeId') || node.get('viewType') || node.get('children')[0].viewType;
                     //Ext.Msg.alert('Acceso:', node.get('viewType'));
                    Ext.ComponentQuery.query('#principalName')[0].setText(Session.Principal.name + ' ' + Session.Principal.lastName+ ' <b>( ' + Session.Principal.unidad+ ' )</b>' );
                    var img = Session.Principal.name.charAt(0);                   
                    Ext.ComponentQuery.query('#principalPict')[0].setSrc('resources/images/user-profile/'+img.toLowerCase()+'.jpg');
                    Ext.GlobalEvents.fireEvent('logIn', firstItem);
                  
                } else {  
                    /*Ext.Msg.ERROR //Icono de error
                        Ext.Msg.INFO //Icono de información
                        Ext.Msg.WARNING //Icono de advertencia
                        Ext.Msg.QUESTION //Icono de pregunta*/
                   /* Ext.Msg.show({
                        title:'Error',
                        message: response.statusMessage,                        
                        icon: Ext.Msg.ERROR                      
                    });*/
                    Ext.Msg.alert('Error', response.statusMessage);
                    me.getView().getReferences()['userNameField'].el.dom.getElementsByClassName('x-form-trigger-wrap-default')[0].classList.add('x-form-trigger-wrap-invalid')
                    me.getView().getReferences()['passwordField'].el.dom.getElementsByClassName('x-form-trigger-wrap-default')[0].classList.add('x-form-trigger-wrap-invalid')
                }

            }
        });



    }    
});