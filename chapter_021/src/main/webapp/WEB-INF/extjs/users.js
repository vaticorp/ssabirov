Ext.onReady(function () {
    Ext.define('Catalog.model.User', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'userId', type: 'int'},
            {name: 'name', type: 'string'},
            {name: 'surname', type: 'string'},
            {name: 'age', type: 'int'}
        ],
        associations: [{
            type: 'hasOne',
            model: 'Catalog.model.Address',
            name: 'address'
        }]
    });

    Ext.define('Catalog.model.Address', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'id', type: 'int'},
            {name: 'index', type: 'int'},
            {name: 'city',  type: 'string'},
            {name: 'street',  type: 'string'},
            {name: 'houseNumber', type: 'int'}
        ]
    });

    Ext.define('Catalog.store.Users', {
        extend  : 'Ext.data.Store',
        storeId: 'userStore',
        model   : 'Catalog.model.User',
        fields  : ['userId', 'name', 'surname','age'],
        proxy: {
            type: 'ajax',
            url: '/list',
            reader: {
                type: 'json',
                root: 'users'
            }
        },
        autoLoad: true
    });

    Ext.define('Catalog.view.UsersList', {
        extend: 'Ext.grid.Panel',
        alias: 'widget.userslist',
        title: 'Catalog of users (main information)',
        store: 'Users',
        initComponent: function () {
            this.tbar = [{
                text    : 'Add User',
                action  : 'add'
            }];
            this.columns = [
                { header: 'Identifier', dataIndex: 'userId', width: 30 },
                { header: 'Name', dataIndex: 'name', flex: 1 },
                { header: 'Surname', dataIndex: 'surname' },
                { header: 'Age', dataIndex: 'age' , width: 60 },
                { header: 'Action', width: 50,
                    renderer: function (v, m, r) {
                        var id = Ext.id();
                        Ext.defer(function () {
                            Ext.widget('image', {
                                renderTo: id,
                                name: 'delete',
                                src : 'static/img/delete-user.png',
                                listeners : {
                                    afterrender: function (me) {
                                        me.getEl().on('click', function() {
                                            var grid = Ext.ComponentQuery.query('userslist')[0];
                                            if (grid) {
                                                var sm = grid.getSelectionModel();
                                                var rs = sm.getSelection();
                                                if (!rs.length) {
                                                    Ext.Msg.alert('Info', 'No User Selected');
                                                    return;
                                                }
                                                Ext.Msg.confirm('Remove User',
                                                    'Are you sure you want to delete?',
                                                    function (button) {
                                                        if (button == 'yes') {
                                                            //grid.store.remove(rs[0]);
                                                            var user_data = rs[0].getData();
                                                            Ext.Ajax.request({
                                                                url: '/delete',
                                                                method  : 'DELETE',
                                                                /*params : {
                                                                    dataDetails : Ext
                                                                        .encode(user_data)
                                                                },*/
                                                                jsonData: user_data,
                                                                success: function(response){
                                                                    var grid = Ext.ComponentQuery.query('userslist')[0];
                                                                    grid.getStore().load();
                                                                }
                                                            });
                                                        }
                                                    });
                                            }
                                        });
                                    }
                                }
                            });
                        }, 50);
                        return Ext.String.format('<div id="{0}"></div>', id);
                    }
                }
            ];
            this.callParent(arguments);
        }
    });

    Ext.define('Catalog.view.UsersForm', {
        extend  : 'Ext.window.Window',
        alias   : 'widget.usersform',
        title   : 'Add User',
        width   : 350,
        layout  : 'fit',
        resizable: false,
        closeAction: 'hide',
        modal   : true,
        config  : {
            recordIndex : 0,
            action : ''
        },
        items   : [{
            xtype : 'form',
            layout: 'anchor',
            bodyStyle: {
                background: 'none',
                padding: '10px',
                border: '0'
            },
            defaults: {
                xtype : 'textfield',
                anchor: '100%'
            },
            items : [{
                name  : 'userId',
                fieldLabel: 'Identifier'
            },{
                name  : 'name',
                fieldLabel: 'User name'
            },{
                name: 'surname',
                fieldLabel: 'User surname'
            },{
                name: 'age',
                fieldLabel: 'Age(years)'
            }]
        }],
        buttons: [{
            text: 'OK',
            action: 'add'
        },{
            text    : 'Reset',
            handler : function () {
                this.up('window').down('form').getForm().reset();
            }
        },{
            text   : 'Cancel',
            handler: function () {
                this.up('window').close();
            }
        }]
    });

    Ext.define('Catalog.controller.Users', {
        extend  : 'Ext.app.Controller',
        stores  : ['Users'],
        views   : ['UsersList', 'UsersForm'],
        refs    : [{
            ref   : 'formWindow',
            xtype : 'usersform',
            selector: 'usersform',
            autoCreate: true
        }],
        init: function () {
            this.control({
                'userslist > toolbar > button[action=add]': {
                    click: this.showAddForm
                },
                'userslist': {
                    itemdblclick: this.onRowdblclick
                },
                'usersform button[action=add]': {
                    click: this.doAddUser
                }
            });
        },
        onRowdblclick: function(me, record, item, index) {
            var win = this.getFormWindow();
            win.setTitle('Edit User');
            win.setAction('edit');
            win.setRecordIndex(index);
            win.down('form').getForm().setValues(record.getData());
            win.show();
        },
        showAddForm: function () {
            var win = this.getFormWindow();
            win.setTitle('Add User');
            win.setAction('add');
            win.down('form').getForm().reset();
            win.show();
        },
        doAddUser: function () {
            var win = this.getFormWindow();
            var store = this.getUsersStore();
            var values = win.down('form').getValues();

            var action = win.getAction();
            var url = '';
            if(action == 'edit') {
                url = '/update';
            }
            else {
                url = '/add';
            }
            Ext.Ajax.request({
                url: url,
                method  : 'post',
                /*jsonData: values,*/
                params : {
                    dataDetails : Ext
                        .encode(values)
                },
                success: function(response){
                    store.load();
                }
            });
            win.close();
        }
    });

    Ext.application({
            name  : 'Catalog',
            controllers: ['Users'],
            launch: function () {
                Ext.widget('userslist', {
                    width : 800,
                    height: 500,
                    renderTo: 'output'
                });
            }
        }
    );
});