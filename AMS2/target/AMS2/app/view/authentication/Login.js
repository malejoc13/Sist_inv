Ext.define('Admin.view.authentication.Login', {
    extend: 'Admin.view.authentication.LockingWindow',
    xtype: 'login',

    requires: [
        'Admin.view.authentication.Dialog',
        'Ext.container.Container',
        'Ext.form.field.Text',
        'Ext.form.field.Checkbox',
        'Ext.button.Button'
    ],

    title: 'JURAMICUA PURE S.C.',
    defaultFocus: 'authdialog', // Focus the Auth Form to force field focus as well
    // controller: 'authentication',
    items: [
        {
            xtype: 'authdialog',
            defaultButton : 'loginButton',
            autoComplete: true,
            bodyPadding: '20 20',
            cls: 'auth-dialog-login',
            header: false,
            width: 415,
            layout: {
                type: 'vbox',
                align: 'stretch'
            },

            defaults : {
                margin : '5 0'
            },

            items: [
                {
                    xtype: 'label',
                    text: 'Introduzca sus credenciales'
                },
                {
                    xtype: 'textfield',
                    reference: 'userNameField',
                    cls: 'auth-textbox',
                    name: 'userid',
                 //   bind: '{userid}',
                    height: 55,
                   // value:'sad',
                    hideLabel: true,
                    allowBlank : false,
                    emptyText: 'Usuario',
                    blankText : 'Este campo es obligatorio',
                    triggers: {
                        glyphed: {
                            cls: 'trigger-glyph-noop auth-email-trigger'
                        }
                    }
                },
                {
                    xtype: 'textfield',
                    reference: 'passwordField',
                    cls: 'auth-textbox',
                    height: 55,
                    hideLabel: true,
                    emptyText: 'Contraseña',
                    inputType: 'password',
                    name: 'password',
                    blankText : 'Este campo es obligatorio',
                   // value:'contraseña',
                   // bind: '{password}',
                    allowBlank : false,
                    triggers: {
                        glyphed: {
                            cls: 'trigger-glyph-noop auth-password-trigger'
                        }
                    }
                },
                {
                    xtype: 'container',
                    layout: 'hbox',
                    items: [
                        {
                            xtype: 'checkboxfield',
                            flex : 1,
                            cls: 'form-panel-font-color rememberMeCheckbox',
                            height: 30,
                            bind: '{persist}',
                            boxLabel: 'Recordarme'
                        }
                    ]
                },
                {
                    xtype: 'button',
                    reference: 'loginButton',
                    scale: 'large',
                    ui: 'soft-green',
                    iconAlign: 'right',
                    iconCls: 'x-fa fa-angle-right',
                    text: 'Iniciar',
                    formBind: true,
                    listeners: {
                        click:'onLoginButton'
                    }
                }
            ]
        }
    ],

    initComponent: function() {
        //this.addCls('user-login-register-container');
        this.callParent(arguments);
    }
});
