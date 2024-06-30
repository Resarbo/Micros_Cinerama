IF OBJECT_ID('Sel_Sede') IS NOT NULL
    DROP PROCEDURE Sel_Sede
GO

CREATE PROCEDURE Sel_Sede
AS
BEGIN
	Select s.nID, s.cNombre, s.cDireccion, s.cTelefono
	from Sede s
	where s.nID = @nId
END