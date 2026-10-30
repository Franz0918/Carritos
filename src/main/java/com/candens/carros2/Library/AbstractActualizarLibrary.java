package com.candens.carros2.Library;

public abstract class AbstractActualizarLibrary implements InterfaceActualizarLibrary{

   DaoActualizarLibrary daoActualizarLibrary;

   public void setDal(DaoActualizarLibrary dal) {this.daoActualizarLibrary = dal;}
}
