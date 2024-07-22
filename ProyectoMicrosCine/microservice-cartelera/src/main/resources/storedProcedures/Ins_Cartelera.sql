IF OBJECT_ID('Ins_Cartelera') IS NOT NULL
    DROP PROCEDURE Ins_Cartelera
GO


CREATE PROCEDURE Ins_Cartelera(
	@mPrecio money,
	@cUsuarioRegistro varchar (100),
	@nIDPelicula varchar(100),
	@nIDSala varchar(100),
	@nIDHorario varchar(100),
	@nIDSala varchar(100),
	@nIDSede varchar(100)
)
AS
BEGIN
	SET NOCOUNT ON
	BEGIN TRY
		BEGIN TRAN
			INSERT INTO Cartelera(mPrecio, cUsuarioRegistro,nIDPelicula, nIDSala, nIDHorario, nIDSala, nIDSede)
			values(@mPrecio, @cUsuarioRegistro, @nIDPelicula, @nIDSala, @nIDHorario, @nIDSala, @nIDSede)
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