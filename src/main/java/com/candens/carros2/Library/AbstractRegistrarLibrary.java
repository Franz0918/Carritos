package com.candens.carros2.Library;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractRegistrarLibrary implements InterfaceRegistrarLibrary{


    DaoRegistrarLibrary daoRegistrarLibrary;

    public void setDrl(DaoRegistrarLibrary drl) {

        this.daoRegistrarLibrary = drl;
    }
}
