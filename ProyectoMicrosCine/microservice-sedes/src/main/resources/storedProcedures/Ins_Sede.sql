IF OBJECT_ID('Ins_Sede') IS NOT NULL
    DROP PROCEDURE Ins_Sede
GO


CREATE PROCEDURE Ins_Sede(
    @cNombre varchar (200),
	@cDireccion varchar (200),
	@cTelefono varchar (20)


)
AS
BEGIN
	SET NOCOUNT ON
	BEGIN TRY
		BEGIN TRAN
			INSERT INTO Sede(cNombre, cDireccion, cTelefono)
			values(@cNombre, @cDireccion, @cTelefono)
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