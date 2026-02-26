/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Client {
    private int idClt;
    private String nomClt;
    private String villeClt;

    public Client() {}

    public Client(int idClt, String nomClt, String villeClt) {
        this.idClt = idClt;
        this.nomClt = nomClt;
        this.villeClt = villeClt;
    }

    public Client(String nomClt, String villeClt) {
        this.nomClt = nomClt;
        this.villeClt = villeClt;
    }

    public int getIdClt() { return idClt; }
    public void setIdClt(int idClt) { this.idClt = idClt; }

    public String getNomClt() { return nomClt; }
    public void setNomClt(String nomClt) { this.nomClt = nomClt; }

    public String getVilleClt() { return villeClt; }
    public void setVilleClt(String villeClt) { this.villeClt = villeClt; }
}
