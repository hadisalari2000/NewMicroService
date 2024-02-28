package org.amigoscode.fraud.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.amigoscode.fraud.utilities.ApplicationProperties;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseDTO<T> {

    private String[] errorMessages;
    private String[] hiddenMessages;
    private String[] informationMessages;
    private Boolean isSuccess;

    private T data;

    public static BaseDTO getSuccess(){
        return BaseDTO.builder()
                .isSuccess(true)
                .informationMessages(new String[]{ApplicationProperties.getProperty("successful")})
                .build();
    }

}
