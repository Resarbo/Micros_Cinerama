IF OBJECT_ID('Sel_Cartelera') IS NOT NULL
    DROP PROCEDURE Sel_Cartelera
GO

CREATE PROCEDURE Sel_Cartelera
AS
BEGIN
	Select c.nID, c.mPrecio, p.cNombre, s.cNombre, h.cInicio, se.cNombre
	from Cartelera c
	inner join Pelicula p on p.nID = c.nIDPelicula
	inner join Horario h on h.nID = c.nIDHorario
	inner join Sala s on s.nID = c.nIDHorario
	inner join Sede se on se.nID = c.nIDSede
	where c.bEstado = 1
END