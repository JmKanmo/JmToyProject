package com.jmshop.jmshop_admin.dto.domain;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @NotEmpty(message = "상품명은 비어있습니다!")
    @NotBlank(message = "상품명은 공백만 올 수 없습니다!")
    @Size(max = 128, message = "상품명은 최대 128글자 까지 작성 가능합니다.")
    private String name;

    @Size(max = 65545, message = "상품설명은 최대 65545글자 까지 작성 가능합니다.")
    private String description;

    @Range(min = 0L, max = 999999999999L, message = "최소 0원 ~ 999,999,999,999원 범위의 금액만 가능합니다.")
    private Long price;

    @Range(min = 0, max = 10000, message = "최소 0원 ~ 10000원 범위의 금액만 가능합니다.")
    private Integer shippingFee;

    @Range(min = 0, max = 100, message = "할인율은 0% ~ 100% 범위 내에서 작성 가능합니다.")
    private Integer discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
}
