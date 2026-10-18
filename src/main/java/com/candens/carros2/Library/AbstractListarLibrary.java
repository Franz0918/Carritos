package com.candens.carros2.Library;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractListarLibrary implements InterfaceListarLibrary{

    @Autowired
    DaoListarLibrary daoListarLibrary;

    public void setDll(DaoListarLibrary dll) {this.daoListarLibrary = dll;}
}
