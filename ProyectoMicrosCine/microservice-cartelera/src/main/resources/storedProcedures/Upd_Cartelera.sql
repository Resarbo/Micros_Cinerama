IF OBJECT_ID('Upd_Cartelera') IS NOT NULL
    DROP PROCEDURE Upd_Cartelera
GO

CREATE PROCEDURE Upd_Cartelera(
	@mPrecio money,
	@cUsuarioRegistro varchar (100),
	@nIDPelicula varchar(100),
	@nIDSala varchar(100),
	@nIDHorario varchar(100),
	@nID int
)
AS
BEGIN
	SET NOCOUNT ON
	BEGIN TRY
		BEGIN TRAN
			update Cartelera
			set
				mPrecio = @mPrecio,
				cUsuarioRegistro = @cUsuarioRegistro,
				nIDPelicula = @nIDPelicula,
				nIDSala = @nIDSala,
				nIDHorario = @nIDHorario
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