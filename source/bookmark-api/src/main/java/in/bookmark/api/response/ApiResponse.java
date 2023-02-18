package in.bookmark.api.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {

    private T data;

    private List<String> errors;

    private Integer status;
    
}
