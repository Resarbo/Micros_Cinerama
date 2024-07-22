IF OBJECT_ID('Ins_Confiteria') IS NOT NULL
    DROP PROCEDURE Ins_Confiteria
GO


CREATE PROCEDURE Ins_Confiteria(
	@cNombre varchar (200),
	@cDescripcion varchar (1000),
	@mPrecio money,
	@nStock int,
	@cImagen varchar (200)
)
AS
BEGIN
	SET NOCOUNT ON
	BEGIN TRY
		BEGIN TRAN
			INSERT INTO Confiteria(cNombre, cDescripcion, mPrecio, nStock, cImagen)
			values(@cNombre, @cDescripcion, @mPrecio, @nStock, @cImagen)
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