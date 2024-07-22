IF OBJECT_ID('Upd_Confiteria') IS NOT NULL
    DROP PROCEDURE Upd_Confiteria
GO

CREATE PROCEDURE Upd_Confiteria(
	    @cNombre varchar (200),
		@cDescripcion varchar (1000),
		@mPrecio money,
		@nStock int,
		@cImagen varchar (200),
		@nID int
)
AS
BEGIN
	SET NOCOUNT ON
	BEGIN TRY
		BEGIN TRAN
			update Confiteria
			set
				cNombre = @cNombre,
				cDescripcion = @cDescripcion,
				mPrecio = @mPrecio,
				nStock = @nStock,
				cImagen = @cImagen


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