package com.srfzz.tickets.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicketTypeRequestDto {

    @NotBlank(message = "Ticket Name is Required")
    @Size(max=100)
    private String name;
    @NotNull(message = "Ticket Price is Required")
    @PositiveOrZero(message = "Price Must be Zero or Greater than Zero")
    private Double price;

    private String description;
    private Integer totalAvailable;
}
