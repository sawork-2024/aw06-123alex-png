package com.micropos.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * InlineObjectDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-08T21:34:20.340856+08:00[Asia/Shanghai]")
public class InlineObjectDto   {

  @JsonProperty("quantity")
  private Integer quantity;

  public InlineObjectDto quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Quantity to be reduced
   * @return quantity
  */
  
  @Schema(name = "quantity", description = "Quantity to be reduced", required = false)
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineObjectDto inlineObject = (InlineObjectDto) o;
    return Objects.equals(this.quantity, inlineObject.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(quantity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineObjectDto {\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

