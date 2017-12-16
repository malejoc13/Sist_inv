Ext.define('Admin.view.userSections.user.view.UserEditor', {
    extend: 'Admin.base.BaseEditor',
    alias: 'widget.userEditor',
    height: 350,
    items: [
        {
            items: [
                {
                    xtype     : 'baseTextField',
                    fieldLabel: 'Nombre',
                    name: 'firstName',//le pongo de nombre el mismo valord el grid para que me lo cargue a la hora de modificar
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio'                    
                }, 
                {
                    xtype     : 'baseTextField',
                    fieldLabel: 'Usuario',
                    name: 'username',//le pongo de nombre el mismo valord el grid para que me lo cargue a la hora de modificar
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio'                    
                },
                {
                    xtype     : 'baseCheckboxField',
                    fieldLabel: 'Activo',
                    name: 'active'                   
                }
            ]
        },
        {
            items: [
                {
                    xtype     : 'baseTextField',
                    fieldLabel: 'Apellidos',
                    name: 'lastName',//le pongo de nombre el mismo valord el grid para que me lo cargue a la hora de modificar
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio'                    
                },                
                {
                    xtype     : 'basePassField',
                    fieldLabel: 'Contrase&ntilde;a',
                    name: 'password',                   
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio' 
                },
                {
                    xtype     : 'basePassField',
                    fieldLabel: 'Confirme contrase&ntilde;a',
                    name: 'confirmPassword',                  
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio',                    
                    validator:function (val) {
                            formData = this.up().up().getValues(); 
                            if (val){
                                    if (val == formData.values['password']) {           
                                        return true;
                                    }else{
                                         return "Las contrase&ntilde;as no coinciden";
                                    }
                            }                         
                     }                   
                }
            ]
        },
        {
            items: [
                {
                    xtype     : 'baseTextField',
                    fieldLabel: 'Email',
                    name: 'email',
                    regex : /^([a-z]+[a-z1-9._-]*)@{1}([a-z1-9\.]{2,})\.([a-z]{2,3})$/,//solo email
                    regexText : "Solo se permiten direcciones de correo v&aacute;lidos"                    
                }, 
                 {
                    fieldLabel: 'Unidad',
                    xtype: 'baseSelectField',
                    name: 'unidadId',
                    url: 'unidad',
                    allowBlank : false,                    
                    emptyText : "Seleccione...",
                    editable : false,
                    blankText : 'Este campo es obligatorio'
                },
                {
                    fieldLabel: 'Rol',
                    xtype: 'baseSelectField',
                    name: 'roleId',
                    url: 'role',
                    allowBlank : false,                    
                    emptyText : "Seleccione...",
                    editable : false,
                    blankText : 'Este campo es obligatorio'
                },
                {
                    xtype: 'idField'
                }
            ]
        }
    ]
});
