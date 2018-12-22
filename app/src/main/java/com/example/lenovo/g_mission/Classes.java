package com.example.lenovo.g_mission;

/**
 * C'est classe define les objets pour creér les missions et les garder sur la basse de donneés.
 * @author Jesus Enrique Nava Sanchez
 * @version 10/12/2018
 */
public class Classes {
    //Attributs de la classe
    String claseid, nom, type, jour, description;

    /**
     *Constructeur pour les missions
     * @param claseid cette param définit l'id de la mission
     * @param nom cette param définit le nom de la mission
     * @param type cette param définit le type de la mission
     * @param jour cette param définit la date de la mission
     * @param description cette param définit la description de la mission
     */
    public Classes(String claseid, String nom, String type, String jour, String description) {
        this.claseid = claseid;
        this.nom = nom;
        this.type = type;
        this.jour = jour;
        this.description = description;
    }


    public Classes(){

    }

    public String getClaseid() {
        return claseid;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public String getJour() {
        return jour;
    }

    public String getDescription() {
        return description;
    }

    public void setClaseid(String claseid) {
        this.claseid = claseid;
    }
}
