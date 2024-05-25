IF OBJECT_ID('Sel_PeliculasByCategoria_ID') IS NOT NULL
    DROP PROCEDURE Sel_PeliculasByCategoria_ID
GO

CREATE PROCEDURE Sel_PeliculasByCategoria_ID(
    @nID int
)
AS
BEGIN

	SELECT
		p.nID as pelicula_id,
		p.cNombre as pelicula_nombre,
		p.cDescripcion as pelicula_descripcion,
        p.cDirector as pelicula_director,
		p.cImagen as pelicula_imagen,
		c.cNombre as categoria_nombre
	FROM Pelicula p
	JOIN CategoriaPelicula c ON p.nIDCategoria = c.nID
    WHERE c.nID = @nId

END