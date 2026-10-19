package com.candens.carros2.Library;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractActualizarLibrary implements InterfaceActualizarLibrary{


   DaoActualizarLibrary daoActualizarLibrary;

   public void setDal(DaoActualizarLibrary dal) {this.daoActualizarLibrary = dal;}
}
