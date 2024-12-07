package mada_immo.dto;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private T data;
    private String status;
    private ApiError error;

    public ApiResponse( T data ) {
        this.setData( data );
        this.setStatus( "success" );
        this.setError( null );
    }

    public ApiResponse( ApiError error ) {
        this.setData( null );
        this.setStatus( "error" );
        this.setError( error );
    }
}
