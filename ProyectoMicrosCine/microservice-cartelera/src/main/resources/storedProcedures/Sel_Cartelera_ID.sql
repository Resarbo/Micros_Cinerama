IF OBJECT_ID('Sel_Cartelera_ID') IS NOT NULL
    DROP PROCEDURE Sel_Cartelera_ID
GO

CREATE PROCEDURE Sel_Cartelera_ID(
    @nID int
)
AS
BEGIN
	Select c.nID, c.mPrecio, c.dtFechaRegistro, h.cInicio, s.cNombre, se.cNombre
	from Cartelera c
	inner join Horario h on h.nID = c.nIDHorario
	inner join Sala s on s.nID = c.nIDHorario
	inner join Sede se on se.nID = c.nIDSala
	where c.nID = @nId
END