package com.candens.carros2.Library;

public abstract class AbstractBorrarLibrary implements InterfaceBorrarLibrary{


    DaoBorrarLibrary daoBorrarLibrary;

    public void setDaoBorrarLibrary(DaoBorrarLibrary dbol) {
        this.daoBorrarLibrary = dbol;
    }
}
