IF OBJECT_ID('Ins_Peliculas') IS NOT NULL
    DROP PROCEDURE Ins_Peliculas
GO

CREATE PROCEDURE Ins_Peliculas(
	@cNombre varchar(100),
	@cDescripcion varchar(100),
	@cDirector varchar(100),
	@cImagen varchar(100),
	@nDuracion varchar(100),
	@nIDTrailer varchar(100),
	@cUsuarioRegistro varchar(100),
	@nIDCategoria varchar(100)
)
AS
BEGIN
	SET NOCOUNT ON
	BEGIN TRY
		BEGIN TRAN
			INSERT INTO Pelicula (cNombre, cDescripcion, cDirector, cImagen, nDuracion, nIDTrailer, cUsuarioRegistro, nIDCategoria)
			values(@cNombre, @cDescripcion, @cDirector, @cImagen, @nDuracion, @nIDTrailer, @cUsuarioRegistro, @nIDCategoria)
		COMMIT TRAN
	END TRY
	BEGIN CATCH
		IF @@TRANCOUNT > 0
			ROLLBACK TRAN
		DECLARE @ErrorMessage NVARCHAR(4000);
		DECLARE @ErrorSeverity INT;
		DECLARE @ErrorState INT;

		SELECT
			@ErrorMessage = ERROR_MESSAGE(),
			@ErrorSeverity = ERROR_SEVERITY(),
			@ErrorState = ERROR_STATE();
		RAISERROR(@ErrorMessage, @ErrorSeverity, @ErrorState);
	END CATCH
END