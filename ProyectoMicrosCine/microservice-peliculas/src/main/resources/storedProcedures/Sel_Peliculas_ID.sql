IF OBJECT_ID('Sel_Peliculas_ID') IS NOT NULL
    DROP PROCEDURE Sel_Peliculas_ID
GO

CREATE PROCEDURE Sel_Peliculas_ID(
    @nID int
)
AS
BEGIN
	Select p.nID, p.bEstado, p.cNombre, p.cDescripcion, p.cDirector, p.cImagen, p.nDuracion, t.cRuta, cp.cNombre
	from Pelicula p
	inner join CategoriaPelicula cp on cp.nID = p.nIDCategoria
	inner join Trailer t on t.nID = p.nIDTrailer
	where p.nID = @nId
END