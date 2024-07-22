IF OBJECT_ID('Sel_Sede_ID') IS NOT NULL
    DROP PROCEDURE Sel_Sede_ID
GO

CREATE PROCEDURE Sel_Sede_ID(
    @nID int
)
AS
BEGIN
	Select s.nID, s.cNombre, s.cDireccion, s.cTelefono
	from Sede s
	where s.nID = @nId
END