package com.candens.carros2.Library;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractBuscarLibrary implements InterfaceBuscarLibrary{


    DaoBuscarLibrary daoBuscarLibrary; // APUNTA A NULL

    public void setDbl(DaoBuscarLibrary dbl) {

        this.daoBuscarLibrary = dbl;
    }
}
