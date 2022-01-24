/**
 * WSLibrarySearch.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.urbe.search;

public interface WSLibrarySearch extends java.rmi.Remote {
    public int[] singleSearch(int typeMaterial, java.lang.String query) throws java.rmi.RemoteException;
    public int[] advanceSearch(int typeMaterial, java.lang.String query1, java.lang.String tag1, java.lang.String operator2, java.lang.String query2, java.lang.String tag2, java.lang.String operator3, java.lang.String query3, java.lang.String tag3) throws java.rmi.RemoteException;
    public java.lang.Integer[] singleSearchArray(int typeMaterial, java.lang.String query) throws java.rmi.RemoteException;
    public java.lang.Integer[] advanceSearchArray(int typeMaterial, java.lang.String query1, java.lang.String tag1, java.lang.String operator2, java.lang.String query2, java.lang.String tag2, java.lang.String operator3, java.lang.String query3, java.lang.String tag3) throws java.rmi.RemoteException;
    public void createrMaterial(edu.urbe.search.WsMaterial[] eduUrbeWebWsBeansWSMaterial) throws java.rmi.RemoteException;
    public void updateMaterial(edu.urbe.search.WsMaterial[] eduUrbeWebWsBeansWSMaterial) throws java.rmi.RemoteException;
    public void publicaMaterial(edu.urbe.search.WsMaterial[] eduUrbeWebWsBeansWSMaterial, int estado) throws java.rmi.RemoteException;
    public void publicaEstadoMaterial(edu.urbe.search.WsMaterial[] eduUrbeWebWsBeansWSMaterial) throws java.rmi.RemoteException;
    public void deleteContent(edu.urbe.search.Content eduUrbeWebBaseLibraryContent) throws java.rmi.RemoteException;
    public void sincronizeMysqlDB() throws java.rmi.RemoteException;
}
