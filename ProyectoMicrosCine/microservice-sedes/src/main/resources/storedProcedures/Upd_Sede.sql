IF OBJECT_ID('Upd_Sede') IS NOT NULL
    DROP PROCEDURE Upd_Sede
GO

CREATE PROCEDURE Upd_Sede(
		@cNombre varchar (200),
		@cDireccion varchar (200),
		@cTelefono varchar (20),
		@nID int
)
AS
BEGIN
	SET NOCOUNT ON
	BEGIN TRY
		BEGIN TRAN
			update Sede
			set
				cNombre = @cNombre,
				cDireccion = @cDireccion,
				cTelefono = @cTelefono
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