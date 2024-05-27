IF OBJECT_ID('Sel_Cartelera') IS NOT NULL
    DROP PROCEDURE Sel_Cartelera
GO

CREATE PROCEDURE Sel_Cartelera(
    @nID int
)
AS
BEGIN
	Select c.nID, c.mPrecio, c.dtFechaRegistro, h.cInicio, s.cNombre
	from Cartelera c
	inner join Horario h on h.nID = c.nIDHorario
	inner join Sala s on s.nID = c.nIDHorario
	where c.bEstado = 1
END