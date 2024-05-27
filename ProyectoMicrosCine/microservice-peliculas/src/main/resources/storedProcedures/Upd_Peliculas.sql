IF OBJECT_ID('Upd_Peliculas') IS NOT NULL
    DROP PROCEDURE Upd_Peliculas
GO

CREATE PROCEDURE Upd_Peliculas(
	@cNombre varchar(100),
	@cDescripcion varchar(100),
	@cDirector varchar(100),
	@cImagen varchar(100),
	@nDuracion varchar(100),
	@nIDTrailer varchar(100),
	@cUsuarioRegistro varchar(100),
	@nIDCategoria varchar(100),
	@nID int
)
AS
BEGIN
	SET NOCOUNT ON
	BEGIN TRY
		BEGIN TRAN
			update Pelicula
			set
				cNombre = @cNombre,
				cDescripcion = @cDescripcion,
				cDirector = @cDirector,
				cImagen = @cImagen,
				nDuracion = @nDuracion,
				nIDTrailer = @nIDTrailer,
				cUsuarioRegistro = @cUsuarioRegistro,
				nIDCategoria = @nIDCategoria
			where nID = @nID
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