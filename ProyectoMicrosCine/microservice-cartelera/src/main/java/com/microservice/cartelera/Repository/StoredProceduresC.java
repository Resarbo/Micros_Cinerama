package com.microservice.cartelera.Repository;

public class StoredProceduresC {
    public static final String SEL_CARTELERA_ID = "{call Sel_Cartelera_ID(?)}";
    public static final String SEL_CARTELERA= "{call Sel_Cartelera}";
    public static final String INS_CARTELERA = "{call Ins_Cartelera ( ?, ?, ?, ?, ?, ?)}";
    public static final String UPD_CARTELERA = "{call Upd_Cartelera ( ?, ?, ?, ?, ?, ?, ?)}";
    public static final String DEL_CARTELERA = "{call Del_Cartelera ( ? )}";
    public static final String SEL_CARTELERABYHORARIO_ID = "{call Sel_CarteleraByHorario_ID ( ? )}";
    public static final String SEL_CARTELERABYPELICULA_ID = "{call Sel_CarteleraByPelicula_ID ( ? )}";
}
