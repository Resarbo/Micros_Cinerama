IF OBJECT_ID('Sel_Confiteria') IS NOT NULL
    DROP PROCEDURE Sel_Confiteria
GO

CREATE PROCEDURE Sel_Confiteria
AS
BEGIN
	Select c.nID, c.cNombre, c.cDescripcion, c.mPrecio, c.nStock, c.cImagen
	from Confiteria c
END