package com.candens.carros2.Library;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractBorrarLibrary implements InterfaceBorrarLibrary{

    @Autowired
    DaoBorrarLibrary daoBorrarLibrary;

    public void setDaoBorrarLibrary(DaoBorrarLibrary dbol) {
        this.daoBorrarLibrary = dbol;
    }
}
