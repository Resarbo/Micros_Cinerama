package com.microservice.peliculas.Repository;

public class StoredProcedures {
    public static final String SEL_PELICULAS_ID = "{call Sel_Peliculas_ID(?)}";
    public static final String SEL_PELICULAS = "{call Sel_Peliculas}";
    public static final String INS_PELICULAS = "{call Ins_Peliculas ( ?, ?, ?, ?, ?, ?, ?, ?)}";
    public static final String UPD_PELICULAS = "{call Upd_Peliculas ( ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
    public static final String DEL_PELICULAS = "{call Del_Peliculas ( ? )}";
    public static final String SEL_PELICULASBYCATEGORIA_ID = "{call Sel_PeliculasByCategoria_ID ( ? )}";
}
