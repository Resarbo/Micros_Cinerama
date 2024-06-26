IF OBJECT_ID('Sel_CarteleraByHorario_ID') IS NOT NULL
    DROP PROCEDURE Sel_CarteleraByHorario_ID
GO

CREATE PROCEDURE Sel_CarteleraByHorario_ID(
    @nID int
)
AS
BEGIN

	SELECT
		c.nID as cartelera_id,
		c.mPrecio as cartelera_precio,
		c.nIDPelicula as cartelera_pelicula,
		s.cNombre as cartelera_sala,
		h.cInicio as Cartelera_horario
	FROM Cartelera c
	JOIN Horario h ON c.nIDHorario = h.nID
	JOIN Sala s ON c.nIDSala = s.nID
    WHERE h.nID = @nId

END
