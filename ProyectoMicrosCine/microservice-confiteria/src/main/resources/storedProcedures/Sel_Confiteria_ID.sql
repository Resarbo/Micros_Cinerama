IF OBJECT_ID('Sel_Confiteria_ID') IS NOT NULL
    DROP PROCEDURE Sel_Confiteria_ID
GO

CREATE PROCEDURE Sel_Confiteria_ID(
    @nID int
)
AS
BEGIN
	Select c.nID, c.cNombre, c.cDescripcion, c.mPrecio, c.nStock, c.cImagen
	from Confiteria c
	where c.nID = @nId
END