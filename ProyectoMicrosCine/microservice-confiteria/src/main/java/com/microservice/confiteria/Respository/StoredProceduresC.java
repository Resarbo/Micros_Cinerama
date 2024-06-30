package com.microservice.confiteria.Respository;

public class StoredProceduresC {
    public static final String SEL_CONFITERIA_ID = "{call Sel_Confiteria_ID(?)}";
    public static final String SEL_CONFITERIA= "{call Sel_Confiteria}";
    public static final String INS_CONFITERIA = "{call Ins_Confiteria ( ?, ?, ?, ?, ?)}";
    public static final String UPD_CONFITERIA = "{call Upd_Confiteria ( ?, ?, ?, ?, ?, ?)}";
    public static final String DEL_CONFITERIA = "{call Del_Confiteria ( ? )}";
}
