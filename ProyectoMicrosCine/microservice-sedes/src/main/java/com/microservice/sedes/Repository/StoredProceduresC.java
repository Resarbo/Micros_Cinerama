package com.microservice.sedes.Repository;

public class StoredProceduresC {
    public static final String SEL_SEDE_ID = "{call Sel_Sede_ID(?)}";
    public static final String SEL_SEDE= "{call Sel_Sede}";
    public static final String INS_SEDE = "{call Ins_Sede ( ?, ?, ?)}";
    public static final String UPD_SEDE = "{call Upd_Sede ( ?, ?, ?, ?)}";
    public static final String DEL_SEDE = "{call Del_Sede ( ? )}";
}
