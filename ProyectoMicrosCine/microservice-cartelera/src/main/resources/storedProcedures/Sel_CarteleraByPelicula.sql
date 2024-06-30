IF OBJECT_ID('Sel_CarteleraByPelicula_ID') IS NOT NULL
    DROP PROCEDURE Sel_CarteleraByPelicula_ID
GO

CREATE PROCEDURE Sel_CarteleraByPelicula_ID(
    @nID int
)
AS
BEGIN

	SELECT
		c.nID as cartelera_id,
        		c.mPrecio as cartelera_precio,
        		p.cNombre as cartelera_nombre,
        		c.nIDSala as cartelera_sala,
        		h.cInicio as cartelera_inicio,
        		se.cNombre as cartelera_sede
        	FROM Cartelera c
        	inner join Pelicula p on p.nID = c.nIDPelicula
        	inner join Horario h on h.nID = c.nIDHorario
        	inner join Sede se ON c.nIDSede = se.nID
            WHERE c.bEstado = 1 and c.nIDPelicula = @nId;

END
